package torti.clients;

import torti.shop.CakeShop;

public class CorporativeClient extends Client {

	double discount = 0.1;
	
	public CorporativeClient(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CorporativeClient [discount=" + discount + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	@Override
	public void makeOrder(CakeShop shop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double giveBakshis(double suma) {
		// TODO Auto-generated method stub
		return suma*0.05;
	}


}
