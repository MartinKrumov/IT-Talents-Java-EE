package test4e;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import test4e.Baraka.Vegetable;

public class Baba extends Person {
	
	private Kuhnq k;
	private int koli4stvo;
	private List<Partida> kashon;
	private Pisar pisar;

	public Baba(String name, Kuhnq k, Pisar p) {
		super(name, new Random().nextInt(21) + 35);
		
		this.k = k;
		this.koli4stvo = 0;
		this.kashon = new ArrayList<>();
		this.pisar = p;
	}

	@Override
	public void run() {
		while(true) {
			k.get(Vegetable.CHUSHKA);
			k.get(Vegetable.DOMAT);
			k.get(Vegetable.PATLADJAN);
			
			try {
				Thread.sleep(10_000);
			} catch (InterruptedException e) {
				System.out.println("POAA");
			}
			
			int quantity = new Random().nextInt(10) + 3;
			koli4stvo += quantity;
			Partida p = new Partida("dneska", quantity);
			kashon.add(p);
			pisar.insertLutenica(p.getDate(), p.getQuantity(), this.getPersonName());
		}
	}
	
	public int getKoli4stvo() {
		return koli4stvo;
	}
	
	public List<Partida> getKashon() {
		return Collections.unmodifiableList(kashon);
	}
}