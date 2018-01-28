package asteriskconfig;

import java.util.ArrayList;
import java.util.List;

abstract class PropertyBase {
	private String key;
	private String value;
	private Boolean allowDuplicates = false;

	protected PropertyBase(Boolean allowDuplicates) {
		this.allowDuplicates = allowDuplicates;
	}
	
	public PropertyBase(String key, String value) {
		this.key = key;
		setValue(value);
	}

	protected PropertyBase(String key, String value, Boolean allowDuplicates) {
		this.key = key;
		this.value = value;
		this.allowDuplicates = allowDuplicates;
	}

	public String getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public Boolean allowDuplicates() {
		return this.allowDuplicates;
	}
}
