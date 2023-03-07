/**
 * Tests the different components of an ElectronicsStore
 */
public class ElectronicsStoreTester
{

    public static void main(String[] args)
    {
        TV tv1 = new TV("LG Smart TV", TV.Type.LED, 45.0);
        tv1.addStock(50);
        TV tv2 = new TV("LG Smart TV", TV.Type.LED, 45.0);
        tv2.addStock(100);
        TV tv3 = new TV("Sony Bravia", TV.Type.OLED, 55.0);
        tv3.addStock(75);

        Computer c1 = new Computer("Macbook Pro", 13, 16, 256);
        c1.addStock(25);
        Computer c2 = new Computer("Macbook Pro", 13, 16, 128);
        c2.addStock(35);
        Computer c3 = new Computer("Macbook Pro", 13, 16, 256);
        c3.addStock(67);

        System.out.println("--- TEST 1: Test that toString works correctly");
        System.out.println("OUTPUT:   " + tv1);
        System.out.println("EXPECTED: Model: LG Smart TV, Stock: 50, Type: LED, Screen Size: 45.0");
        System.out.println("OUTPUT:   " + c1);
        System.out.println("EXPECTED: Model: Macbook Pro, Stock: 25, Screen Size: 13.0, RAM: 16.0, hdSpace: 256.0");

        System.out.println("\n\n--- TEST 2: Check equals");
        System.out.println("tv1 equals tv2?");
        System.out.println("OUTPUT:   " + tv1.equals(tv2));
        System.out.println("EXPECTED: true");

        System.out.println("\ntv1 equals tv3?");
        System.out.println("OUTPUT:   " + tv1.equals(tv3));
        System.out.println("EXPECTED: false");

        System.out.println("\nc1 equals c2?");
        System.out.println("OUTPUT:   " + c1.equals(c2));
        System.out.println("EXPECTED: false");

        System.out.println("\nc1 equals c3?");
        System.out.println("OUTPUT:   " + c1.equals(c3));
        System.out.println("EXPECTED: true");

        System.out.println("\n\n--- TEST 3: Check Store Initialization");
        ElectronicsStore store = new ElectronicsStore();
        System.out.println("OUTPUT:   " + store.getNumberComputers());
        System.out.println("EXPECTED: " + 0);
        System.out.println("\nOUTPUT:   " + store.getNumberOfTVs());
        System.out.println("EXPECTED: " + 0);

        // add products
        store.addTVStock(tv1);
        store.addTVStock(tv2);
        store.addTVStock(tv3);

        store.addComputerStock(c1);
        store.addComputerStock(c2);
        store.addComputerStock(c3);

        System.out.println("\n\n--- TEST 4: Test addTVStock");

        System.out.println("check right number of stored tvs");
        System.out.println("OUTPUT:   " + store.getNumberOfTVs());
        System.out.println("EXPECTED: 2");

        System.out.println("\ncheck right values for TVs");
        System.out.println("OUTPUT:   " + store.getTV(0));
        System.out.println("EXPECTED: Model: LG Smart TV, Stock: 150, Type: LED, Screen Size: 45.0");
        System.out.println("OUTPUT:   " + store.getTV(1));
        System.out.println("EXPECTED: Model: Sony Bravia, Stock: 75, Type: OLED, Screen Size: 55.0");

        System.out.println("\ncheck tv1 copied and not stored");
        System.out.println("OUTPUT:   " + tv1);
        System.out.println("EXPECTED: Model: LG Smart TV, Stock: 25, Type: LED, Screen Size: 45.0");

        System.out.println("\n\n--- TEST 5: Test addTVStock");

        System.out.println("check right number of stored computers");
        System.out.println("OUTPUT:   " + store.getNumberComputers());
        System.out.println("EXPECTED: 2");

        System.out.println("\ncheck right values for Computers");
        System.out.println("OUTPUT:   " + store.getComputer(0));
        System.out.println("EXPECTED: Model: Macbook Pro, Stock: 92, Screen Size: 13.0, RAM: 16.0, hdSpace: 256.0");
        System.out.println("OUTPUT:   " + store.getComputer(1));
        System.out.println("EXPECTED: Model: Macbook Pro, Stock: 35, Screen Size: 13.0, RAM: 16.0, hdSpace: 128.0");

        System.out.println("\ncheck tv1 copied and not stored");
        System.out.println("OUTPUT:   " + c1);
        System.out.println("EXPECTED: Model: Macbook Pro, Stock: 25, Screen Size: 13.0, RAM: 16.0, hdSpace: 256.0");
    }
}
