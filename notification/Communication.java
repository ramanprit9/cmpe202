package notification;

import notification.Message.MessageType;
import notification.Message.Recipient;

public abstract class Communication {
	private Message _message;
	
	public Communication(Message msg) {
		_message = msg;
	}
	
	protected String createMessage (MessageType msgType) {
		return _message.createMessage(msgType);
	}
	
	public abstract void sendNotification(Message.Recipient rc, String message);
}
