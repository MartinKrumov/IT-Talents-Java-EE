package rakia;

public class Rakidjiq extends Person implements Runnable {
	private float litri;

	public Rakidjiq(String name, int age) {
		super(name, age);
	}

	public float getLitri() {
		return this.litri;
	}

	public void setLitri(float litri) {
		if (litri > 0)
			this.litri = litri;
	}

	public void vari() {

		Kazan kazan = getSelo().daiPylenKazan();
		while (kazan == null) {
			try {
				synchronized (getSelo()) {
					getSelo().wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			kazan = getSelo().daiPylenKazan();
		}
		if (kazan != null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
			int kgDjibri = kazan.getKg();
			Fruit fruit = kazan.getFruit();
			float liters = (float) (Math.random() * kgDjibri);
			kazan.emptyKazan();
			synchronized (getSelo()) {
				getSelo().notifyAll();
			}

			if (fruit == null)
				fruit = Fruit.KAISIYA;

			getSelo().nqkoiSvariRakiq(this, fruit, liters);
			System.out
					.println("Az " + this.getName() + " svarih dnes " + liters + " litri rakiq ot " + fruit.toString());
		}
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("Pochvam da varq !");

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				return;
			}
			this.vari();
		}
	}
}
