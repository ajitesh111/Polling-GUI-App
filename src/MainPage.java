import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.*;
import java.awt.Window;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MainPage extends JFrame {

	protected static final String DECLARE = null;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	/**
	 * Create the frame.
	 */
	public MainPage() {
		
		connection = SqliteConnection.dbconnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1057, 782);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToGymkhana = new JLabel("Welcome To GymKhana Election 2019-20");
		lblWelcomeToGymkhana.setFont(new Font("Dialog", Font.ITALIC, 24));
		lblWelcomeToGymkhana.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToGymkhana.setBounds(249, 25, 562, 62);
		contentPane.add(lblWelcomeToGymkhana);
		
		JLabel lblNewLabel = new JLabel("");
		Image imgg1 = new ImageIcon(this.getClass().getResource("/abhijai.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imgg1));
		lblNewLabel.setBounds(50, 162, 216, 257);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		Image imgg2 = new ImageIcon(this.getClass().getResource("/Ajju.jpg")).getImage();
		label.setIcon(new ImageIcon(imgg2));
		label.setBounds(479, 162, 174, 266);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		Image imgg3 = new ImageIcon(this.getClass().getResource("/bisal.jpg")).getImage();
		label_1.setIcon(new ImageIcon(imgg3)); 
		label_1.setBounds(787, 155, 235, 306);
		contentPane.add(label_1);
		
		JButton btnVoteForRohit = new JButton("Vote For Abhijai");
		btnVoteForRohit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "Select votecount from candidates where enrollment='LIT2018047'";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
			
					int n = rs.getInt("votecount") + 1 ;
					  
					String update = "update candidates set  votecount="+n+" where enrollment='LIT2018047' ";
					PreparedStatement pp = connection.prepareStatement(update);
					int rst = pp.executeUpdate();
					
					setVisible(false);
					Thankyou you = new Thankyou();
					you.setVisible(true);
		
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
				}
				}
		});
		btnVoteForRohit.setBounds(93, 506, 155, 25);
		contentPane.add(btnVoteForRohit);
		
		JLabel lblCandidate = new JLabel("Candidate 1");
		lblCandidate.setBounds(116, 114, 132, 15);
		contentPane.add(lblCandidate);
		
		JLabel lblCandidate_1 = new JLabel("Candidate 2");
		lblCandidate_1.setBounds(502, 114, 124, 15);
		contentPane.add(lblCandidate_1);
		
		JLabel lblCandidate_2 = new JLabel("Candidate 3");
		lblCandidate_2.setBounds(874, 114, 118, 15);
		contentPane.add(lblCandidate_2);
		
		JButton btnVoteForAjitesh = new JButton("Vote For Ajitesh");
		btnVoteForAjitesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						String query = "Select votecount from candidates where enrollment='LIT2018067'";
						PreparedStatement pst = connection.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
				
						int n = rs.getInt("votecount") + 1 ;
						 
						String update = "update candidates set  votecount="+n+" where enrollment='LIT2018067' ";
						PreparedStatement pp = connection.prepareStatement(update);
						int rst = pp.executeUpdate();
						
						setVisible(false);
						Thankyou you = new Thankyou();
						you.setVisible(true);
			
					
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null,ee);
				}
			}
			
		});
		btnVoteForAjitesh.setBounds(475, 506, 165, 25);
		contentPane.add(btnVoteForAjitesh);
		
		JButton btnVoteForUtkarsh = new JButton("Vote For Vishal");
		btnVoteForUtkarsh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent t) {
					try {
						String query = "Select votecount from candidates where enrollment='LIT2018001'";
						PreparedStatement pst = connection.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
				
						int n = rs.getInt("votecount") + 1 ;
						
						String update = "update candidates set votecount="+n+" where enrollment='LIT2018001' ";
						PreparedStatement pp = connection.prepareStatement(update);
						int rst = pp.executeUpdate();
						
						setVisible(false);
						Thankyou you = new Thankyou();
						you.setVisible(true);
			
				}catch(Exception eee) {
					JOptionPane.showMessageDialog(null,eee);
				}
			}
		});
		btnVoteForUtkarsh.setBounds(837, 506, 155, 25);
		contentPane.add(btnVoteForUtkarsh);
	}
}
