import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class Thankyou extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	   
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thankyou frame = new Thankyou();
					frame.setVisible(true);
					
					Timer timer = new Timer();
					timer.schedule(new TimerTask(){
						@Override
						public void run() {
							frame.setVisible(false);
							Login login = new Login();
							login.frame.setVisible(true);
						}
					},5000);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Thankyou() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 549);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThankyou = new JLabel("Thankyou");
		lblThankyou.setFont(new Font("Dialog", Font.BOLD, 59));
		lblThankyou.setBounds(322, 30, 374, 122);
		contentPane.add(lblThankyou);
		
		JLabel lblYourResponseHas = new JLabel("Your Response Has Been Recorded....");
		lblYourResponseHas.setFont(new Font("Dialog", Font.BOLD, 24));
		lblYourResponseHas.setBounds(230, 137, 495, 96);
		contentPane.add(lblYourResponseHas);
		
		
		
		JTextArea txtrDgjhgsdjhas = new JTextArea();
		txtrDgjhgsdjhas.setBackground(SystemColor.text);
		txtrDgjhgsdjhas.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		txtrDgjhgsdjhas.setText("Developed by :- \n\tRohit Verma (Lit2018068) \n\tAjitesh Jaiswal (Lit2018067) \n\tAbhijay Singh Jain (Lit2018047) \n\tVishal Mishra (Lit2018001)");
		txtrDgjhgsdjhas.setBounds(87, 278, 609, 182);
		contentPane.add(txtrDgjhgsdjhas);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/home/rohit/Desktop/Aritro_Sir/election .png"));
		lblNewLabel.setBounds(658, 186, 231, 268);
		contentPane.add(lblNewLabel);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Login lo = new Login();
				lo.frame.setVisible(true);
				
			}
		});
		btnExit.setBounds(726, 448, 114, 25);
		contentPane.add(btnExit);
	}
}
