package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class Main {

	private JFrame frmMusicClassManagement;

	/**
	 * Launch the application.
	 */
	/*
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
	*/

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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(82, 113, 167, 25);
		frmMusicClassManagement.getContentPane().add(comboBox);
		
		JButton btnOpen = new JButton("open");
		btnOpen.setBounds(261, 112, 97, 25);
		frmMusicClassManagement.getContentPane().add(btnOpen);
		
		JLabel lblCurrentClass = new JLabel("Current class");
		lblCurrentClass.setBounds(82, 84, 146, 16);
		frmMusicClassManagement.getContentPane().add(lblCurrentClass);
	}
}
