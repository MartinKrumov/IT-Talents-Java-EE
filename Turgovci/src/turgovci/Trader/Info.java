package turgovci.Trader;

public abstract class Info {
	private String name;
	private String address;
	
	public Info(String name, String address) {
		if (isValidString(name)) {
			this.name = name;
		}
		if (isValidString(address)) {
			this.address = address;
		}
	}
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	protected boolean isValidString(String str) {
		return str != null && !str.isEmpty();
	}
}
