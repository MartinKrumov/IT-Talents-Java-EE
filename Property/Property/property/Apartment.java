package property;

public class Apartment extends Property{
	private MaterialType matType;
	
	public Apartment(String description, String address, int price, int area, IProperty type, MaterialType matType) {
		super(description, address, price, area, type);
		this.matType = matType;
	}
	
}
