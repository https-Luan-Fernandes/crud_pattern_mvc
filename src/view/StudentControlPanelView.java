package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import controller.StudentController;
import model.StudentDTO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentControlPanelView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LoginView loginView;
	private JPanel panel_1;
	private StudentController studentController;
	private StudentDTO recoveredStudent;
	private DeleteAccountJDialog deleteAccountView;
	private EditStudentInfoView editStudentInfoView;


	/**
	 * @wbp.parser.constructor
	 */
	public StudentControlPanelView(StudentController studentController) {
		this.studentController = studentController;
		createGUIComponents();
	}
	
	public StudentControlPanelView(StudentController studentController, StudentDTO recoveredStudent) {
        this.recoveredStudent = recoveredStudent;
		this.studentController = studentController;
		createGUIComponents();
	}

	public void createGUIComponents() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 473);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(21, 2, 40));
		contentPane.setBorder(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(49, 49, 49));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(77, 77, 77), null, null, null));
		panel.setBounds(0, 0, 169, 473);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSCM = new JLabel("S C M");
		lblSCM.setForeground(new Color(91, 91, 91));
		lblSCM.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		lblSCM.setBounds(10, 11, 171, 23);
		panel.add(lblSCM);
		
		JLabel lblRecoveredName = new JLabel(recoveredStudent.getName());
		lblRecoveredName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		lblRecoveredName.setIcon(new ImageIcon("C:\\Users\\Luanf\\eclipse-workspace\\crud_padrao_mvc\\images\\ft_perfil.png"));
		lblRecoveredName.setForeground(new Color(97, 97, 97));
		lblRecoveredName.setBounds(10, 45, 171, 38);
		panel.add(lblRecoveredName);
		
		JButton btnExit = new JButton("Sair");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if(loginView == null)
					loginView = new LoginView(studentController);
				loginView.setVisible(true);
			}
		});
		btnExit.setHorizontalAlignment(SwingConstants.LEFT);
		btnExit.setIcon(new ImageIcon("C:\\Users\\Luanf\\eclipse-workspace\\crud_padrao_mvc\\images\\saida.png"));
		btnExit.setForeground(new Color(97, 97, 97));
		btnExit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		btnExit.setBackground(new Color(49, 49, 49));
		btnExit.setBounds(10, 231, 149, 31);
		panel.add(btnExit);
		
		panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(21, 2, 40));
		panel_1.setBounds(179, 11, 676, 412);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnEditInfo = new JButton("Editar informações");
		btnEditInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(editStudentInfoView == null) {
					editStudentInfoView = new EditStudentInfoView(studentController, recoveredStudent, StudentControlPanelView.this );
					editStudentInfoView.setLocationRelativeTo(panel_1);
				}else {
					editStudentInfoView.setLocationRelativeTo(panel_1);
					editStudentInfoView.setVisible(true);
				}
				
			}
		});
		btnEditInfo.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditInfo.setForeground(new Color(97, 97, 97));
		btnEditInfo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		btnEditInfo.setBackground(new Color(49, 49, 49));
		btnEditInfo.setBounds(10, 147, 149, 31);
		panel.add(btnEditInfo);
		
		JButton btnTutoringAnnouncement = new JButton("Acompanhar editais");
		btnTutoringAnnouncement.setHorizontalAlignment(SwingConstants.LEFT);
		btnTutoringAnnouncement.setForeground(new Color(97, 97, 97));
		btnTutoringAnnouncement.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		btnTutoringAnnouncement.setBackground(new Color(49, 49, 49));
		btnTutoringAnnouncement.setBounds(10, 107, 149, 31);
		panel.add(btnTutoringAnnouncement);
		
		JButton btnDeleteAccount = new JButton("Excluir conta");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(deleteAccountView == null) {
					deleteAccountView = new DeleteAccountJDialog(studentController, StudentControlPanelView.this);
					deleteAccountView.setLocationRelativeTo(panel_1);
				}else {
					deleteAccountView.setLocationRelativeTo(panel_1);
					deleteAccountView.setVisible(true);
				}
			}
		});
		btnDeleteAccount.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeleteAccount.setForeground(new Color(97, 97, 97));
		btnDeleteAccount.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		btnDeleteAccount.setBackground(new Color(49, 49, 49));
		btnDeleteAccount.setBounds(10, 189, 149, 31);
		panel.add(btnDeleteAccount);
		setVisible(true);
	}
}
