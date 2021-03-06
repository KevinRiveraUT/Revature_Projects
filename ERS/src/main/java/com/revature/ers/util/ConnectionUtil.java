package com.revature.ers.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class ConnectionUtil {
	final static Logger log = Logger.getLogger(ConnectionUtil.class); 
	private ConnectionUtil() {}
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			log.warn("Exception thrown adding oracle driver.",e);
		}
	}

	public static Connection getConnection() {
		InputStream in = null;
		try {
			Properties props = new Properties();
			//in = new FileInputStream("/var/lib/jenkins/workspace/ERS/ERS/src/main/resources/db.properties");
			//props.load(in);
			return DriverManager.getConnection("jdbc:oracle:thin:@jta1804.cj5ag5bbxgrs.us-east-2.rds.amazonaws.com:1521:orcl", "ERS", "ERS1");
			
		} catch (SQLException e){
			log.error(e.getMessage());
			log.error("SQL State: " + e.getSQLState());
			log.error("Error Code: " + e.getErrorCode());
		} catch (Exception e){
			e.printStackTrace();
		} 
		// catch (IOException e){
		// 	e.printStackTrace();
		// } finally {
		// 	try {
		// 		in.close();
		// 	} catch (IOException e) {
		// 		e.printStackTrace();
		// 	}
		// }
		
		return null;
	}

	public static void main(String[] args) {
		System.out.println(ConnectionUtil.getConnection());
	}
}