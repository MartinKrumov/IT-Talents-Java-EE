package angency;

public abstract class ContactInfo {
	private String name;
	private String phoneNumber;

	public ContactInfo(String name, String phoneNumber) {
		if (isValidString(name))
			this.name = name;

		if (isValidString(phoneNumber))
			this.phoneNumber = phoneNumber;
	}

	public boolean isValidString(String str) {
		return str != null && !str.isEmpty();
	}

	@Override
	public String toString() {
		return "name = " + name + ", phoneNumber = " + phoneNumber;
	}
}
