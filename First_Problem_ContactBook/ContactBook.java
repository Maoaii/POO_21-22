

public class ContactBook {
	static final int DEFAULT_SIZE = 100;

	private int counter;
	private Contact[] contacts;

	public ContactBook() {
		counter = 0;
		contacts = new Contact[DEFAULT_SIZE];
	}

	/** Pre: name != null */
	public boolean hasContact(String name) {
		return searchIndex(name) >= 0;
	}

	public int getNumberOfContacts() {
		return counter;
	}

	/** Pre: name!= null && !hasContact(name) */
	public void addContact(String name, int phone, String email) {
		if (counter == contacts.length) 
			resize();
		contacts[counter] = new Contact(name, phone, email);
		counter++;
	}

	/** Pre: name != null && hasContact(name) */
	public void deleteContact(String name) {
		int index = searchIndex(name);		
		for(int i=index; i<counter; i++)
			contacts[i] = contacts[i+1];
		counter--;
	}

	/** Pre: name != null && hasContact(name) */
	public int getPhone(String name) {
		return contacts[searchIndex(name)].getPhone();
	}

	/** Pre: name != null && hasContact(name) */
	public String getEmail(String name) {
		return contacts[searchIndex(name)].getEmail();
	}
	
	/**
	 * Searches a person's name by its' phone number
	 * 
	 * @param phone: phone number to search from
	 * @return the name of the person with phone as phone number
	 */
	public String getNameByPhone(int phone) {
		boolean found = false;
		int index = 0;
		String indexedName = "";
		// If there's atleast one contact stored
		if (counter > 0) {
			// While not found and not at the last contact
			while (!found && index < counter) {
				// Get the contact that i'm indexed at
				Contact indexedContact = contacts[index];
				// If phone number matches the contact i'm indexed at, stop the loop
				if (indexedContact.getPhone() == phone) {
					found = true;
					indexedName = indexedContact.getName();
				}
				index++;
			}
		}
		return indexedName;
	}
	
	/**
	 * Goes through contact list and see's if there's atleast two identical phone numbers
	 * 
	 * @return true if there's atleast two people with the same phone number, false otherwise
	 */
	public boolean isThereSameNumber() {
		boolean found = false;
		int index = 0;
		
		while (!found && index < counter-1) {
			int indexedPhone = contacts[index].getPhone();
			for (int i = index+1; i < counter; i++) {
				if (contacts[i].getPhone() == indexedPhone) {
					found = true;
				}
			}
			index++;
		}
		
		return found;
	}

	/** Pre: name != null && hasContact(name) */
	public void setPhone(String name, int phone) {
		contacts[searchIndex(name)].setPhone(phone);
	}

	/** Pre: name != null && hasContact(name) */
	public void setEmail(String name, String email) {
		contacts[searchIndex(name)].setEmail(email);
	}

	public ContactIterator iterator() {
		return new ContactIterator(contacts, counter);
	}
	
	private int searchIndex(String name) {
		int i = 0;
		int result = -1;
		boolean found = false;
		while (i<counter && !found)
			if (contacts[i].getName().equals(name))
				found = true;
			else
				i++;
		if (found) result = i;
		return result;
	}

	private void resize() {
		Contact tmp[] = new Contact[2*contacts.length];
		for (int i=0;i<counter; i++)
			tmp[i] = contacts[i];
		contacts = tmp;
	}
	
}
