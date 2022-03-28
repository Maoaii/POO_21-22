package FriendsBook;


public interface Person {
	
	/**
	 * @return this person's name
	 */
	public String getName();
	
	/**
	 * @return this person's email
	 */
	public String getEmail();
	
	/**
	 * @return this person's status
	 */
	public String getStatus();
	
	/**
	 * Checks if this person is friends with person with <code>friendName</code> as name
	 * 
	 * @param friendName: friend name to search for
	 * @pre friend != null
	 * @return true if this person is friends with given person
	 */
	public boolean isFriendsWith(String friendName);
	
	/**
	 * This person starts a friendship with <code>friend</code>
	 * 
	 * @param friend: person to make friends with
	 * @pre friend != null
	 */
	public void makeFriends(Person friend);
	
	/**
	 * Gets this person's friends
	 * 
	 * @return an array with this person's friends
	 */
	public Person[] getFriends();
	
	/**
	 * Changes this person status to <code>status</code>
	 * 
	 * @param status: status to change to
	 * @pre status != null
	 */
	public void changeStatus(String status);
	
	/**
	 * Gets the amount of friends this person has
	 * 
	 * @return the amount of friends this person has
	 */
	public int getAmountFriends();
	
	public void addPost(String author, String message);
}
