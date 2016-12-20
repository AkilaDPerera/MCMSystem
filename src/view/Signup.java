package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dbConnection.User;
import validation.GeneralValidations;

import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Signup extends JFrame implements SelectableTeacher {
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblId;
	
	
	private JFrame main;
	private JFrame win;

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
	public Signup(JFrame main) {
		setResizable(false);
		this.main = main;
		this.win = this;
		setType(Type.POPUP);
		setTitle("Sign up");
		setBounds(100, 100, 363, 369);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Teacher"}));
		comboBox.setBounds(143, 16, 163, 22);
		getContentPane().add(comboBox);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(22, 19, 56, 16);
		getContentPane().add(lblRole);
		
		JLabel lblEmail = new JLabel("E-mail*");
		lblEmail.setBounds(22, 121, 56, 16);
		getContentPane().add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username*");
		lblUsername.setBounds(22, 156, 72, 16);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password*");
		lblPassword.setBounds(22, 191, 109, 16);
		getContentPane().add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-enter password*");
		lblReenterPassword.setBounds(22, 226, 131, 16);
		getContentPane().add(lblReenterPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(143, 223, 163, 22);
		getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(143, 188, 163, 22);
		getContentPane().add(passwordField_1);
		
		textField = new JTextField();
		textField.setBounds(143, 153, 163, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 118, 163, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		
		btnNewButton.setBounds(212, 291, 97, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.dispose();
				main.setVisible(true);
			}
		});
		btnBack.setBounds(34, 291, 97, 25);
		getContentPane().add(btnBack);
		
		JLabel lblTeacherId = new JLabel("Teacher Id:");
		lblTeacherId.setVisible(false);
		lblTeacherId.setBounds(22, 65, 72, 16);
		getContentPane().add(lblTeacherId);
		
		lblId = new JLabel("");
		lblId.setVisible(false);
		lblId.setBounds(143, 65, 163, 16);
		getContentPane().add(lblId);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex()==1){
					lblId.setVisible(true);
					lblTeacherId.setVisible(true);
					
					SelectTeacher window;
					try {
						window = new SelectTeacher(win);
						window.setVisible(true);
						win.setVisible(false);
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}else{
					lblId.setVisible(false);
					lblTeacherId.setVisible(false);
				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password1 = (new String(passwordField_1.getPassword())).trim();
				String password2 = (new String(passwordField.getPassword())).trim();
				
				if (!GeneralValidations.emailValidation(textField_1.getText().trim())){
					JOptionPane.showMessageDialog(null, "Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
				}else if (!GeneralValidations.usernameValidation(textField.getText().trim())){
					JOptionPane.showMessageDialog(null, "Username can be contained only letters", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(password1.length()==0 || password2.length()==0){
					JOptionPane.showMessageDialog(null, "Passwords cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(!password1.equals(password2)){
					JOptionPane.showMessageDialog(null, "Passwords are not matching", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					//basic validations done
					//check whether username is unique
					try {
						if(User.isUserThere(textField.getText().trim())){
							JOptionPane.showMessageDialog(null, "Please try other username. This username is already exsiting.", "Info", JOptionPane.INFORMATION_MESSAGE);
						}else{
							if (comboBox.getSelectedIndex()==0){
								User.setUser("admin", textField.getText().trim(), password1, textField_1.getText().trim(), "0");
							}else{
								User.setUser("teacher", textField.getText().trim(), password1, textField_1.getText().trim(), lblId.getText());
							}
							JOptionPane.showMessageDialog(null, "Successful!", "Info", JOptionPane.INFORMATION_MESSAGE);
							win.dispose();
							main.setVisible(true);
							
						}
						
					} catch (SQLException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

	}

	@Override
	public void setNameId(String id, String name, String email) {
		// TODO Auto-generated method stub
		lblId.setText(id);
		textField_1.setText(email);
		
	}

}
