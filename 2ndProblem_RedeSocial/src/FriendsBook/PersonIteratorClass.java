package FriendsBook;

public class PersonIteratorClass implements PersonIterator {
	
	// Instance variables
	private Person[] people;
	private int size;
	private int nextIndex;

	/**
	 * Person iterator constructor
	 * 
	 * @param people
	 * @param size
	 * @pre people != null && size != null
	 */
	public PersonIteratorClass(Person[] people, int size) {
		this.people = people;
		this.size = size;
		nextIndex = 0;
	}
	
	@Override
	public boolean hasNext() {
		return nextIndex < size;
	}
	
	@Override
	public Person next() {
		return people[nextIndex++];
	}

}
