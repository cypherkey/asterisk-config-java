package asteriskconfig;

public class Comment extends ValueOnlyImpl implements IValueOnly {
	public Comment(String comment)
	{
		// Comments are their own value
		super("", comment);
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(GlobalSettings.getInstance().getCommentChar());
	    // This can be an empty comment line, check whether anything is defined.
        if ((getComment() != null) && (!getComment().isEmpty())) {
            sb.append(" ");
            sb.append(getComment());
        }
        return sb.toString();
	}
}
