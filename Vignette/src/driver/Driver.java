package driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import vehicle.Bus;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;
import vignette.Period;
import vignette.Vignette;

public class Driver {
	private String name;
	private List<Vehicle> vehicles;
	private int money;
	private GasStation gasStation;
	
	public Driver(String name, int money, GasStation gasStation) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
		this.vehicles = new ArrayList<>();
		this.money = money;
		this.gasStation = gasStation;
	}
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void addVehicle(Vehicle v) {
		this.vehicles.add(v);
	}
	
	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}

	public void buyVignette(int randomVehicle) { 
//		randomVehicle = new Random().nextInt(this.vehicles.size());
		
		if (this.vehicles.get(randomVehicle) instanceof Car) {
			Vignette vin = this.gasStation.saleVignette("Car", Period.values()[new Random().nextInt(Period.values().length)]);
			this.money -= vin.getPrice();
			this.vehicles.get(randomVehicle).setVinetka(vin);
		} else if (this.vehicles.get(randomVehicle) instanceof Bus) {
			Vignette vin = this.gasStation.saleVignette("Bus", Period.values()[new Random().nextInt(Period.values().length)]);
			this.money -= vin.getPrice();
			this.vehicles.get(randomVehicle).setVinetka(vin);
		} else if (this.vehicles.get(randomVehicle) instanceof Truck) {
			Vignette vin = this.gasStation.saleVignette("Truck", Period.values()[new Random().nextInt(Period.values().length)]);
			this.money -= vin.getPrice();
			this.vehicles.get(randomVehicle).setVinetka(vin);
		} else {
			System.out.println("The vignette you want to buy is out of stock.");
		}
	}
	
	public void buyVignette() {
		for (Vehicle vehicle : vehicles) {
			if (vehicle instanceof Car) {
				Vignette vin = this.gasStation.saleVignette("Car", Period.values()[new Random().nextInt(Period.values().length)]);
				this.money -= vin.getPrice();
				vehicle.setVinetka(vin);
			} else if (vehicle instanceof Bus) {
				Vignette vin = this.gasStation.saleVignette("Bus", Period.values()[new Random().nextInt(Period.values().length)]);
				this.money -= vin.getPrice();
				vehicle.setVinetka(vin);
			} else if (vehicle instanceof Truck) {
				Vignette vin = this.gasStation.saleVignette("Truck", Period.values()[new Random().nextInt(Period.values().length)]);
				this.money -= vin.getPrice();
				vehicle.setVinetka(vin);
			}
		}
	}
	
}
