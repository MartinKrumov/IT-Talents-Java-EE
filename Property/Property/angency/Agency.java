package angency;

import java.util.ArrayList;
import java.util.List;

import property.Property;

public class Agency extends ContactInfo {
	private String address;
	private List<Agent> agents;
	private List<Property> adverts; 
	private int budget;

	public Agency(String name, String phoneNumber, String address) {
		super(name, phoneNumber);
		if (isValidString(address)) {
			this.address = address;
		}
		this.adverts = new ArrayList<>();
		this.agents = new ArrayList<>();
	}
	
	public void addAgents(List<Agent> agents) {
		this.agents.addAll(agents);
	}
	
	public void addAdvert(Property p) {
		this.adverts.add(p);
	}
	
	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	
	public void takeComision(int money) {
		this.budget += money;
	}

	@Override
	public String toString() {
		return "Agency [address=" + address + ", agents=" + agents + ", adverts=" + adverts + ", "
				+ super.toString() + "]";
	}
	
}
