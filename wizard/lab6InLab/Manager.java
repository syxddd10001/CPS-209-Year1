
/**
   A class to model a manager. You are to complete the following tasks

 	- Complete the constructor
 	- Complete the toString method
 */
public class Manager extends Employee
{
	private String department;

	/**
      Make a manager with a given name, salary, and department.
      @param name the name
      @param salary the salary
      @param department the department
	 */
	public Manager(String name, double salary, String department)
	{
		//-----------Start below here. To do: approximate lines of code = 2
		// Initialize the inherited variables name and salary using the super() keyword
		// initialize the new instance variable department
		super(name, salary);
		this.department = department;
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}

	/**
      Provide a string description of a manager.
	 */
	
	public String toString()
	{
	//-----------Start below here. To do: approximate lines of code = 1
	// Override the method toString() from super class Employee
		//Hint: use the super. (see toString() method in Employee)
		// and add " Department: " followed by the department name to the returned string
		return super.toString() + " Department: " + department;
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	
}
