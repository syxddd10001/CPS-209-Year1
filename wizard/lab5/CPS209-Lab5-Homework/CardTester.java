/**
 * Tests the card class. Complete the two getCardInfo methods, one that returns
 * a String representation of a CreditCard and one that returns a String
 * representation of a Driver's License.
 */
public class CardTester
{
    // For a given credit card, returns a string of the form
    //
    // "Name: Tom Jones, ID: 123, Expiry: 2025, Balance: 5000"
    public static String getCardInfo(CreditCard card) {
        //-----------Start below here. To do: approximate lines of code = 2
        //
        
        return ("Name: " + card.getName() + ", ID: " + card.getID() + ", Expiry: " + card.getExpiryYear() +  ", Balance: "+ card.getBalance());
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    // For a given driver's license, returns a string of the form
    //
    // "Name: Tom Jones, ID: 123, Expiry: 2025, Type: G"
    //
    // HINT: Remember to handle the different license types with different strings
    public static String getCardInfo(DriversLicense card) {
        //-----------Start below here. To do: approximate lines of code = 9
        //
        
        return ("Name: " + card.getName() + ", ID: " + card.getID() + ", Expiry: " + card.getExpiryYear() +  ", Type: "+ card.getLicenseType());
        
        
  
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    public static void main(String[] args)
    {
        CreditCard credit = new CreditCard("Bob Turner", "1023431", 2023, 15000.0);
        DriversLicense license = new DriversLicense("Tim Jones", "V54 98H 763", 2024, DriversLicense.LicenseType.G1);

        // Test constructor and getCardInfo methods
        System.out.println(getCardInfo(credit));
        System.out.println("Expected:\nName: Bob Turner, ID: 1023431, Expiry: 2023, Balance: 15000.0");

        System.out.println(getCardInfo(license));
        System.out.println("Expected:\nName: Tim Jones, ID: V54 98H 763, Expiry: 2024, Type: G1");

        // Test updateLicenseType
        license.updateLicenseType(DriversLicense.LicenseType.G2);
        System.out.println(getCardInfo(license));
        System.out.println("Expected:\nName: Tim Jones, ID: V54 98H 763, Expiry: 2024, Type: G2");

        // Test purchase
        credit.purchase(10000);
        System.out.println(getCardInfo(credit));
        System.out.println("Expected:\nName: Bob Turner, ID: 1023431, Expiry: 2023, Balance: 5000.0");

        // Test purchase overdraft
        credit.purchase(10000);
        System.out.println("Expected:\nInsufficient funds remaining");
        System.out.println(getCardInfo(credit));
        System.out.println("Expected:\nName: Bob Turner, ID: 1023431, Expiry: 2023, Balance: 5000.0");

        // Test pay off balance
        credit.payOffBalance();
        System.out.println(getCardInfo(credit));
        System.out.println("Expected:\nName: Bob Turner, ID: 1023431, Expiry: 2023, Balance: 15000.0");
    }
}
