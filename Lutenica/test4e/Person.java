package test4e;

public abstract class Person extends Thread {

	private String name;
	private int age;
	
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public String getPersonName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}
