package property;


public class Plot extends Property{
	private boolean isInRegulation;

	public Plot(String description, String address, int price, int area,IProperty type, boolean isInRegulation) {
		super(description, address, price, area, type);
		this.isInRegulation = isInRegulation;
	}
}
