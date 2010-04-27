package com.compactcode;

import static com.compactcode.FluentFunction.function;
import static com.compactcode.FluentList.fluent;
import static com.compactcode.Functions.each;
import static com.compactcode.Functions.sum;
import static com.compactcode.Functions.toPropertyValue;
import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Function;

public class GettingStartedTest {

	public class Order {
		private final Integer cost;
		public Order(Integer cost) {
			this.cost = cost;
		}
		public Integer getCost() {
			return cost;
		}
	}
	
	public class Customer {
		private final List<Order> orders;
		public Customer(Order... orders) {
			this.orders = newArrayList(orders);
		}
		public List<Order> getOrders() {
			return orders;
		}
	}
	
	private FluentList<Customer> customers = fluent(
		new Customer(new Order(100)),
		new Customer(new Order(150)),
		new Customer(new Order(200), new Order(300))
	);
	
	private Function<Customer, List<Order>> toOrders = toPropertyValue("orders");
	private Function<Order, Integer> toCost = toPropertyValue("cost");
	
	@Test
	public void testCountTotalNumberOfOrders() {
		Integer expected = 4;
		Integer actual = customers.expand(toOrders).size();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCountTotalOrderCost() {
		Integer expected = 750;
		Integer actual = customers.expand(toOrders).map(toCost).reduce(sum());
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCountTotalOrderCostPerCustomer() {
		List<Integer> expected = newArrayList(100, 150, 500);
		List<Integer> actual = customers.map(toOrders).map(each(toCost)).map(sum());
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindBiggestSpender() {
		Function<Customer, Integer> totalSpent = function(toOrders).map(each(toCost)).map(sum());
		Customer expected = customers.get(2);
		Customer actual = customers.sort(totalSpent).last();
		assertEquals(expected, actual);
	}
	
}
