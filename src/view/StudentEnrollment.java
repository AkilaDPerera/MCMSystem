package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import dbConnection.Takes;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class StudentEnrollment extends JFrame implements SelectableStudent, SelectableClass {

	private JLabel lblclssId;
	private JLabel lblSubjt;
	private JLabel lblClssname;
	
	private JLabel lblstdId;
	private JLabel lblStdname;
	private JLabel lblEmail_1;
	
	private JFrame submain;
	private JFrame win;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StudentEnrollment frame = new StudentEnrollment();
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
	public StudentEnrollment(JFrame submain) {
		this.submain = submain;
		this.win = this;
		
		setResizable(false);
		setType(Type.POPUP);
		setTitle("Student Enrollments");
		setBounds(100, 100, 536, 302);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnSelectStd = new JButton("Select Student");
		btnSelectStd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnSelectStd.setBounds(291, 42, 140, 25);
		getContentPane().add(btnSelectStd);
		
		JButton btnSelectClass = new JButton("Select Class");
		btnSelectClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectClass window;
				try {
					window = new SelectClass(win);
					window.setVisible(true);
					win.setVisible(false);
				} catch (IOException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSelectClass.setBounds(53, 42, 140, 25);
		getContentPane().add(btnSelectClass);
		
		JLabel lblEnrollments = new JLabel("Enrollments");
		lblEnrollments.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnrollments.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnrollments.setBounds(137, 13, 217, 16);
		getContentPane().add(lblEnrollments);
		
		JButton btnEnrol = new JButton("Enrol");
		btnEnrol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblclssId.getText().equals("") && !lblstdId.getText().equals("")){
					try {
						Takes.addEnrolment(lblclssId.getText(), lblstdId.getText());
						JOptionPane.showMessageDialog(null, "Class enrolment successful!", "Successful",JOptionPane.INFORMATION_MESSAGE);
						win.dispose();
						submain.setVisible(true);
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnEnrol.setBounds(209, 100, 67, 55);
		getContentPane().add(btnEnrol);
		
		JLabel lblClassId = new JLabel("Class Id :");
		lblClassId.setBounds(53, 100, 56, 16);
		getContentPane().add(lblClassId);
		
		JLabel lblSubject = new JLabel("Subject :");
		lblSubject.setBounds(53, 139, 56, 16);
		getContentPane().add(lblSubject);
		
		JLabel lblNewLabel = new JLabel("Student Id :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(326, 100, 84, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student Name :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(310, 139, 100, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(310, 182, 100, 16);
		getContentPane().add(lblEmail);
		
		lblclssId = new JLabel("");
		lblclssId.setBounds(116, 100, 77, 16);
		getContentPane().add(lblclssId);
		
		lblSubjt = new JLabel("");
		lblSubjt.setBounds(116, 139, 77, 16);
		getContentPane().add(lblSubjt);
		
		lblClssname = new JLabel("");
		lblClssname.setBounds(109, 182, 100, 16);
		getContentPane().add(lblClssname);
		
		lblstdId = new JLabel("");
		lblstdId.setBounds(426, 100, 77, 16);
		getContentPane().add(lblstdId);
		
		lblStdname = new JLabel("");
		lblStdname.setBounds(422, 139, 81, 16);
		getContentPane().add(lblStdname);
		
		lblEmail_1 = new JLabel("");
		lblEmail_1.setBounds(422, 182, 100, 16);
		getContentPane().add(lblEmail_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.dispose();
				submain.setVisible(true);
			}
		});
		btnBack.setBounds(200, 231, 97, 25);
		getContentPane().add(btnBack);

	}

	@Override
	public void setClassDetails(String class_id, String subject, String teacher_name) {
		lblclssId.setText(class_id);
		lblSubjt.setText(subject);
		lblClssname.setText(teacher_name);
	}

	@Override
	public void setStdNameId(String student_id, String student_name, String email, String address) {
		lblstdId.setText(student_id);
		lblStdname.setText(student_name);
		lblEmail_1.setText(email);
		
	}



}
