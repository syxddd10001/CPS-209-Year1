import java.util.* ;
/**
   Complete the code as indicated. 
   Google the Java Scanner class to see the available methods (e.g. scanner.nextDouble(), scanner.nextInt(), scanner.next(), scanner.nextLine() etc)
 */
public class ScannerTest
{
    public static void main(String[] args)
    {
	    Scanner scanner = new Scanner("5.42 integer 99 Hello World!") ;
	    //-----------Start below here. To do: approximate lines of code = 4
	    // 1. read a double number from scanner into a variable x 
	    
	    //2. read a word into a variable word
	    
	    //3. read an integer from the scanner into a variable i
	    
	    //4. read the rest of the words into a variable line
		
	    double x = scanner.nextDouble();
	    String word = scanner.next();
	    int i = scanner.nextInt();
	    String line = scanner.nextLine();

		    
	    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	    System.out.println("Double read: " + x + "\nExpected: 5.42") ;
	    System.out.println("Word read: " + word + "\nExpected: integer") ;
	    System.out.println("Integer read: " + i + "\nExpected: 99") ;
	    System.out.println("Line read:" + line + "\nExpected: Hello World!") ;
	    System.out.println("Checking types: i/2 + x/x = " + (i/i + x/x)) ;
    }
}
