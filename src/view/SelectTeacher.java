package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;

import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.List;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class SelectTeacher extends JFrame {
	private JTable table;
	private JTextField textField;
	private ButtonGroup bg = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectTeacher frame = new SelectTeacher("none");
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
	public SelectTeacher(String type) {
		setTitle("Select Teacher");
		setBounds(100, 100, 880, 520);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblSelectTeacher = new JLabel("Select Teacher");
		lblSelectTeacher.setBounds(349, 13, 86, 16);
		getContentPane().add(lblSelectTeacher);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 110, 838, 293);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Teacher-ID", "First Name", "Last Name", "Subjects", "Mobile no.", "Email"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.setBounds(12, 416, 838, 25);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(463, 52, 315, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSearchBy = new JLabel("Search by");
		lblSearchBy.setBounds(31, 58, 57, 16);
		getContentPane().add(lblSearchBy);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("ID");
		rdbtnNewRadioButton.setBounds(96, 54, 41, 25);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("First Name");
		rdbtnNewRadioButton_1.setBounds(141, 54, 91, 25);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Last Name");
		rdbtnNewRadioButton_2.setBounds(236, 54, 127, 25);
		getContentPane().add(rdbtnNewRadioButton_2);
		
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		
		JLabel lblKeyword = new JLabel("Keyword");
		lblKeyword.setBounds(406, 55, 56, 16);
		getContentPane().add(lblKeyword);
		

	}
}
