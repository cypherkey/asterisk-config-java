package asteriskconfig;

public interface IValueOnly extends IEntry {
	String getValue();
	void setValue(String value);
	String getComment();
	void setComment(String comment);
}
