package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.Interfaces.User_Resistration;

public class User_RegistrationIML implements User_Resistration  {

	@Override
	public void getUserDetails() {
		Scanner scanner = new Scanner(System.in);
  	  
 	   System.out.println("Enter First Name") ;
 	  String FirstName = scanner.nextLine();
 	  
 	  System.out.println("Enter Last Name") ;
 	  String LastName = scanner.nextLine();
 	  
 	  System.out.println("Enter EmailId ") ;
 	  String EmailId = scanner.nextLine();
 	   
 	  System.out.println("Enter UserName ") ;
 	  String UserName = scanner.nextLine();
       
 	  System.out.println("Set PassWord ") ;
 	  String PassWord = scanner.nextLine();
 	  
 	  System.out.println("Enter Country") ;
 	  String Country = scanner.nextLine();
    
   getUserInformation(FirstName,LastName,EmailId, UserName, PassWord,Country);
    
    }
		
	
   @Override
	public void getUserInformation(String FirstName, String LastName, String EmailId, String UserName, String PassWord,
			String Country) {
	
	   {
	    	

			try {
				Connection connection=CommonConnection.getConnection();
			    
	     	PreparedStatement ps = connection.prepareStatement("insert into user_register(FirstName,LastName,EmailId,UserName,PassWord,Country) values(?,?,?,?,?,?)");
			
			ps.setString(1, FirstName);
			ps.setString(2, LastName);
			ps.setString(3, EmailId);
			ps.setString(4, UserName);
			ps.setString(5, PassWord);
			ps.setString(6, Country);
			
			ps.execute();
			
			System.out.println("User Registration Successfull\n");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	    }

	
	
	
	
	}


}
