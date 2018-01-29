package asteriskconfig;

abstract class ValueOnlyImpl implements IValueOnly, IEntry {
	private String value;
	private String comment;
	
	protected ValueOnlyImpl(String value) {
		setValue(value);
	}

	protected ValueOnlyImpl(String value, String comment) {
		setValue(value);
		setComment(comment);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getValue());
		if (getComment() != null && ! getComment().isEmpty()) {
			sb.append("  ;");
			sb.append(getComment());
		}
		return sb.toString();
	}
}
