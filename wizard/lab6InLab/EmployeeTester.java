
/**
   Tests the Employee, Manager, and Executive classes
*/
public class EmployeeTester
{
   public static void main(String[] args)
   {
      System.out.println("--- TEST 1: Check employee toString");
      Employee e1 = new Employee("Jeff", 30000);
      System.out.println("RESULT:   " + e1);
      System.out.println("EXPECTED: Employee Name: Jeff Salary: 30000.0");

      System.out.println("\n\n--- TEST 2: Check manager toString");
      Employee e2 = new Manager("Larry", 80000, "Sales");
      System.out.println("RESULT:   " + e2);
      System.out.println("EXPECTED: Manager Name: Larry Salary: 80000.0 Department: Sales");

      System.out.println("\n\n--- TEST 3: Check executive toString");
      Employee e3 = new Executive("Jayne", 800000, "Regional VP",20000);
      System.out.println("RESULT:   " + e3);
      System.out.println("EXPECTED: Executive Name: Jayne Salary: 800000.0 Department: Regional VP Bonus: 20000");
   }
}
