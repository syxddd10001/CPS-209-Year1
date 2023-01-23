import java.util.Scanner;
/*
 * This program determines whether a word contains more than 1 vowel in a row
 * If it does, it prints the word 
 * For example, 
 * if the word = "field" then "field" is printed ("ie")
 *             = "queue" then "queue" is printed ("ueue")
 */
public class ConsecutiveVowels 
{
	public static void main(String[] args) 
	{
		String  words = "field quick abdicate mood about cattle"; 
		Scanner in = new Scanner(words);

		while (in.hasNext())
		{
			String word = in.next();

			//-----------Start below here. To do: approximate lines of code = 9
			// Use a for loop and go through each character of the string word 
			// check if the character is one of 'a' 'e' 'i' 'o' 'u' 
			// if it is, record (in a variable) the index where this occurred
			// if another vowel is encountered, check to see if this new index is one more than the stored index (eg. index 3 then index 4 or index 7 then index 8)
			// if so, print the word. If not, update the index 
			int index;
			for (int i = 0; i < word.length()-1; i++)
			{
				if (word.charAt(i) == 'a' || word.charAt(i) == 'e'|| word.charAt(i) == 'i' ||word.charAt(i) == 'o' || word.charAt(i) == 'u')
				{
					index = i;
					if (word.charAt(i+1) == 'a' || word.charAt(i+1) == 'e'|| word.charAt(i+1) == 'i' ||word.charAt(i+1) == 'o' || word.charAt(i+1) == 'u')
					{
				
					System.out.println(word);
					break;
					}
				}
				
				

			
			}	
			
			
				// Check each letter of word to see if a vowel, 
				// when comparing characters don't forget to use ==  
				// Hint: use class String method charAt() to get the next character
				// e.g. word.charAt(3) returns a char at position 3 in the string word 
			
			
			
			
			
			
			
			
			
			
			
			
			//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		}
		System.out.println("Expected:\nfield\nquick\nmood\nabout");
	}
}
