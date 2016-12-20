package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import model.AddClassLogic;
import model.AddStudentLogic;
import validation.GeneralValidations;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import com.toedter.calendar.JDateChooser;
import java.awt.Window.Type;

public class InitializeClass extends JFrame implements SelectableTeacher {

	private JFrame main;
	private JFrame win;
	
	private JPanel contentPane;
	private JTextField textFieldCount;
	private JTextField txtLocation;
	private JTextField textFieldStartTime;
	private JTextField txtEndTime;
	private JTextField textFieldMonthlyfee;
	private JTextField txtLine;
	
	private JLabel lblName;
	private JLabel lblID;
	private JLabel lblStdName;
	private JLabel lblStdId;
	private JTextField textFieldSubject;
	private JTextField textFieldHourlyPay;

	/**
	 * Launch the application.
	 */
	
	private static JDateChooser dateChooser;
	private static String commenceDate=null;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InitializeClass frame = new InitializeClass();
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
	public InitializeClass(JFrame main) {
		setType(Type.UTILITY);//
		this.main = main;
		this.win = this;
		setTitle("Initialize Class");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 500, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInitializeAClass = new JLabel("Initialize a Class");
		lblInitializeAClass.setBounds(185, 13, 119, 16);
		contentPane.add(lblInitializeAClass);
		
		JLabel lblSubject = new JLabel("Subject*");
		lblSubject.setBounds(12, 115, 68, 16);
		contentPane.add(lblSubject);
		
		JLabel lblTeacher = new JLabel("Teacher*");
		lblTeacher.setBounds(12, 67, 56, 16);
		contentPane.add(lblTeacher);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(12, 223, 56, 16);
		contentPane.add(lblType);
		
		JComboBox comboBoxType = new JComboBox();

		comboBoxType.setModel(new DefaultComboBoxModel(new String[] {"Induvidual", "Group"}));
		comboBoxType.setBounds(64, 220, 124, 22);
		contentPane.add(comboBoxType);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(12, 315, 35, 16);
		contentPane.add(lblDay);
		
		JComboBox comboBoxDay = new JComboBox();
		comboBoxDay.setModel(new DefaultComboBoxModel(new String[] {"Sunday", "Monday", "Tuesday", "Wednesay", "Thursday", "Friday", "Saturday"}));
		comboBoxDay.setBounds(60, 312, 92, 22);
		contentPane.add(comboBoxDay);
		
		JLabel lblStartingTime = new JLabel("Starting Time* :");
		lblStartingTime.setBounds(12, 350, 106, 16);
		contentPane.add(lblStartingTime);
		
		JLabel lblFinishingTime = new JLabel("Finishing Time* :");
		lblFinishingTime.setBounds(185, 350, 111, 16);
		contentPane.add(lblFinishingTime);
		
		textFieldStartTime = new JTextField();
		textFieldStartTime.setText("hh:mm");
		textFieldStartTime.setBounds(108, 347, 50, 22);
		contentPane.add(textFieldStartTime);
		textFieldStartTime.setColumns(10);
		
		JLabel lblH = new JLabel("h");
		lblH.setBounds(165, 350, 23, 16);
		contentPane.add(lblH);
		
		txtEndTime = new JTextField();
		txtEndTime.setText("hh:mm");
		txtEndTime.setBounds(289, 347, 50, 22);
		contentPane.add(txtEndTime);
		txtEndTime.setColumns(10);
		
		JLabel label = new JLabel("h");
		label.setBounds(347, 350, 23, 16);
		contentPane.add(label);
		
		JLabel lblCommencingDate = new JLabel("Commencing Date (yyyy/mm/dd) :");
		lblCommencingDate.setBounds(12, 394, 204, 16);
		contentPane.add(lblCommencingDate);
		
		JLabel lblMonthlyFee = new JLabel("*Student monthly fee :");
		lblMonthlyFee.setBounds(12, 436, 140, 16);
		contentPane.add(lblMonthlyFee);
		
		textFieldMonthlyfee = new JTextField();
		textFieldMonthlyfee.setText("750.00");
		textFieldMonthlyfee.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldMonthlyfee.setBounds(152, 433, 68, 22);
		contentPane.add(textFieldMonthlyfee);
		textFieldMonthlyfee.setColumns(10);
		
		JPanel panel_induvidual = new JPanel();
		panel_induvidual.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_induvidual.setBounds(200, 159, 246, 141);
		contentPane.add(panel_induvidual);
		panel_induvidual.setLayout(null);
		
		JLabel lblStudent = new JLabel("Student* :");
		lblStudent.setBounds(12, 57, 68, 16);
		panel_induvidual.add(lblStudent);
		
		JLabel lblLocation_1 = new JLabel("Address* :");
		lblLocation_1.setBounds(12, 86, 68, 16);
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
		
		JLabel lblHowMany = new JLabel("How many*");
		lblHowMany.setBounds(12, 45, 68, 16);
		panel_group.add(lblHowMany);
		
		JLabel lblLocation = new JLabel("Location*");
		lblLocation.setBounds(12, 74, 56, 16);
		panel_group.add(lblLocation);
		
		textFieldCount = new JTextField();
		textFieldCount.setBounds(91, 42, 35, 22);
		panel_group.add(textFieldCount);
		textFieldCount.setText("999");
		textFieldCount.setColumns(10);
		
		txtLocation = new JTextField();
		txtLocation.setBounds(92, 71, 124, 22);
		panel_group.add(txtLocation);
		txtLocation.setText("Old gym");
		txtLocation.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		
		btnSubmit.setBounds(298, 477, 97, 25);
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
		
		JLabel lblNewLabel = new JLabel("*Teachers hourly payment :");
		lblNewLabel.setBounds(239, 436, 174, 16);
		contentPane.add(lblNewLabel);
		
		textFieldHourlyPay = new JTextField();
		textFieldHourlyPay.setBounds(402, 433, 68, 22);
		contentPane.add(textFieldHourlyPay);
		textFieldHourlyPay.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(228, 394, 142, 22);
		contentPane.add(dateChooser);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.dispose();
				main.setVisible(true);
			}
		});
		btnBack.setBounds(78, 477, 97, 25);
		contentPane.add(btnBack);
		
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		
		comboBoxType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxType.getSelectedIndex()==1){
					panel_group.setVisible(true);
					panel_induvidual.setVisible(false);

					
				}else if(comboBoxType.getSelectedIndex()==0){
					panel_group.setVisible(false);
					panel_induvidual.setVisible(true);

				}
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Boolean> temp = new ArrayList<Boolean>();
				
				int type = comboBoxType.getSelectedIndex();
				
				String teacherId = lblID.getText();
				String subject = textFieldSubject.getText().trim();
				String day = (String) comboBoxDay.getSelectedObjects()[0];
				
				try{
					commenceDate = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
				}catch(Exception ee){}
				
				
				String monthly_fee = textFieldMonthlyfee.getText().trim();
				String hourly_pay = textFieldHourlyPay.getText().trim();
				String start_time = textFieldStartTime.getText().trim();
				String end_time = txtEndTime.getText().trim();
				
				String count = textFieldCount.getText().trim();
				String location = txtLocation.getText().trim();
				
				String std_id = lblStdId.getText().trim();
				String address = txtLine.getText().trim();
				
				Boolean isGoodToGo = true;
				
				
				temp.add(GeneralValidations.idValidation(teacherId));
				temp.add(GeneralValidations.dobValidation(commenceDate));
				temp.add(GeneralValidations.nameValidation(subject));
				temp.add(GeneralValidations.salaryValidation(monthly_fee));
				temp.add(GeneralValidations.salaryValidation(hourly_pay));
				temp.add(GeneralValidations.isTime(start_time));
				temp.add(GeneralValidations.isTime(end_time));

				if (type==0){
					//individual
					temp.add(GeneralValidations.idValidation(std_id));
					temp.add(GeneralValidations.addressValidation(address));

					for (Boolean t: temp){
						if (!t){
							//Basic validation fail. Check the entries again
							//Changing the font color
							lblTeacher.setForeground(Color.red);
							lblSubject.setForeground(Color.red);
							lblStudent.setForeground(Color.red);
							lblLocation_1.setForeground(Color.red);
							lblHowMany.setForeground(Color.red);
							lblLocation.setForeground(Color.red);
							lblDay.setForeground(Color.red);
							lblStartingTime.setForeground(Color.red);
							lblFinishingTime.setForeground(Color.red);
							lblCommencingDate.setForeground(Color.red);
							lblMonthlyFee.setForeground(Color.red);
							lblNewLabel.setForeground(Color.red);
							
							
							//display a error message
							JOptionPane.showMessageDialog(null, "Check the highlighted text and try again.", "Error", JOptionPane.ERROR_MESSAGE);
							isGoodToGo = false;
							break;
						}
					}
					//No basic error found
					if (isGoodToGo){
						try {
							String [] result = AddClassLogic.initializeInduvidualClass(teacherId, std_id, hourly_pay, subject, monthly_fee, commenceDate, start_time, end_time, address, day);
						
							JOptionPane.showMessageDialog(null, result[0], "Successful", JOptionPane.INFORMATION_MESSAGE);
							
							win.dispose();
							main.setVisible(true);
							
						} catch (SQLException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				}else{
					//Group
					temp.add(GeneralValidations.idValidation(count));
					temp.add(GeneralValidations.nameValidation(location));
					
					for (Boolean t: temp){
						if (!t){
							//Basic validation fail. Check the entries again
							//Changing the font color
							lblTeacher.setForeground(Color.red);
							lblSubject.setForeground(Color.red);
							lblStudent.setForeground(Color.red);
							lblLocation_1.setForeground(Color.red);
							lblHowMany.setForeground(Color.red);
							lblLocation.setForeground(Color.red);
							lblDay.setForeground(Color.red);
							lblStartingTime.setForeground(Color.red);
							lblFinishingTime.setForeground(Color.red);
							lblCommencingDate.setForeground(Color.red);
							lblMonthlyFee.setForeground(Color.red);
							lblNewLabel.setForeground(Color.red);

							//display a error message
							JOptionPane.showMessageDialog(null, "Check the highlighted text and try again.", "Error", JOptionPane.ERROR_MESSAGE);
							isGoodToGo = false;
							break;
						}
					}
					//No basic error found
					if (isGoodToGo){
						try {
							String [] result = AddClassLogic.initializeGroupClass(teacherId, hourly_pay, subject, monthly_fee, commenceDate, start_time, end_time, count, location,day);
				
							JOptionPane.showMessageDialog(null, result[0], "Info", JOptionPane.INFORMATION_MESSAGE);
						
							win.dispose();
							main.setVisible(true);
							
						} catch (IOException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					}
				}
			}
		);
	}
	
	public void setStdNameId(String id, String name){
		lblStdId.setText(id);
		lblStdName.setText(name);
	}
	public void setAddress(String address){
		txtLine.setText(address);
	}

	@Override
	public void setNameId(String id, String name, String email) {
		lblName.setText(name);
		lblID.setText(id);	
	}
}
