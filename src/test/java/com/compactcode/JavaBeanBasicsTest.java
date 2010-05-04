package com.compactcode;

import static com.compactcode.Customer.toAge;
import static com.compactcode.FluentList.listOf;
import static com.compactcode.Functions.max;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.number.OrderingComparisons.*;

import java.util.List;

import org.junit.Test;

public class JavaBeanBasicsTest {

	@Test
	public void findTheOldestCustomerAge() {
		FluentList<Customer> customers = listOf(
				new Customer(45), 
				new Customer(35), 
				new Customer(55),
				new Customer(18)
		);
		Integer expected = 55;
		
		assertEquals(expected, customers.sort(toAge()).last().getAge());
		
		assertEquals(expected, customers.map(toAge()).sort().last());
		
		assertEquals(expected, customers.map(toAge()).reduce(max()));
	}
	
	@Test
	public void findCustomersOlderThan35() {
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
