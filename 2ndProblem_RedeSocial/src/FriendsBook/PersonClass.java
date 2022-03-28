package FriendsBook;

public class PersonClass implements Person {
	// Constants
	private static final int FRIEND_LIST_MAX = 50;
	private static final int POSTS_LIST_MAX = 50;
	private static final int GROWTH_FACTOR = 2;
	
	// Instance variables
	private String name, email, status;
	private Person[] friends;
	private int size;
	private Post[] posts;
	private int postSize;
	
	
	/**
	 * Person class constructor
	 * 
	 * @param name: person's name
	 * @param email: person's email
	 * @param status: person's status
	 * @pre name != null && email != null && status != null
	 */
	public PersonClass(String name, String email, String status) {
		this.name = name;
		this.email = email;
		this.status = status;
		
		friends = new PersonClass[FRIEND_LIST_MAX];
		size = 0;
		
		posts = new PostClass[POSTS_LIST_MAX];
		postSize = 0;
	}
	
	/**
	 * Goes through this person's friends array, looking for friend with friendName
	 */
	@Override
	public boolean isFriendsWith(String friendName) {
		boolean found = false;
		int index = 0;
		
		if (size > 0) {
			while (!found && index < size) {
				if (friendName.equals(friends[index].getName()))
					found = true;
				index++;
			}
		}
		
		return found;
	}

	/**
	 * Creates a new friendship between two people
	 */
	@Override
	public void makeFriends(Person friend) {
		friends[size] = new PersonClass(friend.getName(), friend.getEmail(), friend.getStatus());
		size++;
	}

	/**
	 * Creates a copy of this person's friend array and sends it out to FriendsBook
	 */
	@Override
	public Person[] getFriends() {
		Person[] friendsCopy = new PersonClass[size];
		for (int index = 0; index < size; index++) {
			friendsCopy[index] = friends[index];
		}
		
		return friendsCopy;
	}

	/**
	 * Changes this person's status to <code>status</code>
	 */
	@Override
	public void changeStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public int getAmountFriends() {
		return size;
	}
	
	public void addPost(String author, String message) {
		if (!isPostsFull())
			posts[postSize] = new PostClass(author, message);
		else {
			growPosts();
			posts[postSize] = new PostClass(author, message);
		}
		postSize++;
	}
	
	private boolean isPostsFull() {
		return postSize == posts.length;
	}
	
	private void growPosts() {
		Post[] postCopy = new Post[GROWTH_FACTOR * posts.length];
		for (int i = 0; i < posts.length; i++)
			postCopy[i] = posts[i];
		posts = postCopy;
	}
}
