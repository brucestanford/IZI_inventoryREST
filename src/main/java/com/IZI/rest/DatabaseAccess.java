package com.IZI.rest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DatabaseAccess {
	
    public static Connection connection = null;
    public static Statement statement = null;


	public static int logNumber =0;


	public static void log(String content) {
		

		try {
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("log.txt", true)));
		    out.println(logNumber+content);
		    out.close();
		} catch (IOException e) {
		   e.printStackTrace();
		}
		logNumber++;

	}

	public static void closeDatabase() {
		
	    try {

		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      if (statement != null) {
		        try {
		          statement.close();
		        } catch (SQLException e) {
		        } 
		      }
		      if (connection != null) {
		        try {
		          connection.close();
		        } catch (SQLException e) {
		        } 
		      }
		    }
	}
	public static int executeSQLstatement(String SQLstatement) {


	      try {
			statement.executeUpdate(SQLstatement);
			return 1;
		} catch (SQLException e) {

		}
		return 0;
		
	}
	public static void accessDatabase() {
		
		if(connection == null) {
		    try {
			      Class.forName("org.gjt.mm.mysql.Driver").newInstance();

			      String url = "jdbc:mysql://localhost:3306/inventory";
			      connection = DriverManager.getConnection(url, "root", "root");

			      statement = connection.createStatement();

			    } catch (Exception e) {
			    	// Write an exception 
			    }			
		}



	}

	




}

