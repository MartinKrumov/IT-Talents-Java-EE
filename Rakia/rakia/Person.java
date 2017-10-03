package rakia;

public abstract class Person {
	private String name;
	private int age;
	private static Selo selo;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public static Selo getSelo() {
		return Selo.getInstance();
	}

	public static void setSelo(Selo selo) {
		Person.selo = selo;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
