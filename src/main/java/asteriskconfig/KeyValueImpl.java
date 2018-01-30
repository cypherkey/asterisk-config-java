package asteriskconfig;

abstract class KeyValueImpl extends ValueOnlyImpl {
	private String key;
	
	KeyValueImpl(String key, String value) {
		super(value);
		this.key = key;
	}
	
	KeyValueImpl(String key, String value, String comment) {
		super(value, comment);
		this.key = key;
	}

	public String getKey() {
		return key;
	}
	
	public String toString() {
		return super.toString();
	}
}
