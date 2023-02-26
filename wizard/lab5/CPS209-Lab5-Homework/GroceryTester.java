public class GroceryTester
{
    public static void main(String[] args)
    {
        GroceryStore store1 = new GroceryStore("MLG Loblaws", 40, 150, 75);
        GroceryStore store2 = new GroceryStore("Dundas Square Loblaws", 30, 100, 50);
        GroceryStore store3 = new GroceryStore("West End Loblaws", 50, 80, 60);

        // Tests get inventory method
        System.out.println("The inventory of tomato at MLG Loblaws is " + store1.getInventory(GroceryStore.GroceryItem.TOMATO));
        System.out.println("Expected:\nThe inventory of tomato at MLG Loblaws is 150");

        System.out.println("The inventory of lettuce at Dundas Square Loblaws is " + store2.getInventory(GroceryStore.GroceryItem.LETTUCE));
        System.out.println("Expected:\nThe inventory of lettuce at Dundas Square Loblaws is 30");

        System.out.println("The inventory of cucumber at West End Loblaws is " + store3.getInventory(GroceryStore.GroceryItem.CUCUMBER));
        System.out.println("Expected:\nThe inventory of cucumber at West End Loblaws is 60");

        // Tests the add inventory method
        store1.addInventory(GroceryStore.GroceryItem.TOMATO, 10);
        System.out.println("The inventory of tomato at MLG Loblaws is " + store1.getInventory(GroceryStore.GroceryItem.TOMATO));
        System.out.println("Expected:\nThe inventory of tomato at MLG Loblaws is 160");

        store3.addInventory(GroceryStore.GroceryItem.CUCUMBER, 10);
        System.out.println("The inventory of cucumber at West End Loblaws is " + store3.getInventory(GroceryStore.GroceryItem.CUCUMBER));
        System.out.println("Expected:\nThe inventory of cucumber at West End Loblaws is 70");

        // Creates stores
        GroceryChain loblaws = new GroceryChain("loblaws");
        loblaws.addGroceryStore(store1);
        loblaws.addGroceryStore(store2);
        loblaws.addGroceryStore(store3);

        // Tests the getTotalInventory method
        System.out.println("The total inventory of lettuce is " + loblaws.getTotalInventory(GroceryStore.GroceryItem.LETTUCE));
        System.out.println("Expected:\nThe total inventory of lettuce is 120");

        System.out.println("The total inventory of tomato is " + loblaws.getTotalInventory(GroceryStore.GroceryItem.TOMATO));
        System.out.println("Expected:\nThe total inventory of tomato is 340");

        System.out.println("The total inventory of cucumber is " + loblaws.getTotalInventory(GroceryStore.GroceryItem.CUCUMBER));
        System.out.println("Expected:\nThe total inventory of cucumber is 195");

        store1.addInventory(GroceryStore.GroceryItem.LETTUCE, 5);
        store2.addInventory(GroceryStore.GroceryItem.TOMATO, 10);
        store3.addInventory(GroceryStore.GroceryItem.CUCUMBER, 15);

        System.out.println("The total inventory of lettuce is " + loblaws.getTotalInventory(GroceryStore.GroceryItem.LETTUCE));
        System.out.println("Expected:\nThe total inventory of lettuce is 125");

        System.out.println("The total inventory of tomato is " + loblaws.getTotalInventory(GroceryStore.GroceryItem.TOMATO));
        System.out.println("Expected:\nThe total inventory of tomato is 350");

        System.out.println("The total inventory of cucumber is " + loblaws.getTotalInventory(GroceryStore.GroceryItem.CUCUMBER));
        System.out.println("Expected:\nThe total inventory of cucumber is 210");
    }
}
