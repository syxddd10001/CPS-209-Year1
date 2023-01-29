/**
   This class has a main method that prints out an integer array in various ways
   
   Difficulty: Easy
 */

public class ArrayPrinter
{
   public static void main(String[] args)
   {
      int[] data = {2, 34, 57, 31, 5, 79, 88, 62, 98, 53, 42};
      

      //-----------Start below here. To do: approximate lines of code = 2
      // Write a loop to print out even indices (NOTE: do not print the elements of array data)
      // use System.out.print, not System.out.println so the index numbers are printed on one line
      for (int i = 0; i<data.length;i+=2)
      {
         System.out.print(i+ " ");  
      }

      //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
      System.out.println();
      System.out.println("EXPECTED:") ;
      System.out.println("0 2 4 6 8 10");
      

      //-----------Start below here. To do: approximate lines of code = 2
      // Write a loop to print out the integer elements stored at even indices of array data
      
      for (int i = 0; i<data.length; i+=2)
      {
         System.out.print(data[i] +" ");  
      }

      
      
      //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
      System.out.println();
      System.out.println("EXPECTED:") ;
      System.out.println("2 57 5 88 98 42");
      
      //-----------Start below here. To do: approximate lines of code = 2
      // Print out the elements in array data in reverse order
      //Hint: use a for loop but start at the end of the array and count down
      for (int i = data.length-1; i>=0; i--)
      {
         System.out.print(data[i]+ " ");
      }
   
      //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
      System.out.println();
      System.out.println("EXPECTED:") ;
      System.out.println("42 53 98 62 88 79 5 31 57 34 2");

      //-----------Start below here. To do: approximate lines of code = 1
      // Print out only the first and last element
      System.out.print(data[0] + " " + data[data.length-1]+ "\n");
      //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
      System.out.println("EXPECTED:") ;
      System.out.println("2 42");
   }
}
