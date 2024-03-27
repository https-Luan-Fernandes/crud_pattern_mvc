package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;

import controller.StudentController;
import model.StudentDTO;

import javax.swing.border.BevelBorder;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEnrollment;
	private JPasswordField passwordField;
	private StudentRegisterView studentRegisterView;
	private StudentController studentController;

	/**
	 * Create the frame.
	 */
	public LoginView(StudentController studentController) {
		this.studentController = studentController;
		createGUIComponents();
	}
	
	public void createGUIComponents() {
		
		setTitle("tela de login");
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
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(26, 2, 65));
		panel.setBounds(378, 56, 382, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(0, 255, 64));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
		lblLogin.setBounds(125, 11, 133, 25);
		panel.add(lblLogin);
		
		JLabel lblUser = new JLabel("Usuário");
		lblUser.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setBounds(35, 56, 150, 25);
		panel.add(lblUser);
		
		textFieldEnrollment = new JTextField();
		textFieldEnrollment.requestFocusInWindow();
		textFieldEnrollment.setToolTipText("digite sua matrícula...");
		textFieldEnrollment.setForeground(new Color(0, 0, 0));
		textFieldEnrollment.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		textFieldEnrollment.setBounds(35, 92, 322, 22);
		panel.add(textFieldEnrollment);
		textFieldEnrollment.setColumns(10);
		
		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Arial", Font.BOLD, 18));
		lblPassword.setBounds(35, 142, 150, 32);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("digite sua senha...");
		passwordField.setForeground(new Color(0, 0, 0));
		passwordField.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		passwordField.setBounds(35, 200, 322, 22);
		panel.add(passwordField);
		
		JButton btnLogin = new JButton("entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String enrollment = textFieldEnrollment.getText();
				String password = new String(passwordField.getPassword());
				StudentDTO studentDTO = new StudentDTO(enrollment, password);
				if(studentController.isStudentRegistered(studentDTO)) {
					StudentDTO recoveredStudent = studentController.recoverStudent(studentDTO);
					new StudentControlPanelView(studentController, recoveredStudent);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Usuário inválido!");
				}
				
			}
		});
		
		btnLogin.setBackground(new Color(0, 255, 64));
		btnLogin.setFont(new Font("Arial", Font.BOLD, 12));
		btnLogin.setForeground(new Color(21, 2, 40));
		btnLogin.setBounds(125, 254, 118, 23);
		panel.add(btnLogin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(21, 2, 40));
		panel_1.setBounds(61, 39, 215, 373);
		contentPane.add(panel_1);
		
		JLabel lblSCM = new JLabel("S     C     M");
		lblSCM.setForeground(new Color(0, 255, 64));
		lblSCM.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		lblSCM.setBounds(47, 11, 116, 29);
		panel_1.add(lblSCM);
		
		JLabel lblIAO = new JLabel("I     A     O");
		lblIAO.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		lblIAO.setBounds(47, 51, 106, 29);
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
		
		JButton btnRegister = new JButton("Cadastrar-se");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if(studentRegisterView == null)
					studentRegisterView = new StudentRegisterView(studentController);
				studentRegisterView.setVisible(true);
			}
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Arial", Font.BOLD, 12));
		btnRegister.setBackground(new Color(21, 2, 40));
		btnRegister.setBounds(47, 310, 118, 23);
		panel_1.add(btnRegister);
		setVisible(true);
	}
}
