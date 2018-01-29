package asteriskconfig;

public class Comment extends ValueOnlyImpl implements IValueOnly {
	public Comment(String comment)
	{
		super("", comment);
	}
	
	public String toString() {
		return String.format(";\t\t%s", getComment());
	}
}
