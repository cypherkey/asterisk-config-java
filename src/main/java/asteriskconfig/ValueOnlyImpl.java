package asteriskconfig;

abstract class ValueOnlyImpl implements IValueOnly, IEntry {
	private String value;
	private String comment;
	
	ValueOnlyImpl(String value) {
		setValue(value);
	}

	ValueOnlyImpl(String value, String comment) {
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
		// Add the value
		sb.append(getValue());

		// If a comment is defined for the entry, add it
		if (getComment() != null && ! getComment().isEmpty()) {
			// If there is a value defined, then this is an inline comment and prefix is required.
			if (value.isEmpty() == false)
				sb.append(GlobalSettings.getInstance().getInlineCommentPrefix());
			// Append the comment character and the comment itself
			sb.append("; ");
			sb.append(getComment());
		}
		return sb.toString();
	}
}
