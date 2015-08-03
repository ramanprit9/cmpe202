package notification;

import java.awt.Frame;

import javax.swing.JOptionPane;

public class Phone extends Communication {

	public Phone (Message msg) {
		super(msg);
	}
	
	public void sendNotification(String recipient, String message) {
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
