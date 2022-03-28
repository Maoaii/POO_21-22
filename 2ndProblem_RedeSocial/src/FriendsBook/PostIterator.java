package FriendsBook;

public interface PostIterator {
	/**
	 * @return true if there's a next post to iterate over
	 */
	public boolean hasNext();
	
	/**
	 * @return the next post read
	 */
	public Post next();
}
