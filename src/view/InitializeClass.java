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
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class InitializeClass extends JFrame {

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
	private JTextField txtLineoptional;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	public InitializeClass() {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Organ", "Gitur", "Violin", "Voice Training"}));
		comboBox.setBounds(92, 112, 124, 22);
		contentPane.add(comboBox);
		
		JLabel lblAgeRange = new JLabel("Age range");
		lblAgeRange.setBounds(274, 115, 68, 16);
		contentPane.add(lblAgeRange);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"7-8 yr.", "9-10 yr.", "10-12 yr.", "12-14 yr.", "14-16 yr.", "16+ yr."}));
		comboBox_1.setBounds(354, 112, 92, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblTeacher = new JLabel("Teacher");
		lblTeacher.setBounds(12, 67, 56, 16);
		contentPane.add(lblTeacher);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"should filled with teacher coming from db"}));
		comboBox_2.setBounds(92, 64, 124, 22);
		contentPane.add(comboBox_2);
		
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
		
		JPanel panel_induvidual = new JPanel();
		panel_induvidual.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_induvidual.setBounds(200, 159, 246, 141);
		contentPane.add(panel_induvidual);
		panel_induvidual.setLayout(null);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(80, 13, 154, 22);
		panel_induvidual.add(comboBox_5);
		
		JLabel lblStudent = new JLabel("Student :");
		lblStudent.setBounds(12, 16, 56, 16);
		panel_induvidual.add(lblStudent);
		
		JLabel lblLocation_1 = new JLabel("Address :");
		lblLocation_1.setBounds(12, 51, 56, 16);
		panel_induvidual.add(lblLocation_1);
		
		txtLine = new JTextField();
		txtLine.setText("line 1");
		txtLine.setBounds(80, 48, 154, 22);
		panel_induvidual.add(txtLine);
		txtLine.setColumns(10);
		
		txtLineoptional = new JTextField();
		txtLineoptional.setText("line 2 (optional)");
		txtLineoptional.setBounds(80, 71, 154, 22);
		panel_induvidual.add(txtLineoptional);
		txtLineoptional.setColumns(10);
		
		JButton btnNewButton = new JButton("Add new student");
		btnNewButton.setBounds(12, 106, 222, 25);
		panel_induvidual.add(btnNewButton);
		
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
}
