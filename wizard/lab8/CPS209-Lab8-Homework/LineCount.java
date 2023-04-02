/**
   This is a simple program to count the lines in a data file. You are to
   complete the lineCounter method.

 */
import java.util.* ;
import java.io.* ;

public class LineCount
{

	public static int lineCounter(String fileName)
	{
		//-----------Start below here. To do: approximate lines of code = 10
		// Use a try{...}catch(){...} block and open a file "data.txt"
		// using the File class. Create a Scanner object and pass in the File
		// reference. Read the lines one at a time from the file
		// and count them. Return the count
		int count = 0;
		try {
			File newFile = new File(fileName);
			Scanner scanFile = new Scanner(newFile);
			count = 0;
			
			while (scanFile.hasNextLine()){
				String a = scanFile.nextLine();
				count++;
				
			}
			return count;

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	public static void main(String[] args) 
	{
		System.out.println("--- TEST 1: Checks on one file");
		System.out.println("OUTPUT:   " + lineCounter("data.txt"));
		System.out.println("EXPECTED: 13");

		System.out.println("\n--- TEST 2: Checks on a second file");
		System.out.println("OUTPUT:   " + lineCounter("lines.txt"));
		System.out.println("EXPECTED: 9");
	}
}
