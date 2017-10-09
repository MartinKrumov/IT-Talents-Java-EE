package test4e;

import java.util.HashMap;

public class Baraka {

	public enum Vegetable {DOMAT, CHUSHKA, PATLADJAN}
	
	private static final int MIN_CAP = 0;
	private static final int MAX_CAP = 40;
	private int nabranoDomati;
	private int nabranoChuski;
	private int nabranoPatladjani;
	
	private HashMap<Vegetable, Integer> koshnica;
	
	public Baraka() {
		koshnica = new HashMap<>();
		koshnica.put(Vegetable.DOMAT, 0);
		koshnica.put(Vegetable.CHUSHKA, 0);
		koshnica.put(Vegetable.PATLADJAN, 0);
		this.nabranoDomati = 0;
		this.nabranoChuski = 0;
		this.nabranoPatladjani = 0;
	}

	public synchronized void add(Vegetable v, int count) {
		while (koshnica.get(v) + count > MAX_CAP) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("OPAA");
			}
		}
		
		if (v.equals(Vegetable.DOMAT)) {
			nabranoDomati += count;
		} else if (v.equals(Vegetable.CHUSHKA)) {
			nabranoChuski += count;
		} else {
			nabranoPatladjani += count;
		}
		
		System.out.println("**Slojih " + count + " " + v + " v koshnicata");
		koshnica.put(v, koshnica.get(v) + count);
		notifyAll();
	}
	
	public synchronized void get(Vegetable v) {
		while (koshnica.get(v) < 1) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("OPAA");
			}
			
			System.out.println("Vzeh " + v + " ot koshnicata.");
			koshnica.put(v, koshnica.get(v) - 1);
			notifyAll();
		}
	}
	
	public Vegetable getNaiNabrano() {
		if (nabranoChuski >= nabranoDomati && nabranoChuski >= nabranoPatladjani) {
			return Vegetable.CHUSHKA;
		}
		
		if (nabranoDomati >= nabranoDomati && nabranoDomati >= nabranoPatladjani) {
			return Vegetable.DOMAT;
		}
		
		return Vegetable.PATLADJAN;
	}
}
