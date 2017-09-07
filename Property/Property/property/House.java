package property;

public class House extends Property{
	private int places;

	public House(String description, String address, int price, int area, IProperty type, int places) {
		super(description, address, price, area, type);
		this.places = places;
	}
}
