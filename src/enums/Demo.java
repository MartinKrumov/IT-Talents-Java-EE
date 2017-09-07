package enums;

import enums.City.BuildingType;

public class Demo {

	public static void main(String[] args) {
		
		City sofia = new City();
		sofia.addBuilding(BuildingType.PUBLIC, new Building());
		sofia.addBuilding(BuildingType.OFFICE, new Building());
		sofia.addBuilding(BuildingType.PUBLIC, new Building());
		sofia.addBuilding(BuildingType.MUSEUM, new Building());
		sofia.addBuilding(BuildingType.LIVING, new Building());
		sofia.addBuilding(BuildingType.LIVING, new Building());
		sofia.addBuilding(BuildingType.OFFICE, new Building());
		sofia.addBuilding(BuildingType.PUBLIC, new Building());
	}
}
