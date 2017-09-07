package torti.clients;

import torti.shop.CakeShop;
import torti.shop.ContactInfo;

public abstract class Client extends ContactInfo{

	public Client(String name) {
		super(name);
	}
	
	public abstract void makeOrder(CakeShop shop);
	public abstract double giveBakshis(double suma);

}
