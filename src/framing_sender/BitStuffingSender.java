package framing_sender;

public class BitStuffingSender implements Sender {

	private static final String FLAG = "01111110";
	private static final char ESCAPE_BIT = '0';
	private static final char ONE_BIT = '1';
	private static final int MAX_SUCCESSIVE_ONES = 5;
	private int countOnes;
	
	@Override
	public String getFrame(String packet) {
		if (packet.isEmpty()) {
			throw new EmptyPacketException("the packet is empty.");
		}
		countOnes = 0;
		StringBuffer frame =  new StringBuffer(FLAG);
		for (int i = 0; i < packet.length(); i++) {
			char bit = packet.charAt(i);
			if (!isAcceptableBit(bit)) {
				throw new IncorrectFormatException("incorrect data: " + packet);
			}
			if (isMaxSuccessiveOnes(bit)) {
				frame.append(ESCAPE_BIT);
				countOnes = 1;
			}
			frame.append(bit);
		}
		frame.append(FLAG);
		return frame.toString();
	}
	
	private boolean isAcceptableBit(char bit) {
		return bit == ONE_BIT || bit == ESCAPE_BIT;
	}

	private boolean isMaxSuccessiveOnes(char bit) {
		if (bit == ONE_BIT) {
			countOnes++;
		} else {
			countOnes = 0;
		}
		return countOnes == MAX_SUCCESSIVE_ONES + 1;
	}
}
