package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;

public class StudentEnrollment extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentEnrollment frame = new StudentEnrollment();
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
	public StudentEnrollment() {
		setType(Type.UTILITY);
		setTitle("Student Enrollments");
		setBounds(100, 100, 500, 300);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

	}

}
