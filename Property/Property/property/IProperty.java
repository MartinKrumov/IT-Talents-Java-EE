package property;

public interface IProperty {
	
	public enum ApartmentType implements IProperty{
		STUDIO, GARSIONERA, DVUSTAEN, TRISTAEN, MEZONET;
	}
	
	public enum HouseType implements IProperty {
		FLOOR_OF_HOUSE, HOUSE;
	}
	
	public enum PlotType implements IProperty {
		FIELD, MEADOW, FOREST;
	}
}
