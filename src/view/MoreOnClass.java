package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class MoreOnClass extends JFrame {

	/**
	 * Launch the application.
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
	public MoreOnClass() {
		setTitle("More");
		setBounds(100, 100, 861, 551);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblClassid = new JLabel("Class_ID");
		lblClassid.setBounds(29, 13, 56, 16);
		getContentPane().add(lblClassid);
		
		JLabel lblNewLabel = new JLabel("Subject");
		lblNewLabel.setBounds(97, 13, 56, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Teacher's name");
		lblNewLabel_1.setBounds(165, 13, 99, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("on");
		lblNewLabel_2.setBounds(276, 13, 28, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("from");
		lblNewLabel_3.setBounds(316, 13, 56, 16);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Max std");
		lblNewLabel_4.setBounds(384, 13, 56, 16);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("number of people already enrolled");
		lblNewLabel_5.setBounds(452, 13, 215, 16);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblAttendenceFees = new JLabel("Attendence & fees");
		lblAttendenceFees.setBounds(29, 100, 157, 16);
		getContentPane().add(lblAttendenceFees);
		
		JLabel lblNewLabel_6 = new JLabel("This should be auto generated");
		lblNewLabel_6.setBounds(29, 167, 189, 16);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblStudentid = new JLabel("Student-ID");
		lblStudentid.setBounds(29, 219, 76, 16);
		getContentPane().add(lblStudentid);
		
		JLabel lblStdName = new JLabel("Std name | last name | ");
		lblStdName.setBounds(117, 219, 147, 16);
		getContentPane().add(lblStdName);
		
		JCheckBox chckbxPaid = new JCheckBox("paid");
		chckbxPaid.setBounds(276, 215, 62, 25);
		getContentPane().add(chckbxPaid);
		
		JCheckBox chckbxPresent = new JCheckBox("present");
		chckbxPresent.setBounds(342, 215, 82, 25);
		getContentPane().add(chckbxPresent);
		
		JButton btnAttachMarks = new JButton("attach marks");
		btnAttachMarks.setBounds(432, 215, 157, 25);
		getContentPane().add(btnAttachMarks);
		
		JButton btnEnrollExistingStd = new JButton("Enroll existing std");
		btnEnrollExistingStd.setBounds(646, 56, 133, 25);
		getContentPane().add(btnEnrollExistingStd);
		
		JLabel label = new JLabel("Teacher's name");
		label.setBounds(29, 60, 99, 16);
		getContentPane().add(label);
		
		JCheckBox chckbxPresent_1 = new JCheckBox("present");
		chckbxPresent_1.setBounds(151, 56, 113, 25);
		getContentPane().add(chckbxPresent_1);

	}
}
