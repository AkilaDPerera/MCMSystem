package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Signin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel lblUsername;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signin frame = new Signin();
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
	public Signin() {
		setTitle("Sign in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 246, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(92, 48, 114, 22);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(92, 13, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setBounds(49, 90, 97, 25);
		contentPane.add(btnSignIn);
		
		btnNewButton = new JButton("Sign up");
		btnNewButton.setBounds(49, 127, 97, 25);
		contentPane.add(btnNewButton);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(12, 16, 68, 16);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 51, 68, 16);
		contentPane.add(lblPassword);
	}

}
