package application;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderList {
	
	private static  ArrayList<Order> orderList;
	
	public OrderList() {
		orderList = new ArrayList<>();
	}
	
	public void addOrder(Order order) {
		orderList.add(order);
	}

	public static ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void removeOrder(int index) {
		orderList.remove(index);
	}
	
	

}
