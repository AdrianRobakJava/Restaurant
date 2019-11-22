package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderListTest {
	
	OrderWindow orderWindow;
	OrderList orderList;
	Order order;
	
	
	@BeforeEach
	public void addOrders() {
		
		orderList = new OrderList();
		
		orderList.addOrder(new Order("Kebeb1", 10.0));
		orderList.addOrder(new Order("Kebeb2", 10.0));
		orderList.addOrder(new Order("Kebeb3", 10.0));
		orderList.addOrder(new Order("Kebeb4", 10.0));
		orderList.addOrder(new Order("Kebeb5", 10.0));
		orderList.addOrder(new Order("Kebeb6", 10.0));
		orderList.addOrder(new Order("Kebeb7", 10.0));
		orderList.addOrder(new Order("Kebeb8", 10.0));
		orderList.addOrder(new Order("Kebeb9", 10.0));
		orderList.addOrder(new Order("Kebeb10", 10.0));
		orderList.addOrder(new Order("Kebeb11", 10.0));
		orderList.addOrder(new Order("Kebeb12", 10.0));
		orderList.addOrder(new Order("Kebeb13", 10.0));
		orderList.addOrder(new Order("Kebeb14", 10.0));
		orderList.addOrder(new Order("Kebeb15", 10.0));
	}
	
	@Test
	void checkArraySize() {
		assertEquals(15, orderList.getSize());
	}
	
	@Test
	void checClearArray() {
		orderList.clearOrderList();
		assertEquals(0, orderList.getSize());
	}
	
	@Test
	void checRemoveOrderFromArray() {
		orderList.removeOrder(5);
		orderList.removeOrder(5);
		orderList.removeOrder(5);
		orderList.removeOrder(5);
		orderList.removeOrder(5);
		assertEquals(10, orderList.getSize());
	}
	
	
	
	

}
