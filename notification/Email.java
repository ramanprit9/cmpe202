package notification;

import java.awt.Frame;

import javax.swing.JOptionPane;

public class Email extends Communication {


	public Email (Message msg) {
		super(msg);
	}
	
	public void sendNotification(String recipient, String message) {
		System.out.println("Email to "+recipient+":\n "+message);
		
		Frame frame = new Frame();
		JOptionPane.showMessageDialog(frame,
			    message + "\n",
			    "Email to " + recipient + " ",
			    JOptionPane.INFORMATION_MESSAGE);
	}
}
