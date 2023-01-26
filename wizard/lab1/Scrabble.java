import java.util.Scanner;

// This program uses a static method letterValue() to determine the numeric value of a letter in Scrabble

// Scrabble letter values:
// A,E,I,O,U,L,N,S,T,R  = 1
// D,G = 2
// B,C,M,P = 3
// F, H, V, W, Y = 4
// K = 5
// J, X = 8
// Q, Z = 10

public class Scrabble
{
	public static void main(String[] args)
	{
		String words = "abdicate kite quick zap about cattle";
		Scanner in = new Scanner(words);
		while (in.hasNext())
		{
			String word = in.next();
			System.out.println("The Scrabble value of " + word + " is " + wordValue(word));
		}
		System.out.println("Expected: ");
		System.out.println("The Scrabble value of abdicate is 13\nThe Scrabble value of kite is 8\nThe Scrabble value of quick is 20\nThe Scrabble value of zap is 14\nThe Scrabble value of about is 7\nThe Scrabble value of cattle is 8");

	}
	
	/**
      Finds the point value of a letter in Scrabble
      @param ch the character to be evaluated
      @return the letter point value (int)
	 */
	public static int letterValue(char ch)
	{
		int value = 0;
		//-----------Start below here. To do: approximate lines of code = 23
		// Use a switch statement (i.e. switch on the ch variable) to determine which letter is input and return that value of that letter. 
		// See the comments at the top of the file for Scrabble letter values. 
		// Convert ch to an uppercase letter first before using it in the switch statement
		// Hint: the Character class has a static method called toUpperCase(). For example: ch = Character.toUpperCase(ch);
		ch = Character.toUpperCase(ch);
		switch (ch)
		{
			case 'A':
				value = 1;
				break;
			case 'E':
				value = 1;
				break;
			case 'I':
				value = 1;
				break;
			case 'O':
				value = 1;
				break;
			case 'U':
				value = 1;
				break;
			case 'L':
				value = 1;
				break;
			case 'N':
				value = 1;
				break;
			case 'S':
				value = 1;
				break;
			case 'T':
				value = 1;
				break;
			case 'R':
				value = 1;
				break;
			case 'D':
				value = 2;
				break;
			case 'G':
				value = 2;
				break;
			case 'B':
				value = 3;
				break;
			case 'C':
				value = 3;
				break;
			case 'M':
				value = 3;
				break;
			case 'P':
				value = 3;
				break;
			case 'F':
				value = 4;
				break;
			case 'H':
				value = 4;
				break;
			case 'V':
				value = 4;
				break;
			case 'W':
				value = 4;
				break;
			case 'Y':
				value = 4;
				break;
			case 'K':
				value = 5;
				break;
			case 'J':
				value = 8;
				break;
			case 'X':
				value = 8;
				break;
			case 'Q':
				value = 10;
				break;
			case 'Z':
				value = 10;
				break;
			default:
				return value;

		}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		return value;
	}

	/**
      Finds the point value of a word in Scrabble
      @param str the word to be evaluated
      @return the letter point value of the word 
	 */
	public static int wordValue(String str)
	{
		int total = 0;
		for (int i = 0; i < str.length(); ++i)
		{
			total = total + letterValue(str.charAt(i));
		}
		return total;
	}
}
