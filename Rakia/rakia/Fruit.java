package rakia;

public enum Fruit {
	SLIVA("Sliva"), GROZDE("Grozde"), KAISIYA("Kaisiya");

	public String getName() {
		return name;
	}

	private String name;

	private Fruit(String name) {
		this.name = name;
	}
}
