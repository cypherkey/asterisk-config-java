package asteriskconfig;

public class SectionAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 5885607998045681822L;

	public SectionAlreadyExistsException() {
		super();
	}
	
	public SectionAlreadyExistsException(String message) {
		super(message);
	}
}