package torti;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import torti.cakes.Cake;
import torti.cakes.ITypeCake;
import torti.cakes.ITypeCake.TypeKidCake;
import torti.cakes.ITypeCake.TypeSpecialCake;
import torti.cakes.ITypeCake.TypeStandartCake;
import torti.cakes.ITypeCake.TypeWeddingCake;
import torti.cakes.KidCake;
import torti.cakes.SpecialCake;
import torti.cakes.StandartCake;
import torti.cakes.WeddingCake;
import torti.clients.Client;
import torti.clients.CorporativeClient;
import torti.clients.PrivateClient;
import torti.cakes.Cake.KindCake;
import torti.shop.CakeShop;
import torti.shop.Supplier;

public class Demo {

	public static void main(String[] args) {

		// 1.
		CakeShop shop = new CakeShop("Sladki talanti", "Vrajdebna 5");

		final String[] names = { "Micheto", "Puhi", "Andrea", "Preslava", "Galena" };
		List<Supplier> suppliers = new ArrayList<Supplier>();
		for (int i = 0; i < 5; i++) {
			Supplier s = new Supplier(names[new Random().nextInt(names.length)]);
			suppliers.add(s);
			shop.addSupplier(s);
		}

		// for (Supplier s: suppliers) {
		// System.out.println(s);
		// }

		// 2.
		final String[] cakeNames = { "Torta 1", "Torta 2", "Torta 3" };
		final int[] prices = { 10, 20, 60, 40, 80, 100, 200 };
		final int[] pieces = { 5, 8, 12, 16, 20, 25 };

		for (int i = 0; i < 30; i++) {

			int randomChance = new Random().nextInt(4);
			String nameOfCake = cakeNames[new Random().nextInt(cakeNames.length)];
			int priceOfCake = prices[new Random().nextInt(prices.length)];
			int piecesOfCake = pieces[new Random().nextInt(pieces.length)];
			int randIndex = 0;
			ITypeCake type = null;
			Cake c = null;
			switch (randomChance) {
			// Standart
			case 0:
				randIndex = new Random().nextInt(TypeStandartCake.values().length);
				type = TypeStandartCake.values()[randIndex];
				c = new StandartCake(nameOfCake, priceOfCake, 
						piecesOfCake, type, KindCake.STANDARD);
				break;
			// Special
			case 1:
				randIndex = new Random().nextInt(TypeSpecialCake.values().length);
				type = TypeSpecialCake.values()[randIndex];
				c = new SpecialCake(nameOfCake, priceOfCake, 
						piecesOfCake, type, KindCake.SPECIAL);
				break;
			// Kid
			case 2:
				randIndex = new Random().nextInt(TypeKidCake.values().length);
				type = TypeKidCake.values()[randIndex];
				c = new KidCake(nameOfCake, priceOfCake, piecesOfCake, type, KindCake.KID);
				break;
			// Wedding
			case 3:
				randIndex = new Random().nextInt(TypeWeddingCake.values().length);
				type = TypeWeddingCake.values()[randIndex];
				c = new WeddingCake(nameOfCake, priceOfCake, piecesOfCake, type, KindCake.WEDDING);
				break;
			}
			
			shop.addCake(c);

		}
		
		shop.printCatalog();
		
		//3. 
		ArrayList<Client> clients = new ArrayList<Client>();
		for (int i = 0; i < 5; i++) {
			PrivateClient pclient = new PrivateClient(names[new Random().nextInt(names.length)]);
			int randomIndex = new Random().nextInt(4) + 1;
			for (int j = 0; j < randomIndex; j++) {
				pclient.addVoucher( new Random().nextInt(21) + 10);
			}
			clients.add(pclient);
			Client cclient = new CorporativeClient(names[new Random().nextInt(names.length)]);
			clients.add(cclient);
		}
		
		for (Client c:clients) {
			System.out.println(c);
		}
		
		//4.
		for (Client c:clients) {
			clients.makeOrder(shop);
		}
		
		

	}

}
