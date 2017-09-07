package driver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import vehicle.Vehicle;
import vehicle.Bus;
import vehicle.Car;
import vehicle.Truck;

public class Demo {

	public static void main(String[] args) {
		final String[] names = { "Vasko", "Pesho", "Tisho", "Gosho", "Vankata", "Minka", "Tedo", "Pedo", "Vlado" };
		final String[] brands = { "BMW", "Toyota", "Golf", "Ferari", "Nissan" };

		GasStation gasStation = new GasStation(1000);

		System.out.println(gasStation.getVinetki()); // Task: 1
//		System.out.println(gasStation.getVinetki().size());

		HashSet<Driver> drivers = new HashSet<>();
		drivers = createDrivers(names, gasStation);

		ArrayList<Vehicle> vehicles = new ArrayList<>();
		vehicles = createVehicle(brands);
		
		for (Driver driver : drivers) { //Distributing the vehicles
			for (int i = 0; i < 10; i++) {
				driver.addVehicle(vehicles.remove(new Random().nextInt(vehicles.size())));
			}
		}
		
		buyVignettesForVehicles(drivers);
		
		printDrivers(drivers);
		
		System.out.println(gasStation.getVinetki().size());
	}

	public static void buyVignettesForVehicles(HashSet<Driver> drivers) {
		int count = 0;
		for (Driver driver : drivers) {
			count++;
			if (count % 3 == 0) {
				for (int i = 0; i < 5; i++) {
					int rng = new Random().nextInt(10);
					driver.buyVignette(rng);
				}
			}
			driver.buyVignette();
		}
	}
	
	public static HashSet<Driver> createDrivers(String[] names, GasStation gasStation) {
		HashSet<Driver> drivers = new HashSet<>();
		for (int i = 0; i < 20; i++) {
			drivers.add(new Driver(names[new Random().nextInt(names.length)], (new Random().nextInt(90000) + 1800),
					gasStation));
		}
		
		return drivers;
	}
	
	public static void printDrivers(HashSet<Driver> drivers) { //TODO: Enter date
		for (Driver d : drivers) {
			System.out.println("\nDriver's name: " + d.getName() + ", CARS:");
			for (Vehicle v : d.getVehicles()) {
				if (v instanceof Car) {
					System.out.println(v);
				}
			}
			System.out.println("Money: " + d.getMoney() + "\n");
		}
	}
	
	private static ArrayList<Vehicle> createVehicle(String[] brands) {
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			int rng = new Random().nextInt(3);
			
			switch (rng) {
			case 0:
				vehicles.add(new Car(brands[new Random().nextInt(brands.length)], (new Random().nextInt(45) + 1970)));
				break;
			case 1:
				vehicles.add(new Bus(brands[new Random().nextInt(brands.length)], (new Random().nextInt(45) + 1970)));
				break;
				
			case 2:
				vehicles.add(new Truck(brands[new Random().nextInt(brands.length)], (new Random().nextInt(45) + 1970)));
				break;
			}
		}
		
        return vehicles;
    }
}
