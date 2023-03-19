package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.Interfaces.Buy_Product;

public class Buy_Product_Add_CartIML implements Buy_Product {

	@Override
	public void buyProduct() {
		 Scanner scanner = new Scanner(System.in);
		  
			System.out.println(" User Verification To Buy Product");
			 
			 
			 System.out.println("Enter PassWord ") ;
	   	    String PassWord = scanner.nextLine();
	   	    
	   	   System.out.println("Enter Your Id1") ;
		    int Id1 = scanner.nextInt();
	  
			System.out.println("Enter Product Id to Buy ") ;
	  	    int ProductId= scanner.nextInt();
	  	  
	  	      System.out.println("Enter Your Id To Verify") ;
		    int Id = scanner.nextInt();
		    

	  	      System.out.println("Enter Your Quantity") ;
		    int Quantity = scanner.nextInt();
		    
		    checkUser( Id1,PassWord,ProductId,Id,Quantity);
		
	}

	@Override
	public void checkUser(int Id1, String PassWord, int ProductId, int Id, int Quantity) {
		ResultSet resultset = null;
		  try {
				Connection connection=CommonConnection.getConnection();
			    
	  	PreparedStatement ps = connection.prepareStatement("select * from user_register where Id=? and PassWord=?");
			
			
			ps.setInt(1, Id1);
			ps.setString(2, PassWord);
			
			resultset = ps.executeQuery();
			
			
			
			if(resultset.next()) {
				
	             System.out.println(" User Identified ");
				
				System.out.println(resultset.getString(2)+" "+resultset.getString(3));
				
			}
			
			else {
				
				System.out.println("  Sorry Wrong Id or PassWord \n ");
				System.out.println("  Please Try Again ");
			     
			}
			
			
			} 
		  
		  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	
		 try {
			  {
			
		 Connection connection=CommonConnection.getConnection();
			    
		  String sql2 = "insert into Cart (ProductId,Id,Quantity) values (?,?,?)";
				
				PreparedStatement ps2 = connection.prepareStatement(sql2);
			    
				ps2.setInt(1, ProductId);
		     	ps2.setInt(2, Id); 
		       ps2.setInt(3, Quantity);
	     	
		       
		       if(Id1==Id    && PassWord.equals(resultset.getString(6))) 
	     			 
	     			 { ps2.execute(); 
	       
	       System.out.println("Added to cart Successfully");
			
	     	 }
			
			 
	     	 
	     	 else {    System.out.println(" Sorry !!Wrong Id , Please Enter Your Id Correctly");}
		 
			 }
		
		
		 
			
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
		 
		 
	
	
	
	}
	
	
	
	
	
	
}

	