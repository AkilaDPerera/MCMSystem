package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class AddTeacher extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacher frame = new AddTeacher();
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
	public AddTeacher() {
		setTitle("Add Teacher");
		setBounds(100, 100, 500, 560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Teacher");
		lblNewLabel.setBounds(157, 13, 138, 16);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(201, 87, 164, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(201, 122, 164, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name*");
		lblNewLabel_2.setBounds(73, 125, 116, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("First Name*");
		lblNewLabel_1.setBounds(73, 90, 70, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblAddressLine = new JLabel("Address line 1*");
		lblAddressLine.setBounds(73, 186, 116, 16);
		getContentPane().add(lblAddressLine);
		
		textField_2 = new JTextField();
		textField_2.setBounds(201, 180, 164, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAddressLine_1 = new JLabel("Address line 2");
		lblAddressLine_1.setBounds(73, 218, 116, 16);
		getContentPane().add(lblAddressLine_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(201, 215, 164, 22);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(201, 250, 164, 22);
		getContentPane().add(textField_4);
		
		JLabel lblNewLabel_3 = new JLabel("Address line 3");
		lblNewLabel_3.setBounds(73, 253, 116, 16);
		getContentPane().add(lblNewLabel_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(201, 307, 164, 22);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblPhoneNumberprimary = new JLabel("Mobile Number*");
		lblPhoneNumberprimary.setBounds(73, 310, 116, 16);
		getContentPane().add(lblPhoneNumberprimary);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(201, 342, 164, 22);
		getContentPane().add(textField_6);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile Number");
		lblNewLabel_4.setBounds(73, 345, 116, 16);
		getContentPane().add(lblNewLabel_4);
		
		textField_7 = new JTextField();
		textField_7.setBounds(201, 377, 164, 22);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblEmailAddress = new JLabel("E-mail address*");
		lblEmailAddress.setBounds(73, 380, 116, 16);
		getContentPane().add(lblEmailAddress);
		
		textField_8 = new JTextField();
		textField_8.setBounds(201, 424, 164, 22);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Salary*");
		lblNewLabel_5.setBounds(73, 427, 84, 16);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblRs = new JLabel("Rs.");
		lblRs.setBounds(174, 427, 25, 16);
		getContentPane().add(lblRs);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(268, 477, 97, 25);
		getContentPane().add(btnSubmit);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mr.", "Miss.", "Mrs."}));
		comboBox.setBounds(201, 52, 84, 22);
		getContentPane().add(comboBox);
		
		JLabel lblDecoration = new JLabel("Decoration");
		lblDecoration.setBounds(73, 55, 84, 16);
		getContentPane().add(lblDecoration);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel_1, lblAddressLine, lblNewLabel_2, lblAddressLine_1, lblNewLabel_3, lblPhoneNumberprimary, lblNewLabel_4, lblEmailAddress, lblNewLabel_5, lblRs, lblDecoration, lblNewLabel, comboBox, textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6, textField_7, textField_8, btnSubmit}));

	}
}
