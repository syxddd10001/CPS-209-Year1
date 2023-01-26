/**
   Encodes a string by replacing all letters "i" with "!" and
   all letters "s" with "$". Use the replace method of class String. Look up the documentation of this method to see how to use it.
   Do this with variable town (see code below), assigning the result to variable townEncoding, 
   and with the variable sentence, assigning the result to variable sentenceEncoding.
   Difficulty: Easy
 */

public class StringReplace
{
    public static void main(String[] args)
    {
      	String town = "Mississauga" ;
      	String townEncoding ;
     	String sentence = "This is a simple sentence." ;
      	String sentenceEncoding ;
	  //-----------Start below here. To do: approximate lines of code = 4
	  // 1. Assign to townEncoding the result of applying the replace method to town to replace "i" with "!" ; 
	  
	  //2. now update townEncoding by replacing s to $ in string townEncoding; 
	  
	  //3. assign to sentenceEncoding the result of applying replace() on sentence to replace "i" with "!".  
	  
	  //4. now replace s with $ in string sentenceEncoding (i.e. update sentenceEncoding).
		
	townEncoding = town.replace("i","!");
	townEncoding= townEncoding.replace("s","$");
	sentenceEncoding = sentence.replace("i","!");
	sentenceEncoding = sentenceEncoding.replace("s","$");
		



	  //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	  System.out.println("Encoding of town:" + townEncoding) ;
	  System.out.println("Encoding of sentence:" + sentenceEncoding) ;
      System.out.println("Expected:") ;
      System.out.println("Encoding of town: M!$$!$$auga" ) ;
	  System.out.println("Encoding of sentence: Th!$ !$ a $!mple $entence.") ;
    }
}
