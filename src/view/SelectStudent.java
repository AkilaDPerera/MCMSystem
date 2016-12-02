package view;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

public class SelectStudent extends JFrame {
	private JTextField textField;
	private ButtonGroup bg = new ButtonGroup();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectStudent frame = new SelectStudent();
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
	public SelectStudent() {
		setTitle("Select Student");
		setBounds(100, 100, 880, 520);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblSelectStudent = new JLabel("Select Student");
		lblSelectStudent.setBounds(351, 13, 94, 16);
		getContentPane().add(lblSelectStudent);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(473, 38, 315, 22);
		getContentPane().add(textField);
		
		JLabel label = new JLabel("Keyword");
		label.setBounds(416, 41, 56, 16);
		getContentPane().add(label);
		
		JRadioButton radioButton = new JRadioButton("Last Name");
		radioButton.setBounds(246, 40, 127, 25);
		getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("First Name");
		radioButton_1.setBounds(151, 40, 91, 25);
		getContentPane().add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("ID");
		radioButton_2.setBounds(106, 40, 41, 25);
		getContentPane().add(radioButton_2);
		
		JLabel label_1 = new JLabel("Search by");
		label_1.setBounds(41, 44, 57, 16);
		getContentPane().add(label_1);
		
		bg.add(radioButton);
		bg.add(radioButton_1);
		bg.add(radioButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 86, 838, 324);
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
				"Student-ID", "First Name", "Last Name", "Mobile No.", "Email", "Age"
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
		btnNewButton.setBounds(12, 424, 838, 25);
		getContentPane().add(btnNewButton);

	}

}
