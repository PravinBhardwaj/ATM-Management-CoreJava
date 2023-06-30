package ATM_Manage;

import java.util.Scanner;

public class ATM_Management_System {
public static void main(String[] args) {
		
		displaymenu();
	}
	private static void displaymenu() {
		
		int savingAccountopeningBal=10000;
		int currentAccountopeningBal=20000;
		int savingAccountpinnum=1234;
		int currentAccountpinnum=5678;
		
	
		System.out.println("Welcome To ATM Management System");
		System.out.println("Please Select Account Type");
		System.out.println("Select 1 Saving Account");
		System.out.println("Select 2 Current Account");
		Scanner sc = new Scanner(System.in);
		String accountType = sc.nextLine();
		
		if(accountType.equals("1")) {
			ATMoperations(savingAccountopeningBal,savingAccountpinnum,accountType);
		}else if(accountType.equals("2")){
			ATMoperations(currentAccountopeningBal,currentAccountpinnum,accountType);
		}else {
			System.out.println("Please Enter Pin ");
		}
	}
	
private static void ATMoperations(int currentAccountopeningBal, int currentAccountpinnum, String accountType) {
		
		
		int choice;
	do{
		System.out.println("Choose 1 Withdraw ");
		System.out.println("Choose 2 Deposit ");
		System.out.println("Choose 3 Check Balance ");
		System.out.println("Choose 4 Change Pin ");
		System.out.println("Choose 5 Exit ");
		Scanner sc2 = new Scanner(System.in);
		choice = sc2.nextInt();
		System.out.println("Please Enter Your Pin Number");
		int pincode=sc2.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter money to be withdrawn:");
			int withdraw = sc2.nextInt(); 
			if (accountType.equalsIgnoreCase("current") && pincode == currentAccountpinnum) {
				if(currentAccountopeningBal>=withdraw && currentAccountopeningBal-withdraw>=3000) {
					currentAccountopeningBal=currentAccountopeningBal-withdraw;
					System.out.println("Balance"+" "+currentAccountopeningBal);
				}else {
					System.out.println("minimum acc balance not maintained or invalid amount");
				}
				}else if(currentAccountopeningBal>=withdraw && pincode == currentAccountpinnum) {
					
						currentAccountopeningBal=currentAccountopeningBal-withdraw;
						System.out.println("Balance"+" "+currentAccountopeningBal);
					
						
					}else{  
	           
	            System.out.println("Insufficient Balance or Incorrect Pin");  
	        }  
	        System.out.println("");  
	        break;  
	        
		case 2:
			System.out.println("Enter money to be Deposit:");
			int Deposit = sc2.nextInt(); 
			if (currentAccountopeningBal>=Deposit && pincode == currentAccountpinnum) {
				currentAccountopeningBal=currentAccountopeningBal+Deposit;
				System.out.println("Balance"+" "+currentAccountopeningBal);  
			}   else  
	        {  
	           
	            System.out.println("Insufficient Balance");  
	        }  
	        System.out.println("");  
	        break;  
	        
		case 3:
			System.out.println("Balance:"+" "+currentAccountopeningBal );
			  
	        break; 
		case 4:
			System.out.println("Please Enter new pin here..");
			Scanner sc3=new Scanner(System.in);
			int pinchange = sc3.nextInt();
			currentAccountpinnum = pinchange;
			break;
		case 5:
			System.exit(0);
			
		}
		
	}while(choice !=5);


}}
