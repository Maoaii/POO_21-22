package FriendsBook;

public class PostIteratorClass implements PostIterator {

	// Instance variables
	private Post[] posts;
	private int size;
	private int nextIndex;

	/**
	 * Person iterator constructor
	 * 
	 * @param people
	 * @param size
	 * @pre people != null && size != null
	 */
	public PostIteratorClass(Post[] posts, int size) {
		this.posts = posts;
		this.size = size;
		nextIndex = 0;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return nextIndex < size;
	}

	@Override
	public Post next() {
		// TODO Auto-generated method stub
		return posts[nextIndex++];
	}

}
