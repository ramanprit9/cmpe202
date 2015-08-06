package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class MemberFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtCardNum;
	private JTextField txtCVS;
	private JTextField txtUpAddr;
	private JTextField txtUpCity;
	private JTextField txtUpState;
	private JTextField txtUpZip;
	private JTextField txtUpFirstName;
	private JTextField txtUpLastName;
	private JTextField txtUpCardNum;
	private JTextField txtUpCVS;
	private JTextField txtAddr;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtZip;
	private JTextField txtUsername;
	private JTextField txtUpUsername;
	JComboBox cmbStatus;
	JComboBox cmbCard;
	JComboBox cmbUpStatus;
	JComboBox cmbUpCard;
	JButton btnUpdateMember;
	JButton btnRemoveMember;
	JButton btnAddMember;
	JButton btnGo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberFrame frame = new MemberFrame();
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
	public MemberFrame() {
		setTitle("CRUD Member");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 627, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 564, 204);
		contentPane.add(panel);
		
		JLabel lblAddNewMember = new JLabel("Add New Member:");
		lblAddNewMember.setForeground(Color.BLACK);
		lblAddNewMember.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddNewMember.setBounds(10, 11, 138, 15);
		panel.add(lblAddNewMember);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFirstName.setBounds(10, 35, 100, 14);
		panel.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("James");
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(86, 33, 153, 20);
		panel.add(txtFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastName.setBounds(10, 62, 100, 14);
		panel.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setText("Cruise");
		txtLastName.setColumns(10);
		txtLastName.setBounds(86, 60, 153, 20);
		panel.add(txtLastName);
		
		JLabel lblCardType = new JLabel("Card Type:");
		lblCardType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCardType.setBounds(10, 114, 76, 14);
		panel.add(lblCardType);
		
		cmbCard = new JComboBox();
		cmbCard.setModel(new DefaultComboBoxModel(new String[] {"CREDITCARD", "DEBITCARD"}));
		cmbCard.setBounds(96, 112, 126, 20);
		panel.add(cmbCard);
		
		JLabel lblCardNumber = new JLabel("Card Number:");
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCardNumber.setBounds(10, 136, 86, 14);
		panel.add(lblCardNumber);
		
		txtCardNum = new JTextField();
		txtCardNum.setText("3456789");
		txtCardNum.setColumns(10);
		txtCardNum.setBounds(96, 134, 143, 20);
		panel.add(txtCardNum);
		
		JLabel lblCvsNumber = new JLabel("CVS Number:");
		lblCvsNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCvsNumber.setBounds(10, 161, 100, 14);
		panel.add(lblCvsNumber);
		
		txtCVS = new JTextField();
		txtCVS.setText("234");
		txtCVS.setColumns(10);
		txtCVS.setBounds(96, 159, 76, 20);
		panel.add(txtCVS);
		
		btnAddMember = new JButton("Add Member");
		btnAddMember.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddMember.setBounds(192, 173, 160, 23);
		panel.add(btnAddMember);
		btnAddMember.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(259, 11, 295, 121);
		panel.add(panel_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(115, 12, 0, 0);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(120, 12, 0, 0);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(125, 12, 0, 0);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(130, 12, 0, 0);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Street Address:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(15, 14, 100, 14);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("City:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(15, 39, 54, 14);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("State:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_7.setBounds(10, 70, 54, 14);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("Zipcode:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_8.setBounds(15, 95, 66, 14);
		panel_1.add(label_8);
		
		txtAddr = new JTextField();
		txtAddr.setText("1505 Shining Moon Drive");
		txtAddr.setColumns(10);
		txtAddr.setBounds(115, 12, 172, 20);
		panel_1.add(txtAddr);
		
		txtCity = new JTextField();
		txtCity.setText("Milpitas");
		txtCity.setColumns(10);
		txtCity.setBounds(115, 39, 172, 20);
		panel_1.add(txtCity);
		
		txtState = new JTextField();
		txtState.setText("CA");
		txtState.setColumns(10);
		txtState.setBounds(115, 64, 172, 20);
		panel_1.add(txtState);
		
		txtZip = new JTextField();
		txtZip.setText("95035");
		txtZip.setColumns(10);
		txtZip.setBounds(115, 95, 172, 20);
		panel_1.add(txtZip);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(252, 144, 100, 14);
		panel.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setText("james.cruise");
		txtUsername.setColumns(10);
		txtUsername.setBounds(320, 142, 138, 20);
		panel.add(txtUsername);
		
		JLabel lblStatus_1 = new JLabel("Status:");
		lblStatus_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStatus_1.setBounds(10, 87, 76, 14);
		panel.add(lblStatus_1);
		
		cmbStatus = new JComboBox();
		cmbStatus.setModel(new DefaultComboBoxModel(new String[] {"SILVER", "GOLD", "PLATINUM"}));
		cmbStatus.setBounds(96, 87, 126, 20);
		panel.add(cmbStatus);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 213, 564, 215);
		contentPane.add(panel_2);
		
		JLabel lblUpdateremoveMember = new JLabel("Update/Remove Member:");
		lblUpdateremoveMember.setForeground(Color.BLACK);
		lblUpdateremoveMember.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUpdateremoveMember.setBounds(10, 11, 176, 15);
		panel_2.add(lblUpdateremoveMember);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(258, 48, 296, 130);
		panel_2.add(panel_3);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(115, 12, 0, 0);
		panel_3.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(120, 12, 0, 0);
		panel_3.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(125, 12, 0, 0);
		panel_3.add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(130, 12, 0, 0);
		panel_3.add(label_13);
		
		JLabel label_14 = new JLabel("Street Address:");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_14.setBounds(10, 12, 100, 14);
		panel_3.add(label_14);
		
		JLabel label_15 = new JLabel("City:");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_15.setBounds(10, 37, 54, 14);
		panel_3.add(label_15);
		
		JLabel label_16 = new JLabel("State:");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_16.setBounds(10, 71, 54, 14);
		panel_3.add(label_16);
		
		JLabel label_17 = new JLabel("Zipcode:");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_17.setBounds(10, 106, 66, 14);
		panel_3.add(label_17);
		
		txtUpAddr = new JTextField();
		txtUpAddr.setColumns(10);
		txtUpAddr.setBounds(115, 12, 172, 20);
		panel_3.add(txtUpAddr);
		
		txtUpCity = new JTextField();
		txtUpCity.setColumns(10);
		txtUpCity.setBounds(115, 41, 172, 20);
		panel_3.add(txtUpCity);
		
		txtUpState = new JTextField();
		txtUpState.setColumns(10);
		txtUpState.setBounds(115, 69, 172, 20);
		panel_3.add(txtUpState);
		
		txtUpZip = new JTextField();
		txtUpZip.setColumns(10);
		txtUpZip.setBounds(115, 104, 172, 20);
		panel_3.add(txtUpZip);
		
		JLabel label_18 = new JLabel("First Name:");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_18.setBounds(10, 35, 100, 14);
		panel_2.add(label_18);
		
		txtUpFirstName = new JTextField();
		txtUpFirstName.setColumns(10);
		txtUpFirstName.setBounds(86, 33, 153, 20);
		panel_2.add(txtUpFirstName);
		
		JLabel label_19 = new JLabel("Last Name:");
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_19.setBounds(10, 62, 100, 14);
		panel_2.add(label_19);
		
		txtUpLastName = new JTextField();
		txtUpLastName.setColumns(10);
		txtUpLastName.setBounds(86, 60, 153, 20);
		panel_2.add(txtUpLastName);
		
		JLabel label_20 = new JLabel("Card Type:");
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_20.setBounds(10, 115, 76, 14);
		panel_2.add(label_20);
		
		cmbUpCard = new JComboBox();
		cmbUpCard.setModel(new DefaultComboBoxModel(new String[] {"CREDIT CARD", "DEBIT CARD"}));
		cmbUpCard.setBounds(86, 115, 126, 20);
		panel_2.add(cmbUpCard);
		
		JLabel label_21 = new JLabel("Card Number:");
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_21.setBounds(10, 142, 100, 14);
		panel_2.add(label_21);
		
		txtUpCardNum = new JTextField();
		txtUpCardNum.setColumns(10);
		txtUpCardNum.setBounds(96, 140, 143, 20);
		panel_2.add(txtUpCardNum);
		
		JLabel label_22 = new JLabel("CVS Number:");
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_22.setBounds(10, 164, 100, 14);
		panel_2.add(label_22);
		
		txtUpCVS = new JTextField();
		txtUpCVS.setColumns(10);
		txtUpCVS.setBounds(96, 162, 76, 20);
		panel_2.add(txtUpCVS);
		
		btnUpdateMember = new JButton("Update Member");
		btnUpdateMember.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateMember.setBounds(106, 183, 133, 23);
		panel_2.add(btnUpdateMember);
		btnUpdateMember.addActionListener(this);
		
		btnRemoveMember = new JButton("Remove Member");
		btnRemoveMember.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemoveMember.setBounds(279, 183, 143, 23);
		panel_2.add(btnRemoveMember);
		btnRemoveMember.addActionListener(this);
		
		JLabel label = new JLabel("Username:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(221, 17, 100, 14);
		panel_2.add(label);
		
		txtUpUsername = new JTextField();
		txtUpUsername.setColumns(10);
		txtUpUsername.setBounds(289, 15, 138, 20);
		panel_2.add(txtUpUsername);
		
		btnGo = new JButton("Go");
		btnGo.setBounds(436, 14, 89, 23);
		panel_2.add(btnGo);
		btnGo.addActionListener(this);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStatus.setBounds(10, 90, 76, 14);
		panel_2.add(lblStatus);
		
		cmbUpStatus = new JComboBox();
		cmbUpStatus.setModel(new DefaultComboBoxModel(new String[] {"SILVER", "GOLD", "PLATINUM"}));
		cmbUpStatus.setBounds(86, 87, 133, 20);
		panel_2.add(cmbUpStatus);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnAddMember)) {
			String sql = "insert into member_registration (member_fname, member_lname, member_street," 
					+ " member_city, member_state, member_zip, member_card_type, member_card_number, member_card_cvs_number,"
					+ " member_username, member_active) values('" 
					+ txtFirstName.getText() + "', '" 
					+ txtLastName.getText() + "', '"  
					+ txtAddr.getText() + "', '" 
					+ txtCity.getText() + "', '" 
					+ txtState.getText() + "', '" 
					+ txtZip.getText() + "', '"  
					+ cmbCard.getSelectedItem().toString() + "', '"
					+ txtCardNum.getText() + "', '"
					+ txtCVS.getText() + "', '"
					+ txtUsername.getText() + "', 'Y')";
			DBHandler.updateDB(sql);
			System.out.println("New Member - " + txtFirstName.getText()+ " - " + txtLastName.getText() + " sucessfully added");
		}
		if (e.getSource() == (btnGo)) {
			String username = txtUpUsername.getText();
			   String query =
				        "select member_fname,member_lname, member_street, member_city, member_state, member_zip, member_type, member_card_type, member_card_number," +
						" member_card_cvs_number from member_registration where member_username = '"+username + "'"; 
				        ResultSet rs = DBHandler.queryDB(query);
						try {
							rs.next();
								txtUpFirstName.setText(rs.getString(1));
								txtUpLastName.setText(rs.getString(2));
								txtUpAddr.setText(rs.getString(3));
								txtUpCity.setText(rs.getString(4));
								txtUpState.setText(rs.getString(5));
								txtUpZip.setText(rs.getString(6));
								cmbUpStatus.setSelectedIndex(0);
								cmbUpCard.setSelectedIndex(0);
								txtUpCardNum.setText(rs.getString(9));
								txtUpCVS.setText(rs.getString(10));
						} catch (SQLException ex) {
					// TODO Auto-generated catch block
							ex.printStackTrace();
					}
				
		}
		if (e.getSource() == (btnUpdateMember)) {
			String sql = "UPDATE member_registration SET "  
					+ " member_fname = '" + txtUpFirstName.getText() 
					+ "', member_lname = '" + txtUpLastName.getText() 
					+ "', member_street = '" + txtUpAddr.getText() 
					+ "', member_city = '" + txtCity.getText() 
					+ "', member_state = '" + txtState.getText() 
					+ "', member_zip = '" + txtZip.getText()   
					+ "', member_card_type = '" + cmbCard.getSelectedItem().toString() 
					+ "', member_card_number = '" + txtCardNum.getText()
					+ "', member_card_cvs_number = '" + txtCVS.getText()
					+ "' where member_username = '" + txtUsername.getText() + "'";
			DBHandler.updateDB(sql);
			System.out.println("Member " + txtUpFirstName.getText() + " " + txtUpLastName.getText() + " updated.");
		}
		if (e.getSource() == (btnRemoveMember)) {
			String sql = "UPDATE member_registration SET member_active = 'N' where member_username = '" + txtUpUsername.getText() + "'";
			DBHandler.updateDB(sql);
			System.out.println("Member " + txtUpFirstName.getText() + " " + txtUpLastName.getText() + " inactivated.");
		}

	}
}
