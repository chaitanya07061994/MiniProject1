package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.Interfaces.Billing;

public class BillingIML implements Billing {

	@Override
	public void getDetails() {
		System.out.println("Please Enter Your Id to get Bill");
		Scanner scanner = new Scanner(System.in);
		int Id = scanner.nextInt();
		
		getBill(Id);
		
	}

	@Override
	public void getBill(int Id) {
		try {
			Connection connection = CommonConnection.getConnection();
		
		PreparedStatement ps = connection.prepareStatement("select pd.Price,ct.Quantity from products pd join cart ct on pd.ProductId=ct.ProductId where Id=?");  
				
		
		ps.setInt(1, Id);
	
		ResultSet rs =ps.executeQuery();
		
		while(rs.next()) {
			
			System.out.println("Price Of Product Rs  "+ rs.getInt(1));
			System.out.println("Quantity -"+ rs.getInt(2));
		
			System.out.println("Billing Amount Is   "+ rs.getInt(1)*rs.getInt(2));
			
		
		}
		
			
	} catch (SQLException e) {
			
		
		// TODO Auto-generated catch block
			e.printStackTrace();
	
		
		}  
	
		
	}

}
