package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DriverFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverFrame frame = new DriverFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DriverFrame() {
		setTitle("Driver");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		textField = new JTextField();
		textField.setBounds(114, 0, 145, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblVehicleStatus = new JLabel("Vehicle Status:");
		lblVehicleStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVehicleStatus.setBounds(0, 28, 116, 17);
		panel.add(lblVehicleStatus);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(114, 27, 145, 23);
		panel.add(textField_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 83, 287, 70);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRequest = new JLabel("Request:");
		lblRequest.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRequest.setBounds(0, 0, 116, 17);
		panel_1.add(lblRequest);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 0, 221, 59);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnStartRide = new JButton("Start Ride");
		btnStartRide.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStartRide.setBounds(10, 204, 121, 23);
		contentPane.add(btnStartRide);
		
		JButton btnEndRide = new JButton("End Ride");
		btnEndRide.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEndRide.setBounds(149, 204, 141, 23);
		contentPane.add(btnEndRide);
		
		JButton btnCustomerNoshow = new JButton("Customer No-Show");
		btnCustomerNoshow.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCustomerNoshow.setBounds(300, 204, 155, 23);
		contentPane.add(btnCustomerNoshow);
	}
}
