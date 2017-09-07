package instruments;

public abstract class Instrument {

	protected enum InstrumentType { KLAVIRNI, STRUNNI, UDARNI, DUHOVI, ELEKTRONNI; }
	
	private String name;
	private double price;
	private int quantity;
	private InstrumentType type;
	
	public Instrument(String name, double price, int quantity, InstrumentType type) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void decreaseQuantity(int q){
		this.quantity-=q;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void increaseQuantity(int q){
		this.quantity+=q;
	}

	@Override
	public String toString() {
		return "Instrument [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
	
}
