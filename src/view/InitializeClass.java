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
		setBounds(100, 100, 500, 400);
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
		lblType.setBounds(12, 157, 56, 16);
		contentPane.add(lblType);
		
		JComboBox comboBox_3 = new JComboBox();

		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Induvidual", "Group"}));
		comboBox_3.setBounds(92, 154, 124, 22);
		contentPane.add(comboBox_3);
		
		textField = new JTextField();
		textField.setVisible(false);
		textField.setText("999");
		textField.setBounds(296, 154, 35, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblHowMany = new JLabel("how many");
		lblHowMany.setVisible(false);
		lblHowMany.setBounds(228, 157, 68, 16);
		contentPane.add(lblHowMany);
		
		txtOldGym = new JTextField();
		txtOldGym.setText("Old gym");
		txtOldGym.setBounds(92, 192, 124, 22);
		contentPane.add(txtOldGym);
		txtOldGym.setColumns(10);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(12, 195, 56, 16);
		contentPane.add(lblLocation);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(306, 195, 35, 16);
		contentPane.add(lblDay);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Sunday", "Monday", "Tuesday", "Wednesay", "Thursday", "Friday", "Saturday"}));
		comboBox_4.setBounds(354, 192, 92, 22);
		contentPane.add(comboBox_4);
		
		JLabel lblStartingTime = new JLabel("Starting Time :");
		lblStartingTime.setBounds(12, 227, 92, 16);
		contentPane.add(lblStartingTime);
		
		JLabel lblFinishingTime = new JLabel("Finishing Time :");
		lblFinishingTime.setBounds(185, 227, 92, 16);
		contentPane.add(lblFinishingTime);
		
		textField_2 = new JTextField();
		textField_2.setText("08:30");
		textField_2.setBounds(107, 224, 42, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblH = new JLabel("h");
		lblH.setBounds(152, 227, 23, 16);
		contentPane.add(lblH);
		
		txtHhmm = new JTextField();
		txtHhmm.setText("hh:mm");
		txtHhmm.setBounds(289, 224, 42, 22);
		contentPane.add(txtHhmm);
		txtHhmm.setColumns(10);
		
		JLabel label = new JLabel("h");
		label.setBounds(336, 227, 23, 16);
		contentPane.add(label);
		
		textField_3 = new JTextField();
		textField_3.setText("31");
		textField_3.setBounds(228, 268, 23, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCommencingDate = new JLabel("Commencing Date (dd/mm/yyyy) :");
		lblCommencingDate.setBounds(12, 271, 204, 16);
		contentPane.add(lblCommencingDate);
		
		textField_4 = new JTextField();
		textField_4.setText("12");
		textField_4.setBounds(274, 268, 22, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setText("2016");
		textField_5.setBounds(318, 268, 35, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(259, 271, 16, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("/");
		label_2.setBounds(308, 271, 16, 16);
		contentPane.add(label_2);
		
		JLabel lblMonthlyFee = new JLabel("Monthly fee");
		lblMonthlyFee.setBounds(12, 313, 73, 16);
		contentPane.add(lblMonthlyFee);
		
		textField_6 = new JTextField();
		textField_6.setText("750.00");
		textField_6.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField_6.setBounds(120, 310, 68, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblRs = new JLabel("Rs.");
		lblRs.setBounds(92, 313, 23, 16);
		contentPane.add(lblRs);
		
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox_3.getSelectedIndex()==1){
					lblHowMany.setVisible(true);
					textField.setVisible(true);
				}else if(comboBox_3.getSelectedIndex()==0){
					lblHowMany.setVisible(false);
					textField.setVisible(false);
				}
			}
		});
	}
}
