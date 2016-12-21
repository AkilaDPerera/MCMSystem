package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dbConnection.ClassEntity;
import dbConnection.Student;
import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class SelectClass extends JFrame {
	private SelectableClass submain;
	private JFrame win;
	
	private JTextField textField;
	private JTable table;
	private ButtonGroup bg = new ButtonGroup();


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SelectClass frame = new SelectClass();
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
	public SelectClass(JFrame submain) throws FileNotFoundException, IOException, SQLException {
		setResizable(false);
		setType(Type.POPUP);
		this.submain = (SelectableClass) submain;
		this.win = this;
		
		setTitle("Select Class");
		setBounds(100, 100, 880, 520);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Select Student");
		label.setBounds(339, 26, 94, 16);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(480, 54, 283, 22);
		getContentPane().add(textField);
		
		JLabel label_1 = new JLabel("Keyword");
		label_1.setBounds(423, 57, 56, 16);
		getContentPane().add(label_1);
		
		JRadioButton rdbtnLocation = new JRadioButton("Location");
		rdbtnLocation.setBounds(214, 53, 80, 25);
		getContentPane().add(rdbtnLocation);
		
		JRadioButton rdbtnSubject = new JRadioButton("Subject");
		rdbtnSubject.setBounds(139, 53, 71, 25);
		getContentPane().add(rdbtnSubject);
		
		JRadioButton rdbtnID = new JRadioButton("ID");
		rdbtnID.setSelected(true);
		rdbtnID.setBounds(94, 53, 41, 25);
		getContentPane().add(rdbtnID);
		
		JLabel label_2 = new JLabel("Search by");
		label_2.setBounds(29, 57, 57, 16);
		getContentPane().add(label_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 113, 838, 310);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(DbUtils.resultSetToTableModel(ClassEntity.getAll()));
		
		JButton button = new JButton("Select");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index>=0){
					String id = table.getValueAt(index, 0).toString();
					String subject = (String) table.getValueAt(index, 1);
					((SelectableClass) submain).setClassDetails(id, subject, "");
					submain.setVisible(true);
					win.dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Select a class to proceed.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button.setBounds(670, 434, 140, 25);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("All");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					table.setModel(DbUtils.resultSetToTableModel(ClassEntity.getAll()));
				} catch (IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_1.setBounds(29, 75, 57, 25);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Find");
		
		button_2.setBounds(775, 51, 63, 25);
		getContentPane().add(button_2);
		
		JRadioButton rdbtnDay = new JRadioButton("Day");
		rdbtnDay.setBounds(293, 53, 63, 25);
		getContentPane().add(rdbtnDay);
		
		bg.add(rdbtnDay);
		bg.add(rdbtnLocation);
		bg.add(rdbtnSubject);
		bg.add(rdbtnID);
		
		JButton btnBa = new JButton("Back");
		btnBa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				submain.setVisible(true);
				win.dispose();
			}
		});
		btnBa.setBounds(366, 434, 133, 23);
		getContentPane().add(btnBa);
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnID.isSelected()){
					try {
						table.setModel(DbUtils.resultSetToTableModel(ClassEntity.searchById(textField.getText().trim())));
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(rdbtnLocation.isSelected()){
					try {
						table.setModel(DbUtils.resultSetToTableModel(ClassEntity.searchByLocation(textField.getText().trim())));
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(rdbtnSubject.isSelected()){
					try {
						table.setModel(DbUtils.resultSetToTableModel(ClassEntity.searchBySubject(textField.getText().trim())));
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(rdbtnDay.isSelected()){
					try {
						table.setModel(DbUtils.resultSetToTableModel(ClassEntity.searchByDay(textField.getText().trim())));
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

	}
}
