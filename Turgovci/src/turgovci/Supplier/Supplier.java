package turgovci.Supplier;

import turgovci.Trader.Info;

public abstract class Supplier extends Info{
	private int wornkingHours;
	private int money;
	
	public Supplier(String name, String address, int wornkingHours) {
		super(name, address);
		this.wornkingHours = wornkingHours;
	}
	
	public void addMoney(int money) {
		this.money += money;
	}
	
	public int completeSupply(int amount) {
		if (this instanceof Wholesale) {
			int money = (int)(amount - amount * 0.15);
			this.addMoney(money);
			return (int)(amount * 0.15);
		} else {
			this.addMoney(amount);
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Supplier [name = "+ super.getName() + ", address = " + super.getAddress() + "wornkingHours=" + wornkingHours + "money = " + money + "]";
	}
}
