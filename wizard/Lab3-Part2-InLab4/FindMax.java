import java.util.ArrayList;
import java.util.Scanner;
/*
 * This program finds the largest number in an arraylist of doubles
 */
public class FindMax
{
	public static void main(String[] args)
	{
		String data = "45.34 72.15 35.93 90.25 12.45 3.24 204.67 317.01 684.22 23.34 44.45";
		ArrayList<Double> values = new ArrayList<Double>();

		Scanner in = new Scanner(data);
		while (in.hasNextDouble())
		{
			values.add(in.nextDouble());
		}

		// Find the largest and smallest value in array list values
		double largest  = values.get(0);
		//-----------Start below here. To do: approximate lines of code = 3
		// Loop through the remaining elements in values and update largest variable
		for (int i = 0; i < values.size(); ++i)
		{
			if (values.get(i) > largest)
			{
				largest = values.get(i);
			}
		}
		
		
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		System.out.printf("Largest = %.2f\n", largest) ;
		System.out.println("Expected:\nLargest = 684.22");
	}
}


