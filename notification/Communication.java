package notification;

import notification.Message.MessageType;

public abstract class Communication {
	protected Message _message;
	
	public Communication(Message msg) {
		_message = msg;
	}
	
	protected String createMessage (MessageType msgType) {
		return _message.createMessage(msgType);
	}
	
	public abstract void sendNotification(String recipient);

	public abstract void sendNotification(String recipient, String message);
}
