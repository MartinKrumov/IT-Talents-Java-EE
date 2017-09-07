package angency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import client.Buyer;
import client.Seller;
import property.Apartment;
import property.House;
import property.IProperty;
import property.IProperty.ApartmentType;
import property.IProperty.HouseType;
import property.IProperty.PlotType;
import property.MaterialType;
import property.Plot;
import property.Property;

public class Demo {

	static final String[] NAMES = { "Bojo", "Pepo", "Nick", "Jon", "Cris", "Qna", "Kari", "Cveta", "Joro", "Vankata",
			"Petar", "Tedi" };
	static final String[] ADDRESSES = { "Mladost", "Lulin", "Nadejda", "Iztok" };

	public static void main(String[] args) {
		Agency agenciq = new Agency("Talanti", "0895465241", "Mladost");
		List<Agent> agents = createAgents();
		agenciq.addAgents(agents);

		System.out.println(agenciq);

		Set<Property> properties = createProperty();

		Set<Seller> sellers = createSellers(properties);
		System.out.println(sellers);
		System.out.println("---------------------");

		for (Seller s : sellers) {
			s.registerProperty(agenciq);
		}

		Set<Buyer> buyers = createBuyers();

		// 5.Всички купувачи да регистрират заявки за търсене на имот към
		// агенцията
		for (Buyer b : buyers) {
			b.register(agenciq);
		}

		// 6. Всеки купувач да заяви 3 огледа на произволни имоти от агенцията;
		for (Buyer b : buyers) {
			for (int i = 0; i < 3; i++) {
				if (!b.makeView(getRandomProperty(properties))) {
					i--;
				}
			}
		}

	}

	// Да се създадат 10 купувача на произволен принцип с бюджети между 30 000 и
	// 150 000 евро;
	static Set<Buyer> createBuyers() {
		Set<Buyer> buyers = new HashSet<>();

		for (int i = 0; i < 10; i++) {
			buyers.add(new Buyer(NAMES[new Random().nextInt(NAMES.length)], "078965421" + i,
					(new Random().nextInt(120000) + 30000)));
		}

		return buyers;
	}

	static List<Agent> createAgents() {
		ArrayList<Agent> agents = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			agents.add(new Agent(NAMES[new Random().nextInt(NAMES.length)], "0876445678" + i));
		}
		return agents;
	}

	// Да се създадат 30 продавача на имоти
	static Set<Seller> createSellers(Set<Property> properties) {
		HashSet<Seller> sellers = new HashSet<>();

		for (int i = 0; i < 30; i++) {
			sellers.add(new Seller(NAMES[new Random().nextInt(NAMES.length)], ("08766998" + i),
					getRandomProperty(properties)));
		}
		return sellers;
	}

	public static Property getRandomProperty(Set<Property> properties) { // TODO:
		Property prop = null;
		while (prop != null) {
			int index = new Random().nextInt(properties.size());

			for (Property p : properties) {
				if (index == 0) {
					prop = p;
				}
				index--;
			}
		}
		return prop;
	}

	public static Set<Property> createProperty() {
		Set<Property> props = new HashSet<>();

		for (int i = 0; i < 30; i++) {
			int rng = new Random().nextInt(3);

			IProperty propertyType;
			String address = ADDRESSES[new Random().nextInt(ADDRESSES.length)];

			switch (rng) {
			// Apartment
			case 0:
				propertyType = ApartmentType.values()[new Random().nextInt(ApartmentType.values().length)];
				props.add(new Apartment("Aparatament", address, (new Random().nextInt(80001) + 70000),
						new Random().nextInt(100), propertyType,
						MaterialType.values()[new Random().nextInt(MaterialType.values().length)]));
				break;
			// House
			case 1:
				propertyType = HouseType.values()[new Random().nextInt(HouseType.values().length)];
				props.add(new House("House", address, (new Random().nextInt(50001) + 30000), new Random().nextInt(100),
						propertyType, new Random().nextInt(10)));
				break;
			// Plot
			case 2:
				propertyType = PlotType.values()[new Random().nextInt(PlotType.values().length)];
				props.add(new Plot("Plot", address, (new Random().nextInt(55001) + 30000), new Random().nextInt(100),
						propertyType, new Random().nextBoolean()));
				break;
			}
		}
		return props;
	}

}
