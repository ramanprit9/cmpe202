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
	JButton btnCustomerNoShow;
	ServiceManager serviceManager;
	Request req;


	/**
	 * Create the frame.
	 */
	public DriverFrame(Request _req) {
		req = _req;
		setTitle("Driver");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 287, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Vehicle ID: ");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(0, 0, 104, 17);
		panel.add(label);
		
		txtVehicleID = new JTextField();
		txtVehicleID.setEditable(false);
		txtVehicleID.setBounds(114, 0, 145, 20);
		panel.add(txtVehicleID);
		txtVehicleID.setColumns(10);
		
		JLabel lblVehicleStatus = new JLabel("Vehicle Status:");
		lblVehicleStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVehicleStatus.setBounds(0, 28, 116, 17);
		panel.add(lblVehicleStatus);
		
		txtVehicleStatus = new JTextField();
		txtVehicleStatus.setEditable(false);
		txtVehicleStatus.setColumns(10);
		txtVehicleStatus.setBounds(114, 27, 145, 23);
		panel.add(txtVehicleStatus);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 83, 287, 70);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRequest = new JLabel("Request:");
		lblRequest.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRequest.setBounds(0, 0, 116, 17);
		panel_1.add(lblRequest);
		
		txtReq = new JTextField();
		txtReq.setEditable(false);
		txtReq.setBounds(66, 0, 221, 59);
		panel_1.add(txtReq);
		txtReq.setColumns(10);
		
		btnStartRide = new JButton("Start Ride");
		btnStartRide.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStartRide.setBounds(10, 204, 121, 23);
		contentPane.add(btnStartRide);
		
		btnEndRide = new JButton("End Ride");
		btnEndRide.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEndRide.setBounds(149, 204, 141, 23);
		contentPane.add(btnEndRide);
		
		btnCustomerNoShow = new JButton("Customer No-Show");
		btnCustomerNoShow.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCustomerNoShow.setBounds(300, 204, 155, 23);
		contentPane.add(btnCustomerNoShow);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		serviceManager = new ServiceManager();
		if (e.equals(btnStartRide)) {
			serviceManager.startRide(req);
		}
		if (e.equals(btnEndRide)) {
			serviceManager.endRide(req);
		}
	}
}
