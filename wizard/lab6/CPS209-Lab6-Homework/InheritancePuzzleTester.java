/**
 * Tests that you have solved the inheritance puzzle correctly. You will need to look
 * at the expected output to figure out how to update the methods in B and C.
 *
 * HINT: Update the methods to handle the tests 1 at a time.
 */
public class InheritancePuzzleTester
{
    public static void main(String[] args)
    {
        C c = new C();
        B b = new B();

        System.out.println("--- TEST 1: Check that calling methodA1 from C works correctly");
        System.out.println("OUTPUT");
        c.methodA1(10);
        System.out.println("EXPECTED");
        System.out.println("methodA1 in C called with value 10\nmethodA1 in B called with value 51\n" +
                "methodA1 in A called with value 70\n");

        System.out.println("--- TEST 2: Check that calling methodA2 from C works correctly");
        System.out.println("OUTPUT");
        c.methodA2(50);
        System.out.println("EXPECTED");
        System.out.println("methodA2 in C called with value 50\nmethodA2 in A called with value 75\n");

        System.out.println("--- TEST 3: Check that calling methodA3 from C works correctly");
        System.out.println("OUTPUT");
        c.methodA3(100);
        System.out.println("EXPECTED");
        System.out.println("methodA3 in C called with value 100\nmethodA3 in B called with value 101\n");

        System.out.println("--- TEST 4: Check that calling method B1 from B works correctly");
        System.out.println("OUTPUT");
        b.methodB1(200);
        System.out.println("EXPECTED");
        System.out.println("methodB1 in B called with value 200\n");

        System.out.println("--- TEST 5: Check that calling methodB2 from B works correctly");
        System.out.println("OUTPUT");
        b.methodB2(400);
        System.out.println("EXPECTED");
        System.out.println("methodB2 in B called with value 400\nmethodB1 in B called with value 413\n" +
                "methodA1 in B called with value 472\nmethodA1 in A called with value 491\n");

        System.out.println("--- TEST 6: Check that calling methodB2 from C works correctly");
        System.out.println("OUTPUT");
        c.methodB2(1000);
        System.out.println("EXPECTED");
        System.out.println("methodB2 in C called with value 1000\nmethodB2 in B called with value 1067\n" +
                "methodB1 in B called with value 1080\nmethodA1 in C called with value 1139\n" +
                "methodA1 in B called with value 1180\nmethodA1 in A called with value 1199\n" +
                "methodA1 in C called with value 1056\nmethodA1 in B called with value 1097\n" +
                "methodA1 in A called with value 1116\n");

        System.out.println("--- TEST 7: Check that calling methodA3 from D works correctly");
        D d = new D();
        System.out.println("OUTPUT");
        d.methodA3(240);
        System.out.println("EXPECTED");
        System.out.println("methodA3 in A called with value 240\nmethodA2 in D called with value 250\n" +
                "methodA1 in A called with value 259");
    }
}
