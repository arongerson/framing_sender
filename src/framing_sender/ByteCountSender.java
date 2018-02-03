package framing_sender;

public class ByteCountSender implements Sender {

	@Override
	public String getFrame(String packet) {
		if (packet.isEmpty()) {
			throw new EmptyPacketException("the packet is empty.");
		}
		int byteCount = packet.length() + 1;
		return byteCount + packet;
	}

}
