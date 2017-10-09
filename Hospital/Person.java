package hospital;

public abstract class Person {

	private String firstName;
	private String lastName;
	private String phone;
	public Person(String firstName, String lastName, String phone) {
		if(validString(firstName)){
			this.firstName = firstName;
		}
		if(validString(lastName)){
			this.lastName = lastName;
		}
		if(validString(phone)){
			this.phone = phone;
		}
	}
	
	private boolean validString(String s){
		return s != null && !s.isEmpty();
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public String toString() {
		return getFirstName() + " " + getLastName();
	}
	
}
