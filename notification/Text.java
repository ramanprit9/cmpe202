package notification;

import java.awt.Frame;

import javax.swing.JOptionPane;

public class Text extends Communication {

	public Text (Message msg) {
		super(msg);
	}
	
	public void sendNotification(String recipient, String message) {
		System.out.println("Text to "+recipient+":\n "+message);
		
		Frame frame = new Frame();
		JOptionPane.showMessageDialog(frame,
			    message + "\n",
			    "Text to " + recipient + " ",
			    JOptionPane.INFORMATION_MESSAGE);
	}
	
}
