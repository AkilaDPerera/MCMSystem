package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import validation.SignInValidation;

import java.awt.Component;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.peer.TextFieldPeer;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Signin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordFieldPassword;
	private JTextField textFieldUsername;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private static JFrame frm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Signin frame = new Signin();
		frame.setVisible(true);
		frm = frame;
	}

	/**
	 * Create the frame.
	 */
	public Signin() {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Sign in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 239, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(92, 67, 114, 22);
		contentPane.add(passwordFieldPassword);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(92, 32, 116, 22);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setBounds(55, 117, 97, 25);
		contentPane.add(btnSignIn);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(12, 35, 68, 16);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 70, 68, 16);
		contentPane.add(lblPassword);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldUsername, passwordFieldPassword, btnSignIn}));
		
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String username = textFieldUsername.getText().trim();
				String password = (new String(passwordFieldPassword.getPassword())).trim();
				
				try {
					String [] data = SignInValidation.getValidatedSignIn(username, password);
					
					if (data[0].equals("-1")){
						//Authentication fails
						JOptionPane.showMessageDialog(null, data[1], "Error", JOptionPane.ERROR_MESSAGE);
					}else{
						//Authentication successful.
						JOptionPane.showMessageDialog(null, "Login successful!!!", "Successful", JOptionPane.INFORMATION_MESSAGE);
						
						try {
							Main window = new Main(data[0], username, data[1]);//role, username, user-id
							window.frmMusicClassManagement.setVisible(true);
							frm.dispose();
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
					
					
				} catch (IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
