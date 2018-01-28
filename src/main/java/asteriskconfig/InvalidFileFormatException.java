package asteriskconfig;

import java.io.IOException;

public class InvalidFileFormatException extends IOException {
	private static final long serialVersionUID = 118127704869713543L;

	public InvalidFileFormatException(String message)
    {
        super(message);
    }

    public InvalidFileFormatException(String message, Integer lineNumber) {
		super(String.format("%s at line %d", message, lineNumber));
	}

	public InvalidFileFormatException(String message, Throwable parentException) {
		super(message, parentException);
	}

	public InvalidFileFormatException(String message, Integer lineNumber, Throwable parentException) {
		super(String.format("%s at line %d", message, lineNumber), parentException);
	}
}