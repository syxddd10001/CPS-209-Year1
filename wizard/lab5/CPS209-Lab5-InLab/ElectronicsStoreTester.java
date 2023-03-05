/**
 * Runs tests for the ElectronicsStore class.
 */
public class ElectronicsStoreTester
{
    public static void main(String[] args)
    {
        ElectronicsStore store1 = new ElectronicsStore("Radioshack", "123 Dundas Street", "12353");
        ElectronicsStore store2 = new ElectronicsStore("Circuit City", "45 Yonge Street", "44574556");

        store1.addComputerIventory(500);
        store2.addComputerIventory(200);

        store1.addTabletIventory(230);
        store2.addTabletIventory(98);

        System.out.println(store1.getElectronicsStoreInfo());
        System.out.println("Expected:\nName: Radioshack, Address: 123 Dundas Street, ID: 12353, Computers: 500, Tablets: 230");

        System.out.println(store2.getElectronicsStoreInfo());
        System.out.println("Expected:\nName: Circuit City, Address: 45 Yonge Street, ID: 44574556, Computers: 200, Tablets: 98");
    }
}
