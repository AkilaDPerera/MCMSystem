package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.toedter.calendar.JDateChooser;

import dbConnection.Takes;
import model.AddStudentLogic;
import validation.GeneralValidations;

import java.awt.Component;
import javax.swing.JRadioButton;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.SwingConstants;
import java.awt.Window.Type;

public class AddStudent extends JFrame {
	private JFrame main;
	private JFrame win;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldAddress;
	private JTextField textFieldEmail;
	private JTextField textFieldMobile;
	private JTextField textFieldMobile2;
	private ButtonGroup bg = new ButtonGroup();
	private JTextField textFieldFamID;
	private JTextField textFieldMomName;
	private JTextField textFieldDadName;
	private JTextField textFieldMomContact;
	private JTextField textFieldDadContact;
	private JTextField textFieldGuardianName;
	private JTextField textFieldGuardianContact;

	private JLabel lblClass;

	/**
	 * Launch the application.
	 */

	private static JDateChooser dateChooser_1;
	private static String dob=null;

	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// AddStudent frame = new AddStudent();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public AddStudent(JFrame main) {
		setType(Type.UTILITY); // (JFrame main)
		this.main = main;
		win = this;
		setTitle("Add Student");
		setBounds(100, 100, 500, 719);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblAddStudent = new JLabel("Add Student");
		lblAddStudent.setBounds(162, 13, 138, 16);
		getContentPane().add(lblAddStudent);

		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(101, 42, 164, 22);
		getContentPane().add(textFieldFirstName);
		textFieldFirstName.setColumns(10);

		JLabel lblFirstName = new JLabel("First Name*");
		lblFirstName.setBounds(12, 45, 77, 16);
		getContentPane().add(lblFirstName);

		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(101, 77, 164, 22);
		getContentPane().add(textFieldLastName);

		JLabel lblLastName = new JLabel("Last Name*");
		lblLastName.setBounds(12, 80, 77, 16);
		getContentPane().add(lblLastName);

		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(22, 209, 164, 22);
		getContentPane().add(textFieldAddress);
		textFieldAddress.setColumns(10);

		JLabel lblAddressLine = new JLabel("Address line 1*");
		lblAddressLine.setBounds(12, 188, 112, 16);
		getContentPane().add(lblAddressLine);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(306, 209, 164, 22);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail address*");
		lblEmail.setBounds(281, 188, 119, 16);
		getContentPane().add(lblEmail);

		textFieldMobile = new JTextField();
		textFieldMobile.setBounds(22, 262, 164, 22);
		getContentPane().add(textFieldMobile);
		textFieldMobile.setColumns(10);

		textFieldMobile2 = new JTextField();
		textFieldMobile2.setBounds(306, 262, 164, 22);
		getContentPane().add(textFieldMobile2);
		textFieldMobile2.setColumns(10);

		JLabel lblMobileNumber_1 = new JLabel("Mobile Number*");
		lblMobileNumber_1.setBounds(12, 244, 108, 16);
		getContentPane().add(lblMobileNumber_1);

		JLabel lblMobileNumber_2 = new JLabel("Mobile Number");
		lblMobileNumber_2.setBounds(281, 244, 108, 16);
		getContentPane().add(lblMobileNumber_2);

		JLabel lblGender = new JLabel("Gender*");
		lblGender.setBounds(12, 130, 56, 16);
		getContentPane().add(lblGender);

		JComboBox comboBoxGender = new JComboBox();
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female" }));
		comboBoxGender.setBounds(22, 153, 164, 22);
		getContentPane().add(comboBoxGender);

		JLabel lblDateOfBirth = new JLabel("Date of birth*");
		lblDateOfBirth.setBounds(281, 130, 164, 16);
		getContentPane().add(lblDateOfBirth);

		JRadioButton rdbtnNewRadioButtonNewFam = new JRadioButton("New Family");
		rdbtnNewRadioButtonNewFam.setSelected(true);
		rdbtnNewRadioButtonNewFam.setBounds(262, 368, 127, 25);
		getContentPane().add(rdbtnNewRadioButtonNewFam);

		JRadioButton rdbtnNewRadioButtonExist = new JRadioButton("Existing Family");

		rdbtnNewRadioButtonExist.setBounds(70, 368, 127, 25);
		getContentPane().add(rdbtnNewRadioButtonExist);

		bg.add(rdbtnNewRadioButtonExist);
		bg.add(rdbtnNewRadioButtonNewFam);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(12, 402, 458, 206);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setEnabled(true);

		JLabel lblMothersName = new JLabel("Mother's name*");
		lblMothersName.setBounds(39, 26, 95, 16);
		panel_1.add(lblMothersName);

		textFieldMomName = new JTextField();
		textFieldMomName.setBounds(49, 41, 164, 22);
		panel_1.add(textFieldMomName);
		textFieldMomName.setColumns(10);

		JLabel lblFathersName = new JLabel("Father's name*");
		lblFathersName.setBounds(39, 76, 95, 16);
		panel_1.add(lblFathersName);

		textFieldDadName = new JTextField();
		textFieldDadName.setBounds(49, 90, 164, 22);
		panel_1.add(textFieldDadName);
		textFieldDadName.setColumns(10);

		JLabel lblGuardiansName = new JLabel("Guardian's name");
		lblGuardiansName.setBounds(39, 125, 118, 16);
		panel_1.add(lblGuardiansName);

		textFieldGuardianName = new JTextField();
		textFieldGuardianName.setBounds(49, 140, 164, 22);
		panel_1.add(textFieldGuardianName);
		textFieldGuardianName.setColumns(10);

		JLabel lblContactNumber = new JLabel("Contact Number*");
		lblContactNumber.setBounds(274, 13, 108, 16);
		panel_1.add(lblContactNumber);

		textFieldMomContact = new JTextField();
		textFieldMomContact.setBounds(274, 41, 95, 22);
		panel_1.add(textFieldMomContact);
		textFieldMomContact.setColumns(10);

		textFieldDadContact = new JTextField();
		textFieldDadContact.setBounds(274, 90, 95, 22);
		panel_1.add(textFieldDadContact);
		textFieldDadContact.setColumns(10);

		textFieldGuardianContact = new JTextField();
		textFieldGuardianContact.setBounds(274, 140, 95, 22);
		panel_1.add(textFieldGuardianContact);
		textFieldGuardianContact.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(12, 402, 458, 206);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		panel.setEnabled(false);

		JLabel lblFamilyId = new JLabel("Family id*");
		lblFamilyId.setBounds(125, 91, 59, 16);
		panel.add(lblFamilyId);

		textFieldFamID = new JTextField();
		textFieldFamID.setBounds(218, 88, 116, 22);
		panel.add(textFieldFamID);
		textFieldFamID.setColumns(10);

		JLabel lblClassWantTo = new JLabel("Class want to join :");
		lblClassWantTo.setBounds(306, 42, 117, 16);
		getContentPane().add(lblClassWantTo);

		// JLabel lblDate = new JLabel("yyyy-mm-dd");
		// lblDate.setBounds(281, 156, 80, 16);
		// getContentPane().add(lblDate);
		//
		// JButton btnPickDate = new JButton("Pick Date");
		// btnPickDate.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// }
		// });
		// btnPickDate.setBounds(373, 152, 97, 25);
		// getContentPane().add(btnPickDate);

		JButton btnSelectClass = new JButton("Select Class");
		btnSelectClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectClass window;
				try {
					window = new SelectClass(win);
					window.setVisible(true);
					win.setVisible(false);
				} catch (IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnSelectClass.setBounds(306, 76, 164, 25);
		getContentPane().add(btnSelectClass);

		lblClass = new JLabel("None");
		lblClass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClass.setBounds(414, 59, 56, 16);
		getContentPane().add(lblClass);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { lblMobileNumber_2,
				textFieldFirstName, textFieldLastName, comboBoxGender, lblAddStudent, lblLastName, lblAddressLine,
				textFieldAddress, textFieldEmail, lblEmail, textFieldMobile, lblMobileNumber_1, textFieldMobile2,
				lblGender, lblDateOfBirth, lblFirstName }));

		rdbtnNewRadioButtonNewFam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(true);
				panel_1.setEnabled(true);
				panel.setVisible(false);
				panel.setEnabled(false);

			}
		});

		rdbtnNewRadioButtonExist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(true);
				panel.setEnabled(true);
				panel_1.setVisible(false);
				panel_1.setEnabled(false);
			}
		});
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(((JTextField) dateChooser_1.getDateEditor().getUiComponent()).getText());

				ArrayList<Boolean> temp = new ArrayList<Boolean>();

				String first_name = textFieldFirstName.getText().trim();
				String last_name = textFieldLastName.getText().trim();
				String address = textFieldAddress.getText().trim();
				String email = textFieldEmail.getText().trim();
				String phone = textFieldMobile.getText().trim();
				String alt_phone = textFieldMobile2.getText().trim();
				try{
				dob = ((JTextField) dateChooser_1.getDateEditor().getUiComponent()).getText(); // "1994-12-25";//lblDate.getText().trim();
				}catch(Exception ee){}
				
				String gender = comboBoxGender.getSelectedItem().toString();
				String family_id = textFieldFamID.getText().trim();

				String momName = textFieldMomName.getText().trim();
				String dadName = textFieldDadName.getText().trim();
				String guardianName = textFieldGuardianName.getText().trim();

				String momContact = textFieldMomContact.getText().trim();
				String dadContact = textFieldDadContact.getText().trim();
				String guardianContact = textFieldGuardianContact.getText().trim();

				Boolean isGoodToGo = true;

				temp.add(GeneralValidations.nameValidation(first_name));
				temp.add(GeneralValidations.nameValidation(last_name));
				temp.add(GeneralValidations.addressValidation(address));
				temp.add(GeneralValidations.emailValidation(email));
				temp.add(GeneralValidations.phoneValidation(phone));
				temp.add(GeneralValidations.optionalPhoneValidation(alt_phone));
				temp.add(GeneralValidations.dobValidation(dob));

				if (rdbtnNewRadioButtonNewFam.isSelected()) {

					temp.add(GeneralValidations.nameValidation(momName));
					temp.add(GeneralValidations.nameValidation(dadName));
					temp.add(GeneralValidations.optionalNameValidation(guardianName));

					temp.add(GeneralValidations.phoneValidation(momContact));
					temp.add(GeneralValidations.phoneValidation(dadContact));
					temp.add(GeneralValidations.optionalPhoneValidation(guardianContact));

					for (Boolean t : temp) {
						if (!t) {
							// Basic validation fail. Check the entries again
							// Changing the font color
							lblFirstName.setForeground(Color.red);
							lblLastName.setForeground(Color.red);
							lblDateOfBirth.setForeground(Color.red);
							lblAddressLine.setForeground(Color.red);
							lblEmail.setForeground(Color.red);
							lblMobileNumber_1.setForeground(Color.red);
							lblMobileNumber_2.setForeground(Color.red);

							lblMothersName.setForeground(Color.red);
							lblFathersName.setForeground(Color.red);
							lblGuardiansName.setForeground(Color.red);
							lblContactNumber.setForeground(Color.red);

							lblFamilyId.setForeground(Color.red);

							// display a error message
							JOptionPane.showMessageDialog(null, "Check the highlighted text and try again.", "Error",
									JOptionPane.ERROR_MESSAGE);
							isGoodToGo = false;
							break;
						}
					}
					// No basic error found
					if (isGoodToGo) {
						try {
							String[] result = AddStudentLogic.addStudentNewFam(first_name, last_name, phone, alt_phone,
									address, email, dob, gender, momName, momContact, dadName, dadContact, guardianName,
									guardianContact);

							JOptionPane.showMessageDialog(null,
									"Adding successful!\nstudent id: " + result[0] + "\nfamily id:" + result[1],
									"Successful", JOptionPane.INFORMATION_MESSAGE);

							// If enrolment added
							String classid = lblClass.getText();
							if (!classid.equals("None")) {
								Takes.addEnrolment(classid, result[0]);
								JOptionPane.showMessageDialog(null, "Class enrolment successful!", "Successful",
										JOptionPane.INFORMATION_MESSAGE);
							}

							win.dispose();
							main.setVisible(true);

						} catch (SQLException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				} else {
					temp.add(GeneralValidations.idValidation(family_id));

					for (Boolean t : temp) {
						if (!t) {
							// Basic validation fail. Check the entries again
							// Changing the font color
							lblFirstName.setForeground(Color.red);
							lblLastName.setForeground(Color.red);
							lblDateOfBirth.setForeground(Color.red);
							lblAddressLine.setForeground(Color.red);
							lblEmail.setForeground(Color.red);
							lblMobileNumber_1.setForeground(Color.red);
							lblMobileNumber_2.setForeground(Color.red);

							lblMothersName.setForeground(Color.red);
							lblFathersName.setForeground(Color.red);
							lblGuardiansName.setForeground(Color.red);
							lblContactNumber.setForeground(Color.red);

							lblFamilyId.setForeground(Color.red);

							// display a error message
							JOptionPane.showMessageDialog(null, "Check the highlighted text and try again.", "Error",
									JOptionPane.ERROR_MESSAGE);
							isGoodToGo = false;
							break;
						}
					}
					// No basic error found
					if (isGoodToGo) {
						try {
							String[] t = AddStudentLogic.addStudentExistingFam1(family_id);
							if (t[0].equals("-1")) {
								JOptionPane.showMessageDialog(null, t[1], "Error", JOptionPane.ERROR_MESSAGE);

							} else {
								int rslt = JOptionPane.showConfirmDialog(null,
										"Is your mother: " + t[0] + "\nAnd father: " + t[2]);
								if (rslt == JOptionPane.YES_OPTION) {
									String[] result = AddStudentLogic.addStudentExistingFam2(first_name, last_name,
											phone, alt_phone, address, email, dob, gender, family_id);

									JOptionPane.showMessageDialog(null,
											"Adding successful!\nstudent id: " + result[0] + "\nfamily id:" + result[1],
											"Successful", JOptionPane.INFORMATION_MESSAGE);

									// If enrolment added
									String classid = lblClass.getText();
									if (!classid.equals("None")) {
										Takes.addEnrolment(classid, result[0]);
										JOptionPane.showMessageDialog(null, "Class enrolment successful!", "Successful",
												JOptionPane.INFORMATION_MESSAGE);
									}

									win.dispose();
									main.setVisible(true);

								} else if (rslt == JOptionPane.NO_OPTION) {
									JOptionPane.showMessageDialog(null, "Please put the accurate family id.", "Info",
											JOptionPane.INFORMATION_MESSAGE);
								}
							}

						} catch (IOException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

			}
		});

		btnSubmit.setBounds(303, 625, 97, 25);
		getContentPane().add(btnSubmit);

		JLabel lblClassId = new JLabel("Class ID: ");
		lblClassId.setBounds(355, 59, 56, 16);
		getContentPane().add(lblClassId);

		dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("yyyy-MM-dd");
		dateChooser_1.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dateChooser_1.setBounds(306, 153, 164, 22);
		getContentPane().add(dateChooser_1);
		
		JButton btnBackToMain = new JButton("Back");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.dispose();
				main.setVisible(true);
			}
		});
		btnBackToMain.setBounds(57, 625, 97, 25);
		getContentPane().add(btnBackToMain);
//		dob = ((JTextField) dateChooser_1.getDateEditor().getUiComponent()).getText();
		// System.out.println(((JTextField)dateChooser_1.getDateEditor().getUiComponent()).getText());

	}

	public void setId(String id) {
		lblClass.setText(id);
	}
}
