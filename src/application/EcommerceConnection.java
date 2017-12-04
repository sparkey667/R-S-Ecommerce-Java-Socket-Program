//Dheric Seney
//COMP1150-01
//Final Project
//6 December 2017

package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EcommerceConnection {
//you are going to need to download the sql connection driver
	public Connection Connect() {
		try{
		String url = "jdbc:mysql://localhost:3306/ecommerce";
		String user = ""; //create a username on myphpadmin and insert it here
		String password = ""; //create a password on myphpadmin and insert it here
		
		Class.forName("java.sql.Driver");
		Connection connect = DriverManager.getConnection(url,user,password);
		return connect;
		}catch(ClassNotFoundException | SQLException ex){
			Logger.getLogger(EcommerceConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}
