/**
 * Tests that Employee has been implemented correctly
 */
public class EmployeeTester
{
    public static void main(String[] args)
    {
        System.out.println("--- TEST 1: Check that constructor works with valid input");
        Employee emp1 = new Employee("Tim", 17.00);
        System.out.println("OUTPUT:   " + emp1);
        System.out.println("EXPECTED: (Name: Tim, Rate: 17.0, Hours: 0.0)");

        System.out.println("\n--- TEST 2: Check that exception is thrown for bad hours");
        System.out.print("OUTPUT:   ");
        try {
            Employee emp2 = new Employee("Rick", 14.00);
            System.out.println();  // Should never get here
        } catch(IllegalArgumentException e)
        {
            System.out.println("Exception caught - " + e.getMessage());
        }
        System.out.println("EXPECTED: Exception caught - Hourly rate below minimum wage");

        System.out.println("\n--- TEST 3: Check that add hours works in valid case");
        emp1.addHours(20.0);

        System.out.println("OUTPUT:   " + emp1.getHours());
        System.out.println("EXPECTED: 20.0");

        System.out.println("\n--- TEST 4: Check that exception is thrown for negative hours");
        System.out.print("OUTPUT:   ");
        try {
            emp1.addHours(-5.0);
            System.out.println(); // Should never get here
        } catch(IllegalArgumentException e)
        {
            System.out.println("Exception caught - " + e.getMessage());
        }

        System.out.println("EXPECTED: Exception caught - Hours cannot be less than 0");

        System.out.println("\ncheck that hours hasn't changed");
        System.out.println("OUTPUT:   " + emp1.getHours());
        System.out.println("EXPECTED: 20.0");
    }
}
