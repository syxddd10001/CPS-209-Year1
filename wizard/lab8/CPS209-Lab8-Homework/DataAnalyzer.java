import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.zip.CheckedInputStream;
import java.util.NoSuchElementException;

/**
 * This program reads a file containing numbers and analyzes its contents.
 * If the file doesn't exist or contains strings that are not numbers, an
 * error message is displayed. You are to complete the following
 *
 *  - Complete the method signature for readFile
 *  - Complete printSum to print out the sum of values in a given file and handle exceptions
 */
public class DataAnalyzer
{
    /**
     * Reads a data set.
     *
     * @param filename the name of the file holding the data
     * @return the data in the file
     */
    //-----------Start below here. To do: approximate lines of code = 1
    // Make readFile() tell the compiler it will not handle any thrown checked exceptions
    
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    public static double[] readFile(String filename) throws IOException{
        double[] values;

        Scanner in = new Scanner(new File(filename));
        int numberOfValues = in.nextInt();
        values = new double[numberOfValues];
        for (int i = 0; i < numberOfValues; i++) {
            values[i] = in.nextDouble();
        }
        return values;
    }

    /**
     * Uses the readFile method to get the double values in an array, and then
     * calculates the sum of these values.
     *
     * Handles all exceptions
     *
     * @param filename The filename to read from
     */
    public static void printSum(String filename){
        //-----------Start below here. To do: approximate lines of code = 12
        //
        // Call readFile on the given filename within a try block to get the
        // array of integers in the input file. Then calculate the sum of the
        // values in the array and print the result. This should all be done
        // inside the try-block
        // Then calculate the sum over the returned array
        try{
            double[] num = readFile(filename);
            
            double sum = 0;
            
            for (double d : num){
                sum+=d;
            }
            System.out.println(sum);

            
        }
        catch(FileNotFoundException f) {
            System.out.println("File not found: " + filename);
        }

        catch(NoSuchElementException e){
            System.out.println("File contents contain bad data");
        }

        catch(IOException e){
            System.out.println(e.getMessage());
        }

        

        
        
        
        // catch exceptions FileNotFoundException, NoSuchElementException, IOException
        // For FileNotFoundException, print "File not found: " followed by filename
        
        
        
        // For NoSuchElementException, print "File contents contain bad data"
        
        
        
        // For IOException print out the message stored in the exception object (Hint: use the getMessage() method)
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public static void main(String[] args)
    {
        System.out.println("--- TEST 1: Handle correct case");
        System.out.print("OUTPUT  : ");
        printSum("goodData.txt");
        System.out.println("EXPECTED: 15.0");

        System.out.println("\n\n--- TEST 2: Catch exception due to bad data");
        System.out.print("OUTPUT  : ");
        printSum("badData.txt");
        System.out.println("EXPECTED: File contents contain bad data");

        System.out.println("\n\n--- TEST 3: Catch exception due to missing file");
        System.out.print("OUTPUT  : ");
        printSum("missingData.txt");
        System.out.println("EXPECTED: File not found: missingData.txt");

        System.out.println("\n\n--- TEST 4: Catch exception due to bad data again");
        System.out.print("OUTPUT  : ");
        printSum("missingRow.txt");
        System.out.println("EXPECTED: File contents contain bad data");
    }
}