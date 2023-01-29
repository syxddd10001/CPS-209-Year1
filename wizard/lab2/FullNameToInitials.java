import java.util.Scanner;

/* 
 * Write a program that takes a full name string, converts it to initials and prints 
 * For example, if the full name is "John Jacob Schmidt" then the program outputs:
 * John Jacob Schmidt: J.J.S.
 */


public class FullNameToInitials
{
	public static void main (String[] args)
	{
		 String fullNames[] = {"Timothy John McInerney","Rick Valenzano","Inigo Montoya","Gaga","Doja Cat", "Lil Nas X"};
		 
		 //-----------Start below here. To do: approximate lines of code = 2
		 // go through all the full name strings in the array fullNames and call the initials() method for each to convert each to their initials
		 // print the fullName followed by a ": " followed by the initials  
		 for (int i = 0; i<fullNames.length;i++)
		 {
			System.out.println(fullNames[i] + ": " + initials(fullNames[i]));
		 }
		 
		 
		 
		 //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		 System.out.println("Expected:\nTimothy John McInerney: T.J.M.\n"
		 		+ "Rick Valenzano: R.V.\n"
		 		+ "Inigo Montoya: I.M.\n"
		 		+ "Gaga: G.\n"
		 		+ "Doja Cat: D.C.\n"
		 		+ "Lil Nas X: L.N.X.");
	}
	
	
	// Takes a full name string as input, extracts and returns the initials 
	// Each initial should be followed by a "." 
	static String initials(String fullName)
	{
		//-----------Start below here. To do: approximate lines of code = 6
		// Hint: create and use a scanner to read each name from the fullName string, extract the first character 
		// and add it (i.e. concatenate) to a result string 
		// Hint: use the charAt() method of class String - look up the documentation to see how it is used if you have forgotten
		Scanner nameReader = new Scanner(fullName);
		String initial = "";
		while (nameReader.hasNext())
		{
			String name = nameReader.next();				
			initial += name.charAt(0) + ".";		
		}

		return initial;	
		
		
		// Return the string containing the initials
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
}
