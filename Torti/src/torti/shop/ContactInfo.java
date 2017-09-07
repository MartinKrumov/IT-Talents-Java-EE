package torti.shop;

import java.text.DecimalFormat;
import java.util.Random;

public abstract class ContactInfo {
	
	@Override
	public String toString() {
		return "ContactInfo [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

	private String name;
	private String phoneNumber;
	
	public ContactInfo(String name) {
		if(this.isValid(name))
		this.name = name;
		this.phoneNumber = this.generateRandomPhoneNumber();
	}

	public boolean isValid(String string) {
		return string!=null && !(string.equals(""));
	}
	
	private String generateRandomPhoneNumber() {
		Random rand = new Random();
        int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

        String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
        return phoneNumber;
	}
	
}
