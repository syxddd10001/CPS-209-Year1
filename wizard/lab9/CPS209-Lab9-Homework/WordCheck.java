import java.util.TreeSet;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
   This program checks to see what percent of the unique words in one file
   are used in another file. You are to complete the following:

     - Write a static method called readWords that reads in the words in a file into a Set
     - Complete the percentageWords method
 */
public class WordCheck
{
	/**
	 Reads all words from a file and puts them into a set (a hash set)
	 @param filename the name of the file
	 @return a set with all lowercase words in the file. Here, a
	 word is a sequence of upper- and lowercase letters.
	 */
	//-----------Start below here. To do: approximate lines of code = 5
	// A static method readWords returning a set of Strings ...
	// Make it throw a FileNotFoundException
	public static Set <String> readWords(String filename) throws FileNotFoundException{
	
		// Let 'words' be a set of Strings, constructed as a TreeSet
		Set words = new TreeSet<String>();
		Scanner scanner = new Scanner(new File(filename)); //
		//scanner.useDelimiter("[^a-zA-Z]+"); // Use this line to set the delimiter
		// this sets the delimiter as anything that is not a letter
		scanner.useDelimiter("[^a-zA-Z]+"); //
		// While scanner has another word
		while (scanner.hasNext()){
			words.add(scanner.next().toLowerCase());
			
			// Put the lower case version of that word into 'words'.
		}
		return words;
	}
	
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

	/**
	 * Returns the percentage of words in set1 that also appear in set2.
	 *
	 * @param set1 The first set
	 * @param set2 The second set
	 * @return The percentage of words
	 */
	public static double getWordPercentage(Set<String> set1, Set<String> set2)
	{
		//-----------Start below here. To do: approximate lines of code = 4
		// Create a counter to keep track of the words in set1 found in set 2
		int count = 0;
		
		// for each word in set1
		for (String s : set1){
			// If set2 also contains that word, count it
			if (set2.contains(s)) count++; //
		} //
		// calculate and return percent of words in set1 that you counted
		System.out.println(count);
		return (double) (count/set1.size())*100;
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		// Read the two files, storing the words in sets
		Set<String> set1 = readWords("catInHat.txt");
		Set<String> set2 = readWords("paper.txt");

		System.out.println("--- Test 1: Percentage of words in Cat in the Hat in paper.txt");
		double percent = getWordPercentage(set1, set2);
		System.out.printf("OUTPUT:   %.0f\n", percent) ;
		System.out.printf("EXPECTED: %.0f\n", 21.0) ;

		System.out.println("\n--- Test 2: Percentage of words in paper.txt in Cat in the Hat");
		percent = getWordPercentage(set2, set1);
		System.out.printf("OUTPUT:   %.0f\n", percent) ;
		System.out.printf("EXPECTED: %.0f\n", 100.0) ;
	}

}

