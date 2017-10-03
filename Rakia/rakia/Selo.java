package rakia;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class Selo {
	private static final int MIN_KOLICHESTVO_PLODOVE_ZA_DA_MOJE_ONQ_DA_VARI_RAKIQ = 10;
	private static final int MAX_NUMBER_OF_KAZANS = 5;
	private List<Kazan> kazani = new ArrayList<Kazan>();

	private Set<Berach> berachiByAge = new TreeSet<Berach>((b1, b2) -> b1.getAge() - b2.getAge());
	private Set<Rakidjiq> rakidjiiByName = new TreeSet<Rakidjiq>((r1, r2) -> r1.getName().compareTo(r2.getName()));
	private Set<Rakidjiq> rakidjiiByLitri = new TreeSet<Rakidjiq>((r1, r2) -> {
		if (r1.getLitri() == r2.getLitri()) {
			return r1.getName().compareTo(r2.getName());
		}
		return (int) (r1.getLitri() * 200 - r2.getLitri() * 200);
	});

	private Map<Fruit, Integer> plodoveCount = new ConcurrentHashMap<Fruit, Integer>();
	private Map<Fruit, Float> litriRakiya = new ConcurrentHashMap<Fruit, Float>();

	private static Selo instance = null;

	private Selo() {
		synchronized (this) {
			plodoveCount.put(Fruit.GROZDE, 0);
			plodoveCount.put(Fruit.KAISIYA, 0);
			plodoveCount.put(Fruit.SLIVA, 0);

			litriRakiya.put(Fruit.GROZDE, 0.0f);
			litriRakiya.put(Fruit.KAISIYA, 0.0f);
			litriRakiya.put(Fruit.SLIVA, 0.0f);

			for (int count = 1; count <= MAX_NUMBER_OF_KAZANS; count++) {
				kazani.add(new Kazan());
			}
		}
	}

	public String naiBranPlod() {
		int max = -3;
		Fruit maxFruit = null;
		for (Fruit fruit : plodoveCount.keySet()) {
			if (plodoveCount.get(fruit) > max) {
				max = plodoveCount.get(fruit);
				maxFruit = fruit;
			}
		}

		return maxFruit.getName();
	}

	public String rakiqSNaiMnogoLitri() {
		float max = 0;
		Fruit maxFruit = null;
		for (Fruit fruit : litriRakiya.keySet()) {
			if (litriRakiya.get(fruit) > max) {
				max = plodoveCount.get(fruit);
				maxFruit = fruit;
			}
		}

		return maxFruit.getName();
	}

	public static Selo getInstance() {
		synchronized (Selo.class) {
			if (instance == null) {
				instance = new Selo();
			}
		}
		return instance;
	}

	public void nqkoiNabraPlodove(Fruit fruit, int kg) {
		int kgDosega = this.plodoveCount.get(fruit);
		this.plodoveCount.put(fruit, kgDosega + kg);
	}

	public void nqkoiSvariRakiq(Rakidjiq r, Fruit fruit, float liters) {
		synchronized (rakidjiiByLitri) {
			float stariLitri = r.getLitri();
			rakidjiiByLitri.remove(r);
			r.setLitri(stariLitri + liters);
			rakidjiiByLitri.add(r);
		}

		if (fruit == null)
			fruit = Fruit.SLIVA;
		float ltDosega = this.litriRakiya.get(fruit);
		this.litriRakiya.put(fruit, ltDosega + liters);
	}

	public void addBerach(Berach b) {
		if (b != null) {
			synchronized (berachiByAge) {
				berachiByAge.add(b);
			}
		}
	}

	public void addRakidjiq(Rakidjiq r) {
		if (r != null) {
			synchronized (rakidjiiByLitri) {
				rakidjiiByLitri.add(r);
			}

			synchronized (rakidjiiByName) {
				rakidjiiByName.add(r);
			}
		}
	}

	public Kazan daiKazan(Fruit fruit) {
		for (Kazan kazan : this.kazani) {
			if (kazan.getFruit() == null || kazan.getFruit().equals(fruit)) {
				return kazan;
			}
		}

		return null;
	}

	public Kazan daiPylenKazan() {
		for (Kazan kazan : this.kazani) {
			if (kazan.getKg() >= MIN_KOLICHESTVO_PLODOVE_ZA_DA_MOJE_ONQ_DA_VARI_RAKIQ) {
				return kazan;
			}
		}

		// tuka trqbva exception da se hvyrli (ama kogato gi uchim - togaz)
		return null;
	}

}
