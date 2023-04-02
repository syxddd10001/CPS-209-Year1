/**
 * A bank account has a balance that can be changed by
 * deposits and withdrawals. This version only has a balance variable.
 * You are to complete the following:
 *
 *   - Complete the constructor
 *   - Complete deposit to throw an excpeption as needed
 *   - Complete withdraw to throw an exception as needed
 */
public class BankAccount
{
    //instance variables
    private double balance; //the money in the account

    /**
     * Initializes balance with a given parameter value aBalance.
     *
     * @param balance the initial balance
     */
    public BankAccount(double balance)
    {
        //-----------Start below here. To do: approximate lines of code = 3
        // Throw an IllegalArgumentException if the initial balance is negative
        // Set message to "initial balance is negative", otherwise initialize the
        // member variables appropriately
        if (balance < 0){
            throw new IllegalArgumentException("initial balance is negative");
        }

        else this.balance = balance;
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Deposits money into the bank account.
     *
     * @param amount the amount to deposit, which cannot be negative
     */
    public void deposit(double amount)
    {
        //-----------Start below here. To do: approximate lines of code = 3
        // Throw an IllegalArgumentException if the amount is negative
        // set the message in the exception to: "Deposit amount is negative!"
        // If an exception is not thrown, it should update the balance
        
        
        if (amount < 0) throw new IllegalArgumentException("Deposit amount is negative!");        
        
        else balance +=amount;
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Withdraws money from the bank account.
     *
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount)
    {
        //-----------Start below here. To do: approximate lines of code = 3
        // Throw an IllegalArgumentException if the amount is too much or
        // if amount is negative set the message in the exception to:
        // "withdrawal amount is negative or greater than balance!"
        // If an exception is not thrown, the balance should be updated
        
        
        if (amount < 0 || amount > balance) throw new IllegalArgumentException("withdrawal amount is negative or greater than balance!");
        
        else balance -= amount;
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    /**
     * Gets the current balance of the bank account.
     *
     * @return the current balance
     */
    public double getBalance()
    {
        return balance;
    }
}
