package vinetki;

public enum VinetkaType {
	
	WEEKLY_CAR("green", 10), WEEKLY_BUS("blue", 10), WEEKLY_TRUCK("red", 10), 
	ANNUAL_CAR("green", 90), ANNUAL_BUS("blue", 90), ANNUAL_TRUCK("red", 90),
	MONTHLY_CAR("green", 25), MONTHLY_BUS("blue", 25), MONTHLY_TRUCK("red", 25);

	private String color;
	private int price;
	
	VinetkaType(String color, int price){
		this.color = color;
		this.price = price;
	}
	
	public int stickyTime(){
		return price*4;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getColor() {
		return color;
	}

}
