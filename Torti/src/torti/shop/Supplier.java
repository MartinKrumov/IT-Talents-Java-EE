package torti.shop;

import java.util.HashSet;
import java.util.Set;

public class Supplier extends ContactInfo{

	//TO DO what should be the set
	private Set<Order> orders;
	private double bakshish;
	
	public Supplier(String name) {
		super(name);
		orders = new HashSet<Order>();
	}
	
	public void addOrder(Order o) {
		this.orders.add(o);
	}
	
	public void executeOrder(Order o) {
		this.bakshish += o.getClient().giveBakshis(o.getPrice());
	}
	

}
