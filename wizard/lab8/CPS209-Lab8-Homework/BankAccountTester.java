/**
   Practicing with throwing exceptions.  In this exercise you throw an 
   exception in the BankAccount class if 
   1) the constructor receives an initial balance that is negative, or 
   2) the deposit method receives a negative amount, or 
   3) the withdraw method receives a negative amount 
 */
public class BankAccountTester
{
	public static BankAccount constructorTest(double initBalance) {
		BankAccount b = null;

		try {
			b = new BankAccount(initBalance);
		} catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		return b;
	}
	public static void main(String[] args)
	{
		String [] testDescription = {
				"Initialize with 1000", "Deposit 0", "Initialize with -500", "Withdraw 300",
				"Withdraw -300", "Deposit 300", "Deposit -300", "Withdraw 2000"
		} ;
		String[] expect = {
				"Balance is 1000.0",
				"Balance is 1000.0",
				"IllegalArgumentException was caught, Balance is 1000.0",
				"Balance is 700.0",
				"IllegalArgumentException was caught, Balance is 700.0",
				"Balance is 1000.0",
				"IllegalArgumentException was caught, Balance is 1000.0",
				"IllegalArgumentException was caught, Balance is 1000.0"
		} ;
		BankAccount account = new BankAccount(1000) ;
		for (int i = 0 ; i < testDescription.length ; i++ ) {
			System.out.println("\n--- TEST " + i + ": " + testDescription[i]) ;
			System.out.print("OUTPUT:   ");
			try {

				switch (i)  {
					case 0 : account = new BankAccount(1000) ; break;
					case 1 : account.deposit(0) ; break ;
					case 2 : account = new BankAccount(-500) ; break ;
					case 3 : account.withdraw(300) ; break ;
					case 4 : account.withdraw(-300) ; break ;
					case 5 : account.deposit(300) ; break ;
					case 6 : account.deposit(-300) ; break ;
					case 7 : account.withdraw(2000) ; break ;
				}

				System.out.println("Balance is " + account.getBalance()) ;
			}
			catch (IllegalArgumentException e) {
				System.out.print("IllegalArgumentException was caught, ") ;
				System.out.println("Balance is " + account.getBalance()) ;
			}
			System.out.println("EXPECTED: " + expect[i]);
		}
	}
}



