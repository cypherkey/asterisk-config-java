package asteriskconfig;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.Collection;
import java.util.Iterator;

public class ConfigSection {
	public static final String GLOBAL_SECTION = "__GLOBAL__";
	
	private String name;
	private MultiValuedMap<String, PropertyBase> properties = new ArrayListValuedHashMap<String, PropertyBase>();
	
	public ConfigSection(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addProperty(PropertyBase property) {
		if (! properties.containsKey(property.getKey())) {
			properties.put(property.getKey(), property);
		} else {
			if (properties.get(property.getKey()).iterator().next().getClass().getName().equalsIgnoreCase(property.getClass().getName()) && property.allowDuplicates()) {
				properties.get(property.getKey()).add(property);
			} else {
				properties.get(property.getKey()).clear();
				properties.get(property.getKey()).add(property);
			}
		}
	}

	public PropertyBase getProperty(String key) {
		return getProperties(key).iterator().next();
	}

	public Collection<PropertyBase> getProperties(String key) {
		return properties.get(key);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("[%s]%n", getName()));
		Iterator<String> keyIterator = properties.keySet().iterator();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Iterator<PropertyBase> valIterator = properties.get(key).iterator();
			while(valIterator.hasNext()) {
				sb.append(String.format("%s%n", valIterator.next().toString()));
			}
		}
		return sb.toString();
	}
}