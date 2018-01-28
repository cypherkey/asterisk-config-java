package asteriskconfig;

public class KeyValueProperty extends PropertyBase {
    public static final String DELIMITER = "=";

    public KeyValueProperty(String key, String value) { super(key, value); }

    @Override
    public String toString() {
        return String.format("%s %s %s", getKey(), DELIMITER, getValue());
    }
}
