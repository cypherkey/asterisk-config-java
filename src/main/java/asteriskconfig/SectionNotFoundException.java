package asteriskconfig;

public class SectionNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 8901635065042277217L;

	public SectionNotFoundException() {
		super();
	}
	
	public SectionNotFoundException(String message) {
		super(message);
	}
}