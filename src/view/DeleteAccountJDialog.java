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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class DeleteAccountJDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldConfirmEnrollment;
	private StudentController studentController;
	private JTextField textFieldPassword;
	private boolean isExclusionAllowed;
	private StudentControlPanelView studentControlPanelView;

	/**
	 * Create the dialog.
	 */
	public DeleteAccountJDialog(StudentController studentController, StudentControlPanelView studentControlPanelView) {
		this.studentController = studentController;
		this.studentControlPanelView = studentControlPanelView;
		createGUIComponents();
	}

	/**
	 * Initialize the components
	 */
	
	public void createGUIComponents() {
		
		setUndecorated(true);
		setResizable(false);
		setBackground(new Color(49, 49, 49));
		setType(Type.UTILITY);
		setBounds(100, 100, 676, 412);
		setAlwaysOnTop(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(49, 49, 49));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		{
			JLabel lblDeleteAccount = new JLabel("Esta operação excluirá sua conta. ");
			lblDeleteAccount.setHorizontalAlignment(SwingConstants.CENTER);
			lblDeleteAccount.setForeground(new Color(255, 255, 255));
			lblDeleteAccount.setFont(new Font("Arial Black", Font.BOLD, 14));
			lblDeleteAccount.setBounds(10, 21, 656, 31);
			contentPanel.add(lblDeleteAccount);
		}
		
		JLabel lblDeleteAllData = new JLabel("Todos os dados associados serão permanentemente removidos do sistema.");
		lblDeleteAllData.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteAllData.setForeground(Color.WHITE);
		lblDeleteAllData.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblDeleteAllData.setBounds(20, 63, 656, 31);
		contentPanel.add(lblDeleteAllData);
		
		JLabel lblWishProceed = new JLabel(" Se deseja prosseguir, confirme sua matrícula e clique em 'OK'.");
		lblWishProceed.setHorizontalAlignment(SwingConstants.CENTER);
		lblWishProceed.setForeground(Color.WHITE);
		lblWishProceed.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblWishProceed.setBounds(10, 99, 656, 31);
		contentPanel.add(lblWishProceed);
		
		JLabel lblCancel = new JLabel("Se deseja cancelar a ação, clique em 'Cancelar'.");
		lblCancel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancel.setForeground(Color.WHITE);
		lblCancel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblCancel.setBounds(10, 141, 656, 31);
		contentPanel.add(lblCancel);
		
		JLabel lblEnrollment = new JLabel("Matrícula");
		lblEnrollment.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnrollment.setForeground(Color.WHITE);
		lblEnrollment.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblEnrollment.setBounds(56, 198, 134, 31);
		contentPanel.add(lblEnrollment);
		
		textFieldConfirmEnrollment = new JTextField();
		textFieldConfirmEnrollment.setFont(new Font("Arial Black", Font.BOLD, 12));
		textFieldConfirmEnrollment.setBounds(200, 204, 311, 20);
		contentPanel.add(textFieldConfirmEnrollment);
		textFieldConfirmEnrollment.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirmar");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enrollment = textFieldConfirmEnrollment.getText();
				String password = textFieldPassword.getText();
				if(studentController == null) {
					studentController = new StudentController(studentController.getStudent());
				}
				if(studentController.isAuthenticated(new StudentDTO(enrollment, password))) {
					JOptionPane.showMessageDialog(DeleteAccountJDialog.this, "Dados confirmados");
					isExclusionAllowed = true;
				}else {
					JOptionPane.showMessageDialog(DeleteAccountJDialog.this, "Dados incorretos");
				}
			}
		});
		btnConfirm.setForeground(new Color(255, 0, 0));
		btnConfirm.setBackground(new Color(49, 49, 49));
		btnConfirm.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
		btnConfirm.setBounds(294, 303, 101, 23);
		contentPanel.add(btnConfirm);
		
		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblPassword.setBounds(56, 250, 134, 31);
		contentPanel.add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Arial Black", Font.BOLD, 12));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(200, 256, 311, 20);
		contentPanel.add(textFieldPassword);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(49, 49, 49));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(isExclusionAllowed) {
							String enrollment = textFieldConfirmEnrollment.getText();
							String password = textFieldPassword.getText();
							if(studentController.deleteAccount(new StudentDTO(enrollment, password))) {
								JOptionPane.showMessageDialog(DeleteAccountJDialog.this, "Conta excluída com sucesso!");
								new LoginView(studentController);
								studentControlPanelView.dispose();
								dispose();
							}
						}else {
							JOptionPane.showMessageDialog(DeleteAccountJDialog.this, "Confirme sua matricula e senha!");
						}
					}
				});
				okButton.setForeground(new Color(255, 0, 0));
				okButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
				okButton.setBackground(new Color(49, 49, 49));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textFieldConfirmEnrollment.setText("");
						textFieldPassword.setText("");
						isExclusionAllowed = false;
						dispose();
					}
				});
				cancelButton.setForeground(new Color(0, 255, 0));
				cancelButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
				cancelButton.setBackground(new Color(49, 49, 49));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}
}
