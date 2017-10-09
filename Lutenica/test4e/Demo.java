package test4e;

import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		Baraka b = new Baraka();
		Kuhnq k = new Kuhnq();
		
		ArrayList<Moma> momi = new ArrayList<>();
		ArrayList<Momuk> momci = new ArrayList<>();
		ArrayList<Baba> babi = new ArrayList<>();
		
		Pisar pis = new Pisar("Kris", momi, momci, babi, b);
				
		for (int i = 0; i < 1; i++) {
			momi.add(new Moma("Moma" + i, b, pis));
			momci.add(new Momuk("momuk" + i, b, k, pis));
		}
		
		for (int i = 0; i < 3; i++) {
			babi.add(new Baba("Baba" + i, k, pis));
		}
		
		pis.setDaemon(true);
		pis.start();
		
		for (Moma m : momi) {
			m.start();
		}
		for (Momuk m : momci) {
			m.start();
		}
		for (Baba ba : babi) {
			ba.start();
		}
	}
}
