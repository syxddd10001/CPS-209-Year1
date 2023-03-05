
import java.time.Month;
import java.util.Scanner;

/**
   Demonstration of the appointment classes
 */
public class AppointmentTester
{

	public static void main(String[] args)
	{

		DailyAppointment d = new DailyAppointment(2000, 8, 13, "Brush your teeth");
		System.out.println("--- TEST 1: Test that DailyAppointment Works Correctly");
		System.out.println("For date 2009-09-13:");
		System.out.println("OUTPUT:   " + d.occursOn(2009, 9, 13));
		System.out.println("EXPECTED: true");
		System.out.println("\nFor date 2000-06-13:");
		System.out.println("OUTPUT:   " + d.occursOn(2000, 6, 13));
		System.out.println("EXPECTED: false");
		System.out.println("\nFor date 2001-08-13:");
		System.out.println("OUTPUT:   " + d.occursOn(2001, 8, 13));
		System.out.println("EXPECTED: true");
		System.out.println("\nFor date 2000-08-14:");
		System.out.println("OUTPUT:   " + d.occursOn(2000, 8, 14));
		System.out.println("EXPECTED: true");

		System.out.println("\n\n--- TEST 2: Test that MonthlyAppointment Works Correctly");
		MonthlyAppointment m = new MonthlyAppointment(2003, 5, 20, "Visit grandma");
		System.out.println("For date 2003-04-20:");
		System.out.println("OUTPUT:   " + m.occursOn(2003, 4, 20));
		System.out.println("EXPECTED: false");
		System.out.println("\nFor date 2003-07-20:");
		System.out.println("OUTPUT:   " + m.occursOn(2003, 7, 20));
		System.out.println("EXPECTED: true");
		System.out.println("\nFor date 2004-05-20:");
		System.out.println("OUTPUT:   " + m.occursOn(2004, 5, 20));
		System.out.println("EXPECTED: true");
		System.out.println("\nFor date 2002-05-20:");
		System.out.println("OUTPUT:   " + m.occursOn(2002, 5, 20));
		System.out.println("EXPECTED: false");
		System.out.println("\nFor date 2003-06-19:");
		System.out.println("OUTPUT:   " + m.occursOn(2003, 6, 19));
		System.out.println("EXPECTED: false");
	}
}


