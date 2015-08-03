package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

import request.Request;

public class DriverFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtVehicleID;
	private JTextField txtVehicleStatus;
	private JTextField txtReq;
	JButton btnStartRide;
	JButton btnEndRide;
	JButton btnCancelRide;
	ServiceManager serviceManager;
	Request req;


	/**
	 * Create the frame.
	 */
	public DriverFrame(Request _req) {
		req = _req;
		setTitle("Driver");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 595, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 350, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblVehicleStatus = new JLabel("Vehicle Status:");
		lblVehicleStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVehicleStatus.setBounds(0, 28, 116, 17);
		panel.add(lblVehicleStatus);
		
		txtVehicleStatus = new JTextField();
		txtVehicleStatus.setText("INTRANSIT");
		txtVehicleStatus.setEditable(false);
		txtVehicleStatus.setColumns(10);
		txtVehicleStatus.setBounds(114, 27, 145, 23);
		panel.add(txtVehicleStatus);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 83, 529, 70);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRequest = new JLabel("Request:");
		lblRequest.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRequest.setBounds(0, 0, 116, 17);
		panel_1.add(lblRequest);
		
		txtReq = new JTextField();
		txtReq.setEditable(false);
		txtReq.setBounds(66, 0, 453, 59);
		panel_1.add(txtReq);
		txtReq.setColumns(10);
		txtReq.setText(req.getBasicRequestString());
		
		btnStartRide = new JButton("Start Ride");
		btnStartRide.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStartRide.setBounds(10, 204, 99, 23);
		contentPane.add(btnStartRide);
		btnStartRide.addActionListener(this);
		
		btnEndRide = new JButton("End Ride");
		btnEndRide.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEndRide.setBounds(119, 204, 93, 23);
		contentPane.add(btnEndRide);
		btnEndRide.addActionListener(this);
		
		btnCancelRide = new JButton("Cancel Ride");
		btnCancelRide.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelRide.setBounds(222, 204, 117, 23);
		contentPane.add(btnCancelRide);
		btnCancelRide.addActionListener(this);
		
		JButton btnCustomerPaid = new JButton("Customer Paid");
		btnCustomerPaid.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCustomerPaid.setBounds(349, 205, 147, 23);
		contentPane.add(btnCustomerPaid);
		btnCancelRide.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		serviceManager = new ServiceManager();
		if (e.getSource().equals(btnStartRide)) {
			serviceManager.startRide(req);
		}
		
		if (e.getSource().equals(btnEndRide)) {
			txtVehicleStatus.setText("AVAILABLE");
			serviceManager.endRide(req); 
		}
		
		if (e.getSource().equals(btnCancelRide)) {
			txtVehicleStatus.setText("AVAILABLE");
			serviceManager.endRide(req); 
		}

	}
}
