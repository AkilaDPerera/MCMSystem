package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

	private JFrame frmMusicClassManagement;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmMusicClassManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMusicClassManagement = new JFrame();
		frmMusicClassManagement.setTitle("Music Class Management System");
		frmMusicClassManagement.setBounds(100, 100, 738, 560);
		frmMusicClassManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMusicClassManagement.getContentPane().setLayout(null);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setBounds(511, 112, 177, 25);
		frmMusicClassManagement.getContentPane().add(btnAddStudent);
		
		JButton btnAddTeacher = new JButton("Add Teacher");
		btnAddTeacher.setBounds(511, 161, 177, 25);
		frmMusicClassManagement.getContentPane().add(btnAddTeacher);
		
		JButton btnInitializeAClass = new JButton("Initialize a Class");
		btnInitializeAClass.setBounds(511, 220, 177, 25);
		frmMusicClassManagement.getContentPane().add(btnInitializeAClass);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(600, 13, 108, 16);
		frmMusicClassManagement.getContentPane().add(lblNewLabel);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(532, 13, 56, 16);
		frmMusicClassManagement.getContentPane().add(lblRole);
		
		JButton btnStudentEnrollment = new JButton("Student Enrollment");
		btnStudentEnrollment.setBounds(511, 266, 177, 25);
		frmMusicClassManagement.getContentPane().add(btnStudentEnrollment);
		
		JLabel lblSignOut = new JLabel("Sign out");
		lblSignOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lblSignOut.setBounds(532, 30, 56, 16);
		frmMusicClassManagement.getContentPane().add(lblSignOut);
	}
}
