

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 501);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin login");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		lblNewLabel.setBounds(253, 12, 292, 85);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(195, 178, 88, 15);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.controlHighlight);
		textField.setBounds(370, 176, 124, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(195, 256, 88, 15);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(SystemColor.controlHighlight);
		passwordField.setBounds(370, 256, 124, 17);
		contentPane.add(passwordField);
		
		JButton btnAdminLogin = new JButton("Admin login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
					 String admin_username = "admin";                                              
				     String password = "1234";     													
					
				     String use = textField.getText();
				     String pwd = passwordField.getText();
				     
				     if(admin_username.equals(use) && password.contentEquals(pwd))
				     {
				    	 JOptionPane.showMessageDialog(null,"Entered admin credentials are correct"); 
				    	 setVisible(false);
				    	 AdminResult rst = new AdminResult();
				    	 rst.setVisible(true);
				     } else {
				    	 	JOptionPane.showMessageDialog(null,"Incorrect admin credentials");
				     	}
				     
				}catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,e);
					}
			}
		});
		btnAdminLogin.setBounds(270, 359, 143, 25);
		contentPane.add(btnAdminLogin);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Login log = new Login();
				log.frame.setVisible(true);
			}
		});
		btnBack.setBounds(537, 400, 114, 25);
		contentPane.add(btnBack);
	}
}
