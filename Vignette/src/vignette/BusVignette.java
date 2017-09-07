package vignette;

import java.util.Date;

public class BusVignette extends Vignette{

	public BusVignette(Date date, Period expirationDate, int price) {
		super(date, "BLACK", expirationDate, price);
	}

	@Override
	public int stick() {
		return 20;
	}
}