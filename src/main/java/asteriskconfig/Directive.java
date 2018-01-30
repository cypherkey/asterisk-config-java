package asteriskconfig;

public class Directive extends KeyValueImpl {
	public static final String DELIMITER = "=>";

	public Directive(String key, String value) {
		super(key, value);
	}

	public Directive(String key, String value, String comment) {
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
