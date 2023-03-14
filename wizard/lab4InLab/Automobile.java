/**
   The below class defines an Automobile object. Automobiles have a certain fuel
   efficiency (measured in km/liters) and a certain amount of fuel in the gas
   tank measured in liters.

   Complete the Automobile class as follows:

   - The efficiency should be initialized in the constructor via a parameter
   - The initial fuel level should be set to 0
   - Complete the "drive" method which simulates the driving of the automobile
     for a given distance by reducing the gasoline according to the efficiency
   - Complete method "getGasInTank" to get the amount of gas in the tank
   - Complete method "addGas" which adds fuel to the tank

   See AutomobileTester for details on how the class is used

 Difficulty: Easy
 */
public class Automobile
{  
	private double efficiency ; // kilometers per liter
	private double fuel ; // amount of gas in the tank
	/**
       Initialize inastance variables zero fuel and the given efficiency kmPerLiter
       @param kmPerLiter
	 */
	public Automobile(double kmPerLiter)
	{   
		//-----------Start below here. To do: approximate lines of code = 2
		// set the instance variable fuel to zero; 
		fuel = 0;

		//2. set efficiency to the parameter value
		efficiency = kmPerLiter;
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}

	/**
       Drives the automobile the given distance
       @param distance
	 */
	public void drive(double distance)
	{  
		//-----------Start below here. To do: approximate lines of code = 2
		// 1. calculate the gas used in going that distance 
		// i.e. divide distance by efficiency, update fuel accordingly
		double gas;
		gas = distance/efficiency;
		//2. update the fuel instance variable (fule should decrease)
		fuel -= gas; 
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}

	/**
       Puts fuel in the automobile.
       @param amount the amount of gas added
	 */
	public void addGas(double amount)
	{   
		//-----------Start below here. To do: approximate lines of code = 1
		// update the fuel variable
		fuel += amount;
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}

	/**
       Gets the current fuel level of the automobile.
       @return the current fuel level
	 */
	public double getGasInTank()
	{   
		//-----------Start below here. To do: approximate lines of code = 1
		// return the current fuel level
		return fuel;		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
}



