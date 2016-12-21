package view;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dbConnection.Student;
import dbConnection.Teacher;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class SelectStudent extends JFrame {
	private SelectableStudent submain;
	private JFrame win;
	
	private JTextField textField;
	private ButtonGroup bg = new ButtonGroup();
	private JTable table;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SelectStudent frame = new SelectStudent();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public SelectStudent(JFrame submain) throws FileNotFoundException, IOException, SQLException {
		setType(Type.POPUP);
		this.submain = (SelectableStudent) submain;
		this.win = this;
		
		setTitle("Select Student");
		setBounds(100, 100, 880, 520);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblSelectStudent = new JLabel("Select Student");
		lblSelectStudent.setBounds(351, 13, 94, 16);
		getContentPane().add(lblSelectStudent);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(473, 38, 283, 22);
		getContentPane().add(textField);
		
		JLabel label = new JLabel("Keyword");
		label.setBounds(416, 41, 56, 16);
		getContentPane().add(label);
		
		JRadioButton rdbtnLastName = new JRadioButton("Last Name");
		rdbtnLastName.setBounds(246, 40, 127, 25);
		getContentPane().add(rdbtnLastName);
		
		JRadioButton rdbtnFirstName = new JRadioButton("First Name");
		rdbtnFirstName.setBounds(151, 40, 91, 25);
		getContentPane().add(rdbtnFirstName);
		
		JRadioButton rdbtnID = new JRadioButton("ID");
		rdbtnID.setSelected(true);
		rdbtnID.setBounds(106, 40, 41, 25);
		getContentPane().add(rdbtnID);
		
		JLabel label_1 = new JLabel("Search by");
		label_1.setBounds(41, 44, 57, 16);
		getContentPane().add(label_1);
		
		bg.add(rdbtnLastName);
		bg.add(rdbtnFirstName);
		bg.add(rdbtnID);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 100, 838, 310);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(DbUtils.resultSetToTableModel(Student.getAll()));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index>=0){
					String id = table.getValueAt(index, 0).toString();
					String name = (String) table.getValueAt(index, 1);
					String address = (String) table.getValueAt(index, 5);
					String email = (String) table.getValueAt(index, 6);
					((SelectableStudent) submain).setStdNameId(id, name, email, address);
					submain.setVisible(true);
					win.dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Select a student to proceed.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(12, 424, 838, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("All");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					table.setModel(DbUtils.resultSetToTableModel(Student.getAll()));
				} catch (IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(41, 62, 57, 25);
		getContentPane().add(btnNewButton_1);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnID.isSelected()){
					try {
						table.setModel(DbUtils.resultSetToTableModel(Student.searchById(textField.getText().trim())));
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(rdbtnFirstName.isSelected()){
					try {
						table.setModel(DbUtils.resultSetToTableModel(Student.searchByFirstName(textField.getText().trim())));
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(rdbtnLastName.isSelected()){
					try {
						table.setModel(DbUtils.resultSetToTableModel(Student.searchByLastName(textField.getText().trim())));
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnFind.setBounds(787, 38, 63, 25);
		getContentPane().add(btnFind);

	}

}
