package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import filter.IObjectTest;
import filter.StringObjectTest;
import iterator.FilteringIterator;

public class FilteringIteratorTest {

	@Test
	public void testGetStringLengthGreaterThanFiveIterator() {
		IObjectTest<String> objectTest = new StringObjectTest();
		List<String> testStringCollection = new ArrayList<String>();
		List<String> result = new ArrayList<String>();
		testStringCollection.add("Hello");
		testStringCollection.add("World");
		testStringCollection.add("GreaterThan5LetterString");
		testStringCollection.add("Hello PIMCO!!");
		FilteringIterator<String> filteringIterator = new FilteringIterator<String>(testStringCollection.iterator(),objectTest);
		while(filteringIterator.hasNext()){
			String nextElement = filteringIterator.next();
			System.out.println("Element is "+nextElement);
			result.add(nextElement);
		}
		if(result.size() != 2){
			fail("String Result Collection Size is not 2");
		}
	}
	
	@Test
	public void testEmptyCollection() {
		IObjectTest<String> objectTest = new StringObjectTest();
		List<String> testStringCollection = new ArrayList<String>();
		List<String> result = new ArrayList<String>();
		FilteringIterator<String> filteringIterator = new FilteringIterator<String>(testStringCollection.iterator(),objectTest);
		while(filteringIterator.hasNext()){
			String nextElement = filteringIterator.next();
			System.out.println("Element is "+nextElement);
			result.add(nextElement);
		}
		if(result.size() > 0){
			fail("String Result Collection Size is not 2");
		}
	}
	
	/*
	 * Test to check if the iterator correctly catches null iterator or null test object
	 * and throws IllegalArumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNullCollection() {
		List<String> result = new ArrayList<String>();
		FilteringIterator<String> filteringIterator = new FilteringIterator<String>(null, null);
		while (filteringIterator.hasNext()) {
			String nextElement = filteringIterator.next();
			System.out.println("Element is " + nextElement);
			result.add(nextElement);
		}
	}
	
	//TODO: Similarly write test cases for other objects which will be used like Integer or custom objects etc.

}
