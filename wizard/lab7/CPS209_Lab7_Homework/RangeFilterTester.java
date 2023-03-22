import java.util.ArrayList;

class RangeFilterTester
{
	public static void main( String[] args)
	{
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		accounts.add(new BankAccount(1398723,900));
		accounts.add(new BankAccount(1432561,9900));
		accounts.add(new BankAccount(1584624,52));
		accounts.add(new BankAccount(1856210,2300));
		accounts.add(new BankAccount(1745382,213));
		accounts.add(new BankAccount(1965432,603));
		accounts.add(new BankAccount(1234567,12));

		boolean [] correct = {true, false, false, false, true, true, false};

		System.out.println("--- TEST 1: Tests that inRange works as expected.");
		for(int i = 0; i < accounts.size(); i++)
		{
			System.out.println("Account: " + accounts.get(i));
			System.out.println("OUTPUT:   " + accounts.get(i).inRange(100, 1000));
			System.out.println("EXPECTED: " + correct[i] + "\n");
		}
	}
}
