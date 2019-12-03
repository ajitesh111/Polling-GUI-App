import java.awt.EventQueue;
import java.awt.Window;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
public class Login {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		connection = SqliteConnection.dbconnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 720, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel.setBounds(259, 29, 252, 68);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(189, 135, 80, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(189, 212, 80, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.controlHighlight);
		textField.setBounds(304, 126, 139, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResultSet rst = null;
				try {
					String query = "SELECT * FROM voters where enrollment=? and password=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,passwordField.getText());
					
				    rst = pst.executeQuery();															//this will execute query
					int count = 0;
					while(rst.next()) {
						count++;
		 			}
					if(count == 1) {
						
						//JOptionPane.showMessageDialog(null,"UserName and Password is Correct");
						frame.setVisible(false);
						MainPage page = new MainPage();
						page.setVisible(true);
						rst.close();
						connection.close();
						
					}else if (count > 1) {
							JOptionPane.showMessageDialog(null,"Duplicate Username ");
					}else {
						JOptionPane.showMessageDialog(null,"Incorrect Username and Password ");
					}
					
					
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
					
				}
				
			}
		});
	
		btnLogin.setBounds(206, 301, 204, 25);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(SystemColor.controlHighlight);
		passwordField.setEchoChar('*');
		passwordField.setBounds(307, 203, 136, 33);
		frame.getContentPane().add(passwordField);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				AdminLogin log = new AdminLogin();
				log.setVisible(true);
				
			}
		});
		btnAdminLogin.setBounds(206, 388, 204, 25);
		frame.getContentPane().add(btnAdminLogin);
	}
}
