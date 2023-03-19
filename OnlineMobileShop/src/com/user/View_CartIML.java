package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.Interfaces.View_Cart;

public class View_CartIML implements View_Cart {

	

	@Override
	public void getCartDetails() {
Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please Enter Id ");
		int Id = scanner.nextInt();
		
		System.out.println("Please Enter Username ");
		String username = scanner.next();
		
		System.out.println("Please Enter Id to verify ");
		int Id1 = scanner.nextInt();
		
		System.out.println("Please Enter Product Id ");
		int ProductId = scanner.nextInt();
		
		
		 viewCart( Id, username,Id1,ProductId);
		
	}
//-------------------------------------------------------------------------------------------------------------

	@Override
	public void viewCart(int Id, String username, int Id1, int ProductId) {
		try {
			Connection connection = CommonConnection.getConnection();
		
		PreparedStatement ps = connection.prepareStatement("select ct.OrderNo,ur.Id,ur.FirstName,ur.LastName,ct.ProductId,pd.Discription,pd.Name,pd.Price,ur.UserName from products pd  join cart ct  on pd.ProductId=ct.ProductId join user_register ur on ur.Id=ct.Id where ur.Id=? and ur.UserName=?");  
				
		
		ps.setInt(1, Id);
		ps.setString(2, username);
		
		ResultSet rs =ps.executeQuery();
		
		
		if (rs.next() && Id==Id1)  {
		
			System.out.println("Product- "+rs.getString(7));
			System.out.println(rs.getString(6));
		    System.out.println("Price Rs- " +rs.getInt(8)+"\n");
		  
		 
		
		}
		
		else {   System.out.println("Id not Match");                }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		
		}  
//-------------------------------------------------------------------------------------------------------------------------	
try {
			
			Connection connection = CommonConnection.getConnection();
		
		PreparedStatement ps = connection.prepareStatement("select Quantity  from cart where id = ? and ProductId=? ");
		
		ps.setInt(1, Id1);
		ps.setInt(2, ProductId);
		
		ResultSet rs1 = ps.executeQuery();
		while(rs1.next()) {
			
			
			
			System.out.println(" Quantity -"+rs1.getInt(1));
			
		
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		
	}

}
//--------------------------------------------------------------------------------------------------------------------

