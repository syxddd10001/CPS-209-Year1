/**
   This class tests the Question classes and subclasses.
   It is an example in Big Java.

   Your work is in the todo region in FillInQuestion.java.
   Nothing to change here.
 */
public class QuestionTester
{
   public static void main(String[] args)
   {
      // An array of Question references - no Question objects yet
      Question[] quiz = new Question[3];
      // create a Question object and insert in index 0 of array
      quiz[0] = new Question("Who was the inventor of Java?");
      quiz[0].setAnswer("James Gosling");    
      // Add another Question object	  
      quiz[1] = new FillInQuestion("The inventor of Java was _James Gosling_.") ;

      String response ;
      Question q ;
      System.out.println("--- TEST 1: Checking how Question works when given wrong answer.") ;
      q = quiz[0] ;
      q.display();

      response = "Larry Wall" ;
      System.out.println("OUTPUT:   " + q.checkAnswer(response));
      System.out.println("EXPECTED: false") ;

      System.out.println("\n\n--- TEST 2: Checking how Question works when given right answer.") ;
      response = "James Gosling" ;
      System.out.println("OUTPUT:   " + q.checkAnswer(response));
      System.out.println("EXPECTED: true") ;

      System.out.println("\n\n--- TEST 3: Checking that the question in FillInQuestions has been set correctly.") ;
      q = quiz[1] ;
      System.out.print("OUTPUT:   ");
      q.display();
      System.out.println("EXPECTED: The inventor of Java was _______________.") ;

      System.out.println("\n\n--- TEST 4: Checking that FillInQuestion works when given a wrong answer") ;
      response = "Niklaus Wirth" ;
      System.out.println("OUTPUT:   " + q.checkAnswer(response));
      System.out.println("EXPECTED: false") ;

      System.out.println("\n\n--- TEST 5: Checking that FillInQuestion works when given a wrong answer") ;
      response = "James Gosling" ;
      System.out.println("OUTPUT:   " + q.checkAnswer(response));
      System.out.println("EXPECTED: true\n") ;
   }
}
