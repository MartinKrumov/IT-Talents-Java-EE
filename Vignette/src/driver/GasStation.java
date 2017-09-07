package driver;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import vehicle.*;
import vignette.*;

public class GasStation {
	private int money;
	private List<Vignette> vinetki;

	public GasStation(int money) {
		if (money > 0) {
			this.money = money;
		}
		this.vinetki = new ArrayList<>();
		generateVignette();
	}

	public void generateVignette() {
		for (int i = 0; i < 10000; i++) {
			int rng = new Random().nextInt(3);

			Vignette vinetka;
			Period expirationDate;
			Date date;

			int price = 0;
			int typeOfVinetka = new Random().nextInt(3);

			switch (rng) {
			case 0:
				date = new Date((new Random().nextInt(25) + 90), (new Random().nextInt(12) + 1),
						(new Random().nextInt(31) + 1));
				price = 5;

				if (typeOfVinetka == 0) {
					expirationDate = Period.ONE_DAY;
				} else if (typeOfVinetka == 1) {
					expirationDate = Period.ONE_MOUNT;
					price = price * 7 * 10;
				} else {
					expirationDate = Period.ONE_YEAR;
					price = price * 7 * 10 * 6;
				}

				vinetka = new CarVignette(date, expirationDate, price);
				this.vinetki.add(vinetka);
				break;

			case 1:
				date = new Date((new Random().nextInt(25) + 90), (new Random().nextInt(12) + 1),
						(new Random().nextInt(31) + 1));
				price = 7;

				if (typeOfVinetka == 0) {
					expirationDate = Period.ONE_DAY;

				} else if (typeOfVinetka == 1) {
					expirationDate = Period.ONE_MOUNT;
					price = price * 7 * 10;
				} else {
					expirationDate = Period.ONE_YEAR;
					price = price * 7 * 10 * 6;
				}

				vinetka = new BusVignette(date, expirationDate, price);
				this.vinetki.add(vinetka);
				break;

			case 2:
				date = new Date((new Random().nextInt(25) + 90), (new Random().nextInt(12) + 1),
						(new Random().nextInt(31) + 1));
				price = 9;

				if (typeOfVinetka == 0) {
					expirationDate = Period.ONE_DAY;

				} else if (typeOfVinetka == 1) {
					expirationDate = Period.ONE_MOUNT;
					price = price * 7 * 10;
				} else {
					expirationDate = Period.ONE_YEAR;
					price = price * 7 * 10 * 6;
				}

				vinetka = new TruckVignette(date, expirationDate, price);
				this.vinetki.add(vinetka);
				break;
			}
		}
		Collections.sort(this.vinetki, (v1, v2) -> v1.getPrice() - v2.getPrice());
	}

	// public Date calcDate(Date d, int days) {
	// Calendar cal = Calendar.getInstance();
	// cal.setTime(d);
	// cal.add(Calendar.DATE, days);
	// return cal.getTime();
	// }

	public Vignette saleVignette(String vehicleType, Period period) {
		Vignette vinetka = null;
		if (vehicleType.equalsIgnoreCase("Car")) {
			for (Vignette v : vinetki) {
				if (v instanceof CarVignette && v.getExpirationDate() == period) {
					vinetka = v;
					this.vinetki.remove(v);
					break;
				}
			}
		} else if (vehicleType.equalsIgnoreCase("Bus")) {
			for (Vignette v : vinetki) {
				if (v instanceof BusVignette && v.getExpirationDate() == period) {
					vinetka = v;
					this.vinetki.remove(v);
					break;
				}
			} 
		}else if (vehicleType.equalsIgnoreCase("Truck")) {
			for (Vignette v : vinetki) {
				if (v instanceof BusVignette && v.getExpirationDate() == period) {
					vinetka = v;
					this.vinetki.remove(v);
					break;
				}
			}
		}
		
		Collections.sort(this.vinetki, (v1, v2) -> v1.getPrice() - v2.getPrice());
		return vinetka;
	}

	public void addMoney(int money) {
		this.money += money;
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public List<Vignette> getVinetki() {
		return vinetki;
	}

	public void setVinetki(List<Vignette> vinetki) {
		this.vinetki = vinetki;
	}

	@Override
	public String toString() {
		return "GasStation [money=" + money + ", vinetki=" + vinetki + "]";
	}

}
