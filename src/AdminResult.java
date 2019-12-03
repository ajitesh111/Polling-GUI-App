

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class AdminResult extends JFrame {

	private JPanel contentPane;
	private int abhi,ajitesh,vishal = 0;
	Connection connection = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminResult frame = new AdminResult();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public int resultScore(String s) {
		
		try {
			String query = "Select votecount from candidates where enrollment=\""+s+"\"";
			PreparedStatement p = connection.prepareStatement(query);
			ResultSet rs = p.executeQuery();
		    int j = rs.getInt("votecount");
		    return j;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Create the frame.
	 */
	public AdminResult() {
		connection = SqliteConnection.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 956);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblR = new JLabel("Result of voting");
		lblR.setFont(new Font("Dialog", Font.BOLD, 20));
		lblR.setBounds(285, 12, 329, 52);
		contentPane.add(lblR);
		
		JLabel label = new JLabel("");
		Image imgg1 = new ImageIcon(this.getClass().getResource("/abhijai.jpg")).getImage();
		label.setIcon(new ImageIcon(imgg1));
		label.setBounds(81, 230, 257, 146);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		Image imgg2 = new ImageIcon(this.getClass().getResource("/Ajju.jpg")).getImage();
		label_1.setIcon(new ImageIcon(imgg2));
		label_1.setBounds(135, 425, 203, 146);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		Image imgg3 =  new ImageIcon(this.getClass().getResource("/bisal.jpg")).getImage();
		label_2.setIcon(new ImageIcon(imgg3));
		label_2.setBounds(91, 616, 247, 195);
		contentPane.add(label_2);
		
		int  abhi= resultScore("LIT2018047");
		//JOptionPane.showMessageDialog(null,rohit);
		JLabel lblRohit = new JLabel(String.valueOf(abhi));
		lblRohit.setFont(new Font("Dialog", Font.BOLD, 20));
		lblRohit.setBounds(476, 262, 99, 83);
		contentPane.add(lblRohit);
		
		int ajitesh= resultScore("LIT2018067");
		JLabel lblAjju = new JLabel(String.valueOf(ajitesh));
		lblAjju.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAjju.setBounds(476, 471, 99, 83);
		contentPane.add(lblAjju);
		
		int vishal = resultScore("LIT2018001");
		JLabel lblVishal = new JLabel(String.valueOf(vishal));
		lblVishal.setFont(new Font("Dialog", Font.BOLD, 20));
		lblVishal.setBounds(476, 661, 99, 83);
		contentPane.add(lblVishal);
		
		JLabel label_3 = new JLabel("");
		Image imgg= new ImageIcon(this.getClass().getResource("/chess-33-64.png")).getImage();
		label_3.setIcon(new ImageIcon(imgg)); 
		label_3.setBounds(718, 272, 64, 49);
		contentPane.add(label_3);
		label_3.setVisible(false);
		
		JLabel label_4 = new JLabel("");
		Image im2= new ImageIcon(this.getClass().getResource("/chess-33-64.png")).getImage();
		label_4.setIcon(new ImageIcon(im2)); 
		label_4.setBounds(718, 479, 64, 49);
		contentPane.add(label_4);
		label_4.setVisible(false);
		
		JLabel label_5 = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/chess-33-64.png")).getImage();
		
	
		label_5.setIcon(new ImageIcon(img)); 
		label_5.setBounds(718, 670, 64, 64);
		contentPane.add(label_5);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Login log = new Login();
				log.frame.setVisible(true);
				
			}
		});
		btnExit.setBounds(707, 833, 114, 25);
		contentPane.add(btnExit);
		label_5.setVisible(false);
		
		int maxscore = Math.max(abhi, Math.max(ajitesh, vishal));
		if(abhi == ajitesh || abhi == vishal || ajitesh == vishal){
			JOptionPane.showMessageDialog(null,"Winner Could not be decided through fair voting");
		}else if(maxscore == abhi) {
			label_3.setVisible(true);
		}else if(maxscore == ajitesh) {
			label_4.setVisible(true);
		}else if(maxscore == vishal) {
			label_5.setVisible(true);
		}
	}
}
