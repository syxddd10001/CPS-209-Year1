import java.util.Scanner;
/*
 * Write a method wordCount() to help find the average number of words in an array of sentence strings
 */
public class AverageWordCount
{
   public static void main (String[] args)
   {
      // array of sentences
      String sentences[] = {"Yeah, I'm gonna take my horse", "To the old town road", "I'm gonna ride til I can't no more",
                            "I'm gonna take my horse to the old town road", "I'm gonna ride til I can't no more"};
      int totalWords = 0;
      double averageWords = 0.0;
		 
      for (int i = 0; i < sentences.length; i++)
      {
         totalWords +=  wordCount(sentences[i]);
      }
      //-----------Start below here. To do: approximate lines of code = 2
      // compute the average number of words in a sentence and store in the double variable averageWords (see declaration at the top)
      // Hint: test to make sure you do not divide by 0. Also, you will need to cast the integer value returned by totalWords() to a double
      averageWords = (double) totalWords/ (double) sentences.length;
      
      //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
      System.out.println("Average number of words per sentence: " + averageWords);
      System.out.println("Expected:\nAverage number of words per sentence: 7.4");
   }
	
   // Calculate the number of words in the input String sentence. Return the number of words.
   // Param: a string called sentence that contains some number of word strings
   static int wordCount(String sentence)
   {
      //-----------Start below here. To do: approximate lines of code = 7
      // There are several ways to solve this. One basic way is to use a Scanner, then in a while loop use the scanner to read the words one by 
      // one and increase the word count. Note: when you create the scanner, pass in the parameter String sentence not System.in 
      Scanner sen = new Scanner(sentence);
      
	  // Create an integer variable to hold the number of words found. Don't forget to initialize it to 0
      int count = 0; 
	  // Write the while loop
      while (sen.hasNext())
      {
         String a = sen.next();
         count ++;
         
      }
      return count;
      
      
      
      
	  // Return the integer word count
      
      //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
   }
}
