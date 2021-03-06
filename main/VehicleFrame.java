package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class VehicleFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtLicense;
	private JTextField txtMinPassengers;
	private JTextField txtMaxPassengers;
	private JTextField txtLuggages;
	private JTextField txtUpLicense;
	private JTextField txtUpMinPsg;
	private JTextField txtUpMaxPsg;
	private JTextField txtUpMaxLug;
	private JTextField txtUpVehichleID;
	private JTextField txtPayMin;
	private JTextField txtPayMile;
	private JTextField txtUpPayMin;
	private JTextField txtUpPayMile;
	private JComboBox cmbState;
	private JComboBox cmbVehicleType;
	private JComboBox cmbUpVehicleType;
	private JComboBox cmbUpState;
	JButton btnAddVehicle;
	JButton btnUpdateVehicle;
	JButton btnRemoveVehicle;
	JButton btnGo;
	JComboBox cmbShare;
	JComboBox cmbUpShare;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VehicleFrame frame = new VehicleFrame();
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
	public VehicleFrame() {
		setTitle("CRUD Vehicle");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 623, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 564, 141);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAddNewVehicle = new JLabel("Add New Vehicle:");
		lblAddNewVehicle.setBounds(10, 11, 105, 15);
		lblAddNewVehicle.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddNewVehicle.setForeground(new Color(0, 0, 0));
		panel.add(lblAddNewVehicle);
		
		JLabel lblLicensePlate = new JLabel("License Plate #:");
		lblLicensePlate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLicensePlate.setBounds(10, 33, 105, 21);
		panel.add(lblLicensePlate);
		
		txtLicense = new JTextField();
		txtLicense.setText("CMP6066");
		txtLicense.setBounds(103, 34, 166, 20);
		panel.add(txtLicense);
		txtLicense.setColumns(10);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblType.setBounds(282, 33, 105, 21);
		panel.add(lblType);
		
		cmbVehicleType = new JComboBox();
		cmbVehicleType.setModel(new DefaultComboBoxModel(new String[] {"sedan", "van", "bus"}));
		cmbVehicleType.setBounds(324, 34, 141, 20);
		panel.add(cmbVehicleType);
		
		JLabel lblMinPassengers = new JLabel("Min Passengers:");
		lblMinPassengers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMinPassengers.setBounds(10, 58, 105, 21);
		panel.add(lblMinPassengers);
		
		txtMinPassengers = new JTextField();
		txtMinPassengers.setText("1");
		txtMinPassengers.setColumns(10);
		txtMinPassengers.setBounds(103, 59, 33, 20);
		panel.add(txtMinPassengers);
		
		JLabel lblMaxPassengers = new JLabel("Max Passengers:");
		lblMaxPassengers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxPassengers.setBounds(146, 58, 105, 21);
		panel.add(lblMaxPassengers);
		
		txtMaxPassengers = new JTextField();
		txtMaxPassengers.setText("3");
		txtMaxPassengers.setColumns(10);
		txtMaxPassengers.setBounds(236, 59, 33, 20);
		panel.add(txtMaxPassengers);
		
		JLabel lblMaxLuggages = new JLabel("Max Luggages:");
		lblMaxLuggages.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxLuggages.setBounds(282, 58, 105, 21);
		panel.add(lblMaxLuggages);
		
		txtLuggages = new JTextField();
		txtLuggages.setText("3");
		txtLuggages.setColumns(10);
		txtLuggages.setBounds(367, 59, 33, 20);
		panel.add(txtLuggages);
		
		JLabel lblVehicleState = new JLabel("Vehicle State:");
		lblVehicleState.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVehicleState.setBounds(10, 90, 105, 21);
		panel.add(lblVehicleState);
		
		cmbState = new JComboBox();
		cmbState.setModel(new DefaultComboBoxModel(new String[] {"AVAILABLE", "NOT AVAILABLE", "IN MAINTENANCE"}));
		cmbState.setBounds(97, 91, 134, 20);
		panel.add(cmbState);
		
		btnAddVehicle = new JButton("Add Vehicle");
		btnAddVehicle.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddVehicle.setBounds(187, 118, 125, 23);
		panel.add(btnAddVehicle);
		btnAddVehicle.addActionListener(this);
		
		JLabel lblPayPerMin = new JLabel("Pay per Minute:");
		lblPayPerMin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPayPerMin.setBounds(249, 90, 105, 21);
		panel.add(lblPayPerMin);
		
		txtPayMin = new JTextField();
		txtPayMin.setText("2.00");
		txtPayMin.setColumns(10);
		txtPayMin.setBounds(342, 91, 64, 20);
		panel.add(txtPayMin);
		
		JLabel lblPayPerMiles = new JLabel("Pay per Mile:");
		lblPayPerMiles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPayPerMiles.setBounds(416, 90, 105, 21);
		panel.add(lblPayPerMiles);
		
		txtPayMile = new JTextField();
		txtPayMile.setText("5.00");
		txtPayMile.setColumns(10);
		txtPayMile.setBounds(495, 91, 59, 20);
		panel.add(txtPayMile);
		
		JLabel lblShareable = new JLabel("Shareable:");
		lblShareable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblShareable.setBounds(416, 58, 64, 21);
		panel.add(lblShareable);
		
		cmbShare = new JComboBox();
		cmbShare.setModel(new DefaultComboBoxModel(new String[] {"Y", "N"}));
		cmbShare.setBounds(482, 59, 39, 20);
		panel.add(cmbShare);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 195, 564, 148);
		contentPane.add(panel_1);
		
		JLabel lblUpdateVehicle = new JLabel("Update/Remove Vehicle:");
		lblUpdateVehicle.setForeground(Color.BLACK);
		lblUpdateVehicle.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUpdateVehicle.setBounds(10, 11, 166, 15);
		panel_1.add(lblUpdateVehicle);
		
		JLabel label_1 = new JLabel("License Plate #:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(164, 8, 105, 21);
		panel_1.add(label_1);
		
		txtUpLicense = new JTextField();
		txtUpLicense.setColumns(10);
		txtUpLicense.setBounds(262, 9, 166, 20);
		panel_1.add(txtUpLicense);
		
		JLabel label_2 = new JLabel("Type:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(174, 37, 105, 21);
		panel_1.add(label_2);
		
		cmbUpVehicleType = new JComboBox();
		cmbUpVehicleType.setModel(new DefaultComboBoxModel(new String[] {"sedan", "van", "bus"}));
		cmbUpVehicleType.setBounds(215, 38, 141, 20);
		panel_1.add(cmbUpVehicleType);
		
		JLabel label_3 = new JLabel("Min Passengers:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(10, 58, 105, 21);
		panel_1.add(label_3);
		
		txtUpMinPsg = new JTextField();
		txtUpMinPsg.setColumns(10);
		txtUpMinPsg.setBounds(103, 59, 45, 20);
		panel_1.add(txtUpMinPsg);
		
		JLabel label_4 = new JLabel("Max Passengers:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(158, 58, 105, 21);
		panel_1.add(label_4);
		
		txtUpMaxPsg = new JTextField();
		txtUpMaxPsg.setColumns(10);
		txtUpMaxPsg.setBounds(251, 59, 45, 20);
		panel_1.add(txtUpMaxPsg);
		
		JLabel label_5 = new JLabel("Max Luggages:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(313, 58, 105, 21);
		panel_1.add(label_5);
		
		txtUpMaxLug = new JTextField();
		txtUpMaxLug.setColumns(10);
		txtUpMaxLug.setBounds(406, 59, 45, 20);
		panel_1.add(txtUpMaxLug);
		
		JLabel label_6 = new JLabel("Vehicle State:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBounds(10, 90, 105, 21);
		panel_1.add(label_6);
		
		cmbUpState = new JComboBox();
		cmbUpState.setModel(new DefaultComboBoxModel(new String[] {"AVAILABLE", "INTRANSIT", "NOT AVAILABLE", "IN MAINTENANCE"}));
		cmbUpState.setBounds(97, 91, 141, 20);
		panel_1.add(cmbUpState);
		
		btnUpdateVehicle = new JButton("Update Vehicle");
		btnUpdateVehicle.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateVehicle.setBounds(53, 122, 135, 23);
		panel_1.add(btnUpdateVehicle);
		btnUpdateVehicle.addActionListener(this);

		btnRemoveVehicle = new JButton("Remove Vehicle");
		btnRemoveVehicle.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemoveVehicle.setBounds(236, 122, 135, 23);
		panel_1.add(btnRemoveVehicle);
		btnRemoveVehicle.addActionListener(this);

		txtUpVehichleID = new JTextField();
		txtUpVehichleID.setEditable(false);
		txtUpVehichleID.setColumns(10);
		txtUpVehichleID.setBounds(77, 34, 73, 20);
		panel_1.add(txtUpVehichleID);
		
		JLabel lblVehicleId = new JLabel("Vehicle ID:");
		lblVehicleId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVehicleId.setBounds(10, 33, 105, 21);
		panel_1.add(lblVehicleId);
		
		btnGo = new JButton("Go");
		btnGo.setBounds(434, 8, 55, 23);
		panel_1.add(btnGo);
		btnGo.addActionListener(this);
		
		JLabel label = new JLabel("Pay per Minute:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(251, 90, 105, 21);
		panel_1.add(label);
		
		txtUpPayMin = new JTextField();
		txtUpPayMin.setColumns(10);
		txtUpPayMin.setBounds(344, 91, 63, 20);
		panel_1.add(txtUpPayMin);
		
		JLabel label_7 = new JLabel("Pay per Mile:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_7.setBounds(416, 90, 73, 21);
		panel_1.add(label_7);
		
		txtUpPayMile = new JTextField();
		txtUpPayMile.setColumns(10);
		txtUpPayMile.setBounds(499, 91, 55, 20);
		panel_1.add(txtUpPayMile);
		
		JLabel label_8 = new JLabel("Shareable:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_8.setBounds(444, 37, 64, 21);
		panel_1.add(label_8);
		
		cmbUpShare = new JComboBox();
		cmbUpShare.setModel(new DefaultComboBoxModel(new String[] {"Y", "N"}));
		cmbUpShare.setBounds(510, 38, 39, 20);
		panel_1.add(cmbUpShare);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAddVehicle) {
			String sql = "insert into vehicle (vehicle_license_num , vehicle_type, min_passengers," 
					+ " max_passengers, max_luggages, vehicle_shareable, vehicle_state, "
					+ " pay_per_minute, pay_per_mile, vehicle_active) values('" 
					+ txtLicense.getText() + "', '" 
					+ cmbVehicleType.getSelectedItem().toString() + "', '"  
					+ txtMinPassengers.getText() + "', '" 
					+ txtMaxPassengers.getText() + "', '" 
					+ txtLuggages.getText() + "', '" 
					+ cmbShare.getSelectedItem().toString() + "', '" 
					+ cmbState.getSelectedItem().toString() + "', '"
					+ txtPayMin.getText() + "', '"
					+ txtPayMile.getText() + "', 'Y')";
			DBHandler.updateDB(sql);
			System.out.println("\nNew Vehicle - License: " + txtLicense.getText() + " - " + " sucessfully added\n");
		}
		if (e.getSource() == (btnGo)) {
			String license = txtUpLicense.getText();
			   String query =
				        "select vehicle_type, min_passengers, max_passengers, max_luggages,"
					+ " vehicle_shareable, vehicle_state, pay_per_minute, pay_per_mile,"
				    + "vehicle_active, vehicle_id from vehicle where vehicle_license_num = '"+license + "'"; 
				        ResultSet rs = DBHandler.queryDB(query);
						try {
							rs.next();
							cmbUpVehicleType.setSelectedItem(rs.getString(1).toString());
							txtUpMinPsg.setText(rs.getString(2));
							txtUpMaxPsg.setText(rs.getString(3));
							txtUpMaxLug.setText(rs.getString(4));
							cmbUpShare.setSelectedItem(rs.getString(5).toString());
							cmbUpState.setSelectedIndex(0);
							txtUpPayMin.setText(rs.getString(7));
							txtUpPayMile.setText(rs.getString(8));
							txtUpVehichleID.setText(rs.getString(9));
						} catch (SQLException ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
					}
		}
		if (e.getSource() == (btnUpdateVehicle)) {
			String sql = "UPDATE vehicle SET "  
					+ " vehicle_type = '" + cmbUpVehicleType.getSelectedItem().toString()
					+ "', min_passengers = '" + txtUpMinPsg.getText() 
					+ "', max_passengers = '" + txtUpMaxPsg.getText() 
					+ "', max_luggages = '" + txtUpMaxLug.getText() 
					+ "', vehicle_shareable = '" + cmbUpShare.getSelectedItem().toString()
					+ "', vehicle_state = '" + cmbUpState.getSelectedItem().toString()  
					+ "', pay_per_minute = '" + txtUpPayMin.getText()
					+ "', pay_per_mile = '" + txtUpPayMile.getText()
					+ "' where vehicle_license_num = '" + txtUpLicense.getText() + "'";
			DBHandler.updateDB(sql);
			System.out.println("\nNew Vehicle - License: " + txtUpLicense.getText() + " - " + " updated\n");

		}
		if (e.getSource() == (btnRemoveVehicle)) {
			String sql = "UPDATE vehicle SET vehicle_active = 'N' where vehicle_license_num = '" + txtUpLicense.getText() + "'";
			DBHandler.updateDB(sql);
			System.out.println("\nVehicle - License: " + txtUpLicense.getText() + " - " + " inactivated.\n");
		}
		
	}
}
