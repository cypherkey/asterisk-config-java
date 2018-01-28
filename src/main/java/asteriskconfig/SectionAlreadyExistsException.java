package asteriskconfig;

public class SectionAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 8901635065042277217L;

	public SectionAlreadyExistsException() {
		super();
	}
	
	public SectionAlreadyExistsException(String message) {
		super(message);
	}
}