package framing_sender;

public class SenderTest {

	public static void main(String[] args) {
		Sender byteCountSender = new ByteCountSender();
		Sender byteStuffingSender = new ByteStuffingSender();
		Sender bitStuffingSender = new BitStuffingSender();
		try {
			System.out.println(byteCountSender.getFrame("abc")); 
			System.out.println(byteStuffingSender.getFrame("ABCDEEF"));
			System.out.println(bitStuffingSender.getFrame("0111111010101"));
		} catch (IncorrectFormatException | EmptyPacketException e) {
			System.out.println(e.getMessage());
		}
	}
}
