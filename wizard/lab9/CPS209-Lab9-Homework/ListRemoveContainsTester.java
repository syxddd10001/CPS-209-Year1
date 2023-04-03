/**
   For this question, you will use a ListIterator to remove all elements that contain
   the given String. For this question, you need to complete the removeContains method.
 */
import java.util.LinkedList ;
import java.util.ListIterator ;

public class ListRemoveContainsTester
{
	public static void removeContains(LinkedList<String> list, String toRemove)
	{
		//-----------Start below here. To do: approximate lines of code = 4
		// Use an iterator to remove all elements containing toRemove
		// Start by creating a list iterator.
		// HINT: You will probably want to use the .contains method of a String
		
		ListIterator <String> listIt = list.listIterator(0);
		
		while (listIt.hasNext()){
			if (listIt.next().contains(toRemove)) listIt.remove();
		}
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	public static void main(String[] args)
	{
		LinkedList<String> list = new LinkedList<String>() ;

		System.out.println("---- TEST 1: Empty list");
		removeContains(list, "anything");
		System.out.println("OUTPUT:   " + list);
		System.out.println("EXPECTED: []");

		System.out.println("\n\n---- TEST 2: Given string not contained in any element");
		for (int i = 1 ; i <= 50 ; i++) {
			list.add(i + "") ;
		}
		System.out.println("INITIAL:  " + list) ;
		removeContains(list, "A");
		System.out.println("OUTPUT:   " + list);
		System.out.println("EXPECTED: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50]");

		System.out.println("\n\n---- TEST 3: Remove any element with a 3 in it");
		removeContains(list, "3");
		System.out.println("OUTPUT:   " + list);
		System.out.println("EXPECTED: [1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 22, 24, 25, 26, 27, 28, 29, 40, 41, 42, 44, 45, 46, 47, 48, 49, 50]");
	}
}