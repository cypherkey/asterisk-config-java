package asteriskconfig;

public class IncludeProperty extends ValueOnlyImpl implements IValueOnly {
	public static final String DELIMITER = " ";

	public IncludeProperty(String value) {
		super(value);
	}
	
	public IncludeProperty(String value, String comment) {
		super(value, comment);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("#include ");
		sb.append(super.toString());
		return sb.toString();
	}
}
