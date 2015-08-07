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
	private MemberFrame frmMember;
	JButton btnRequestMile;
	JButton btnVehicle;
	JButton btnMember;
	JButton btnShuttle;
	JButton btnGenerateReport;
	private JButton btnRequestMint;
	
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
		frmHomePage.setBounds(100, 100, 290, 300);
		frmHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomePage.getContentPane().setLayout(null);
		
		btnRequestMile = new JButton("Place Request - pay/mile");
		btnRequestMile.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRequestMile.setBounds(22, 23, 191, 29);
		frmHomePage.getContentPane().add(btnRequestMile);
		btnRequestMile.addActionListener(this);
		
		btnVehicle = new JButton("CRUD Vehicle");
		btnVehicle.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVehicle.setBounds(22, 97, 191, 29);
		frmHomePage.getContentPane().add(btnVehicle);
		btnVehicle.addActionListener(this);
		
		btnMember = new JButton("CRUD Member");
		btnMember.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMember.setBounds(22, 137, 191, 29);
		frmHomePage.getContentPane().add(btnMember);
		btnMember.addActionListener(this);
		
		btnShuttle = new JButton("Register Shuttle");
		btnShuttle.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnShuttle.setBounds(22, 177, 191, 29);
		frmHomePage.getContentPane().add(btnShuttle);
		
		btnRequestMint = new JButton("Place Request - pay/mint");
		btnRequestMint.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRequestMint.setBounds(22, 57, 191, 29);
		frmHomePage.getContentPane().add(btnRequestMint);
		btnRequestMint.addActionListener(this);
		
		btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGenerateReport.setBounds(22, 217, 191, 29);
		frmHomePage.getContentPane().add(btnGenerateReport);
		btnGenerateReport.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRequestMile) {
			frmRequest = new RequestFrame(35);
			if (frmRequest.isVisible() == false ) {
				frmRequest.setVisible(true);
			}
		}
		
		if (e.getSource() == btnRequestMint) {
			frmRequest = new RequestFrame(12);
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
		
		if (e.getSource() == btnMember) {
			frmMember = new MemberFrame();
			if (frmMember.isVisible() == false ) {
				frmMember.setVisible(true);
			}
		}

		if (e.getSource() == btnShuttle) {
			ServiceManager.demonstrateShuttle();
		}
		
		if (e.getSource() == btnGenerateReport) {
			ServiceManager.demonstrateReport();
		}

	}
}
