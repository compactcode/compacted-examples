package com.compactcode;

import static com.compactcode.FluentList.listOf;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hamcrest.core.IsEqual;
import org.hamcrest.number.IsCloseTo;
import org.hamcrest.number.OrderingComparisons;
import org.hamcrest.text.StringContains;
import org.hamcrest.text.StringStartsWith;
import org.junit.Test;

public class FilteringTest {

	@Test
	public void findNumbersEqualTo5() {
		List<Integer> expected = listOf(5, 5);
		
		List<Integer> actual = listOf(2, 4, 5, 5, 6, 8).filter(IsEqual.equalTo(5));
		
		assertEquals(expected, actual);
	}
	
	@Test 
	public void findNumbersGreaterThan3() {
		List<Integer> expected = listOf(4, 5);
		
		List<Integer> actual = listOf(1, 2, 4, 5).filter(OrderingComparisons.greaterThan(3));
		
		assertEquals(expected, actual);
	}
	
	@Test 
	public void findDoublesCloseTo() {
		List<Double> expected = listOf(4.5, 4.7);
		
		List<Double> actual = listOf(3.0, 4.5, 6.0, 4.7).filter(IsCloseTo.closeTo(4.6, 0.11));
		
		assertEquals(expected, actual);
	}
	
	@Test 
	public void findStringsStartingWith() {
		List<String> expected = listOf("home", "hose");
		
		List<String> actual = listOf("home", "car", "hill", "hose").filter(StringStartsWith.startsWith("ho"));
		
		assertEquals(expected, actual);
	}
	
	@Test 
	public void findStringsContaining() {
		List<String> expected = listOf("hill");
		
		List<String> actual = listOf("home", "car", "hill", "hose").filter(StringContains.containsString("hi"));
		
		assertEquals(expected, actual);
	}
	
}
