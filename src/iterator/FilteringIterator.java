package iterator;

import java.util.*;

import filter.IObjectTest;

/*
 * Custom Iterator which takes a Iterator and a custom test object as an input.
 * Only Iterates if the test object's test() function matches.
 */
public class FilteringIterator<T> implements Iterator<T> {
	
	private Iterator<? extends T> iterator;
	private IObjectTest<T> objectTest;
	private T nextElement;
	private boolean hasNext;
	
	public FilteringIterator(Iterator<? extends T> iterator,IObjectTest<T> objectTest){
		if(iterator == null){
			throw new IllegalArgumentException("Iterator cannot be Null");
		}
		if(objectTest == null){
			throw new IllegalArgumentException("Filtering Object cannot be Null");
		}
		this.iterator = iterator;
		this.objectTest = objectTest;
		findNextElement();
	}	

	/*
	 * This function loads the nextElement and hasNext. When it is called, it returns the already calculated next Element from previous call
	 * and calculates the new value of nextElement and hasNext.
	 */
	private T findNextElement() {
		T currentMatch = nextElement;
		while(iterator.hasNext()){
			T obj = iterator.next();
			if(objectTest.test(obj)){
				hasNext = true;
				nextElement = obj;
				return currentMatch;
			}
		}
		hasNext = false;
		return currentMatch;
	}

	/*
	 * Checks if the next element exists which can be accessed by the iterator
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return hasNext;
	}

	/*
	 * Gets the next element accessible by the iterator
	 * @see java.util.Iterator#next()
	 */
	@Override
	public T next() {
		if(hasNext){
			return findNextElement();
		}
		throw new NoSuchElementException();
	}

}
