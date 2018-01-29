package asteriskconfig;

public class DirectiveProperty extends KeyValueImpl {
	public static final String DELIMITER = "=>";

	public DirectiveProperty(String key, String value) {
		super(key, value);
	}

	public DirectiveProperty(String key, String value, String comment) {
		super(key, value, comment);
	}

    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getKey());
    	sb.append(" ");
    	sb.append(DELIMITER);
    	sb.append(" ");
    	sb.append(super.toString());
    	return sb.toString();
    }
}
