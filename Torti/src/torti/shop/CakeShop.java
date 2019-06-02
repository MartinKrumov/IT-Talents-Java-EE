package torti.shop;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import torti.cakes.Cake;
import torti.cakes.Cake.KindCake;
import torti.cakes.ITypeCake;

public class CakeShop extends ContactInfo{

	private double money;
	private String address;
	private List<Supplier> suppliers;
	private Map<KindCake, Map<ITypeCake, List<Cake>>>catalog;
	
	public CakeShop(String name, String address) {
		super(name);
		if (this.isValid(address) )
		this.address = address;
		suppliers = new ArrayList<Supplier>();
		catalog = new Map<KindCake, Map<ITypeCake, List<Cake>>>();
	}
	
	public void addSupplier(Supplier s) {
		this.suppliers.add(s);
	}
	
	public void addCake(Cake c) {
		KindCake kind = c.getKind();
		ITypeCake type = c.getType();

		if (!this.catalog.containsKey(kind)) {
			this.catalog.put(kind, new HashMap<>());
		}
		if (!this.catalog.get(kind).containsKey(type)) {
			this.catalog.get(kind).put(type, new ArrayList<>());
		}
		this.catalog.get(kind).get(type).add(c);
	}
	
	public Cake getRandomCake() {

		//Map<KindCake, HashMap<ITypeCake, List<Cake>>>catalog
		int randInd = new Random().nextInt(KindCake.values().length);
		KindCake kind = KindCake.values()[randInd];
		Map<ITypeCake, List<Cake>> arr = this.catalog.get(kind);
		int randInd2 = new Random().nextInt(arr.keySet().size());
		Object[] a = arr.keySet().toArray();
		ArrayList<Cake> list = arr.get(a[randInd2]);
		
		if (list.size() > 0) {
			int randInd3 = new Random().nextInt(list.size());
			Cake c = list.remove(randInd3);
			return c;
		} else {
			return this.getRandomCake();
		}
	}
	

	public void assignOrder(Order order, double sumaZaZaplashtane) {
		int random = new Random().nextInt(this.suppliers.size());
		Supplier s = this.suppliers.get(random);
		s.addOrder(order);
		s.executeOrder(order);
		this.money +=sumaZaZaplashtane;
			
	}
	public void printCatalog() {
		for (Entry<KindCake, Map<ITypeCake, List<Cake>>> entry : this.catalog.entrySet()) {
			System.out.println(entry.getKey());

			Map<ITypeCake, List<Cake>> map = entry.getValue();

			for (Entry<ITypeCake, ArrayList<Cake>> entry2 : map.entrySet()) {
				System.out.println("  " + entry2.getKey());

				for (Cake c : entry2.getValue()) {
					System.out.println("    " + c);
				}
			}
		}
	}

}
