package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Signup extends JFrame {
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		setTitle("Sign up");
		setBounds(100, 100, 331, 299);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Teacher", "Staff", "Admin"}));
		comboBox.setBounds(133, 13, 163, 22);
		getContentPane().add(comboBox);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(12, 16, 56, 16);
		getContentPane().add(lblRole);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(12, 63, 56, 16);
		getContentPane().add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(12, 98, 72, 16);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 133, 56, 16);
		getContentPane().add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-enter password");
		lblReenterPassword.setBounds(12, 168, 109, 16);
		getContentPane().add(lblReenterPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 165, 163, 22);
		getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(133, 130, 163, 22);
		getContentPane().add(passwordField_1);
		
		textField = new JTextField();
		textField.setBounds(133, 95, 163, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 60, 163, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(94, 212, 97, 25);
		getContentPane().add(btnNewButton);

	}
}
