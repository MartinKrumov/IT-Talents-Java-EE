package instruments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import instruments.Instrument.InstrumentType;

public class Shop {

	private String name;
	private int money;
	private TreeMap<InstrumentType, HashMap<String, Instrument>> instruments;
	private ArrayList<Instrument> ins;
	
	Shop(String name){
		this.name = name;
		instruments = new TreeMap<>();
		instruments.put(InstrumentType.UDARNI, new HashMap<>());
		Instrument i1 = new Drumms("Perlite", 1500, 3);
		instruments.get(InstrumentType.UDARNI).put("Pearls", i1);
		ins.add(i1);
		instruments.get(InstrumentType.UDARNI).put("Yamaha", new Drumms("Yamahite", 1850, 2));
		instruments.put(InstrumentType.KLAVIRNI, new HashMap<>());
		instruments.get(InstrumentType.KLAVIRNI).put("Yamaha", new Piano("Yamaha", 2100, 2));
		instruments.get(InstrumentType.KLAVIRNI).put("Lassy", new Piano("Lassy", 59, 9));
		instruments.put(InstrumentType.STRUNNI, new HashMap<>());
		instruments.get(InstrumentType.STRUNNI).put("Fender", new Piano("Fender", 800, 8));
		instruments.get(InstrumentType.STRUNNI).put("Orfei", new Piano("Orfei", 20, 200));
	}
	
	public void sell(String name, int quantity){
		for(InstrumentType type : instruments.keySet()){
			if(instruments.get(type).containsKey(name)){
				Instrument i = instruments.get(type).get(name);
				if(i.getQuantity() < quantity){
					System.out.println("Not enough quantity, only " + i.getQuantity() + " left");
				}
				else{
					i.decreaseQuantity(quantity);
					System.out.println("Sold!");
					this.money+= quantity*i.getPrice();
				}
			}
		}
	}
	
	public void printInstrumentsByType(){
		for(InstrumentType type : instruments.keySet()){
			System.out.println("========================="+ type +"=========================");
			for(Instrument i : instruments.get(type).values()){
				System.out.println(i);
			}
		}
	}
	
	public int getMoney() {
		return money;
	}
	
}
