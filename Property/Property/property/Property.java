package property;

import angency.Agent;

public abstract class Property {
	private String description;
	private String address;
	private int price;
	private int area;
	private Agent agent;
	private IProperty type;


	public Property(String description, String address, int price, int area, IProperty type) {
		if (isValidString(description)) {
			this.description = description;
		}
		if (isValidString(address)) {
			this.address = address;
		}
		if (price > 0) {
			this.price = price;
		}
		if (area > 0) {
			this.area = area;
		}

		this.type = type;
	}

	public boolean isValidString(String str) {
		return str != null && !str.isEmpty();
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Property [description=" + description + ", address=" + address + ", price=" + price + ", area=" + area
				+ ", agent=" + agent + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + area;
		result = prime * result + price;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (area != other.area)
			return false;
		if (price != other.price)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
}
