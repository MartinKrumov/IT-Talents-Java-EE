package views;

import java.util.Date;

import angency.Agent;
import client.Buyer;
import property.Property;

public class View {
	private Property property;
	private Agent agent;
	private Buyer buyer;
	private Date date; // when the view happened;
	
	public View(Property property, Agent agent, Buyer buyer, Date date) {
		this.property = property;
		this.agent = agent;
		this.buyer = buyer;
		this.date = date;
	}

	public Property getProperty() {
		return property;
	}

	public Agent getAgent() {
		return agent;
	}

	public Buyer getBuyer() {
		return buyer;
	}
	
}
