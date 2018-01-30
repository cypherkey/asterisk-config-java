package asteriskconfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class AstConfigParser {
	public static String COMMENT = ";";
	public static String SECTION_START = "[";
	public static String SECTION_END = "]";
	public static String INCLUDE_DIRECTIVE = "#include";
	public static String DELIMITER = "=";
	public static String DIRECTIVE_DELIMITER = "=>";
	
	public ConfigFile parse(File file) throws IOException {
		return parse(new FileReader(file));
	}
	
	public ConfigFile parse(Reader input) throws IOException {
		ConfigFile config = new ConfigFile();
		ConfigSection currentSection = config.getGlobal();
		
		BufferedReader in = new BufferedReader(input);
		String line;
		Integer lineNumber = 0;
		while((line = in.readLine()) != null) {
			// Keep track of the line number for exceptions
			lineNumber++;
			
			// Trim whitespace off the line
			line = line.trim();

			if (line.startsWith(COMMENT)) {
				// Strip off the semi-colon (;) and trim whitespace
				line = line.substring(1).trim();

				// Add the comment
				Comment entry = new Comment(line);
				currentSection.addEntry(entry);
			}
			else if (line.startsWith(SECTION_START) && line.endsWith(SECTION_END)) {

				// Parse the section name by dropping the first and last character
				String sectionName = line.substring(1, line.length() - 1).trim();

				// Attempt to create a new section. Throw an exception if it already exists.
				try {
					currentSection = config.createNewSection(sectionName);
				} catch (SectionAlreadyExistsException e) {
					throw new InvalidFileFormatException(e.getMessage(), e);
				}
			}
			else {
				// A line can contain inline comments
				String comment = "";
				if (line.contains(";")) {
					comment = line.substring(line.indexOf(";") + 1).trim();
					line = line.substring(0, line.indexOf(";")).trim();
				}

				if (line.toLowerCase().startsWith(INCLUDE_DIRECTIVE)) {
					String[] tokens = line.split(" ");
					if (tokens.length != 2) {
						throw new InvalidFileFormatException("Include directive has too many parts");
					}
					Include entry = new Include(tokens[1].trim(), comment);
					currentSection.addEntry(entry);
				}
				else if (line.contains(DIRECTIVE_DELIMITER)) {
					String[] tokens = line.split(DIRECTIVE_DELIMITER);
					if (tokens.length == 2) {
						Directive entry = new Directive(tokens[0].trim(), tokens[1].trim(), comment);
						currentSection.addEntry(entry);
					}
				}
				else {
					String[] tokens = line.split(DELIMITER);
					if (tokens.length == 2) {
						ConfigEntry entry = new ConfigEntry(tokens[0].trim(), tokens[1].trim(), comment);
						currentSection.addEntry(entry);
					}
				}
			}
		}

		return config;
	}
}