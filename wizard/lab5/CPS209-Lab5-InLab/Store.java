/**
 * A class for a store. Stores have a name, address, and businessID.
 * You should complete the following tasks.
 *     - Complete the getBusinessInfo method
 */
public class Store
{
    private String name;
    private String address;
    private String businessID;

    public Store(String name, String address, String businessID)
    {
        this.name = name;
        this.address = address;
        this.businessID = businessID;
    }

    // Should return a String of the following form:
    //
    // "Name: Staples, Address: 456 Bloor Street, ID: 9876"
    public String getBusinessInfo()
    {
        //-----------Start below here. To do: approximate lines of code = 1
        //
        return ("Name: " + name + ", Address: " + address + ", ID: " + businessID);
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
