package asteriskconfig;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConfigSection {
	public static final String GLOBAL_SECTION = "__GLOBAL__";
	
	private String name;
	private List <IEntry> properties = new ArrayList<IEntry>();
	
	public ConfigSection(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addProperty(IEntry property) {
		properties.add(property);
	}

	public List<IEntry> getProperties() {
		return properties;
	}
	
	public IEntry get(Integer index) {
		return properties.get(index);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		// Global sections do not have a [] section identifier
		if (! name.equalsIgnoreCase(GLOBAL_SECTION)) {
			sb.append(String.format("[%s]%n", getName()));
		}
		
		// Iterate over the entries
		Iterator<IEntry> iterator = properties.iterator();
		while(iterator.hasNext()) {
			sb.append(String.format("%s%n", iterator.next().toString()));
		}
		
		// Return the String
		return sb.toString();
	}
}