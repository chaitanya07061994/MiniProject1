package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.Interfaces.User_Login;

public class User_LoginIML implements User_Login {

	@Override
	public void getUserDetails() {
		 Scanner scanner = new Scanner(System.in);
	 	  
	 	   System.out.println("Enter UserName ") ;
	 	  String UserName = scanner.nextLine();
	       
	 	  System.out.println("Enter PassWord ") ;
	 	  String PassWord = scanner.nextLine();
	 	  
	 	 UserLogin( UserName, PassWord);
		
	}

	public void UserLogin(String UserName,String PassWord) {

		try {
			Connection connection=CommonConnection.getConnection();
		    
  	PreparedStatement ps = connection.prepareStatement("select * from user_register where UserName=? and PassWord=?");
		
		
		ps.setString(1, UserName);
		ps.setString(2, PassWord);
		
		ResultSet resultset = ps.executeQuery();
		
		
		
		if(resultset.next()) {
			
             System.out.println(" Login Sussessfull\n ");
			
			System.out.println(" Welcome  "+ resultset.getString(2)+" "+resultset.getString(3)+ "\n"+" Your ID Is - "+resultset.getString(1));
			
		}
		
		else {
			
			System.out.println("  Sorry Wrong User Name or PassWord \n ");
			System.out.println("  Please Try Again ");
		     System.exit(0);
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	
		
	}

}
