package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;

import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.List;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dbConnection.Teacher;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class SelectTeacher extends JFrame {
	private SelectableTeacher submain;
	private JFrame win;
	
	private JTable table;
	private JTextField textField;
	private ButtonGroup bg = new ButtonGroup();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SelectTeacher frame = new SelectTeacher(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public SelectTeacher(JFrame submain) throws FileNotFoundException, IOException, SQLException {
		setType(Type.UTILITY);
		this.submain = (SelectableTeacher) submain;
		this.win = this;
		
		setTitle("Select Teacher");
		setBounds(100, 100, 880, 520);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblSelectTeacher = new JLabel("Select Teacher");
		lblSelectTeacher.setBounds(349, 13, 86, 16);
		getContentPane().add(lblSelectTeacher);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 127, 838, 276);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(DbUtils.resultSetToTableModel(Teacher.getAll()));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index>=0){
					String id = table.getValueAt(index, 0).toString();
					String name = (String) table.getValueAt(index, 1);
					String email = (String) table.getValueAt(index, 6);
					((SelectableTeacher) submain).setNameId(id, name, email);
					submain.setVisible(true);
					win.dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Select a teacher to proceed.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(12, 416, 838, 25);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(439, 55, 315, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSearchBy = new JLabel("Search by");
		lblSearchBy.setBounds(31, 58, 57, 16);
		getContentPane().add(lblSearchBy);
		
		JRadioButton rdbtnID = new JRadioButton("ID");
		rdbtnID.setSelected(true);
		rdbtnID.setBounds(96, 54, 41, 25);
		getContentPane().add(rdbtnID);
		
		JRadioButton rdbtnFirstName = new JRadioButton("First Name");
		rdbtnFirstName.setBounds(141, 54, 91, 25);
		getContentPane().add(rdbtnFirstName);
		
		JRadioButton rdbtnLastName = new JRadioButton("Last Name");
		rdbtnLastName.setBounds(236, 54, 127, 25);
		getContentPane().add(rdbtnLastName);
		
		bg.add(rdbtnID);
		bg.add(rdbtnFirstName);
		bg.add(rdbtnLastName);
		
		JLabel lblKeyword = new JLabel("Keyword");
		lblKeyword.setBounds(371, 58, 56, 16);
		getContentPane().add(lblKeyword);
		
		JButton btnNewButton_1 = new JButton("Find");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnID.isSelected()){
					try {
						table.setModel(DbUtils.resultSetToTableModel(Teacher.searchById(textField.getText().trim())));
					} catch (IOException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(rdbtnFirstName.isSelected()){
					try {
						table.setModel(DbUtils.resultSetToTableModel(Teacher.searchByFirstName(textField.getText().trim())));
					} catch (IOException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(rdbtnLastName.isSelected()){
					try {
						table.setModel(DbUtils.resultSetToTableModel(Teacher.searchByLastName(textField.getText().trim())));
					} catch (IOException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setBounds(766, 54, 62, 25);
		getContentPane().add(btnNewButton_1);
		
		JButton btnAll = new JButton("All");
		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					table.setModel(DbUtils.resultSetToTableModel(Teacher.getAll()));
				} catch (IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAll.setBounds(26, 87, 62, 25);
		getContentPane().add(btnAll);
		

	}
}
