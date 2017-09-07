package torti.cakes;

import torti.cakes.Cake.KindCake;

public abstract class Cake {
	public enum KindCake {
		STANDARD, KID, WEDDING, SPECIAL;
	}
	private String name;
	private String description;
	private double price;
	private int countPieces;
	//type of cake
	ITypeCake typeOfCake;
	KindCake kind;
	

	public Cake(String nameOfCake, double priceOfCake, int piecesOfCake, ITypeCake type, KindCake kind) {
		//validaciq
		this.name = nameOfCake;
		this.description = "mnoogo qka torta";
		this.price = priceOfCake;
		this.countPieces = piecesOfCake;
		this.typeOfCake = type;
		this.kind = kind;
	}

	@Override
	public String toString() {
		return "Cake [name=" + name + ", price=" + price + ", countPieces=" + countPieces + ", typeOfCake=" + typeOfCake
				+ "]";
	}

	public KindCake getKind() {
		// TODO Auto-generated method stub
		return this.kind;
	}

	public ITypeCake getType() {
		// TODO Auto-generated method stub
		return this.typeOfCake;
	}

	public double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}
}
