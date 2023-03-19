package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.Interfaces.Welcome;

public class WelcomeIML implements Welcome {

	@Override
	public void getProductDetails() {
		System.out.println(" Welcome to Online Mobile Shoping\n ");
		 
		  System.out.println(" 1. Samsung Galaxy A23 5G");
		  System.out.println(" 2. One Plus Nord 2T 5G");
		  System.out.println(" 3. Redmi K50i 5G");
		  System.out.println(" 4. Vivo Y100 5G");
		  System.out.println(" 5. Xiami 11 Lite NE 5G");
		  System.out.println(" 6. Oppo Reno 7 5G");
		  System.out.println(" 7. Samsung Galaxy S22 5G");
		  System.out.println(" 8. One Plus Nord CE 2 Lite 5G");
		  System.out.println(" 9. Redmi Note 11 Pro 5G");
		  System.out.println(" 10. Vivo V23 5G\n");
		
		
	}

	@Override
	public void getId() {
		
		for (int i=1;i<=3;i++) {
		System.out.println(" Please Enter Your Choice ");
   	  Scanner scanner = new Scanner(System.in);
   	  int id = scanner.nextInt();
    
   	  ShopingMobile(id);
		}
	}

	@Override
	public void ShopingMobile(int Id) {
    	
    	try {
			Connection connection = CommonConnection.getConnection();
		
			PreparedStatement ps = connection.prepareStatement("select * from products where ProductId=?");
    	    
			ps.setInt(1, Id);
		  
			ResultSet resultset = ps.executeQuery();
    	   
			if(resultset.next()) {
    	    	
    	    	System.out.println("ProductId-- "+resultset.getInt(1));
    	    	System.out.println("Description-- "+resultset.getString(2));
    	    	System.out.println("Name-- "+resultset.getString(3));
    	    	System.out.println("Price-- "+resultset.getInt(4));
    	    	System.out.println("Quantity-- "+resultset.getInt(5)+"\n");
    	    }
    	
			else {  System.out.println(" Sorry !!! Wrong Product Id") ;   }
			
			
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }

}
