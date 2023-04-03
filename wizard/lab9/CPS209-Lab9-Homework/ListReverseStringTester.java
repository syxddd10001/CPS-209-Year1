import java.util.LinkedList;
import java.util.ListIterator;
/**
   For this problem, you will use a ListIterator to print the values of a LinkedList in reverse order.
   You need to complete the reverseString method for this purpose.
*/
public class ListReverseStringTester
{
	public static String reverseString(LinkedList<Integer> list)
	{
		String output = "";
		//-----------Start below here. To do: approximate lines of code = 3
		// Make a list iterator that starts at the end of the list ;
		// Hint: lookup the documentation for the listIterator() method - you can pass to it a starting point
		// If list is empty, it should return an empty list
		if (list.size() == 0) return output;
		
		ListIterator<Integer> lstIt = list.listIterator(list.size());
		
		// while hasPrevious ;
		while (lstIt.hasPrevious()) {
			
			output += lstIt.previous() + " ";
		}


			// print what is returned by previous() followed by a blank without a newline
			// Don't worry about the last element having a blank in it
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		return output;
	}
	public static void main(String [] args)
	{
		LinkedList<Integer> list = new LinkedList<Integer>();

		System.out.println("---- TEST 1: Empty list");
		System.out.println("OUTPUT:   " + reverseString(list));
		System.out.println("EXPECTED: ");

		System.out.println("\n---- TEST 2: A single entry in the list");
		list.add(5);
		System.out.println("OUTPUT:   " + reverseString(list));
		System.out.println("EXPECTED: 5 ");

		list.remove();

		for (int i = 0 ; i < 100 ; i = i + 2)
		    list.add(i) ;

		System.out.println("\n---- TEST 3: All even integers from 0 to 98");
		System.out.println("OUTPUT:   " + reverseString(list));
		System.out.println("EXPECTED: 98 96 94 92 90 88 86 84 82 80 78 76 74 72 70 68 66 64 62 60 58 56 54 52 50 48 46 44 42 40 38 36 34 32 30 28 26 24 22 20 18 16 14 12 10 8 6 4 2 0");
	}
}
