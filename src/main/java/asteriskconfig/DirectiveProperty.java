package asteriskconfig;

public class DirectiveProperty extends PropertyBase {
	public static final String DELIMITER = "=>";

	public DirectiveProperty(String key, String value) {
		super(key, value, true);
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", getKey(), DELIMITER, getValue());
	}
}
