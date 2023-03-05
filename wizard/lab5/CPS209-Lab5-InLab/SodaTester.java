import java.util.ArrayList;

/**
 * Tests the Soda class. You also must complete the getMinSugar method.
 */
public class SodaTester
{
	/**
	 * Returns the Soda object from the list of sodas that has the minimum
	 * amount of sugar. Return null if the array list is empty.
	 * 
	 * @param sodas An array list of sodas
	 * @return The soda with the minimum sugar content
	 */
	public static Soda getMinSugar(ArrayList<Soda> sodas) {
		//-----------Start below here. To do: approximate lines of code = 5
		//
		if (sodas.size() == 0)
		{
			return null;
		}
		int minimum = sodas.get(0).getSugar();
		Soda s = sodas.get(0);

		

		
		for (Soda soda : sodas)
		{
			if (soda.getSugar() < minimum) 
			{
				minimum = soda.getSugar();
				s = soda;
			}
		
		}
		return s;
		
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
	public static void main(String[] args)
	{
		Soda coke  = new Soda("Coke", 35,355);
		Soda dietCoke = new Soda("Diet Coke", 23, 500);
		Soda pepsi = new Soda("Pepsi",42,355);
		
		System.out.println("Sugar in Coke: " + coke.getSugar() + " grams" );
		System.out.println("Expected:\nSugar in Coke: 35 grams");

		System.out.println("Sugar in Diet Coke: " + dietCoke.getSugar() + " grams" );
		System.out.println("Expected:\nSugar in Diet Coke: 23 grams");

		System.out.println("Sugar in Pepsi: " + pepsi.getSugar() + " grams" );
		System.out.println("Expected:\nSugar in Pepsi: 42 grams");

		System.out.println("Volume of Coke: " + coke.getVolume() + " mL" );
		System.out.println("Expected:\nVolume of Coke: 355 mL");

		System.out.println("Volume of Diet Coke: " + dietCoke.getVolume() + " mL" );
		System.out.println("Expected:\nVolume of Diet Coke: 500 mL");

		System.out.println("Volume of Pepsi: " + pepsi.getVolume() + " mL" );
		System.out.println("Expected:\nVolume of Pepsi: 355 mL");

		ArrayList<Soda> sodas = new ArrayList<Soda>();
		Soda minSoda = getMinSugar(sodas);

		if(minSoda == null) {
			System.out.println("The minimum sugar soda is null");
		} else {
			System.out.println("The minimum sugar soda is " + minSoda.getName());
		}
		System.out.println("Expected:\nThe minimum sugar soda is null");
		
		sodas.add(coke);
		sodas.add(dietCoke);
		sodas.add(pepsi);

		minSoda = getMinSugar(sodas);
		System.out.println("The minimum sugar soda is " + minSoda.getName());
		System.out.println("Expected:\nThe minimum sugar soda is Diet Coke");
	}
}
