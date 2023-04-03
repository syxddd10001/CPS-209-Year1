import java.util.LinkedList ;
import java.util.ListIterator ;
/**
   Write a static method which uses a ListIterator to remove every 2nd element from the LinkedList.
 */

public class DownSizeTester
{
	/**
	 Removes the first, third, fifth, ... elements from a list (i.e. the elements at indices 0, 2, 4, ...).
	 @param list a linked list of String elements
	 */
	public static void downsize(LinkedList<String> list)
	{
		//-----------Start below here. To do: approximate lines of code = 6
		// Use a ListIterator to iterate over the list and remove elements
		// Be careful about the end of the list
		
		ListIterator <String> lstIt = list.listIterator(0);

		int counter = 0; 

		while (lstIt.hasNext()){
			lstIt.next();
			if (counter % 2 == 0){
				lstIt.remove();
			}
			counter++;
	
		}	
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}

	public static void main(String[] args)
	{
		LinkedList<String> list = new LinkedList<String>() ;
		list.add("Sunday 1") ;
		list.add("Monday 2") ;
		list.add("Tuesday 3") ;
		list.add("Wednesday 4") ;
		list.add("Thursday 5") ;
		list.add("Friday 6") ;
		list.add("Saturday 7") ;
		list.add("Sunday 8") ;
		list.add("Monday 9") ;
		System.out.println("Initial list:");
		System.out.println(list);

		System.out.println("\n\n--- TEST 1: Remove when 9 elements");
		downsize(list) ;
		System.out.println("OUTPUT:   " + list);
		System.out.println("EXPECTED: [Monday 2, Wednesday 4, Friday 6, Sunday 8]");

		System.out.println("\n\n--- TEST 2: Remove when 4 elements");
		downsize(list) ;
		System.out.println("OUTPUT:   " + list);
		System.out.println("EXPECTED: [Wednesday 4, Sunday 8]");

		System.out.println("\n\n--- TEST 3: Remove when 2 elements");
		downsize(list) ;
		System.out.println("OUTPUT:   " + list);
		System.out.println("EXPECTED: [Sunday 8]");

		System.out.println("\n\n--- TEST 4: Remove when 1 elements");
		downsize(list) ;
		System.out.println("OUTPUT:   " + list);
		System.out.println("EXPECTED: []");

		System.out.println("\n\n--- TEST 5: Remove when 0 elements");
		downsize(list) ;
		System.out.println("OUTPUT:   " + list);
		System.out.println("EXPECTED: []");
	}

}
