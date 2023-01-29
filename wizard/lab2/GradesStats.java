import java.util.Scanner;
/*
 * This program contains a static method to find the number
 * of target strings occuring in a given input string. It returns this number.
 * Difficulty: Easy
 */
public class GradesStats
{
	public static void main (String[] args)
	{
		 String courseGrades = "B- C+ A+ A B B+ F D+ C- A- B A+";
		 
		 System.out.println("Number of A+ grades is " + countGrades(courseGrades, "A+"));
		 System.out.println("Expected:\nNumber of A+ grades is 2");
		 
		 int numAGrades = 0;
		 //-----------Start below here. To do: approximate lines of code = 1
		 // Call the countGrades() method below (as many times as you need to) and compute the total number of A grades where an A grade is one of "A-" "A" "A+"
		 // store the number of A grades in the variable numAGrades
		 
		 numAGrades = countGrades(courseGrades, "A");
		 //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		 System.out.println("Number of A- A A+ grades is " + numAGrades);
		 System.out.println("Expected:\nNumber of A- A A+ grades is 4");
	}
	
	static int countGrades(String grades, String targetGrade)
	{
		//-----------Start below here. To do: approximate lines of code = 8
		// create a Scanner and loop through the grades parameter string called grades looking for a word equal to targetGrade string
		// If one is found, add it to an integer total variable and continue until there are no more words in grades. Return the total.
		// For example, if grades = "C+ B- B D C+ A" and targetGrade = "C+" then the method returns 2 
		int int_total = 0;

		Scanner gr = new Scanner(grades);

		while (gr.hasNext())
		{
			String g = gr.next();
			if (g.contains(targetGrade))
			{
				int_total ++;
			}

		}

		return int_total;
		
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
	
}