package framing_sender;

public interface Sender {
	String getFrame(String packet) throws IncorrectFormatException;
}
