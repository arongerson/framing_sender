package framing_sender;

public class EmptyPacketException extends RuntimeException {
	private static final long serialVersionUID = 4403469273265350862L;

	public EmptyPacketException(String message) {
		super(message);
	}
}
