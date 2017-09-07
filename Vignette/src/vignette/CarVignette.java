package vignette;

import java.util.Date;

public class CarVignette extends Vignette{

	public CarVignette(Date date, Period expirationDate, int price) {
		super(date, "GREEN", expirationDate, price);
	}

	@Override
	public int stick() {
		return 5;
	}

}
