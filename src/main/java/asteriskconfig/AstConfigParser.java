package asteriskconfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class AstConfigParser {
	public static String COMMENT = ";";
	public static String SECTION_START = "[";
	public static String SECTION_END = "]";
	public static String INCLUDE_DIRECTIVE = "#include";
	public static String DELIMITER = "=";
	
	public ConfigFile parse(Reader input) throws IOException {
		ConfigFile config = new ConfigFile();
		ConfigSection currentSection = config.getGlobal();
		
		BufferedReader in = new BufferedReader(input);
		String line;
		Integer lineNumber = 0;
		while((line = in.readLine()) != null) {
			lineNumber++;

			// Ignore comments
			if (line.startsWith(COMMENT)) {
				continue;
			}
			else if (line.startsWith(SECTION_START) && line.endsWith(SECTION_END)) {
				// Parse the section name by dropping the first and last character
				String sectionName = line.substring(1, line.length() - 2).trim();

				// Attempt to create a new section. Throw an exception if it already exists.
				try {
					currentSection = config.createNewSection(sectionName);
				} catch (SectionAlreadyExistsException e) {
					throw new InvalidFileFormatException(e.getMessage(), e);
				}
			}
			else if (line.toLowerCase().startsWith(INCLUDE_DIRECTIVE)) {
				String[] tokens = line.split(" ");
				if (tokens.length != 2) {
					throw new InvalidFileFormatException("Include directive has too many parts");
				}
				IncludeProperty property = new IncludeProperty(tokens[1].trim());
				config.getGlobal().addProperty(property);
			}
			else {
				String[] tokens = line.split(DELIMITER);
				if (tokens.length == 2) {
					KeyValueProperty property = new KeyValueProperty(tokens[0].trim(), tokens[1].trim());
					currentSection.addProperty(property);
				}
			}
		}

		return config;
	}
}