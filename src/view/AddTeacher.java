package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import model.AddTeacherLogic;
import validation.GeneralValidations;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class AddTeacher extends JFrame {
	private JFrame main;
	private JFrame win;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldAddress;
	private JTextField textFieldPhone;
	private JTextField textFieldPhone2;
	private JTextField textFieldEmail;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	public AddTeacher(JFrame main) {
		setResizable(false);
		setType(Type.POPUP);
		this.main = main;
		this.win = this;
		setTitle("Add Teacher");
		setBounds(100, 100, 418, 446);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Teacher");
		lblNewLabel.setBounds(157, 13, 138, 16);
		getContentPane().add(lblNewLabel);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(140, 57, 164, 22);
		getContentPane().add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(140, 92, 164, 22);
		getContentPane().add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name*");
		lblLastName.setBounds(12, 95, 116, 16);
		getContentPane().add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name*");
		lblFirstName.setBounds(12, 60, 70, 16);
		getContentPane().add(lblFirstName);
		
		JLabel lblAddress = new JLabel("Address*");
		lblAddress.setBounds(12, 156, 116, 16);
		getContentPane().add(lblAddress);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(140, 150, 164, 22);
		getContentPane().add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(140, 208, 164, 22);
		getContentPane().add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		JLabel lblPhone = new JLabel("Mobile Number*");
		lblPhone.setBounds(12, 211, 116, 16);
		getContentPane().add(lblPhone);
		
		textFieldPhone2 = new JTextField();
		textFieldPhone2.setColumns(10);
		textFieldPhone2.setBounds(140, 243, 164, 22);
		getContentPane().add(textFieldPhone2);
		
		JLabel lblPhone2 = new JLabel("Mobile Number");
		lblPhone2.setBounds(12, 246, 116, 16);
		getContentPane().add(lblPhone2);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(140, 278, 164, 22);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail address*");
		lblEmail.setBounds(12, 281, 116, 16);
		getContentPane().add(lblEmail);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Boolean> temp = new ArrayList<Boolean>();
				
				String first_name = textFieldFirstName.getText().trim();
				String last_name = textFieldLastName.getText().trim();
				String address = textFieldAddress.getText().trim();
				String email = textFieldEmail.getText().trim();
				String phone = textFieldPhone.getText().trim();
				String alt_phone = textFieldPhone2.getText().trim();
				
				temp.add(GeneralValidations.nameValidation(first_name));
				temp.add(GeneralValidations.nameValidation(last_name));
				temp.add(GeneralValidations.addressValidation(address));
				temp.add(GeneralValidations.emailValidation(email));
				temp.add(GeneralValidations.phoneValidation(phone));
				temp.add(GeneralValidations.optionalPhoneValidation(alt_phone));
				
				Boolean isGoodToGo = true;
				
				for (Boolean t: temp){
					if (!t){
						//Basic validation fail. Check the entries again
						//Changing the font color
						lblFirstName.setForeground(Color.red);
						lblLastName.setForeground(Color.red);
						lblAddress.setForeground(Color.red);
						lblEmail.setForeground(Color.red);
						lblPhone.setForeground(Color.red);
						lblPhone2.setForeground(Color.red);
						
						//display a error message
						JOptionPane.showMessageDialog(null, "Check the highlighted text and try again.", "Error", JOptionPane.ERROR_MESSAGE);
						isGoodToGo = false;
						break;
					}
				}
				
				if (isGoodToGo){
					try {
						String [] result = AddTeacherLogic.addTeacher(first_name, last_name, phone, alt_phone, address, email, "0");
						JOptionPane.showMessageDialog(null, "Adding successful!\nTeacher id: "+result[0], "Successful", JOptionPane.INFORMATION_MESSAGE);
						win.dispose();
						main.setVisible(true);
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
			}
		});
		btnSubmit.setBounds(259, 335, 97, 25);
		getContentPane().add(btnSubmit);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.dispose();
				main.setVisible(true);
			}
		});
		btnNewButton.setBounds(31, 335, 97, 25);
		getContentPane().add(btnNewButton);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblFirstName, lblAddress, lblLastName, lblPhone, lblPhone2, lblEmail, lblNewLabel, textFieldFirstName, textFieldLastName, textFieldAddress, textFieldPhone, textFieldPhone2, textFieldEmail, btnSubmit}));

	}
}
