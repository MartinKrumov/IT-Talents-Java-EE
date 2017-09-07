package client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import angency.Agency;
import angency.Agent;
import property.Property;
import views.View;

public class Buyer extends Client{
	private int money;
	private List<View> views;
	Agent agent;
	
	public Buyer(String name, String phoneNumber, int money) {
		super(name, phoneNumber);
		if (money > 0) {
			this.money = money;
		}
		this.views = new ArrayList<>();
	}
	
	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public void register(Agency agency) {
		int rng = new Random().nextInt(agency.getAgents().size());
		Agent randomAgent = agency.getAgents().get(rng);
		
		randomAgent.addBuyers(this);
		this.agent = randomAgent;
	}
	
	public boolean makeView(Property property) {
		if (money < property.getPrice()) {
			return false;
		} else {
		Date date = new Date((new Random().nextInt(25) + 90), (new Random().nextInt(12) + 1),
				(new Random().nextInt(31) + 1));
		
		View view = new View(property, this.agent, this, date);
		this.views.add(view);
		this.agent.addViews(view);
		}
		return true;
	}
	
	public void propertyPurchase(Property property, Agency agency) { //TODO: 
		boolean isChecked = false;
		for (View v : views) {
			if (v.getProperty().equals(property)) {
				isChecked = true;
			}
		}
		
		if (isChecked) {
			int comisions = (int)(property.getPrice() - property.getPrice() * 0.03);
			agency.takeComision(this.money - comisions);
		}
	}
}
