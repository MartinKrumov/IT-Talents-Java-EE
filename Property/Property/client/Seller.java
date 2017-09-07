package client;

import java.util.Random;

import angency.Agency;
import angency.Agent;
import property.*;

public class Seller extends Client{
	private Property property;

	public Seller(String name, String phoneNumber, Property property) {
		super(name, phoneNumber);
		addProperty(property);
	}
	
	public void addProperty(Property property) {
		if (property != null) {
			this.property = property;
		}
	}
	
	public void registerProperty(Agency agency) {
		int random = new Random().nextInt(agency.getAgents().size());
		Agent randomAgent = agency.getAgents().get(random);
		
		agency.addAdvert(property); //added in the advert
		randomAgent.addSeller(this); //adding in the list of sellers
		this.property.setAgent(randomAgent); //set agent for the property
	}
	
	
}
