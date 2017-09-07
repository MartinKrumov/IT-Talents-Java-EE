import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import turgovci.ShoppingCenter.Pavilion;
import turgovci.ShoppingCenter.Shop;
import turgovci.ShoppingCenter.ShoppingCenter;
import turgovci.ShoppingCenter.Stall;
import turgovci.Supplier.Retail;
import turgovci.Supplier.Supplier;
import turgovci.Supplier.Wholesale;
import turgovci.Trader.AmbulanceTrader;
import turgovci.Trader.SoleTrader;
import turgovci.Trader.Trader;
import turgovci.Trader.TradingChain;

public class Demo {
	public static final String[] NAMES = { "Chris", "Nick", "Sami", "Pejo", "Qna", "Desi" };
	public static final String[] ADDRESSES = { "Mladost", "Lulin", "Nadejda", "Vraca" };

	public static void main(String[] args) {
		List<Supplier> suppliers = createSuppliers();
		List<ShoppingCenter> shops = createShops();
		
		/* 3. Създава един амбулантен търговец с капитал 100 лева, един ЕТ с капитал
		500 лева и една търговска верига с капитал 3000 лева.*/
		
		Trader ambulanceTrader = new AmbulanceTrader(NAMES[new Random().nextInt(NAMES.length)],
				ADDRESSES[new Random().nextInt(ADDRESSES.length)], 100);
		
		Trader soleTrader = new SoleTrader(NAMES[new Random().nextInt(NAMES.length)],
				ADDRESSES[new Random().nextInt(ADDRESSES.length)], 500);
		
		Trader tradingChain = new TradingChain(NAMES[new Random().nextInt(NAMES.length)],
				ADDRESSES[new Random().nextInt(ADDRESSES.length)], 3000);
		//-----------------------------------------------------------------------------
		
		distributeShops(ambulanceTrader, soleTrader, tradingChain, shops, suppliers);
		
		System.out.println(ambulanceTrader);
		System.out.println(soleTrader);
		System.out.println(tradingChain);
		
	}

	// 1. Създава 10 доставчика на произволен принцип – на дребно и на едро.
	static List<Supplier> createSuppliers() {
		List<Supplier> s = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			int r = new Random().nextInt(2);

			String name = NAMES[new Random().nextInt(NAMES.length)];
			String address = ADDRESSES[new Random().nextInt(ADDRESSES.length)];
			
			if (r == 0) {
				s.add(new Retail(name, address, (new Random().nextInt(9) + 1)));
			} else {
				s.add(new Wholesale(name, address, (new Random().nextInt(9) + 1)));
			}
		}

		return s;
	}

	// 2. Създава 20 търговски обекта на произволен принцип – сергии, магазини и будки.
	static List<ShoppingCenter> createShops() {
		List<ShoppingCenter> shops = new ArrayList<>();
		
		for (int i = 0; i < 20; i++) {
			int r = new Random().nextInt(3);
			
			String address = ADDRESSES[new Random().nextInt(ADDRESSES.length)];
			
			switch (r) {
			case 0:
				shops.add(new Stall(address, (new Random().nextInt(9) + 1), (new Random().nextInt(9) + 2)));
				break;
			case 1:
				shops.add(new Shop(address, (new Random().nextInt(9) + 1), (new Random().nextInt(91) + 10)));
				break;
			case 2:
				shops.add(new Pavilion(address, (new Random().nextInt(9) + 1), (new Random().nextInt(2) + 4)));

			}
		}
		return shops;
	}
	
	//4. Подава на търговците съответни търговски обекти на произволен принцип.
	static void distributeShops(Trader ambTrader, Trader soloeTrader, Trader tradingChain, List<ShoppingCenter> shops, List<Supplier> suppliers) {
		ambTrader.addShoppingCenter(shops.get(new Random().nextInt(shops.size())));
		
		for (ShoppingCenter shop : shops) {
			if (shop instanceof Pavilion || shop instanceof Stall) {
				soloeTrader.addShoppingCenter(shop);
			}
		}
		
		int countShops = 10;
		
		for (ShoppingCenter shop : shops) {
			if (countShops == 0) {
				break;
			}
			
			if (!(shop instanceof Stall)) {
				tradingChain.addShoppingCenter(shop);
				countShops--;
			}
		}
		
		for (Supplier supp : suppliers) {
			if (supp instanceof Retail) {
				ambTrader.addSupplier(supp);
				break;
			}
		}
		
		int countSup = 0;
		for (Supplier supp : suppliers) {
			if (countSup == 5) {
				break;
			}
			if (supp instanceof Retail) {
				soloeTrader.addSupplier(supp);
				countSup++;
			}
		}
		
		countSup = 0;
		for (Supplier supp : suppliers) {
			if (countSup == 15) {
				break;
			}
			
			tradingChain.addSupplier(supp);
			countSup++;
		}
	}
}
