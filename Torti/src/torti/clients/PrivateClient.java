package torti.clients;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import torti.cakes.Cake;
import torti.shop.CakeShop;
import torti.shop.Order;

public class PrivateClient extends Client {

	private List<Integer> vouchers;
	
	public PrivateClient(String name) {
		super(name);
		vouchers = new ArrayList<Integer>();
	}
	
	public void addVoucher(int suma) {
		if ( suma >= 10 && suma <= 30 && vouchers.size() < 4)
		vouchers.add(suma);
	}

	@Override
	public String toString() {
		return "PrivateClient [vouchers=" + vouchers + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

	@Override
	public void makeOrder(CakeShop shop) {
		
		ArrayList<Cake> list = new ArrayList<Cake>();
		double sumOfCakes = 0.0;
		int random = new Random().nextInt(3) + 3;
		for (int i = 0; i < random; i++) {
			Cake c = shop.getRandomCake();
			list.add(c);
			sumOfCakes +=c.getPrice();
		}
		
		double otstypka = 0.0;
		for (int i = 0; i < this.vouchers.size(); i++) {
			otstypka +=this.vouchers.get(i);
		}
		
		double sumaZaZaplashtane = sumOfCakes - otstypka < 0 ? 0.0 : sumOfCakes - otstypka;
		Order order = new Order(this, list, sumOfCakes);
		shop.assignOrder(order, sumaZaZaplashtane);
		
		
		
	}

	@Override
	public double giveBakshis(double suma) {
		// TODO Auto-generated method stub
		return suma*0.02;
	}

}
