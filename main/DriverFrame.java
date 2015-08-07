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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class DriverFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtVehicleID;
	private JTextField txtVehicleStatus;
	private JTextField txtReq;
	JButton btnStartRide;
	JButton btnEndRide;
	JButton btnCancelRide;
	Request req;
	JButton btnCashPayment;
	JButton btnCardPayment;
	JComboBox cmbReason;

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
		btnStartRide.setBounds(80, 154, 135, 23);
		contentPane.add(btnStartRide);
		btnStartRide.addActionListener(this);
		
		btnEndRide = new JButton("End Ride");
		btnEndRide.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEndRide.setBounds(274, 154, 135, 23);
		contentPane.add(btnEndRide);
		btnEndRide.addActionListener(this);
		
		btnCancelRide = new JButton("Cancel Ride");
		btnCancelRide.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelRide.setBounds(265, 220, 117, 23);
		contentPane.add(btnCancelRide);
		btnCancelRide.addActionListener(this);
		
		btnCashPayment = new JButton("Cash Payment");
		btnCashPayment.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCashPayment.setBounds(80, 188, 179, 23);
		contentPane.add(btnCashPayment);
		btnCashPayment.addActionListener(this);
		
		cmbReason = new JComboBox();
		cmbReason.setModel(new DefaultComboBoxModel(new String[] {"Customer No-Show", "Driver Not Available", "Vehicle Collision", "Vehicle Mechinal Issue", "Cop Pulled Over", "Other"}));
		cmbReason.setBounds(55, 222, 179, 21);
		contentPane.add(cmbReason);
		
		btnCardPayment = new JButton("Card/Member Payment");
		btnCardPayment.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCardPayment.setBounds(284, 188, 195, 23);
		contentPane.add(btnCardPayment);
		btnCardPayment.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnStartRide)) {
			req.getVehicle().getDriver().startRide(req);
		}
		
		if (e.getSource().equals(btnEndRide)) {
			txtVehicleStatus.setText("AVAILABLE");
			req.getVehicle().getDriver().endRide(req); 
		}
		
		if (e.getSource().equals(btnCancelRide)) {
			txtVehicleStatus.setText("AVAILABLE");
			req.getVehicle().getDriver().cancelRide(req, cmbReason.getSelectedItem().toString());
		}

		if (e.getSource().equals(btnCashPayment)) {
			txtVehicleStatus.setText("AVAILABLE");
			req.getVehicle().getDriver().cashPayment(req);
		}

		if (e.getSource().equals(btnCardPayment)) {
			txtVehicleStatus.setText("AVAILABLE");
			req.getVehicle().getDriver().cardOrMemberPayment(req);
		}
	}
}
