/**
   For this question, you have to write a static getStringOfList(list, index) method
   that constructs a string representation of a LinkedList and its iterator, given the list
   itself and the index that the iterator is at.

   For example, if the LinkedList contains elements "A", "B", "C", and "D" in that order, and
   the given index is 2, then the returned String should be "AB|CD", where the "|" indicates
   the location of the iterator.
 */
import java.util.LinkedList ;
import java.util.ListIterator ;

public class ListIteratorTester
{
	/**
	 A static method to return a string representation of the
	 list and the iterator.  Note that the listIterator method
	 nextIndex gives the index of the next element that would be
	 returned by a call to next, or list size if the list iterator
	 is at the end of the list. The four possible pictures for a
	 list [A,B,C] are:
	 |ABC             here index would be 0
	 A|BC             here index would be 1
	 AB|C             here index would be 2
	 ABC|             here index would be 3 (i.e., the size of the list)

	 @param list the linked list of type LinkedList<String>
	 @param index of next element that the iterator would return by next
	 @return a string representation like A|BC
	 */

	public static String getStringOfList(LinkedList<String> list, int index)
	{
		//-----------Start below here. To do: approximate lines of code = 10
		// 1. initialize result to empty string ;
		String result = "";
		//2. if index is 0 ;
		if (index == 0) result = "|";
			//then put "|" on result ;
		
		//3. initialize count ;
		int count = 0;

		//4. for each element in the list ;
		for (String s : list){
			//5. append element to result ;
			result+=s;

			//6. increment count ;
			count ++;
			//7. if count is index ;
			if (index == count) result += "|";
				//then append "|" ;
		
		}
		//8. return result.
		return result;
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}

	public static void main(String[] args)
	{
		LinkedList<String> list = new LinkedList<String>() ;
		ListIterator<String> iterator = list.listIterator() ;

		// List is empty
		System.out.println("--- Test 1: Empty list");
		System.out.println("OUTPUT:   " + getStringOfList(list, iterator.nextIndex())) ;
		System.out.println("EXPECTED: |");

		// Add one element using iterator
		System.out.println("\n--- Test 2: Added one element");
		iterator.add("A") ;
		System.out.println("OUTPUT:   " + getStringOfList(list, iterator.nextIndex())) ;
		System.out.println("EXPECTED: A|");

		// Add second element using iterator
		System.out.println("\n--- Test 3: Added second element");
		iterator.add("B") ;
		System.out.println("OUTPUT:   " + getStringOfList(list, iterator.nextIndex())) ;
		System.out.println("EXPECTED: AB|");

		// Add third element using iterator
		System.out.println("\n--- Test 4: Added third element");
		iterator.add("C") ;
		System.out.println("OUTPUT:   " + getStringOfList(list, iterator.nextIndex())) ;
		System.out.println("EXPECTED: ABC|");

		// Add fourth element using iterator
		System.out.println("\n--- Test 5: Added fourth element");
		iterator.add("D") ;
		System.out.println("OUTPUT:   " + getStringOfList(list, iterator.nextIndex())) ;
		System.out.println("EXPECTED: ABCD|");

		// Reset iterator to the beginning
		System.out.println("\n--- Test 6: Reset iterator");
		iterator = list.listIterator() ;
		System.out.println("OUTPUT:   " + getStringOfList(list, iterator.nextIndex())) ;
		System.out.println("EXPECTED: |ABCD");

		// Remove next element (first element) if it is A
		System.out.println("\n--- Test 7: Remove first element");
		iterator.next();
		iterator.remove() ;
		System.out.println("OUTPUT:   " + getStringOfList(list, iterator.nextIndex())) ;
		System.out.println("EXPECTED: |BCD");

		// Move iterator forward one step
		System.out.println("\n--- Test 8: Move iterator forward one step");
		iterator.next();
		System.out.println("OUTPUT:   " + getStringOfList(list, iterator.nextIndex())) ;
		System.out.println("EXPECTED: B|CD");

		System.out.println("\n--- Test 9: Iterate through remaining elements");
		// Iterator through remaining elements
		System.out.print("OUTPUT:   ");
		while(iterator.hasNext())
			System.out.print(iterator.next() + " ") ;
		System.out.println("\nEXPECTED: C D ");

		// Print out final state of the iterator
		System.out.println("\n--- Test 10: Print final state of the iterator");
		System.out.println("OUTPUT:   " + getStringOfList(list, iterator.nextIndex())) ;
		System.out.println("EXPECTED: BCD|");
	}
	
}
