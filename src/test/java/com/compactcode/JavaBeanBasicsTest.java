package com.compactcode;

import static com.compactcode.Customer.toAge;
import static com.compactcode.FluentList.listOf;
import static com.compactcode.Functions.max;
import static com.compactcode.Functions.sum;
import static org.hamcrest.number.OrderingComparisons.greaterThan;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class JavaBeanBasicsTest {

	@Test
	public void convertCustomersToAge() {
		FluentList<Customer> customers = listOf(
				new Customer(45), 
				new Customer(35)
		);
		List<Integer> expected = listOf(
				45, 
				35
		);
		
		assertEquals(expected, customers.map(toAge()));
	}
	
	@Test
	public void findTotalCustomerAge() {
		FluentList<Customer> customers = listOf(
				new Customer(45), 
				new Customer(35), 
				new Customer(25)
		);
		Integer expected = 105;
		
		assertEquals(expected, customers.map(toAge()).reduce(sum()));
	}
	
	@Test
	public void findOldestCustomerAge() {
		FluentList<Customer> customers = listOf(
				new Customer(45), 
				new Customer(35), 
				new Customer(55),
				new Customer(18)
		);
		Integer expected = 55;
		
		assertEquals(expected, customers.map(toAge()).sort().last());
		
		assertEquals(expected, customers.map(toAge()).reduce(max()));
	}
	
	@Test
	public void findAllCustomersOlderThan35() {
		FluentList<Customer> customers = listOf(
				new Customer(45), 
				new Customer(35), 
				new Customer(55),
				new Customer(18)
		);
		List<Customer> expected = listOf(
				new Customer(45), 
				new Customer(55)
		);
		
		assertEquals(expected, customers.filter(toAge(), greaterThan(35)));
	}
	
}
