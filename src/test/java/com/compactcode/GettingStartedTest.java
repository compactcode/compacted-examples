package com.compactcode;

import static com.compactcode.FluentList.listOf;
import static com.compactcode.Functions.min;
import static com.compactcode.Functions.sum;
import static com.compactcode.Functions.toInt;
import static org.hamcrest.number.OrderingComparisons.greaterThan;
import static org.hamcrest.number.OrderingComparisons.lessThan;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class GettingStartedTest {
	
	@Test
	public void sumIntegers() {
		int expected = 16;
		int actual   = listOf(6, 2, 3, 5).reduce(sum());
		assertEquals(expected, actual);
	}
	
	@Test
	public void findMinInteger() {
		int expected = 2;
		int actual   = listOf(6, 2, 3, 5).reduce(min());
		assertEquals(expected, actual);
	}
	
	@Test
	public void convertStringsToIntegers() {
		List<Integer> expected = Arrays.asList(2, 1, 3);
		List<Integer> actual   = listOf("2", "1", "3").map(toInt());
		assertEquals(expected, actual);
	}
	
	@Test
	public void findAllIntegersGreaterThan4() {
		List<Integer> expected = Arrays.asList(6, 7, 5);
		List<Integer> actual   = listOf(1, 6, 7, 5, 4).filter(greaterThan(4));
		assertEquals(expected, actual);
	}
	
	@Test
	public void findFirstIntegerLessThan6() {
		Integer expected = 5;
		Integer actual   = listOf(6, 7, 5, 4).filter(lessThan(6)).first();
		assertEquals(expected, actual);
	}
	
	@Test
	public void removeAllIntegersGreaterThanFour() {
		List<Integer> expected = Arrays.asList(1, 4);
		List<Integer> actual   = listOf(1, 6, 7, 5, 4).reject(greaterThan(4));
		assertEquals(expected, actual);
	}
	
	@Test
	public void findTheTwoLargestIntegers() {
		List<Integer> expected = Arrays.asList(4, 7);
		List<Integer> actual   = listOf(1, 4, 3, 7).sort().last(2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void removeNullElements() {
		List<String> expected = Arrays.asList("a", "a");
		List<String> actual   = listOf(null, "a", null, "a").compact();
		assertEquals(expected, actual);
	}
	
	@Test
	public void removeDuplicateElements() {
		List<String> expected = Arrays.asList("a", "b");
		List<String> actual   = listOf("a", "a", "b", "b").unique().sort();
		assertEquals(expected, actual);
	}
	
	@Test
	public void createStringRepresentation() {
		String expected = "1, 2, 3";
		String actual   = listOf(1, 2, 3).join(", ");
		assertEquals(expected, actual);
	}
	
}
