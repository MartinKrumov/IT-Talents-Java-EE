package test4e;

import java.util.Random;

import test4e.Baraka.Vegetable;

public class Momuk extends Person {
	
	private Baraka b;
	private Kuhnq k;
	private int obraboteno;
	private Pisar pisar;

	public Momuk(String name, Baraka b, Kuhnq k, Pisar pisar) {
		super(name, new Random().nextInt(11) + 15);
		
		this.b = b;
		this.k = k;
		this.obraboteno = 0;
		this.pisar = pisar;
	}

	@Override
	public void run() {
		while(true) {
			Vegetable v = Vegetable.values()[new Random().nextInt(Vegetable.values().length)];
			b.get(v);
			
			int sleepTime = 0;
			if (v.equals(Vegetable.DOMAT)) {
				sleepTime = 3000;
			} else if (v.equals(Vegetable.CHUSHKA)) {
				sleepTime = 6000;
			} else {
				sleepTime = 9000;
			}
			
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				System.err.println("Gurmej");
			}
			
			obraboteno += sleepTime / 1000;
			
			k.add(v);
			pisar.pishiFaila(getPersonName(), obraboteno);
		}
	}
	
	public int getObraboteno() {
		return obraboteno;
	}
	
	@Override
	public String toString() {
		return getPersonName() + " - " + getObraboteno();
	}
}