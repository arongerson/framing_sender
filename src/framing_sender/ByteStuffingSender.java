package framing_sender;

public class ByteStuffingSender implements Sender {

	private static final char FLAG = 'F';
	private static final char ESCAPE = 'E';
	
	@Override
	public String getFrame(String packet) {
		if (packet.isEmpty()) {
			throw new EmptyPacketException("the packet is empty.");
		}
		StringBuffer frame =  new StringBuffer();
		frame.append(FLAG);
		for (int i = 0; i < packet.length(); i++) {
			char character = packet.charAt(i); 
			if (isFlagOrEscape(character)) {
				frame.append(ESCAPE);
			}
			frame.append(character);
		}
		frame.append(FLAG);
		return frame.toString();
	}
	
	private boolean isFlagOrEscape(char character) {
		return character == FLAG || character == ESCAPE;
	}

}
