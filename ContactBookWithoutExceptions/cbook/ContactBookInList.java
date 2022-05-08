package cbook;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class ContactBookInList implements ContactBook {
	/**
	 * Coleccao de contactos.
	 */
	private List<Contact> contacts;
	
	/**
	 * Construtor por omissao
	 */
	public ContactBookInList() {
		contacts = new LinkedList<Contact>();
	}

	@Override 
	public boolean hasContact(String name) {
		return this.getContact(name) != null;
	}

	@Override 
	public int getNumberOfContacts() {
		return contacts.size();
	}

	@Override 
	public void addContact(String name, int phone, String email) {
		contacts.add(new ContactClass(name, phone, email));
	}

	@Override 
	public void deleteContact(String name) {
		// Uma alternativa seria o seguinte codigo:
		// Contact c = this.getContact(name);
		// contacts.remove(c);
		// mas esta solucao involve duas procuras na lista
		
		// A solucao seguinte exige que exista o metodo equals(Object o) 
		// implementado na ContactClass e um construtor que receba como
		// como argumento apenas o name
		contacts.remove(new ContactClass(name));
	}

	@Override 
	public int getPhone(String name) {
		return this.getContact(name).getPhone();
	}

	@Override 
	public String getEmail(String name) {
		return this.getContact(name).getEmail();
	}

	@Override 
	public void setPhone(String name, int phone) {
		this.getContact(name).setPhone(phone);
	}

	@Override 
	public void setEmail(String name, String email) {
		this.getContact(name).setEmail(email);
	}

	@Override 
	public Iterator<Contact> listContacts() {
		return contacts.iterator();
	}
	
	/**
	 * @param name nome do contacto a procurar na lista
	 * @return o contacto com nome <code>name</code> caso exista,
	 * 			<code>null</code> caso contrario
	 */
	private Contact getContact(String name) {
		for (Contact c: contacts)
			if (c.getName().equals(name))
				return c;
		return null;
	}
}
