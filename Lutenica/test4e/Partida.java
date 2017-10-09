package test4e;

public class Partida {

	private String date;
	private int quantity;
	
	public Partida(String date, int quantity) {
		this.date = date;
		this.quantity = quantity;
	}
	
	public String getDate() {
		return date;
	}
	
	public int getQuantity() {
		return quantity;
	}
}