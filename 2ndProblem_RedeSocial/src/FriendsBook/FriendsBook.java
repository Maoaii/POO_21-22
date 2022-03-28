package FriendsBook;

public interface FriendsBook {
	/**
	 * Checks if person with <code>name<code> exists
	 * 
	 * @param name
	 * @pre name != null
	 * @return true if person exists
	 */
	public boolean doesPersonExist(String name);
	
	/**
	 * Registers person in friends book with given credentials:
	 * <code>name</code>, <code>email</code>, <code>status</code>
	 * 
	 * @param name
	 * @param email
	 * @param status
	 * @pre name != null && email != null && status != null
	 */
	public void registerPerson(String name, String email, String status);
	
	/**
	 * Checks if two people, with <code>name1</code> and <code>name2</code> as names, are friends
	 * 
	 * @param name1
	 * @param name2
	 * @pre name1 != null && name2 != null
	 * @return true if they're friends
	 */
	public boolean checkFriendship(String name1, String name2);
	
	/**
	 * Registers friendship between two people, with
	 * <code>name1</code> and </code>name2</code> as names
	 * 
	 * @param name1
	 * @param name2
	 * @pre name1 != null && name2 != null
	 */
	public void registerFriendsip(String name1, String name2);
	
	/**
	 * Changes person's status with <code>status</code> 
	 * 
	 * @param name
	 * @param status
	 * @pre name != null && status != null
	 */
	public void changePersonStatus(String name, String status);
	
	/**
	 * Gets the status of person with <code>name</code> as name
	 * 
	 * @param name
	 * @pre name != null
	 * @return a String with the person's status message
	 */
	public String getPersonStatus(String name);
	
	/**
	 * Checks if person with <code>name</code> as name has friends
	 * 
	 * @param name
	 * @pre name != null
	 * @return true if person has friends
	 */
	public boolean hasFriends(String name);
	
	/**
	 * Gets an iterator for a people array
	 * 
	 * @return a person iterator
	 */
	public PersonIterator getIterator();
	
	/**
	 * Gets an iterator for a persons friend array
	 * 
	 * @param name
	 * @pre name != null
	 * @return a friend iterator
	 */
	public PersonIterator getFriendsIterator(String name);
	
	public void postPublic(String author, String post);
	
	public void post(String author, String post, String destination);
}
