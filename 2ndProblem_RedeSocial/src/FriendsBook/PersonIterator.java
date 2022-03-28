package FriendsBook;

public interface PersonIterator {
	/**
	 * @return true if there's a next person to iterate over
	 */
	public boolean hasNext();
	
	/**
	 * @return the next person read
	 */
	public Person next();
}
