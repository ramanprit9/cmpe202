package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import notification.Communication;
import notification.Text;
import request.Request;

public class RequestFrame extends JFrame implements ActionListener {
	
	ServiceManager serviceManager;

	private JPanel txtMemberID;
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
	private JTextField txtTxtmemberid;
	private JTextField textField_11;
	private JTextField textField_12;
	private String cmbValueShare;
	private String cmbValueComm;
	public JComboBox cmbCommMethod;
	public JComboBox cmbShareable;
	private int vehicleSpeed;
	
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestFrame frame = new RequestFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public RequestFrame(int speed) {
		serviceManager = new ServiceManager();
		vehicleSpeed = speed;
		
		setTitle("Request Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 686, 388);
		txtMemberID = new JPanel();
		txtMemberID.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(txtMemberID);
		txtMemberID.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 48, 296, 130);
		txtMemberID.add(panel);
		
		JLabel label = new JLabel("Pickup Location");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(10, 5, 105, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(115, 12, 0, 0);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(120, 12, 0, 0);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(125, 12, 0, 0);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(130, 12, 0, 0);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Street Address:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(10, 30, 100, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("City:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(10, 56, 54, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("State:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_7.setBounds(10, 81, 54, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Zipcode:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_8.setBounds(10, 106, 66, 14);
		panel.add(label_8);
		
		txtPickAddr = new JTextField();
		txtPickAddr.setText("Bunker Hill Lane");
		txtPickAddr.setColumns(10);
		txtPickAddr.setBounds(115, 24, 172, 20);
		panel.add(txtPickAddr);
		
		txtPickCity = new JTextField();
		txtPickCity.setText("Santa Clara");
		txtPickCity.setColumns(10);
		txtPickCity.setBounds(115, 50, 172, 20);
		panel.add(txtPickCity);
		
		txtPickState = new JTextField();
		txtPickState.setText("CA");
		txtPickState.setColumns(10);
		txtPickState.setBounds(115, 75, 172, 20);
		panel.add(txtPickState);
		
		txtPickZip = new JTextField();
		txtPickZip.setText("95054");
		txtPickZip.setColumns(10);
		txtPickZip.setBounds(115, 100, 172, 20);
		panel.add(txtPickZip);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(334, 48, 296, 130);
		txtMemberID.add(panel_1);
		
		JLabel label_9 = new JLabel("Destination");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_9.setBounds(10, 5, 105, 14);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(115, 12, 0, 0);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(120, 12, 0, 0);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(125, 12, 0, 0);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(130, 12, 0, 0);
		panel_1.add(label_13);
		
		JLabel label_14 = new JLabel("Street Address:");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_14.setBounds(10, 30, 100, 14);
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("City:");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_15.setBounds(10, 56, 54, 14);
		panel_1.add(label_15);
		
		JLabel label_16 = new JLabel("State:");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_16.setBounds(10, 81, 54, 14);
		panel_1.add(label_16);
		
		JLabel label_17 = new JLabel("Zipcode:");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_17.setBounds(10, 106, 66, 14);
		panel_1.add(label_17);
		
		txtDestAddr = new JTextField();
		txtDestAddr.setText("San Jose State ");
		txtDestAddr.setColumns(10);
		txtDestAddr.setBounds(115, 24, 172, 20);
		panel_1.add(txtDestAddr);
		
		txtDestCity = new JTextField();
		txtDestCity.setText("San Jose");
		txtDestCity.setColumns(10);
		txtDestCity.setBounds(115, 50, 172, 20);
		panel_1.add(txtDestCity);
		
		txtDestState = new JTextField();
		txtDestState.setText("CA");
		txtDestState.setColumns(10);
		txtDestState.setBounds(115, 75, 172, 20);
		panel_1.add(txtDestState);
		
		txtDestZip = new JTextField();
		txtDestZip.setText("95112");
		txtDestZip.setColumns(10);
		txtDestZip.setBounds(115, 100, 172, 20);
		panel_1.add(txtDestZip);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 179, 234, 39);
		txtMemberID.add(panel_2);
		
		JLabel label_18 = new JLabel("Number of Passengers:");
		label_18.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_18.setBounds(0, 11, 160, 16);
		panel_2.add(label_18);
		
		txtPassengers = new JTextField();
		txtPassengers.setText("1");
		txtPassengers.setColumns(10);
		txtPassengers.setBounds(170, 10, 42, 20);
		panel_2.add(txtPassengers);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(472, 179, 158, 39);
		txtMemberID.add(panel_3);
		
		JLabel label_19 = new JLabel("Shareable:");
		label_19.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_19.setBounds(10, 11, 85, 16);
		panel_3.add(label_19);
		
		cmbShareable = new JComboBox();
		cmbShareable.setModel(new DefaultComboBoxModel(new String[] {"No", "Yes"}));
		cmbShareable.setSelectedIndex(0);
		cmbShareable.setBounds(92, 6, 57, 29);
		panel_3.add(cmbShareable);
		cmbValueShare = cmbShareable.getSelectedItem().toString();
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(10, 260, 364, 39);
		txtMemberID.add(panel_4);
		
		cmbCommMethod = new JComboBox();
		cmbCommMethod.setModel(new DefaultComboBoxModel(new String[] {"Text", "Phone", "Email"}));
		cmbCommMethod.setSelectedIndex(0);
		cmbCommMethod.setBounds(184, 8, 122, 29);
		panel_4.add(cmbCommMethod);
		cmbValueComm = cmbCommMethod.getSelectedItem().toString();
		
		JLabel label_20 = new JLabel("Communication Method:");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_20.setBounds(0, 13, 160, 16);
		panel_4.add(label_20);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(254, 179, 207, 39);
		txtMemberID.add(panel_5);
		
		JLabel label_21 = new JLabel("Number of Luggages:");
		label_21.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_21.setBounds(10, 11, 160, 16);
		panel_5.add(label_21);
		
		txtLuggages = new JTextField();
		txtLuggages.setText("0");
		txtLuggages.setColumns(10);
		txtLuggages.setBounds(154, 10, 43, 20);
		panel_5.add(txtLuggages);
		
		JButton btnSubmit = new JButton("Submit Request");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubmit.setBounds(263, 310, 158, 35);
		txtMemberID.add(btnSubmit);
		btnSubmit.addActionListener(this);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(10, 2, 199, 35);
		txtMemberID.add(panel_6);
		
		JLabel lblMemberId = new JLabel("Member ID:");
		lblMemberId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMemberId.setBounds(0, 11, 197, 16);
		panel_6.add(lblMemberId);
		
		txtTxtmemberid = new JTextField();
		txtTxtmemberid.setText("1");
		txtTxtmemberid.setColumns(10);
		txtTxtmemberid.setBounds(96, 10, 93, 20);
		panel_6.add(txtTxtmemberid);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(10, 221, 152, 35);
		txtMemberID.add(panel_7);
		
		JLabel lblPickupDate = new JLabel("Pickup Date:");
		lblPickupDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPickupDate.setBounds(0, 11, 160, 16);
		panel_7.add(lblPickupDate);
		
		textField_11 = new JTextField();
		textField_11.setText("1");
		textField_11.setColumns(10);
		textField_11.setBounds(94, 10, 42, 20);
		panel_7.add(textField_11);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(327, 221, 152, 35);
		txtMemberID.add(panel_8);
		
		JLabel lblPickupTime = new JLabel("Pickup Time:");
		lblPickupTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPickupTime.setBounds(0, 11, 160, 16);
		panel_8.add(lblPickupTime);
		
		textField_12 = new JTextField();
		textField_12.setText("1");
		textField_12.setColumns(10);
		textField_12.setBounds(94, 10, 42, 20);
		panel_8.add(textField_12);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Address pickAddr;
		Address destAddr;
		int numPassengers;
		int numLuggages;
		boolean share;
		boolean member = false;
		String communication;
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
		
		cmbValueShare = cmbShareable.getSelectedItem().toString();
		if (cmbValueShare.contains("No")) {
			share = false;
		}
		else {
			share = true;
		}
		
		cmbValueComm = cmbCommMethod.getSelectedItem().toString();
		if (cmbValueComm.contains("Text")) {
			communication = ServiceManager.TEXT_COMMUNICATION;
		}
		else if (cmbValueComm.contains("Phone")) {
			communication = ServiceManager.PHONE_COMMUNICATION;
		}
		else {
			communication = ServiceManager.EMAIL_COMMUNICATION;
		}
		
		System.out.println("************** cmbValueShare= "+cmbValueShare);
		System.out.println("************** cmbValueComm = "+cmbValueComm);

				
		serviceManager.createRequest("guest", pickAddr, destAddr, numPassengers, numLuggages, 
				share, new Date(), "", vehicleSpeed);
		
		//Shared ride can't have more than 1 passenger and more than 1 luggage
		if (share == true) {
			if (numPassengers > 1 || numLuggages > 1) {
				Frame frame = new Frame();
				JOptionPane.showMessageDialog(frame,
						"Shared Ride can't have more than 1 passgenger \n and more than 1 luggage.",
						"Invalid Request ",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}
		
		this.dispose();
		
/*		System.out.println("Request Passed to Service Manager: ");
		System.out.println("\tPickUp Address = "+pickAddr);
		System.out.println("\tDestination Address = "+destAddr);
		System.out.println("\tPassengers = " + numPassengers + "   Luggages = "+numLuggages + 
				"   Shareable");
*/
	}
}
