/**
 * A class for an ElectronicsStore which extends a Store. You should
 * complete the following tasks:
 *
 *     - Complete the constructor
 *     - Add methods for addComputerInventory and addTabletInventory
 *     - Complete the getElectronicsInfo method
 */
public class ElectronicsStore extends Store
{
    private int computerInventory;
    private int tabletInventory;

    // Implement the constructor. It should use super to call the parent
    // constructor and initialize the inventories to 0
    public ElectronicsStore(String name, String address, String businessID)
    {
        //-----------Start below here. To do: approximate lines of code = 3
        //
        super(name, address, businessID);

        this.computerInventory = 0;
        this.tabletInventory = 0;
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    // Add methods called addComputerInventory(int amount) and
    // addTabletInventory(int amount) which increases the corresponding
    // inventory by the given amount
    //-----------Start below here. To do: approximate lines of code = 4
    //
    public void addComputerIventory(int amount)
    {
        computerInventory += amount;
        
    }    
    
    public void addTabletIventory(int amount)
    {
        tabletInventory += amount;
    }    
    
    
    
    
    
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

    // Returns a String of the following form:
    //
    // "Name: Staples, Address: 456 Bloor Street, ID: 9876, Computers: 100, Tablets: 150"
    //
    // HINT: Use the inherited getBusinessInfo() method
    public String getElectronicsStoreInfo()
    {
        //-----------Start below here. To do: approximate lines of code = 4
        //
        return getBusinessInfo() + ", Computers: " + computerInventory + ", Tablets: " + tabletInventory;
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
