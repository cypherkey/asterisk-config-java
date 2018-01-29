package asteriskconfig;

public class ConfigEntry extends KeyValueImpl implements IKeyValue {
    public static final String DELIMITER = "=";

    public ConfigEntry(String key, String value) {
    	super(key, value);
    }

    public ConfigEntry(String key, String value, String comment) {
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
