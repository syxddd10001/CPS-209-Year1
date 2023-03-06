import java.util.ArrayList;

/**
  A class to test the student and instructor subclasses. In addition, you
  are to complete the getOldest method which finds the oldest person in the
  given array list and returns them
 */
public class SchoolPersonTester
{

	/**
	 * Finds the oldest person in the given ArrayList and returns them. Returns null
	 * if the ArrayList is empty.
	 * @param people The list of people
	 * @return The oldest person in the array
	 */
	public static SchoolPerson getOldest(ArrayList<SchoolPerson> people)
	{
		//-----------Start below here. To do: approximate lines of code = 5
		//
		if (people.size() == 0)
		{
			return null;
		}

		SchoolPerson schlperson = people.get(0);
		int byear = people.get(0).getBirthYear();
		
		for (SchoolPerson person : people)
		{
			if (person.getBirthYear() > byear)
			{
				schlperson = person;
			}
		}		
		
		return schlperson;
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	public static void main(String[] args)
	{
		System.out.println("--- TEST 1: Check that toString works correctly");
		System.out.println("check Student toString");
		SchoolPerson student = new Student("Ali",2002, "CS");
		System.out.println("OUTPUT:   " + student);
		System.out.println("EXPECTED: Student Name: Ali Year of Birth: 2002 Major: CS");

		SchoolPerson instructor = new Instructor("Sam", 1991, 120000);
		System.out.println("\ncheck Instructor toString");
		System.out.println("OUTPUT:   " + instructor);
		System.out.println("EXPECTED: Instructor Name: Sam Year of Birth: 1991 Salary: 120000");

		System.out.println("\n\n--- TEST 2: Check that getOldest works on an empty arraylist");
		ArrayList<SchoolPerson> people = new ArrayList<SchoolPerson>();
		System.out.println("OUTPUT:   " + getOldest(people));
		System.out.println("EXPECTED: null");

		System.out.println("\n\n--- TEST 3: Check that getOldest works in standard case");
		SchoolPerson person = new SchoolPerson("Jeff", 2001);
		people.add(student);
		people.add(instructor);
		people.add(person);

		System.out.println("OUTPUT:   " + getOldest(people));
		System.out.println("EXPECTED: Instructor Name: Sam Year of Birth: 1991 Salary: 120000");
	}
}

