package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Window.Type;

public class LogView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LogView frame = new LogView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
	public LogView() {
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 889, 483);
		contentPane.add(scrollPane);

		JTextArea txtrFasdfasssssssssssssssssss = new JTextArea();
		scrollPane.setViewportView(txtrFasdfasssssssssssssssssss);
		txtrFasdfasssssssssssssssssss.setText(" ");
	


		try {
			FileReader reader = new FileReader("log.txt");
			BufferedReader br = new BufferedReader(reader);
			txtrFasdfasssssssssssssssssss.read(br, null);
			br.close();
			txtrFasdfasssssssssssssssssss.requestFocus();

		} catch (Exception eee) {

		}
	

}
}
