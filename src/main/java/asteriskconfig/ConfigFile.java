package asteriskconfig;

import java.util.HashMap;
import java.util.Map;

public class ConfigFile {
	private Map<String, ConfigSection> sections = new HashMap<String, ConfigSection>();
	
	public ConfigFile() {
		ConfigSection newSection = new ConfigSection(ConfigSection.GLOBAL_SECTION);
		sections.put(ConfigSection.GLOBAL_SECTION, newSection);
	}
	
	public ConfigSection createNewSection(String sectionName) throws SectionAlreadyExistsException {
		if (sections.containsKey(sectionName))
			throw new SectionAlreadyExistsException(String.format("Section %s already exists", sectionName));
		else {
			ConfigSection newSection = new ConfigSection(sectionName);
			sections.put(sectionName, newSection);
			return newSection;
		}
	}
	
	public ConfigSection getGlobal() {
		return sections.get(ConfigSection.GLOBAL_SECTION);
	}
	
	public ConfigSection getSection(String sectionName) {
		if (sections.containsKey(sectionName))
			return sections.get(sectionName);
		else
			throw new SectionNotFoundException(sectionName);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();

		// Global section first
		sb.append(sections.get(ConfigSection.GLOBAL_SECTION));
		
		for(ConfigSection section : sections.values()) {
			if (! section.getName().equalsIgnoreCase(ConfigSection.GLOBAL_SECTION))
				sb.append(section.toString());
		}
		return sb.toString();
	}
}