/**
 * For this question, you are to complete a method which takes in a Queue and the
 * number of elements in that queue to remove, and returns that number of elements
 * in a LinkedList. If more elements are requested than are left in the Queue, then
 * all remaining elements should be returned.
 */

import java.util.LinkedList;
import java.util.Queue;

public class QueueTester
{

	/*
	 * Removes a group of people from a queue.
	 * The integer parameter groupMemberSize indicates how many people should be removed from the queue
	 * Returns a list of the people in the group
	 */
	public static LinkedList<String> getNextGroup(Queue<String> queue, int groupMemberSize)
	{
		//-----------Start below here. To do: approximate lines of code = 6
		// Create an empty Linked List of Strings to hold the group members
		
		LinkedList <String> groupMembers = new LinkedList<String>();
		// Remove groupMemberSize strings (representing the names of people in the group) from the queue
		// and add each name string to the list
		// Hint: If more elements are requested than are in the list, the returned LinkedList
		// should contain all values
		
		int count = 0;

		if (queue.size() == 0) return groupMembers;

		if (groupMemberSize > queue.size()) {
			while (count < queue.size()){
				groupMembers.add(queue.poll());
				count++;	
			}
			return groupMembers;
		}

		while (count < groupMemberSize){
			groupMembers.add(queue.poll());
			count++;
		}
		
		
		return groupMembers;
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}

	public static void main(String [] args)
	{
		String [] names = {"Will", "Grace",
				"Rachel", "Ross", "Phoebe", "Chandler", "Monica", "Joey",
				"Jerry", "Elaine", "Kramer", "George",
				"Beth"
		};

		Queue<String> queue = new LinkedList<String>();
		
		for (String name : names)
		{
			queue.add(name);
		}

		System.out.println("--- TEST 1: First 2 elements");
		System.out.println("OUTPUT:   " + getNextGroup(queue, 2));
		System.out.println("EXPECTED: [Will, Grace]");

		System.out.println("\n--- TEST 1: Next 6 elements");
		System.out.println("OUTPUT:   " + getNextGroup(queue, 6));
		System.out.println("EXPECTED: [Rachel, Ross, Phoebe, Chandler, Monica, Joey]");

		System.out.println("\n--- TEST 1: Next 4 elements");
		System.out.println("OUTPUT:   " + getNextGroup(queue, 4));
		System.out.println("EXPECTED: [Jerry, Elaine, Kramer, George]");

		System.out.println("\n--- TEST 1: Next 3 elements, though only 1 left");
		System.out.println("OUTPUT:   " + getNextGroup(queue, 3));
		System.out.println("EXPECTED: [Beth]");

		System.out.println("\n--- TEST 1: Get 2 elements though it is empty");
		System.out.println("OUTPUT:   " + getNextGroup(queue, 2));
		System.out.println("EXPECTED: []");
	}
	

}
