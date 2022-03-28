package FriendsBook;

public class FriendsBookClass implements FriendsBook {
	// Constants
	private static final int BOOK_MAX = 500;
	
	// Instance variables
	private Person[] people;
	private int size;
	
	/**
	 * Friends book constructor
	 */
	public FriendsBookClass() {
		size = 0;
		people = new PersonClass[BOOK_MAX];
	}
	
	/**
	 * Iterates over <code>people</code> array and returns true if person
	 * with <code>name</code> is there
	 */
	@Override
	public boolean doesPersonExist(String name) {
		boolean found = false;
		int personIndex = 0;
		
		while (!found && personIndex < size) {
			if (name.equals(people[personIndex].getName()))
				found = true;
			personIndex++;
		}
		
		return found;
	}

	/**
	 * Registers a new person with given credentials
	 */
	@Override
	public void registerPerson(String name, String email, String status) {
		people[size] = new PersonClass(name, email, status);
		size++;
	}
	
	/**
	 * Checks if two people, with <code>name1</code> and <code>name2</code> as names, are friends
	 */
	@Override
	public boolean checkFriendship(String name1, String name2) {
		return getPerson(name1).isFriendsWith(name2);
	}

	/**
	 * Creates a friendship between two people with
	 * <code>name1</code> and <code>name2</code> as names
	 */
	@Override
	public void registerFriendsip(String name1, String name2) {		
		Person person1 = getPerson(name1);
		Person person2 = getPerson(name2);
		
		person1.makeFriends(person2);
		person2.makeFriends(person1);
	}
	
	/**
	 * Iteratres over <code>people</code> array and returns a copy of the person with <code>name</code> as a name
	 */
	private Person getPerson(String name) {
		boolean found = false;
		int personIndex = 0;
		
		Person person = null;
		
		while(!found && personIndex < size) {
			if (name.equals(people[personIndex].getName())) {
				person = people[personIndex];
				found = true;
			}
			personIndex++;
		}
		
		return person;
	}

	/**
	 * Sends <code>Person</code> class a signal to change given person status'
	 */
	@Override
	public void changePersonStatus(String name, String status) {
		getPerson(name).changeStatus(status);
	}

	/**
	 * Sends <code>Person</code> class a signal to return given person status'
	 */
	@Override
	public String getPersonStatus(String name) {
		return getPerson(name).getStatus();
	}

	/**
	 * Gets an iterator that iterates over <code>people</code> array
	 */
	@Override
	public PersonIterator getIterator() {
		return new PersonIteratorClass(people, size);
	}
	
	/**
	 * Gets an iterator that iterates over <code>friends</code> array of person with <code>name</code> as name
	 */
	@Override
	public PersonIterator getFriendsIterator(String name) {
		Person person = getPerson(name);
		return new PersonIteratorClass(person.getFriends(), person.getAmountFriends());
	}

	/**
	 * Checks if person with <code>name</code> as name has friends
	 */
	@Override
	public boolean hasFriends(String name) {
		return getPerson(name).getAmountFriends() > 0;
	}

	@Override
	public void postPublic(String author, String post) {
		Person person = getPerson(author);
		person.addPost(author, post);
	}

	@Override
	public void post(String author, String post, String destination) {
		Person person1 = getPerson(author);
		Person person2 = getPerson(destination);
		person1.addPost(author, post);
		person2.addPost(author, post);
	}
}
