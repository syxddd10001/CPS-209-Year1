/**
 A class representing an instructor at a school. You are to complete the following:

 - Complete the constructor
 - Complete the toString method
 */
public class Instructor extends SchoolPerson
{
   private int salary;

   /**
      Create an instructor with a given name and date of birth and salary.
      @param name the name
      @param yearOfBirth the date of birth
      @param salary the salary
   */
   public Instructor(String name, int yearOfBirth, int salary)
   {
  	//-----------Start below here. To do: approximate lines of code = 2
  	// Initialize the inherited variables using super() and initialize
 	  // the new variable salary
  	super(name, yearOfBirth);
	this.salary = salary;	
  	
  	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
   }

   /**
      Convert instructor to string form.
   */
   public String toString()
   {
  	//-----------Start below here. To do: approximate lines of code = 1
  	// override the method toString() and return a string
 	  // containing the values of the inherited variables followed by
 	  // " Salary: " followed by salary. Hint: make use of super. 
  	return super.toString() + " Salary: " + salary;	
  	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
   }
}

