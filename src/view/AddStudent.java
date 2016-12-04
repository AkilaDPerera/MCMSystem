package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JRadioButton;
import java.awt.Choice;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class AddStudent extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField txtDd;
	private JTextField txtMm;
	private JTextField txtYyyy;
	private ButtonGroup bg = new ButtonGroup();
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		setTitle("Add Student");
		setBounds(100, 100, 500, 719);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblAddStudent = new JLabel("Add Student");
		lblAddStudent.setBounds(162, 13, 138, 16);
		getContentPane().add(lblAddStudent);
		
		textField = new JTextField();
		textField.setBounds(101, 42, 164, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name*");
		lblNewLabel.setBounds(12, 45, 77, 16);
		getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 77, 164, 22);
		getContentPane().add(textField_1);
		
		JLabel lblLastName = new JLabel("Last Name*");
		lblLastName.setBounds(12, 80, 77, 16);
		getContentPane().add(lblLastName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(22, 209, 164, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAddressLine = new JLabel("Address line 1*");
		lblAddressLine.setBounds(12, 188, 112, 16);
		getContentPane().add(lblAddressLine);
		
		JLabel lblAddressLine_1 = new JLabel("Address line 2");
		lblAddressLine_1.setBounds(12, 244, 112, 16);
		getContentPane().add(lblAddressLine_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(22, 262, 164, 22);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAddressLine_2 = new JLabel("Address line 3");
		lblAddressLine_2.setBounds(12, 297, 112, 16);
		getContentPane().add(lblAddressLine_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(22, 315, 164, 22);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(306, 209, 164, 22);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblMobileNumber = new JLabel("E-mail address*");
		lblMobileNumber.setBounds(281, 188, 119, 16);
		getContentPane().add(lblMobileNumber);
		
		textField_6 = new JTextField();
		textField_6.setBounds(306, 262, 164, 22);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(306, 315, 164, 22);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblMobileNumber_1 = new JLabel("Mobile Number*");
		lblMobileNumber_1.setBounds(281, 244, 108, 16);
		getContentPane().add(lblMobileNumber_1);
		
		JLabel lblMobileNumber_2 = new JLabel("Mobile Number");
		lblMobileNumber_2.setBounds(281, 297, 108, 16);
		getContentPane().add(lblMobileNumber_2);
		
		JLabel lblGender = new JLabel("Gender*");
		lblGender.setBounds(12, 130, 56, 16);
		getContentPane().add(lblGender);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(22, 153, 164, 22);
		getContentPane().add(comboBox);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth (dd/mm/yyyy)");
		lblDateOfBirth.setBounds(259, 130, 164, 16);
		getContentPane().add(lblDateOfBirth);
		
		txtDd = new JTextField();
		txtDd.setText("dd");
		txtDd.setBounds(306, 153, 20, 22);
		getContentPane().add(txtDd);
		txtDd.setColumns(10);
		
		txtMm = new JTextField();
		txtMm.setText("mm");
		txtMm.setBounds(338, 153, 20, 22);
		getContentPane().add(txtMm);
		txtMm.setColumns(10);
		
		txtYyyy = new JTextField();
		txtYyyy.setText("yyyy");
		txtYyyy.setBounds(370, 153, 43, 22);
		getContentPane().add(txtYyyy);
		txtYyyy.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setBounds(327, 156, 10, 16);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(361, 156, 10, 16);
		getContentPane().add(label_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New Family");

		
		
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(262, 368, 127, 25);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Existing Family");

		rdbtnNewRadioButton_1.setBounds(70, 368, 127, 25);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(188, 625, 97, 25);
		getContentPane().add(btnSubmit);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(12, 402, 458, 206);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		panel.setEnabled(false);
		
		JLabel lblFamilyId = new JLabel("Family id*");
		lblFamilyId.setBounds(125, 91, 59, 16);
		panel.add(lblFamilyId);
		
		textField_8 = new JTextField();
		textField_8.setBounds(218, 88, 116, 22);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(12, 402, 458, 206);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setEnabled(true);
		
		JLabel lblMothersName = new JLabel("Mother's name");
		lblMothersName.setBounds(39, 26, 95, 16);
		panel_1.add(lblMothersName);
		
		textField_9 = new JTextField();
		textField_9.setBounds(49, 41, 164, 22);
		panel_1.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblFathersName = new JLabel("Father's name");
		lblFathersName.setBounds(39, 76, 95, 16);
		panel_1.add(lblFathersName);
		
		textField_10 = new JTextField();
		textField_10.setBounds(49, 90, 164, 22);
		panel_1.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblGuardiansName = new JLabel("Guardian's name");
		lblGuardiansName.setBounds(39, 125, 118, 16);
		panel_1.add(lblGuardiansName);
		
		textField_13 = new JTextField();
		textField_13.setBounds(49, 140, 164, 22);
		panel_1.add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setBounds(274, 13, 108, 16);
		panel_1.add(lblContactNumber);
		
		textField_11 = new JTextField();
		textField_11.setBounds(274, 41, 95, 22);
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(274, 90, 95, 22);
		panel_1.add(textField_12);
		textField_12.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(274, 140, 95, 22);
		panel_1.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblClassWantTo = new JLabel("Class want to join :");
		lblClassWantTo.setBounds(306, 42, 117, 16);
		getContentPane().add(lblClassWantTo);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"None", "Set of classes come to here"}));
		comboBox_1.setBounds(327, 60, 143, 22);
		getContentPane().add(comboBox_1);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblMobileNumber_2, textField, textField_1, comboBox, lblAddStudent, txtDd, txtMm, lblLastName, txtYyyy, lblAddressLine, textField_2, textField_3, lblAddressLine_1, textField_4, lblAddressLine_2, textField_5, lblMobileNumber, textField_6, lblMobileNumber_1, textField_7, lblGender, lblDateOfBirth, label, label_1, lblNewLabel}));
		


		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(true);
				panel_1.setEnabled(true);
				panel.setVisible(false);
				panel.setEnabled(false);
				
				
			}
		});
		
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(true);
				panel.setEnabled(true);
				panel_1.setVisible(false);
				panel_1.setEnabled(false);
			}
		});


	}
}
