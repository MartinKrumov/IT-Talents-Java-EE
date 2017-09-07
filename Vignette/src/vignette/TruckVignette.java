package vignette;

import java.util.Date;

public class TruckVignette extends Vignette {

	public TruckVignette(Date date, Period expirationDate, int price) {
		super(date, "RED", expirationDate, price);
	}

	@Override
	public int stick() {
		return 10;
	}
}
