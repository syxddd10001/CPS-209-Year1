/**
 * The following finds corrupt data in a given input string. You
 * are to complete the printCorruptDataValues method
 */

import java.util.Scanner;

public class FindCorruptData
{
    /**
     * Reads a set of floating-point values from a string. The first number
     * is an integer that indicates how many floating point numbers follow.
     * Some of the floating point numbers may be corrupt. This program uses
     * exceptions to find the number of bad floating (i.e. double) numbers
     * and prints them.
     */
    public static void printCorruptDataValues(String input)
    {
        Scanner scan = new Scanner(input);
        int numDoubles = scan.nextInt();

        //-----------Start below here. To do: approximate lines of code = 5
        // Use a for loop to loop through numDoubles double number strings.
        // Get the next double number string using the scanner then use
        // Double.parseDouble() to determine if the current double number string
        // is corrupt in some way. If it is, print "Corrupt Double Number: "
        // followed by the number string.
        // Hint: use try{..} catch{..} such that you catch any NumberFormatException
        // and print out the bad double number making use of the getMessage() method
        // of the exception class to print the corrupt number string.
        // You can assume that the first value, numDoubles, is the correct number of
        // doubles in the input string
        
        for (int i = 0; i<numDoubles; i++)
        {
            try{
                Double.parseDouble(scan.next());
            }
            catch(NumberFormatException e)
            {
                System.out.println("Corrupt Double Number: " + e.getLocalizedMessage());
            }
            
        }

        System.out.println();
        
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public static void main(String[] args)
    {
        System.out.println("--- TEST 1: Checking with correct values");
        String numbers = "6 3.14 7.25 8.23 6.99 9.2 6.34";
        System.out.println("OUTPUT:");
        printCorruptDataValues(numbers);
        System.out.println("EXPECTED:");

        System.out.println("\n--- TEST 2: Output corrupt data values");
        numbers = "6 3.14 7.25 8,23 6.99 9.2w 6.34";
        System.out.println("OUTPUT:");
        printCorruptDataValues(numbers);
        System.out.println("EXPECTED:");
        System.out.println("Corrupt Double Number: For input string: \"8,23\"");
        System.out.println("Corrupt Double Number: For input string: \"9.2w\"");
    }
}
