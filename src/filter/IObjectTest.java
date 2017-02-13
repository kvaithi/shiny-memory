package filter;

/*
 * Interface which defines how an Iterator should be filtered.
 */
public interface IObjectTest<T> {
	/*
	 * Define what condition on the object the iterator would be filtered.
	 */
	public boolean test(T objectTest);
}
