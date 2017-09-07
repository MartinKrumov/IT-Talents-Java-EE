package angency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import client.Buyer;
import client.Seller;
import views.View;

public class Agent extends ContactInfo{
	private Set<Seller> sellers;
	private Set<Buyer> buyers;
	private List<View> views;
	
	public Agent(String name, String phoneNumber) {
		super(name, phoneNumber);
		this.sellers = new HashSet<>();
		this.buyers = new HashSet<>();
		this.views = new ArrayList<>();
	}

	public void addSeller(Seller s) {
		this.sellers.add(s);
	}
	
	public void addBuyers(Buyer b) {
		this.buyers.add(b);
	}
	
	public void addViews(View v) {
		this.views.add(v);
	}
	
	@Override
	public String toString() {
		return "Agent [" + super.toString() + "]";
	}
	
}
