package test4e;

import java.util.Random;

import test4e.Baraka.Vegetable;

public class Moma extends Person {
	
	private Baraka b;
	private int nabrano;
	private Pisar pisar;

	public Moma(String name, Baraka b, Pisar pisar) {
		super(name, new Random().nextInt(6) + 14);
		
		this.b = b;
		this.nabrano = 0;
		this.pisar = pisar;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("POAA");
			}
			
			int currentNabrano = new Random().nextInt(4) + 3;
			nabrano += currentNabrano;
			b.add(Vegetable.values()[new Random().nextInt(Vegetable.values().length)], currentNabrano);
		}
	}
	
	public int getNabrano() {
		return nabrano;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - " + nabrano;
	}
}
