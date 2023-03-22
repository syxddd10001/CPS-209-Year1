/**
   This program tests the measurable Country class.
*/
public class MeasurableTester
{
   public static void main(String[] args)
   {
      Measurable[] countries = new Measurable[3];
      countries[0] = new Country("Uruguay", 176220);
      countries[1] = new Country("Thailand", 513120);
      countries[2] = new Country("Belgium", 30510);

      System.out.println("--- TEST 1: Get the largest country");
      Measurable maxCountry = Measurable.largest(countries);
      System.out.printf("RESULT:   %.1f\n", maxCountry.getMeasure());
      System.out.println("EXPECTED: 513120.0");

      System.out.println("\n--- TEST 2: Get the smallest country");
      Measurable minCountry = Measurable.smallest(countries);
      System.out.printf("RESULT:   %.1f\n", minCountry.getMeasure());
      System.out.println("EXPECTED: 30510.0");
   }
}
