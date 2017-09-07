package torti.cakes;

public interface ITypeCake {

	public enum TypeSpecialCake implements ITypeCake{
		ANNIVERSARY, FIRM, ADVERTISEMENT;
	}
	
	public enum TypeKidCake implements ITypeCake{
		BIRTHDAY, CHRISTENING, PROSHTAPULNIK;
	}

	public enum TypeStandartCake implements ITypeCake{
		BISCUIT, ECLAIR, FRUIT, CHOCOLATE;
	}

	public enum TypeWeddingCake implements ITypeCake{
		LARGE, SMALL, MEDIUM;
	}
}

