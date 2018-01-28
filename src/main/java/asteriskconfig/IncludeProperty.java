package asteriskconfig;

public class IncludeProperty extends PropertyBase {
	public static final String DELIMITER = " ";

	public IncludeProperty(String value) {
		super("#include", value, true);
	}

	@Override
	public String toString() {
		return String.format("#include %s", getValue());
	}
}
