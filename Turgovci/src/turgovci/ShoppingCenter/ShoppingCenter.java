package turgovci.ShoppingCenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class ShoppingCenter {
	private String address;
	private int workTime;
	private int area;
	private int tax;
	private int buget;
	private List<Integer> goods;
	
	public ShoppingCenter(String address, int workTime, int area, int tax) {
		this.address = address;
		this.workTime = workTime;
		this.area = area;
		this.tax = tax;
		this.goods = new ArrayList<>();
	}
	
	public int executeOrder() {
		List<Integer> goods = genereteGoods();
		int totalPrice = 0;
		for (Integer item : goods) {
			totalPrice += item;
		}
		
		return totalPrice;
	}
	
	void calculateBudget() {
		for (Integer item : goods) {
			this.buget += item;
		}
	}
	
	public List<Integer> genereteGoods() {
		List<Integer> goods = new ArrayList<>();
		
		for (int i = 0; i < 7; i++) {
			goods.add(new Random().nextInt(12) + 4);
		}
		return goods;
	}
	
	public void addGoods(List<Integer> g) {
		this.goods.addAll(g);
	}

	public int getTax() {
		return tax;
	}
	
	public int getBuget() {
		return buget;
	}

	@Override
	public String toString() {
		return "ShoppingCenter [address=" + address + ", workTime=" + workTime + ", area=" + area + ", tax=" + tax
				+ "]";
	}
	
}