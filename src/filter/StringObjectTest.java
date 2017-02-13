package filter;

/*
 * Sample String Filter class. This filters if the string length is greater than 5 for testing purposes.
 */
public class StringObjectTest implements IObjectTest<String> {
	
	/*
	 * @see filter.IObjectTest#test(java.lang.Object)
	 * This test function checks if the length of the string is greater than 5. If so it returns true, else false
	 */
	@Override
	public boolean test(String objectTest) {
		if(objectTest != null && objectTest.length() > 5){
			return true;
		}
		return false;
	}

}
