package turgovci.Trader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import turgovci.ShoppingCenter.ShoppingCenter;
import turgovci.Supplier.Supplier;

public abstract class Trader extends Info {
	private int money;
	private List<ShoppingCenter> shoppingCenters;
	private List<Supplier> suppliers;

	public Trader(String name, String address, int money) {
		super(name, address);
		this.money = money;
		this.shoppingCenters = new ArrayList<>();
		this.suppliers = new ArrayList<>();
	}

	public void addMoney(int money) {
		this.money += money;
	}

	public void addSupplier(Supplier supp) {
		this.suppliers.add(supp);
	}

	public void addSuppliers(List<Supplier> supps) {
		this.suppliers.addAll(supps);
	}

	public void addShoppingCenter(ShoppingCenter center) {
		this.shoppingCenters.add(center);
	}

	public void addShoppingCenters(List<ShoppingCenter> centers) {
		this.shoppingCenters.addAll(centers);
	}

	/*
	 * �� ����� ������� �� ���������� �������� ��� ���������. ��������� �� ����
	 * �� ��������� 50% �� �������� �� ���������. ��� ���������� �������
	 * ��������, ��������� � ������ �� �� ����� ������� �� ���������. ���
	 * ������� �� ����� �� ���������, ��������� ������ � ���������� ����� ������
	 * � ���������� ��������� ���� ��������, ���� ����� ������� ��� ������������
	 * � ���������� ���� ����� 5 � 15 ����. ������ ���� �� ����������
	 * ������������ ���������� �� ����������.
	 */

	public void makeOrders() {
		for (ShoppingCenter shop : shoppingCenters) {
			int totalPrice = shop.executeOrder();

			if (totalPrice < this.money / 2) {
				int order = this.suppliers.get(new Random().nextInt(suppliers.size())).completeSupply(totalPrice);
				this.money += order;
			}
		}
	}
	
	public void getProfit(){
		for (ShoppingCenter shop : shoppingCenters) {
			int profit = (int)(shop.getBuget() + shop.getBuget() * 0.30);
			this.addMoney(profit);
		}
	}

	public void payTaxes() {
		for (ShoppingCenter shop : shoppingCenters) {
			this.money -=shop.getTax();
		}
	}

	@Override
	public String toString() {
		return "Trader [name = " + super.getName() + ", address = " + super.getAddress() + ", money=" + money
				+ ", shoppingCenters=" + shoppingCenters + ", suppliers=" + suppliers + "]";
	}

}
