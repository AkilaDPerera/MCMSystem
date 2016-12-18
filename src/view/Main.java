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
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	JFrame frmMusicClassManagement;
	private JTable table;
	private static String role;
	private static String username;
	private static String userid;

	/**
	 * Create the application.
	 */
	public Main(String role, String username, String userid) {
		Main.role = role;
		Main.username = username;
		Main.userid = userid;
		initialize(role, username, userid);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String role, String username, String userid) {
		frmMusicClassManagement = new JFrame();
		frmMusicClassManagement.setResizable(false);
		frmMusicClassManagement.setTitle("Music Class Management System");
		frmMusicClassManagement.setBounds(100, 100, 738, 439);
		frmMusicClassManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMusicClassManagement.getContentPane().setLayout(null);
		
		JPanel panelLoginInfo = new JPanel();
		panelLoginInfo.setBackground(Color.GRAY);
		panelLoginInfo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelLoginInfo.setBounds(698, 82, -486, -68);
		frmMusicClassManagement.getContentPane().add(panelLoginInfo);
		panelLoginInfo.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 105, 462, 236);
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
		lblCurrentClasses.setBounds(23, 76, 236, 16);
		frmMusicClassManagement.getContentPane().add(lblCurrentClasses);
		
		JButton btnMore = new JButton("More");
		btnMore.setBounds(388, 354, 97, 25);
		frmMusicClassManagement.getContentPane().add(btnMore);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Login Info...", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBounds(500, 13, 208, 142);
		frmMusicClassManagement.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel(username);
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setBounds(114, 57, 82, 16);
		panel.add(lblUsername);
		
		JLabel lblRole = new JLabel(role.toUpperCase());
		lblRole.setHorizontalAlignment(SwingConstants.LEFT);
		lblRole.setBounds(114, 87, 82, 16);
		panel.add(lblRole);
		
		JLabel lblUserid = new JLabel(userid);
		lblUserid.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserid.setBounds(114, 28, 82, 16);
		panel.add(lblUserid);
		
		JLabel lblUserid_1 = new JLabel("UserID :");
		lblUserid_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserid_1.setBounds(29, 28, 73, 16);
		panel.add(lblUserid_1);
		
		JLabel lblUsername_1 = new JLabel("Username :");
		lblUsername_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername_1.setBounds(29, 57, 73, 16);
		panel.add(lblUsername_1);
		
		JLabel lblRole_1 = new JLabel("Role :");
		lblRole_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRole_1.setBounds(29, 87, 73, 16);
		panel.add(lblRole_1);
		
		JLabel lblSignOut = new JLabel("Sign out");
		lblSignOut.setBounds(74, 113, 47, 16);
		panel.add(lblSignOut);
		lblSignOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSignOut.setForeground(Color.BLUE);
		
		JLabel lblTitle = new JLabel("Music Class Management System");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle.setBounds(23, 13, 462, 50);
		frmMusicClassManagement.getContentPane().add(lblTitle);
		
		JPanel panelAdmin = new JPanel();
		panelAdmin.setVisible(false);
		panelAdmin.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAdmin.setBounds(500, 168, 208, 211);
		frmMusicClassManagement.getContentPane().add(panelAdmin);
		panelAdmin.setLayout(null);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddStudent addStudentWindow = new AddStudent(frmMusicClassManagement);
				addStudentWindow.setVisible(true);
				frmMusicClassManagement.setVisible(false);

			}
		});
		btnAddStudent.setBounds(19, 13, 177, 25);
		panelAdmin.add(btnAddStudent);
		
		JButton btnAddTeacher = new JButton("Add Teacher");
		btnAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddTeacher addStudentWindow = new AddTeacher(frmMusicClassManagement);
				addStudentWindow.setVisible(true);
				frmMusicClassManagement.setVisible(false);
			}
		});
		btnAddTeacher.setBounds(19, 61, 177, 25);
		panelAdmin.add(btnAddTeacher);
		
		JButton btnInitializeAClass = new JButton("Initialize a Class");
		btnInitializeAClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InitializeClass window = new InitializeClass(frmMusicClassManagement);
				window.setVisible(true);
				frmMusicClassManagement.setVisible(false);
			}
		});
		btnInitializeAClass.setBounds(19, 114, 177, 25);
		panelAdmin.add(btnInitializeAClass);
		
		JButton btnAddUser = new JButton("Add System User");
		btnAddUser.setBounds(19, 161, 177, 25);
		panelAdmin.add(btnAddUser);
		
		JPanel panelTeacher = new JPanel();
		panelTeacher.setBounds(500, 168, 208, 211);
		frmMusicClassManagement.getContentPane().add(panelTeacher);
		panelTeacher.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTeacher.setLayout(null);
		
		JButton btnSalary = new JButton("Salary Details");
		btnSalary.setBounds(12, 92, 184, 25);
		panelTeacher.add(btnSalary);
		panelTeacher.setVisible(false);
		
		if (role.equals("teacher")){
			panelTeacher.setVisible(true);
		}else{
			panelAdmin.setVisible(true);
		}
		
		lblSignOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Signin frame = new Signin();
				frame.setVisible(true);
				frmMusicClassManagement.dispose();
			}
		});

	}
}
