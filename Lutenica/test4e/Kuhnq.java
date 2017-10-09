package test4e;

import java.util.HashMap;

import test4e.Baraka.Vegetable;

public class Kuhnq {

	private static final int MIN_CAP = 0;
	private static final int MAX_CAP = 30;
	
	private HashMap<Vegetable, Integer> tavi;
	
	public Kuhnq() {
		tavi = new HashMap<>();
		tavi.put(Vegetable.DOMAT, 0);
		tavi.put(Vegetable.CHUSHKA, 0);
		tavi.put(Vegetable.PATLADJAN, 0);
	}
	
	public synchronized void add(Vegetable v) {
		while (tavi.get(v) + 1 > MAX_CAP) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("OPAA");
			}
		}
		
		System.out.println("*Slojih " + v + " v tavata");
		tavi.put(v, tavi.get(v) + 1);
		notifyAll();
	}
	
	public synchronized void get(Vegetable v) {
		while (tavi.get(v) < 5) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("OPAA");
			}
			
			System.out.println("Vzeh " + v+ "ot tavata.");
			tavi.put(v, tavi.get(v) - 5);
			notifyAll();
		}
	}
}
