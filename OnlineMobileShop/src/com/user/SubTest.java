package com.user;

import java.util.Scanner;

public class SubTest {
	
	  public void GoThroughLogin() {

	      User_LoginIML ul = new User_LoginIML();
          ul.getUserDetails();

	   WelcomeIML wc = new WelcomeIML();
	
       wc.getProductDetails();
       wc.getId();
	
           System.out.println("1. Buy Product\n");
           System.out.println("2. Exit\n");
           System.out.println(" Please Enter Your Choice");
            Scanner scanner1 = new Scanner(System.in);
           int num = scanner1.nextInt();


     switch(num) {

       case 1:

     Buy_Product_Add_CartIML bp = new  Buy_Product_Add_CartIML();
  
          bp. buyProduct();
          
          System.out.println("1. View Cart");
		    System.out.println("2. Exit");
		    Scanner scanner3=new Scanner(System.in);
		    String ans = scanner3 .nextLine();
		    
		    
		    if (ans.equals("1")) {
		    
		    View_CartIML vc = new View_CartIML();
			
			vc.	getCartDetails();
			
		    }
		    else if (ans.equals("1")) {    System.exit(0);           } 
		    
		    else { System.out.println("Wrong Chice");      }  
		    
		    BillingIML bill = new BillingIML();
		    bill.getDetails();
		    
		    
		    
		    break;

        case 2:
	 System.exit(0);

	 default:
		 System.out.println("Wrong Chice");
     }
  }

}
