package enums;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class City {

	public enum BuildingType {

		MUSEUM(5), LIVING(15), PUBLIC(40), OFFICE(79);
		
		int price;
		private BuildingType(int price) {
			this.price = price;
		}
		
		public int getPrice() {
			return price;
		}
	}
	
	private TreeMap<BuildingType, HashSet<Building>> buildings;
	
	City(){
		buildings = new TreeMap<>();
	}
	
	public void addBuilding(BuildingType type, Building b){
		if(!buildings.containsKey(type)){
			buildings.put(type, new HashSet<>());
		}
		buildings.get(type).add(b);
	}
}
