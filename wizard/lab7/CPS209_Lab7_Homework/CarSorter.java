import java.util.ArrayList;
import java.util.Collections;

public class CarSorter 
{
	public static void main(String[] args)
	{
		ArrayList<Car>  cars = new ArrayList<Car>();

		Car car;

		car = new Car("BMW",5/100.0); // 5 Liters per 100 KM
		car.addGas(20.0); // 20 Liters
		cars.add(car);

		car = new Car("Audi",12/100.0); // 5 Liters per 100 KM
		car.addGas(10.0); // 20 Liters
		cars.add(car);

		car = new Car("Mercedes",1/100.0); // 5 Liters per 100 KM
		car.addGas(50.0); // 20 Liters
		cars.add(car);

		car = new Car("Prius",25/100.0); // 5 Liters per 100 KM
		car.addGas(25.0); // 20 Liters
		cars.add(car);

		car = new Car("Corolla",17/100.0); // 5 Liters per 100 KM
		car.addGas(43.0); // 20 Liters
		cars.add(car);

		System.out.println("Initial Order: " + cars);

		System.out.println("\n--- TEST 1: Sort by efficiency");
		Collections.sort(cars);

		System.out.println("OUTPUT:   " + cars);
		System.out.println("EXPECTED: [(Mercedes, Gas: 50.0, Eff: 0.01), (BMW, Gas: 20.0, Eff: 0.05), (Audi, Gas: 10.0, Eff: 0.12), (Corolla, Gas: 43.0, Eff: 0.17), (Prius, Gas: 25.0, Eff: 0.25)]");
	}

}
