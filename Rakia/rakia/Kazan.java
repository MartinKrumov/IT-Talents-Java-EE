package rakia;

public class Kazan {
	private Fruit fruit = null;
	private int kg = 0;

	public void addFruit(Fruit fruit, int kg) {
		if (this.fruit == null) {
			this.fruit = fruit;
		} else {
			if (fruit.equals(this.fruit)) {
				this.kg += kg;
			}
		}
	}

	public void emptyKazan() {
		this.fruit = null;
		this.kg = 0;
	}

	public Fruit getFruit() {
		return fruit;
	}

	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}

	public int getKg() {
		return kg;
	}

	public void setKg(int kg) {
		this.kg = kg;
	}
}
