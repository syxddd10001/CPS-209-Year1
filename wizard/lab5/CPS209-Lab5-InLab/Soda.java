/**
 * A class for a Person object that stores the soda name, sugar content, and volume
 *
 * You should create the following methods:
 *     - Create a constructor that takes in the three class attributes
 *     - Create a getName method that returns the name
 *     - Create a getSugar method that returns the sugar content in grams
 *     - Create getVolume method that returns the sugar content in mL
 */
public class Soda
{
	/**
	 * name: name of the Soda
	 * sugar: number of grams of sugar in volume
	 * volume: volume of container
	 */
	private String name;
	private int sugar;
	private int volume;


	/**
      Create a constructor method with 3 parameters to initialize 
      the 3 instance variables (see SodaTester.java as a guide).
	  The order should of input should be name, sugar content, volume
	 */
	//-----------Start below here. To do: approximate lines of code = 4
	//
	public Soda(String name, int sugar, int volume)
	{
		this.name = name;
		this.sugar = sugar;
		this.volume = volume;

	}
	
	
	
	
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.


	/**
	 Create a public method getName() that returns the soda's name
	 */
	//-----------Start below here. To do: approximate lines of code = 2
	//
	public String getName()
	{
		return name;
	}
	
	
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

	/**
      Create a public method getSugar() that returns the amount of sugar
	 */
	//-----------Start below here. To do: approximate lines of code = 2
	//
	public int getSugar()
	{
		return sugar;
	}
	
	
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

	/**
	 Create a public method getVolume() method that returns volume
	 */
	//-----------Start below here. To do: approximate lines of code = 2
	//
	public int getVolume()
	{
		return volume;

	}
	
	
	
	//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	
}
