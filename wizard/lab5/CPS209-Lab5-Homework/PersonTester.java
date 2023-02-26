import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class tests the Person class. You should complete the findPerson method
 */
public class PersonTester
{
	// Create a static method that returns true if a person with the given first name and last name
	// is in the given ArrayList of Person objects
	//
	// HINT: Use the equals method you defined in Person
	public static boolean findPerson(ArrayList<Person> people, String firstName, String lastName)
	{
		//-----------Start below here. To do: approximate lines of code = 5
		//
		
		Person p = new Person(firstName, lastName);

		for (Person person: people)
		{	
			if (p.equals(person))
			return true;	
		}
		
		return false;
		
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
  public static void main(String[] args)
  {
	  
	  Person p1 = new Person("Tom","O'Brien");
	  Person p2 = new Person("Alireza","Sadeghian");
	  Person p3 = new Person("Timothy","O'Brien");

	  System.out.println("Name = " + p1.getFullName());
	  System.out.println("Initials = " + p1.getInitials());
	  
	  System.out.println("Name = " + p2.getFullName());
	  System.out.println("Initials = " + p2.getInitials());
	  System.out.println("Expected:\nName = Tom O'Brien\nInitials = TO\nName = Alireza Sadeghian\nInitials = AS");

	  ArrayList<Person> people = new ArrayList<Person>();

	  if (findPerson(people, "Alireza", "Sadeghian"))
		  System.out.println("Alireza Sadeghian is in the array list");
	  else
		  System.out.println("Alireza Sadeghian is not in the array list");
	  System.out.println("Expected:\nAlireza Sadeghian is in the array list");
	  
	  people.add(p1);
	  people.add(p2);
	  people.add(p3);

	  if (findPerson(people, "Rick", "Valenzano"))
	  	System.out.println("Rick Valenzano is in the array list");
	  else
	  	System.out.println("Rick Valenzano is not in the array list");
	  System.out.println("Expected:\nRick Valenzano is not in the array list");

	  if (findPerson(people, "Alireza", "Sadeghian"))
		  System.out.println("Alireza Sadeghian is in the array list");
	  else
		  System.out.println("Alireza Sadeghian is not in the array list");
	  System.out.println("Expected:\nAlireza Sadeghian is in the array list");
  }
}
