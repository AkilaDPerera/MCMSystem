package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class Main {

	private JFrame frmMusicClassManagement;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	/*public static void main(String[] args) {
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
		
		JLabel lblSignOut = new JLabel("Sign out");
		lblSignOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lblSignOut.setBounds(532, 30, 56, 16);
		frmMusicClassManagement.getContentPane().add(lblSignOut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 108, 462, 227);
		frmMusicClassManagement.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Class-ID", "Subject", "Teacher", "On", "From"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblCurrentClasses = new JLabel("Current classes");
		lblCurrentClasses.setBounds(28, 71, 236, 16);
		frmMusicClassManagement.getContentPane().add(lblCurrentClasses);
		
		JButton btnMore = new JButton("More");
		btnMore.setBounds(207, 348, 97, 25);
		frmMusicClassManagement.getContentPane().add(btnMore);
		
		JButton btnNewButton = new JButton("Add System User");
		btnNewButton.setBounds(511, 275, 177, 25);
		frmMusicClassManagement.getContentPane().add(btnNewButton);
	}
}
