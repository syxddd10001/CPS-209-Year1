/**
   A class to calculate the area of several SodaCans. You are to complete the
   following:

     - Complete the method totalMeasure which calculates the total measure over all the Measurable
       items in a given array
*/
public class SodaCanTester
{
   /**
      Calculates the total measure over all the given Measurable items
      @param items the items
      @return the total measure of the items
   */
	 
   private static double totalMeasure(Measurable[] items)
   {
  	  //-----------Start below here. To do: approximate lines of code = 4
  	  // get the measure from all objects in the array, add them up and
  	  // return the total
      double total = 0;;
  	   for (Measurable m : items)
      {
         total += m.getMeasure();
      }
  	  
      return total;
  	  
  	  
  	  //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
   }

   public static void main(String[] args)
   {
      SodaCan[] sodaCans = new SodaCan[4];
      sodaCans[0] = new SodaCan(2, 3);
      sodaCans[1] = new SodaCan(3, 3);
      sodaCans[2] = new SodaCan(5, 7);
      sodaCans[3] = new SodaCan(1, 1);
      System.out.println("--- TEST 1: Calculate the total in a standard case");
      System.out.printf("RESULT:   %.2f\n", totalMeasure(sodaCans));
      System.out.println("EXPECTED: 747.70");

      System.out.println("\n--- TEST 2: Calculate the total for empty array");
      System.out.printf("RESULT:   %.2f\n", totalMeasure(new SodaCan[0]));
      System.out.println("EXPECTED: 0.00");
   }
}
