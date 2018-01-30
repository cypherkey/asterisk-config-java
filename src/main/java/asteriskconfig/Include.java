package asteriskconfig;

public class Include extends ValueOnlyImpl implements IValueOnly {
	public static final String DELIMITER = " ";

	public Include(String value) {
		super(value);
	}
	
	public Include(String value, String comment) {
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
