package notification;

import java.awt.Frame;

import javax.swing.JOptionPane;

import notification.Message.MessageType;

public class Phone extends Communication {

	private MessageType msgType;
	
	public Phone (Message msg, MessageType type) {
		super(msg);
		msgType = type;
	}
	
	public void sendNotification(String recipient) {
		String msg = this.createMessage(msgType);
		sendNotification(recipient, msg);
	}
	
	public void sendNotification(String recipient, String message) {
		this.createMessage(msgType);
		System.out.println("Phone to "+recipient+":\n "+message);
		
		/*
		Frame frame = new Frame();
		JOptionPane.showMessageDialog(frame,
			    message + "\n",
			    "Phone to " + recipient + " ",
			    JOptionPane.INFORMATION_MESSAGE);
		*/
	}
}
