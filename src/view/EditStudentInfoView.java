package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.StudentController;
import model.StudentDTO;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditStudentInfoView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private StudentController studentController;
	private StudentDTO recoveredStudent;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;
	private StudentControlPanelView studentControlPanelView;


	public EditStudentInfoView(StudentController studentController, StudentDTO recoveredStudent,StudentControlPanelView studentControlPanelView) {
		this.studentController = studentController;
		this.recoveredStudent = recoveredStudent;
		this.studentControlPanelView = studentControlPanelView;
		createGUIComponents();
	}
	/**
	 * Create the dialog.
	 */
	public void createGUIComponents() {
		setBounds(100, 100, 676, 412);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(49, 49, 49));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblName = new JLabel("Nome");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblName.setBounds(45, 83, 134, 31);
		contentPanel.add(lblName);
		
		JLabel lblEnrollment = new JLabel("Matrícula");
		lblEnrollment.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnrollment.setForeground(Color.WHITE);
		lblEnrollment.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblEnrollment.setBounds(45, 125, 134, 31);
		contentPanel.add(lblEnrollment);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblEmail.setBounds(45, 167, 134, 31);
		contentPanel.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblPassword.setBounds(45, 210, 134, 31);
		contentPanel.add(lblPassword);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Arial Black", Font.BOLD, 12));
		textFieldName.setColumns(10);
		textFieldName.setBounds(214, 90, 311, 20);
		textFieldName.setText(recoveredStudent.getName());
		contentPanel.add(textFieldName);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Arial Black", Font.BOLD, 12));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(214, 174, 311, 20);
		textFieldEmail.setText(recoveredStudent.getEmail());
		contentPanel.add(textFieldEmail);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Arial Black", Font.BOLD, 12));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(214, 217, 311, 20);
		textFieldPassword.setText(recoveredStudent.getPassword());
		contentPanel.add(textFieldPassword);
		
		JLabel lblEnrollmentRecovered = new JLabel(recoveredStudent.getEnrollment());
		lblEnrollmentRecovered.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnrollmentRecovered.setForeground(Color.WHITE);
		lblEnrollmentRecovered.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblEnrollmentRecovered.setBounds(214, 125, 311, 31);
		contentPanel.add(lblEnrollmentRecovered);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						recoveredStudent.setName(textFieldName.getText());
						recoveredStudent.setEmail(textFieldEmail.getText());
						recoveredStudent.setPassword(textFieldPassword.getText());
						studentController.updateStudent(recoveredStudent);
						JOptionPane.showMessageDialog(EditStudentInfoView.this, "Dados atualizados!");
						studentControlPanelView.createGUIComponents();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}
    
}
