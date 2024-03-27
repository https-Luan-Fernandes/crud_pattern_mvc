package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.StudentController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import model.StudentDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentRegisterView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldEnrollment;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	private LoginView loginView;
	private StudentDTO studentDTO;
	private StudentController studentController;

	/**
	 * Create the frame.
	 */
	public StudentRegisterView(StudentController studentController) {
		this.studentController = studentController;
		createGUIComponents();
	}
	
	public void createGUIComponents() {
		setTitle("tela de cadastro do aluno");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 880, 473);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(21, 2, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(26, 2, 65));
		panel.setBounds(371, 27, 392, 373);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblRegistration = new JLabel("Cadastro");
		lblRegistration.setBounds(136, 11, 124, 26);
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setForeground(new Color(0, 255, 64));
		lblRegistration.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
		panel.add(lblRegistration);
		
		JLabel lblName = new JLabel("Nome");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblName.setBounds(34, 55, 150, 25);
		panel.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setToolTipText("digite seu nome...");
		textFieldName.setForeground(new Color(0, 0, 0));
		textFieldName.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		textFieldName.setColumns(10);
		textFieldName.setBounds(34, 86, 322, 22);
		panel.add(textFieldName);
		
		JLabel lblEnrollment = new JLabel("Matrícula");
		lblEnrollment.setForeground(Color.WHITE);
		lblEnrollment.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblEnrollment.setBounds(34, 119, 150, 25);
		panel.add(lblEnrollment);
		
		textFieldEnrollment = new JTextField();
		textFieldEnrollment.setToolTipText("digite sua matricula...");
		textFieldEnrollment.setForeground(new Color(0, 0, 0));
		textFieldEnrollment.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		textFieldEnrollment.setColumns(10);
		textFieldEnrollment.setBounds(34, 155, 322, 22);
		panel.add(textFieldEnrollment);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblEmail.setBounds(34, 193, 150, 25);
		panel.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setToolTipText("digite seu email...");
		textFieldEmail.setForeground(new Color(0, 0, 0));
		textFieldEmail.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(34, 225, 322, 22);
		panel.add(textFieldEmail);
				
		JButton btnRegister = new JButton("Cadastrar");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textFieldName.getText();
				String enrollment = textFieldEnrollment.getText();
				String email = textFieldEmail.getText();
				String password = new String(passwordField.getPassword());
				if(studentDTO == null) {
					studentDTO = new StudentDTO(name,enrollment,email,password);
				}
				studentDTO.setName(name);
				studentDTO.setEnrollment(enrollment);
				studentDTO.setEmail(email);
				studentDTO.setPassword(password);
				if(studentController.registerStudent(studentDTO)) {
					textFieldName.setText("");
					textFieldEnrollment.setText("");
					textFieldEmail.setText("");
					passwordField.setText("");
					JOptionPane.showMessageDialog(getContentPane(),"Usuário Cadastrado com sucesso!");
				}else {
					JOptionPane.showMessageDialog(getContentPane(), "Dados inválidos!");
				}
				
			}
		});
		
		btnRegister.setForeground(new Color(21, 2, 40));
		btnRegister.setFont(new Font("Arial", Font.BOLD, 12));
		btnRegister.setBackground(new Color(0, 255, 64));
		btnRegister.setBounds(131, 339, 118, 23);
		panel.add(btnRegister);
		
		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 18));
		lblPassword.setBounds(34, 258, 150, 32);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("digite sua senha...");
		passwordField.setForeground(new Color(0, 0, 0));
		passwordField.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		passwordField.setBounds(34, 290, 322, 22);
		panel.add(passwordField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(21, 2, 40));
		panel_1.setBounds(60, 27, 215, 373);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSCM = new JLabel("S     C     M");
		lblSCM.setBounds(47, 11, 116, 29);
		lblSCM.setForeground(new Color(0, 255, 64));
		lblSCM.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		panel_1.add(lblSCM);
		
		JLabel lblIAO = new JLabel("I     A     O");
		lblIAO.setBounds(47, 51, 106, 29);
		lblIAO.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		panel_1.add(lblIAO);
		
		JLabel lblSDN = new JLabel("S     D     N");
		lblSDN.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		lblSDN.setBounds(47, 88, 132, 20);
		panel_1.add(lblSDN);
		
		JLabel lblTAI = new JLabel("T     A     I");
		lblTAI.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		lblTAI.setBounds(47, 118, 132, 20);
		panel_1.add(lblTAI);
		
		JLabel lblEST = new JLabel("E     S     T");
		lblEST.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		lblEST.setBounds(47, 152, 132, 20);
		panel_1.add(lblEST);
		
		JLabel lblMTO = new JLabel("M     T     O");
		lblMTO.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		lblMTO.setBounds(47, 188, 132, 20);
		panel_1.add(lblMTO);
		
		JLabel lblARR = new JLabel("A     R     R");
		lblARR.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		lblARR.setBounds(47, 216, 132, 20);
		panel_1.add(lblARR);
		
		JLabel lblOI = new JLabel("       O     I");
		lblOI.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		lblOI.setBounds(47, 245, 132, 20);
		panel_1.add(lblOI);
		
		JLabel lblA = new JLabel("              A");
		lblA.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		lblA.setBounds(47, 267, 132, 20);
		panel_1.add(lblA);
		
		JButton btnLogin = new JButton("Fazer login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if(loginView == null)
					loginView = new LoginView(studentController);
				loginView.setVisible(true);
			}
		});
		
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Arial", Font.BOLD, 12));
		btnLogin.setBackground(new Color(21, 2, 40));
		btnLogin.setBounds(47, 310, 118, 23);
		panel_1.add(btnLogin);
	}
}
