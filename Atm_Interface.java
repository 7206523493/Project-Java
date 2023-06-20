

                                             // ATM Interface Project //

import java.util.Scanner;

class BankAccount {
	
	
	int Password;
	String UserId;
	
	float balance = 100000f;
	int transactions = 0;
	String transactionHistory = "";
	
	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------");
		System.out.println("Enter Your UserId - ");
		this.UserId = sc.nextLine();
		System.out.println("---------------------------");
		System.out.println("Enter Your Password - ");
		this.Password =sc.nextInt();
	}
	
	
	public void withdraw() {
		
		System.out.println("Enter amount to withdraw - ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			
			if ( balance >= amount ) {
				transactions++;
				balance -= amount;
				System.out.println("Withdraw Successfully");
				String str = amount + " Rs Withdrawed\n";
				transactionHistory = transactionHistory.concat(str);
				
			}
			else {
				System.out.println("Insufficient Balance");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void deposit() {
		
		System.out.println("Enter amount to deposit - ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		
		try {
			if ( amount <= 100000f ) {
				transactions++;
				balance += amount;
				System.out.println("\nSuccessfully Deposited");
				String str = amount + " Rs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else {
				System.out.println("\nSorry...Limit is 100000.00");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void transfer() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Receipent's Name - ");
		String receipent = sc.nextLine();
		System.out.println("Enter amount to transfer - ");
		float amount = sc.nextFloat();
		
		try {
			if ( balance >= amount ) {
				if ( amount <= 50000f ) {
					transactions++;
					balance -= amount;
					System.out.println("\nSuccessfully Transfered to " + receipent);
					String str = amount + " Rs transfered to " + receipent + "\n";
					transactionHistory = transactionHistory.concat(str);
				}
				else {
					System.out.println("\nSorry...Limit is 50000.00");
				}
			}
			else {
				System.out.println("\nInsufficient Balance");
			}
		}
		catch ( Exception e) {
		}
	}
	
	public void checkBalance() {
		System.out.println( balance + " Rs");
	}
	
	public void transHistory() {
		if ( transactions == 0 ) {
			System.out.println("Empty");
		}
		else {
			System.out.println(  transactionHistory);
		}
	}
}


public class Atm_Interface {
	
	
	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) {
					System.out.println("Choose the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Enter only integer value");
				flag = false;
			}
		};
		return input;
	}
	
	
	public static void main(String[] args) {
	
		System.out.println("\n**********WELCOME TO  ATM SYSTEM**********\n");
		System.out.println("1) Register");
		System.out.println("---------------------------");
		System.out.println("2) Exit");
		System.out.println("---------------------------");
		System.out.print("Enter Your Choice - ");
		int choice = takeIntegerInput(2);
		
		if ( choice == 1 ) {
			BankAccount b = new BankAccount();
			b.register();
			while(true) {
				System.out.println("1) Login ");
				System.out.println("2) Exit");
				System.out.print("Enter Your Choice - ");
				int ch = takeIntegerInput(2);
				if ( ch == 1 ) {
				
					
						System.out.println("**********  ATM Menu   **********");
						boolean isFinished = false;
						while (!isFinished) {
							System.out.println("---------------------------");
							System.out.println("1) Withdraw");
							System.out.println("---------------------------");
							System.out.println("2) Deposit");
							System.out.println("---------------------------");
							System.out.println("3) Tranfer");
							System.out.println("---------------------------");
							System.out.println("4) Check Balance");
							System.out.println("---------------------------");
							System.out.println("5) Transaction Hisory");
							System.out.println("---------------------------");
							System.out.println("6) Exit");
							
							System.out.println("Enter Your Choice - ");
							int c = takeIntegerInput(6);
							switch(c) {
								case 1:
								b.withdraw();
								break;
								case 2:
								b.deposit();
								break;
								case 3:
								b.transfer();
								break;
								case 4:
								b.checkBalance();
								break;
								case 5:
								b.transHistory();
								break;
								case 6:
								isFinished = true;
								break;
							}
						}
					}
				}
			
				
				}
			}
			
		
	}

