import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/*
 * For this question, you will implement an undo functionality on a list of words.
 * The possible actions are "addFirst", which adds a given word to the beginning of
 * the list, and "addLast", which adds a given word to the end of the list. You
 * should complete the undo method, which undoes the next element in the actions stack.
 */
public class StackUndoTester
{
	/*
	 * Undo the last action performed on the given list of words. The actions performed
	 * are stored in a stack. The only possible actions are "addLast" and "addFirst"
	 */
	static void undo(LinkedList<String> list, Stack<String> actions)
	{
		//-----------Start below here. To do: approximate lines of code = 6
		// Use the actions stack to undo the last action applied to the list of words
		//an action is either "addFirst" or "addLast"  Hint: check to ensure the stack is not empty
		
		if (actions.isEmpty()) return;

		else if (actions.get(actions.size()-1).equals("addFirst")) {
			list.removeFirst();
			actions.pop();
		}
		
		else if (actions.get(actions.size()-1).equals("addLast")) {
			list.removeLast();
			actions.pop();
			
		}
		
		
		
		
		
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}

	public static void main(String [] args)
	{
		LinkedList<String> list = new LinkedList<String>();
		Stack<String> actions = new Stack<String>();

		// Build a list of words by performing a sequence of actions, where each action has a word parameter
		String commands = "addLast cat addLast bear addLast porcupine addFirst lion addFirst eagle";
		String action = "";
		String word = "";

		System.out.println("BUILDING WORD LIST");
		Scanner scanner = new Scanner(commands);
		while (scanner.hasNext())
		{
			action = scanner.next();
			word = scanner.next();
			System.out.println("Action: " + action + ", word: " + word);
			
			if (action.equals("addLast"))
			{
				list.addLast(word);
				actions.push(action);
			}
			if (action.equals("addFirst"))
			{
				list.addFirst(word);
				actions.push(action);
			}
			System.out.println("\tCurrent list: " + list);
		}

		System.out.println("\n\n--- TEST 1: First undo");
		undo(list, actions);
		System.out.println("OUTPUT:   " + list);
		System.out.println("EXPECTED: [lion, cat, bear, porcupine]");

		System.out.println("\n\n--- TEST 2: Second undo");
		undo(list, actions);
		System.out.println("OUTPUT:   " + list);
		System.out.println("EXPECTED: [cat, bear, porcupine]");

		System.out.println("\n\n--- TEST 3: Third undo");
		undo(list, actions);
		System.out.println("OUTPUT:   " + list);
		System.out.println("EXPECTED: [cat, bear]");

		System.out.println("\n\n--- TEST 4: Fourth undo");
		undo(list, actions);
		System.out.println("OUTPUT:   " + list);
		System.out.println("EXPECTED: [cat]");

		System.out.println("\n\n--- TEST 5: Fifth undo");
		undo(list, actions);
		System.out.println("OUTPUT:   " + list);
		System.out.println("EXPECTED: []");
	}
		

}
