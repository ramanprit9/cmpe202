package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApplication implements ActionListener {

	private JFrame frmHomePage;
	private RequestFrame frmRequest;
	private VehicleFrame frmVehicle;
	JButton btnRequest;
	JButton btnVehicle;
	JButton btnMember;
	JButton btnShuttle;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApplication window = new MainApplication();
					window.frmHomePage.setVisible(true);
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
		frmHomePage = new JFrame();
		frmHomePage.setTitle("Home Page");
		frmHomePage.setBounds(100, 100, 320, 300);
		frmHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomePage.getContentPane().setLayout(null);
		
		btnRequest = new JButton("Place Request");
		btnRequest.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRequest.setBounds(22, 23, 145, 29);
		frmHomePage.getContentPane().add(btnRequest);
		btnRequest.addActionListener(this);
		
		btnVehicle = new JButton("CRUD Vehicle");
		btnVehicle.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVehicle.setBounds(22, 62, 145, 29);
		frmHomePage.getContentPane().add(btnVehicle);
		btnVehicle.addActionListener(this);
		
		btnMember = new JButton("CRUD Member");
		btnMember.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMember.setBounds(22, 102, 145, 29);
		frmHomePage.getContentPane().add(btnMember);
		btnMember.addActionListener(this);
		
		btnShuttle = new JButton("Register Shuttle");
		btnShuttle.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnShuttle.setBounds(22, 142, 145, 29);
		frmHomePage.getContentPane().add(btnShuttle);
		btnShuttle.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRequest) {
			frmRequest = new RequestFrame();
			if (frmRequest.isVisible() == false ) {
				frmRequest.setVisible(true);
			}
		}
		
		if (e.getSource() == btnVehicle) {
			frmVehicle = new VehicleFrame();
			if (frmVehicle.isVisible() == false ) {
				frmVehicle.setVisible(true);
			}
		}

	}
}
