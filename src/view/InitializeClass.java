package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class InitializeClass extends JFrame {

	private JFrame main;
	private JFrame win;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtOldGym;
	private JTextField textField_2;
	private JTextField txtHhmm;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField txtLine;
	
	private JLabel lblName;
	private JLabel lblID;
	private JLabel lblStdName;
	private JLabel lblStdId;
	private JTextField textFieldSubject;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitializeClass frame = new InitializeClass();
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
	public InitializeClass(JFrame main) {
		this.main = main;
		this.win = this;
		setTitle("Initialize Class");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInitializeAClass = new JLabel("Initialize a Class");
		lblInitializeAClass.setBounds(185, 13, 119, 16);
		contentPane.add(lblInitializeAClass);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(12, 115, 68, 16);
		contentPane.add(lblSubject);
		
		JLabel lblTeacher = new JLabel("Teacher");
		lblTeacher.setBounds(12, 67, 56, 16);
		contentPane.add(lblTeacher);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(12, 223, 56, 16);
		contentPane.add(lblType);
		
		JComboBox comboBox_3 = new JComboBox();

		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Induvidual", "Group"}));
		comboBox_3.setBounds(64, 220, 124, 22);
		contentPane.add(comboBox_3);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(12, 315, 35, 16);
		contentPane.add(lblDay);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Sunday", "Monday", "Tuesday", "Wednesay", "Thursday", "Friday", "Saturday"}));
		comboBox_4.setBounds(60, 312, 92, 22);
		contentPane.add(comboBox_4);
		
		JLabel lblStartingTime = new JLabel("Starting Time :");
		lblStartingTime.setBounds(12, 350, 92, 16);
		contentPane.add(lblStartingTime);
		
		JLabel lblFinishingTime = new JLabel("Finishing Time :");
		lblFinishingTime.setBounds(185, 350, 92, 16);
		contentPane.add(lblFinishingTime);
		
		textField_2 = new JTextField();
		textField_2.setText("08:30");
		textField_2.setBounds(107, 347, 42, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblH = new JLabel("h");
		lblH.setBounds(152, 350, 23, 16);
		contentPane.add(lblH);
		
		txtHhmm = new JTextField();
		txtHhmm.setText("hh:mm");
		txtHhmm.setBounds(289, 347, 42, 22);
		contentPane.add(txtHhmm);
		txtHhmm.setColumns(10);
		
		JLabel label = new JLabel("h");
		label.setBounds(336, 350, 23, 16);
		contentPane.add(label);
		
		textField_3 = new JTextField();
		textField_3.setText("31");
		textField_3.setBounds(228, 391, 23, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCommencingDate = new JLabel("Commencing Date (dd/mm/yyyy) :");
		lblCommencingDate.setBounds(12, 394, 204, 16);
		contentPane.add(lblCommencingDate);
		
		textField_4 = new JTextField();
		textField_4.setText("12");
		textField_4.setBounds(274, 391, 22, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setText("2016");
		textField_5.setBounds(318, 391, 35, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(259, 394, 16, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("/");
		label_2.setBounds(308, 394, 16, 16);
		contentPane.add(label_2);
		
		JLabel lblMonthlyFee = new JLabel("Monthly fee");
		lblMonthlyFee.setBounds(12, 436, 73, 16);
		contentPane.add(lblMonthlyFee);
		
		textField_6 = new JTextField();
		textField_6.setText("750.00");
		textField_6.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField_6.setBounds(120, 433, 68, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblRs = new JLabel("Rs.");
		lblRs.setBounds(92, 436, 23, 16);
		contentPane.add(lblRs);
		
		JPanel panel_induvidual = new JPanel();
		panel_induvidual.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_induvidual.setBounds(200, 159, 246, 141);
		contentPane.add(panel_induvidual);
		panel_induvidual.setLayout(null);
		
		JLabel lblStudent = new JLabel("Student :");
		lblStudent.setBounds(12, 57, 56, 16);
		panel_induvidual.add(lblStudent);
		
		JLabel lblLocation_1 = new JLabel("Address :");
		lblLocation_1.setBounds(12, 86, 56, 16);
		panel_induvidual.add(lblLocation_1);
		
		txtLine = new JTextField();
		txtLine.setText("line 1");
		txtLine.setBounds(80, 83, 154, 22);
		panel_induvidual.add(txtLine);
		txtLine.setColumns(10);
		
		JButton btnNewButton = new JButton("Select Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectStudent window;
				try {
					window = new SelectStudent(win);
					window.setVisible(true);
					win.setVisible(false);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(12, 19, 222, 25);
		panel_induvidual.add(btnNewButton);
		
		lblStdName = new JLabel("Name");
		lblStdName.setBounds(158, 57, 76, 16);
		panel_induvidual.add(lblStdName);
		
		lblStdId = new JLabel("ID");
		lblStdId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStdId.setBounds(80, 57, 56, 16);
		panel_induvidual.add(lblStdId);
		
		JPanel panel_group = new JPanel();
		panel_group.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_group.setVisible(false);
		panel_group.setBounds(200, 159, 246, 141);
		contentPane.add(panel_group);
		panel_group.setLayout(null);
		
		JLabel lblHowMany = new JLabel("How many");
		lblHowMany.setBounds(12, 45, 68, 16);
		panel_group.add(lblHowMany);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(12, 74, 56, 16);
		panel_group.add(lblLocation);
		
		textField = new JTextField();
		textField.setBounds(91, 42, 35, 22);
		panel_group.add(textField);
		textField.setText("999");
		textField.setColumns(10);
		
		txtOldGym = new JTextField();
		txtOldGym.setBounds(92, 71, 124, 22);
		panel_group.add(txtOldGym);
		txtOldGym.setText("Old gym");
		txtOldGym.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(199, 477, 97, 25);
		contentPane.add(btnSubmit);
		
		JButton btnNewButton_1 = new JButton("Select Teacher");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnNewButton_1.setBounds(92, 63, 124, 25);
		contentPane.add(btnNewButton_1);
		
		lblName = new JLabel("Name");
		lblName.setBounds(336, 67, 97, 16);
		contentPane.add(lblName);
		
		lblID = new JLabel("ID");
		lblID.setBounds(259, 67, 35, 16);
		contentPane.add(lblID);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(239, 67, 23, 16);
		contentPane.add(lblId);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(289, 67, 42, 16);
		contentPane.add(lblName_1);
		
		textFieldSubject = new JTextField();
		textFieldSubject.setBounds(92, 112, 116, 22);
		contentPane.add(textFieldSubject);
		textFieldSubject.setColumns(10);
		
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox_3.getSelectedIndex()==1){
					panel_group.setVisible(true);
					panel_induvidual.setVisible(false);

					
				}else if(comboBox_3.getSelectedIndex()==0){
					panel_group.setVisible(false);
					panel_induvidual.setVisible(true);

				}
			}
		});
		
		
	}
	
	public void setNameId(String id, String name){
		lblName.setText(name);
		lblID.setText(id);
	}
	public void setStdNameId(String id, String name){
		lblStdId.setText(id);
		lblStdName.setText(name);
	}
	public void setAddress(String address){
		txtLine.setText(address);
	}
}
