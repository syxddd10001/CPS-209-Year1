/**
 * Tests the StaticVariableClass
 */
public class StaticVariableTester
{
    public static void main(String[] args)
    {
        // Tests that the static variables are initialized correctly
        System.out.println("The number of objects is " + StaticVariableClass.getConstructorCounter());
        System.out.println("The method count is " + StaticVariableClass.getMethodCounter());
        System.out.println("Expected:\nThe number of objects created is 0\nThe method count is 0");

        StaticVariableClass o1 = new StaticVariableClass("first");
        StaticVariableClass o2 = new StaticVariableClass();
        StaticVariableClass o3 = new StaticVariableClass("third");

        // Tests that get name works correctly
        System.out.println("o1 name is " + o1.getName());
        System.out.println("o2 name is " + o2.getName());
        System.out.println("o3 name is " + o3.getName());
        System.out.println("Expected:\no1 name is first\no2 name is default\no3 name is third");

        // Tests that constructor counter works correctly
        System.out.println("The number of objects is " + StaticVariableClass.getConstructorCounter());
        System.out.println("Expected:\nThe number of objects is 3");

        // Tests that the method counter works correctly
        o1.myMethod();
        o2.myMethod(5);

        System.out.println("The method count is " + StaticVariableClass.getMethodCounter());
        System.out.println("Expected:\nThe method count is 6");

        o3.myMethod(23);
        o1.myMethod();
        o2.myMethod();

        System.out.println("The method count is " + StaticVariableClass.getMethodCounter());
        System.out.println("Expected:\nThe method count is 31");

    }
}
