package vehicle;

import vignette.Vignette;

public abstract class Vehicle {
	private String model;
	private Vignette vinetka;
	private int yearOfProduction;
	
	public Vehicle(String model, int yearOfProduction) {
		if (model != null && !model.isEmpty()) {
			this.model = model;
		}
		if (yearOfProduction > 1945) {
			this.yearOfProduction = yearOfProduction;
		} 
	}

	public Vignette getVinetka() {
		return vinetka;
	}

	public void setVinetka(Vignette vinetka) {
		if (vinetka != null) {
			this.vinetka = vinetka;
		} else {
			System.out.println("Invalid Vignette.");
		}
	}

	@Override
	public String toString() {
		return "Vehicle [model=" + model + ", vinetka=" + vinetka + ", yearOfProduction=" + yearOfProduction + "]";
	}
	
	
}
