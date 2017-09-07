package torti.shop;

import java.util.ArrayList;
import java.util.List;

import torti.cakes.Cake;
import torti.clients.Client;

public class Order {

	public double getPrice() {
		return price;
	}

	public Client getClient() {
		return client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((orderedCakes == null) ? 0 : orderedCakes.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Order other = (Order) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (orderedCakes == null) {
			if (other.orderedCakes != null)
				return false;
		} else if (!orderedCakes.equals(other.orderedCakes))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	public Order(Client privateClient, ArrayList<Cake> list, double sumOfCakes) {
		this.client = client;
		this.orderedCakes = list;
		this.price = sumOfCakes;
	}

	private Client client;
	private double price;
	private String address;
	private List<Cake> orderedCakes;
	private String data;

}
