package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;











//import net.miginfocom.swing.MigLayout;
//import com.jgoodies.forms.factories.FormFactory;
import java.awt.CardLayout;

import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;

import request.Request;
import notification.Communication;
import notification.DispatchingMessage;
import notification.Email;
import notification.Phone;
import notification.Text;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class MainApplication implements ActionListener{

	private JFrame frame;
	private JTextField txtPickAddr;
	private JTextField txtPickCity;
	private JTextField txtPickState;
	private JTextField txtPickZip;
	private JTextField txtDestAddr;
	private JTextField txtDestCity;
	private JTextField txtDestState;
	private JTextField txtDestZip;
	private JTextField txtPassengers;
	private JTextField txtLuggages;
	private String cmbValueShare;
	private String cmbValueComm;
	private String cmbValueWait;
	
	ServiceManager serviceManager = new ServiceManager();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApplication window = new MainApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println("Initalizing application");
		frame = new JFrame();
		frame.setBounds(100, 100, 693, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pickupPanel = new JPanel();
		pickupPanel.setBounds(24, 43, 296, 130);
		frame.getContentPane().add(pickupPanel);
		
		JLabel lblPickupLocation = new JLabel("Pickup Location");
		lblPickupLocation.setBounds(10, 5, 105, 14);
		lblPickupLocation.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblStreetAddress = new JLabel("Street Address:");
		lblStreetAddress.setBounds(10, 30, 100, 14);
		lblStreetAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setBounds(10, 56, 54, 14);
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblState = new JLabel("State:");
		lblState.setBounds(10, 81, 54, 14);
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblZipcode = new JLabel("Zipcode:");
		lblZipcode.setBounds(10, 106, 66, 14);
		lblZipcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pickupPanel.setLayout(null);
		pickupPanel.add(lblPickupLocation);
		
		JLabel label = new JLabel("");
		label.setBounds(115, 12, 0, 0);
		pickupPanel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(120, 12, 0, 0);
		pickupPanel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(125, 12, 0, 0);
		pickupPanel.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(130, 12, 0, 0);
		pickupPanel.add(label_3);
		pickupPanel.add(lblStreetAddress);
		pickupPanel.add(lblCity);
		pickupPanel.add(lblState);
		pickupPanel.add(lblZipcode);
		
		txtPickAddr = new JTextField();
		txtPickAddr.setText("Bunker Hill Lane");
		txtPickAddr.setBounds(115, 24, 172, 20);
		pickupPanel.add(txtPickAddr);
		txtPickAddr.setColumns(10);
		
		txtPickCity = new JTextField();
		txtPickCity.setText("Santa Clara");
		txtPickCity.setColumns(10);
		txtPickCity.setBounds(115, 50, 172, 20);
		pickupPanel.add(txtPickCity);
		
		txtPickState = new JTextField();
		txtPickState.setText("CA");
		txtPickState.setColumns(10);
		txtPickState.setBounds(115, 75, 172, 20);
		pickupPanel.add(txtPickState);
		
		txtPickZip = new JTextField();
		txtPickZip.setText("95054");
		txtPickZip.setColumns(10);
		txtPickZip.setBounds(115, 100, 172, 20);
		pickupPanel.add(txtPickZip);
		
		JPanel destPanel = new JPanel();
		destPanel.setLayout(null);
		destPanel.setBounds(348, 43, 296, 130);
		frame.getContentPane().add(destPanel);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDestination.setBounds(10, 5, 105, 14);
		destPanel.add(lblDestination);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(115, 12, 0, 0);
		destPanel.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(120, 12, 0, 0);
		destPanel.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(125, 12, 0, 0);
		destPanel.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(130, 12, 0, 0);
		destPanel.add(label_8);
		
		JLabel label_9 = new JLabel("Street Address:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_9.setBounds(10, 30, 100, 14);
		destPanel.add(label_9);
		
		JLabel label_10 = new JLabel("City:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_10.setBounds(10, 56, 54, 14);
		destPanel.add(label_10);
		
		JLabel label_11 = new JLabel("State:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_11.setBounds(10, 81, 54, 14);
		destPanel.add(label_11);
		
		JLabel label_12 = new JLabel("Zipcode:");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_12.setBounds(10, 106, 66, 14);
		destPanel.add(label_12);
		
		txtDestAddr = new JTextField();
		txtDestAddr.setText("San Jose State ");
		txtDestAddr.setColumns(10);
		txtDestAddr.setBounds(115, 24, 172, 20);
		destPanel.add(txtDestAddr);
		
		txtDestCity = new JTextField();
		txtDestCity.setText("San Jose");
		txtDestCity.setColumns(10);
		txtDestCity.setBounds(115, 50, 172, 20);
		destPanel.add(txtDestCity);
		
		txtDestState = new JTextField();
		txtDestState.setText("CA");
		txtDestState.setColumns(10);
		txtDestState.setBounds(115, 75, 172, 20);
		destPanel.add(txtDestState);
		
		txtDestZip = new JTextField();
		txtDestZip.setText("95112");
		txtDestZip.setColumns(10);
		txtDestZip.setBounds(115, 100, 172, 20);
		destPanel.add(txtDestZip);
		
		JPanel numPassPanel = new JPanel();
		numPassPanel.setBounds(24, 184, 234, 39);
		frame.getContentPane().add(numPassPanel);
		numPassPanel.setLayout(null);
		
		JLabel lblNumberOfPassengers = new JLabel("Number of Passengers:");
		lblNumberOfPassengers.setBounds(0, 11, 160, 16);
		lblNumberOfPassengers.setFont(new Font("Tahoma", Font.BOLD, 13));
		numPassPanel.add(lblNumberOfPassengers);
		
		txtPassengers = new JTextField();
		txtPassengers.setText("1");
		txtPassengers.setBounds(170, 10, 42, 20);
		numPassPanel.add(txtPassengers);
		txtPassengers.setColumns(10);
		
		JPanel sharePanel = new JPanel();
		sharePanel.setLayout(null);
		sharePanel.setBounds(486, 184, 158, 39);
		frame.getContentPane().add(sharePanel);
		
		JLabel lblShareable = new JLabel("Shareable:");
		lblShareable.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblShareable.setBounds(10, 11, 85, 16);
		sharePanel.add(lblShareable);
		
		JComboBox cmbShareable = new JComboBox();
		cmbShareable.setModel(new DefaultComboBoxModel(new String[] {"No", "Yes"}));
		cmbShareable.setSelectedIndex(0);
		cmbShareable.setBounds(92, 6, 57, 29);
		sharePanel.add(cmbShareable);
		cmbValueShare = cmbShareable.getSelectedItem().toString();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(24, 234, 271, 39);
		frame.getContentPane().add(panel);
		
		JComboBox cmbCommMethod = new JComboBox();
		cmbCommMethod.setModel(new DefaultComboBoxModel(new String[] {"Text", "Phone", "Email"}));
		cmbCommMethod.setSelectedIndex(0);
		cmbCommMethod.setBounds(142, 8, 122, 29);
		panel.add(cmbCommMethod);
		cmbValueComm = cmbCommMethod.getSelectedItem().toString();
		
		JLabel lblNotificationMethod = new JLabel("Communication Method:");
		lblNotificationMethod.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNotificationMethod.setBounds(0, 13, 160, 16);
		panel.add(lblNotificationMethod);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(268, 184, 207, 39);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNumberOfLuggages = new JLabel("Number of Luggages:");
		lblNumberOfLuggages.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumberOfLuggages.setBounds(10, 11, 160, 16);
		panel_1.add(lblNumberOfLuggages);
		
		txtLuggages = new JTextField();
		txtLuggages.setText("0");
		txtLuggages.setColumns(10);
		txtLuggages.setBounds(154, 10, 43, 20);
		panel_1.add(txtLuggages);
		
		JButton btnSubmitReq = new JButton("Submit Request");
		btnSubmitReq.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubmitReq.setBounds(254, 284, 158, 35);
		frame.getContentPane().add(btnSubmitReq);
		btnSubmitReq.addActionListener(this);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(24, 330, 620, 70);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblRequestResponse = new JLabel("Request Response:");
		lblRequestResponse.setBounds(10, 11, 149, 16);
		lblRequestResponse.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(lblRequestResponse);
		
		JLabel lblWouldYouLike = new JLabel("Would you like to wait?");
		lblWouldYouLike.setEnabled(false);
		lblWouldYouLike.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWouldYouLike.setBounds(386, 31, 163, 16);
		panel_2.add(lblWouldYouLike);
		
		
		JComboBox cmbWait = new JComboBox();
		cmbWait.setEnabled(false);
		cmbWait.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		cmbWait.setSelectedIndex(0);
		cmbWait.setBounds(541, 30, 57, 29);
		panel_2.add(cmbWait);
		cmbValueWait = cmbWait.getSelectedItem().toString();
		
		JLabel lblReqResponse = new JLabel("Request Available");
		lblReqResponse.setEnabled(false);
		lblReqResponse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReqResponse.setBounds(10, 31, 347, 28);
		panel_2.add(lblReqResponse);
	}
	
	
	/* Invoked when Submit Request button is clicked */
	public void actionPerformed(ActionEvent e) {
		
		Address pickAddr;
		Address destAddr;
		int numPassengers;
		int numLuggages;
		boolean share;
		boolean member = false;
		Communication communication;
		Request request;
		
		 // Retrieve request input and create a new Request 
		 //Retrieve pickup address 
		pickAddr = new Address(txtPickAddr.getText(), txtPickCity.getText(),
				txtPickState.getText(), txtPickZip.getText());
		 //Retrieve destination address 
		destAddr = new Address(txtDestAddr.getText(), txtDestCity.getText(),
				txtDestState.getText(), txtDestZip.getText());
		numPassengers = Integer.parseInt(txtPassengers.getText());
		numLuggages = Integer.parseInt(txtLuggages.getText());
		if (cmbValueShare.contains("No")) {
			share = false;
		}
		else {
			share = true;
		}		
		
		System.out.println("Request Passed to Service Manager: ");
		System.out.println("\tPickUp Address = "+pickAddr);
		System.out.println("\tDestination Address = "+destAddr);
		System.out.println("\tPassengers = " + numPassengers + "   Luggages = "+numLuggages + 
				"   Shareable");
		
		serviceManager.createRequest("guest", pickAddr, destAddr, numPassengers, numLuggages, 
				share, (Date)null, "");
		
		System.out.println("******************** Exiting *********************");

	}
}
