package framing_sender;

public class IncorrectFormatException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IncorrectFormatException(String message) {
		super(message);
	}
}
