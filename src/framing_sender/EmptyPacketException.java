package framing_sender;

public class EmptyPacketException extends RuntimeException {
	
	public EmptyPacketException(String message) {
		super(message);
	}
}
