/**
 Searches all files for the specified word and prints out all lines
 containing the specified word. You are to complete the following:

   - implement findAndPrint
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindWordInFile
{

   /**
	Searches file for a word, prints out all lines containing that word.
	@param wordToFind the word to find
	@param filename the filename for the file to search
   */
   public static void findAndPrint(String wordToFind, String filename)
   { 
  	 //-----------Start below here. To do: approximate lines of code = 8
  	 // fill in the method. Make use of the contains() method of class String
  	 // If you find the word in a line of a file, print the file name followed by a ": " followed by the line
  	 // Hint: use a try{..}catch(){...} block. If the file is not found print out the filename followed by
      // " not found!"
  	 
  	 
      try{
         File file = new File(filename);
         Scanner scan = new Scanner(file);

         while (scan.hasNextLine()){
            String s = scan.nextLine();

            if (s.contains(wordToFind)){
               System.out.println(filename + ": " + s);
            }
         }
      }

      catch(Exception e)
      {
         System.out.println(filename+ " not found!");
      }
  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	 
  	 //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
   }

   public static void main(String[] args)
   {
      String wordToFind = "sandwich";

      System.out.println("--- TEST 1: Checks on one file");
      System.out.println("OUTPUT:");
      findAndPrint(wordToFind, "file1.txt");
      System.out.println("EXPECTED:");
      System.out.println("file1.txt: I love a good sandwich");
      System.out.println("file1.txt: A sandwich can be very healty.");

      System.out.println("\n--- TEST 2: Checks on a second file");
      System.out.println("OUTPUT:");
      findAndPrint(wordToFind, "file2.txt");
      System.out.println("EXPECTED:");
      System.out.println("file2.txt: I love to eat a sandwich at lunch.");
      System.out.println("file2.txt: A sandwich is very filling.");
      System.out.println("file2.txt: One of my favorite type of sandwich is gilled cheese.");
      System.out.println("file2.txt: I like a peanut butter and jelly sandwich too.");

      System.out.println("\n--- TEST 3: Checks on a third file");
      System.out.println("OUTPUT:");
      findAndPrint(wordToFind, "file3.txt");
      System.out.println("EXPECTED:");
      System.out.println("file3.txt: If you buy a sandwich at a restaurant they can be quite expensive.");
      System.out.println("file3.txt: That's why I often make a sandwich at home.");

      System.out.println("\n--- TEST 4: Checks on a missing file");
      System.out.println("OUTPUT:");
      findAndPrint(wordToFind, "file4.txt");
      System.out.println("EXPECTED:");
      System.out.println("file4.txt not found!");
   }
}
