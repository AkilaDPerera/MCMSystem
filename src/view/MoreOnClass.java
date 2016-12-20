package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.mysql.fabric.xmlrpc.base.Data;
import com.mysql.jdbc.ResultSetMetaData;

import dbConnection.Student;
import model.MoreOnClassLogic;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;

public class MoreOnClass extends JFrame implements SelectableTeacher{

	private JFrame main;
	private JFrame win;
	private Date dateObj;
	private DateFormat fullDate;
	private JLabel lblSubsituteId;
	private JTable table;
	
	
	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoreOnClass frame = new MoreOnClass();
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
	public MoreOnClass(JFrame main, String class_id) throws FileNotFoundException, IOException, SQLException {
		dateObj = new Date();
		fullDate = new SimpleDateFormat("yyyy-MM-dd EEEE");
		
		setType(Type.POPUP);
		this.main = main;
		this.win = this;
		setTitle("More");
		setBounds(100, 100, 861, 594);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		JLabel lblCurrentDate = new JLabel("Today : " + fullDate.format(dateObj));
		lblCurrentDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCurrentDate.setBounds(572, 13, 259, 25);
		getContentPane().add(lblCurrentDate);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Class details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 52, 819, 99);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblClassid = new JLabel("Class ID: ");
		lblClassid.setBounds(12, 27, 56, 16);
		panel.add(lblClassid);
		
		JLabel lblNewLabel = new JLabel("Subject: ");
		lblNewLabel.setBounds(12, 56, 52, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Teacher's name:");
		lblNewLabel_1.setBounds(180, 27, 99, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("Num. of Student:");
		lblNewLabel_5.setBounds(180, 56, 99, 16);
		panel.add(lblNewLabel_5);
		
		JButton btnEnrollExistingStd = new JButton("Enroll existing std");
		btnEnrollExistingStd.setBounds(658, 27, 149, 59);
		panel.add(btnEnrollExistingStd);
		
		JLabel lblOn = new JLabel("on:");
		lblOn.setBounds(435, 27, 38, 16);
		panel.add(lblOn);
		
		JLabel lblFrom = new JLabel("from:");
		lblFrom.setBounds(435, 56, 38, 16);
		panel.add(lblFrom);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(68, 27, 89, 16);
		panel.add(lblId);
		
		JLabel lblSubjectName = new JLabel("Music");
		lblSubjectName.setBounds(68, 56, 56, 16);
		panel.add(lblSubjectName);
		
		JLabel lblTeacherName = new JLabel("New label");
		lblTeacherName.setBounds(286, 27, 137, 16);
		panel.add(lblTeacherName);
		
		JLabel lblCount = new JLabel("21");
		lblCount.setBounds(286, 56, 56, 16);
		panel.add(lblCount);
		
		JLabel lblTo = new JLabel("To: ");
		lblTo.setBounds(544, 56, 28, 16);
		panel.add(lblTo);
		
		JLabel lblStart = new JLabel("New label");
		lblStart.setBounds(469, 56, 56, 16);
		panel.add(lblStart);
		
		JLabel lblEnd = new JLabel("New label");
		lblEnd.setBounds(568, 56, 56, 16);
		panel.add(lblEnd);
		
		JLabel lblDayName = new JLabel("New label");
		lblDayName.setBounds(469, 27, 56, 16);
		panel.add(lblDayName);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Will the class be held today?");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		chckbxNewCheckBox.setBounds(22, 14, 523, 25);
		getContentPane().add(chckbxNewCheckBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 164, 809, 372);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTeacher = new JLabel("Teacher :");
		lblTeacher.setBounds(12, 13, 92, 16);
		panel_1.add(lblTeacher);
		
		JCheckBox chckbxTeacher = new JCheckBox("present");
		chckbxTeacher.setBounds(75, 9, 78, 25);
		panel_1.add(chckbxTeacher);
		
		JLabel lblOr = new JLabel("or");
		lblOr.setBounds(163, 13, 19, 16);
		panel_1.add(lblOr);
		
		JButton btnSubsitute = new JButton("substitute");
		btnSubsitute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chckbxTeacher.setSelected(false);
				chckbxTeacher.setEnabled(false);
				SelectTeacher window;
				try {
					window = new SelectTeacher(win);
					window.setVisible(true);
					win.setVisible(false);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSubsitute.setBounds(194, 9, 97, 25);
		panel_1.add(btnSubsitute);
		
		JLabel lblSubsituteTeacherId = new JLabel("Subsitute teacher Id: ");
		lblSubsituteTeacherId.setBounds(303, 13, 124, 16);
		panel_1.add(lblSubsituteTeacherId);
		
		lblSubsituteId = new JLabel("ID");
		lblSubsituteId.setBounds(427, 13, 56, 16);
		panel_1.add(lblSubsituteId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 66, 785, 293);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//Creating model as requirement
		ResultSet rs = Student.getAll();
		DefaultTableModel model = new DefaultTableModel();
		
		ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

		ArrayList <Object[]> data = new ArrayList();
	    while (rs.next()) {
	        Object [] row = new Object[6];
	        
	        for (int col = 0; col < 3; col++) {
	        	row[col] = rs.getObject(col + 1);
	        }
	        row[3] = false;
	        row[4] = false;
	        row[5] = false;
	        
	        data.add(row);
	    }
	    Object[][] d = new Object[data.size()][];
	    for (int t = 0; t<data.size(); t++){
	    	d[t] = data.get(t);
	    }
	    
	    table.setModel(
	    new DefaultTableModel(
	    		d,
	    	new String[] {
	    		"StudentID", "FirstName", "LastName", "Present", "Paid", "Attach"
	    	}
	    ) {
	    	Class[] columnTypes = new Class[] {
	    		String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class
	    	};
	    	public Class getColumnClass(int columnIndex) {
	    		return columnTypes[columnIndex];
	    	}
	    	boolean[] columnEditables = new boolean[] {
	    		false, false, false, true, true, true
	    	};
	    	public boolean isCellEditable(int row, int column) {
	    		return columnEditables[column];
	    	}
	    });
	    //Done
		
	    String [] initialData = MoreOnClassLogic.getInitialData(class_id);
	    lblId.setText(class_id);
	    lblSubjectName.setText(initialData[0]);
	    lblTeacherName.setText(initialData[1]);
	    lblCount.setText(initialData[2]);
	    lblDayName.setText(initialData[3]);
	    lblStart.setText(initialData[4]);
	    lblEnd.setText(initialData[5]);
		
		JLabel lblNewLabel_6 = new JLabel("Attendence and other student Info...");
		lblNewLabel_6.setBounds(12, 48, 345, 16);
		panel_1.add(lblNewLabel_6);

	}


	@Override
	public void setNameId(String id, String name) {
		lblSubsituteId.setText(id);
	}
}
