/**
 * A class for a credit card which extends Card. Complete the following tasks
 *
 *     - The constructor
 *     - Complete the purchase method to remove the given amount
 *     - Complete the payOffBalance method to reset the balance
 *     - Complete the balance accessor method
 */
public class CreditCard extends Card
{
    private double limit;
    private double balance;

    // Complete the constructor to call the parent constructor using super and
    // set the limit and balance
    // The balance should be initialized to the limit
    public CreditCard(String name, String id, int expiryYear, double limit)
    {
        //-----------Start below here. To do: approximate lines of code = 3
        //
        super(name, id, expiryYear);
        this.limit = limit;
        balance = limit;
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    // Decrease the given amount from the balance. If the amount exceeds the balance,
    // the balance should not be changed and "Insufficient funds remaining" should
    // be printed.
    public void purchase(double amount)
    {
        //-----------Start below here. To do: approximate lines of code = 4
        //
        if (amount > balance) 
        {
            System.out.println("Insufficient funds remaining");
            return;
        }
        
        balance -= amount; 
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    // Rest the balance to the credit card limit
    public void payOffBalance()
    {
        //-----------Start below here. To do: approximate lines of code = 1
        //
        balance = limit;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    // Gets the current balance
    public double getBalance()
    {
        //-----------Start below here. To do: approximate lines of code = 1
        //
        return balance;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
