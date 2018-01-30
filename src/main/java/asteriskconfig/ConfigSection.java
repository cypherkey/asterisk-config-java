package asteriskconfig;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConfigSection {
	public static final String GLOBAL_SECTION = "__GLOBAL__";
	
	private String name;
	private List <IEntry> entries = new ArrayList<IEntry>();
	
	public ConfigSection(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addEntry(IEntry entry) {
		entries.add(entry);
	}

	public List<IEntry> getEntries() {
		return entries;
	}
	
	public IEntry get(Integer index) {
		return entries.get(index);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		// Global sections do not have a [] section identifier
		if (! name.equalsIgnoreCase(GLOBAL_SECTION)) {
			sb.append(String.format("[%s]%s", getName(), GlobalSettings.getInstance().getEol()));
		}
		
		// Iterate over the entries
		Iterator<IEntry> iterator = entries.iterator();
		while(iterator.hasNext()) {
			sb.append(String.format("%s%s", iterator.next().toString(), GlobalSettings.getInstance().getEol()));
		}
		
		// Return the String
		return sb.toString();
	}
}