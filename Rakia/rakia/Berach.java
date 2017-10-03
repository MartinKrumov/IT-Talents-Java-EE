package rakia;

public class Berach extends Person implements Runnable {

	private static final int MIN_FOR_VARENE_RAKIQ = 10;
	private Fruit fruit;

	public Berach(String name, int age) {
		super(name, age);
		this.fruit = Fruit.SLIVA;
	}

	public void beri() {
		Kazan kazan = getSelo().daiKazan(this.fruit);
		while (kazan == null) {
			try {
				synchronized (getSelo()) {
					getSelo().wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			kazan = getSelo().daiKazan(this.fruit);
		}
		int kg = (int) (Math.random() * 10);
		kazan.addFruit(this.fruit, kg);
		if (kazan.getKg() >= MIN_FOR_VARENE_RAKIQ) {
			synchronized (getSelo()) {
				getSelo().notifyAll();
			}
		}
		getSelo().nqkoiNabraPlodove(this.fruit, kg);
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("Pochvam da bera !");

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				return;
			}
			this.beri();
		}
	}
}
