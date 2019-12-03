import java.sql.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

import javax.swing.JOptionPane;

public class SqliteConnection { 

	Connection con = null;
	
	public static Connection dbconnector() {
		try {
			//defining class for connection 
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:/home/rohit/rough/voting");
		//	JOptionPane.showMessageDialog(null,"Connection is succesfull");
			return con;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
}
