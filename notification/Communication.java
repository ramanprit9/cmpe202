package notification;

import notification.Message.MessageType;

public abstract class Communication {
	private Message _message;
	
	public Communication(Message msg) {
		_message = msg;
	}
	
	public String createMessage (MessageType msgType) {
		return _message.createMessage(msgType);
	}
	
	public abstract void sendNotification(String recipient, String message);
}
