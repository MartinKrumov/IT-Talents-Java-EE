package vignette;

import java.util.Date;

public abstract class Vignette {
	private Date date;
	private String color;
	private Period expirationDate;
	private int price;

	public Vignette(Date date, String color, Period expirationDate, int price) {
		this.date = date;
		if (isValidString(color)) {
			this.color = color;
		}
		this.expirationDate = expirationDate;
		if (price > 0) {
			this.price = price;
		}
	}

	public int getPrice() {
		return price;
	}

	
	public Period getExpirationDate() {
		return expirationDate;
	}

	public boolean isValidString(String str) {
		return str != null && !str.isEmpty();
	}
	
	abstract public int stick();

	@Override
	public String toString() {
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		String sDate= sdf.format(date);
//		String exDate= sdf.format(expirationDate);
		
		return "Vignette [ price = " + price +", " + "color = " + color + "]";
	}
	
	

}
