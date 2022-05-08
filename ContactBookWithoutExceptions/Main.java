import java.util.Scanner;

import cbook.Contact;
import cbook.ContactBook;
import cbook.ContactBookInList;
import exceptions.EmptyStringException;
import exceptions.PhoneNumberNotInRange;
import exceptions.PhoneNumberNotNineDigits;

/**
 * Programa principal para a aplicacao ContactBook.
 */
public class Main {
	//Constantes que definem as mensagens para o utilizador
	public static final String CONTACT_EXISTS = "Contact already exists.";
	public static final String NAME_NOT_EXIST = "Contact does not exist.";
	public static final String CONTACT_ADDED = "Contact added.";
	public static final String CONTACT_REMOVED = "Contact removed.";
	public static final String CONTACT_UPDATED = "Contact updated.";
	public static final String BOOK_EMPTY = "Contact book empty.";
	public static final String ERROR = "Unknown command.";
	public static final String EXIT = "Goodbye!";

	// Enumerado que define os comandos
	private enum Command {
		ADD_CONTACT("AC"), REMOVE_CONTACT("RC"), GET_PHONE("GP"), GET_EMAIL("GE"), 
		SET_PHONE("SP"), SET_EMAIL("SE"), LIST_CONTACTS("LC"), 
		QUIT("Q"), UNKNOWN_COMMAND("");

		private final String commandInputName;

		private Command(String commandInputName) {
			this.commandInputName = commandInputName;
		}

		public String getCommandInputName() {
			return commandInputName;
		}
	};

	/**
	 * Programa principal. Invoca interpretador de comandos.
	 * @param args - argumentos para execucao da aplicacao. Nao sao usados, neste programa.
	 */
	public static void main(String[] args) { 
		Main.execute_commands();
	}

	/**
	 * Interpretador de comandos.
	 */
	private static void execute_commands() {
		Scanner in = new Scanner(System.in);
		ContactBook cBook = new ContactBookInList();
		Command comm = readCommand(in);
		while (!comm.equals(Command.QUIT)){
			switch (comm) {
			case ADD_CONTACT:
				addContact(in,cBook);
				break;
			case REMOVE_CONTACT:
				deleteContact(in,cBook);
				break;
			case GET_PHONE:
				getPhone(in,cBook);
				break;
			case GET_EMAIL:
				getEmail(in,cBook);
				break;
			case SET_PHONE:
				setPhone(in,cBook);
				break;
			case SET_EMAIL:
				setEmail(in,cBook);
				break;
			case LIST_CONTACTS:
				listAllContacts(cBook);
				break;
			default:
			}
			System.out.println();
			comm = readCommand(in);
		}
		System.out.println(EXIT);
		System.out.println();
		in.close();
	}

	/**
	 * Le o novo comando a executar.
	 * @param in input de onde os dados vao ser lidos.
	 */
	private static Command readCommand(Scanner in) {
		String input = in.nextLine().toUpperCase().trim();
		for (Command c :Command.values())
			if (c.getCommandInputName().equals(input))
				return c;
		return Command.UNKNOWN_COMMAND;
	}

	/**
	 * Adiciona um novo contacto, se ele ainda nao existir. Se ja existir, nao faz nada.
	 * @param in input de onde os dados vao ser lidos.
	 * @param cBook ContactBook no qual se pretende adicionar o contacto.
	 */
	private static void addContact(Scanner in, ContactBook cBook)
			throws NumberFormatException {
		String name, email;
		name = email = "";
		int phone = 0;



		try {
			// Try to get user name
			name = getUserInfo(in);

			// Try to get a phone number
			phone = getPhoneNumber(in);

			// Try to get user email
			email = getUserInfo(in);
		} catch (NumberFormatException e) {
			// If it's not a number, retry
			System.out.println("Not a valid number.");
			execute_commands();
		} catch (PhoneNumberNotNineDigits e) {
			// If it's not nine digits, retry
			System.out.println(e.getErrorInfo());
			execute_commands();
		} catch (PhoneNumberNotInRange e) {
			// If it's not in phone number range, retry
			System.out.println(e.getErrorInfo());
			execute_commands();
		} catch (EmptyStringException e) {
			System.out.println(e.getErrorInfo());
			execute_commands();
		}


		if (!cBook.hasContact(name)) {
			cBook.addContact(name, phone, email);
			System.out.println(Main.CONTACT_ADDED);
		} else System.out.println(Main.CONTACT_EXISTS);
	}

	private static int getPhoneNumber(Scanner in)
			throws PhoneNumberNotInRange, PhoneNumberNotNineDigits, EmptyStringException {
		int number = Integer.parseInt(in.nextLine().trim());

		// Throw not nine digits exception
		if (number < 100000000 || number > 999999999)
			throw new PhoneNumberNotNineDigits("Number is not 9 digits.");
		// Throw not in range exception
		else if (number < 200000000)
			throw new PhoneNumberNotInRange("Number is not between valid range.");

		return number;
	}

	private static String getUserInfo(Scanner in) throws EmptyStringException {
		String info = in.nextLine().trim();

		// Throw empty string exception
		if (info.equals(""))
			throw new EmptyStringException("Name and/or email must not be empty.");

		return info;
	}

	/**
	 * Remove um contacto, se ele existir. Se nao ja existir, nao faz nada.
	 * @param in input de onde os dados vao ser lidos.
	 * @param cBook ContactBook no qual se pretende remover o contacto.
	 */
	private static void deleteContact(Scanner in, ContactBook cBook) {
		String name;
		name = in.nextLine();
		if (cBook.hasContact(name)) {
			cBook.deleteContact(name);
			System.out.println(Main.CONTACT_REMOVED);
		}
		else System.out.println(Main.NAME_NOT_EXIST);
	}

	/**
	 * Consulta o telefone de um contacto, se ele existir. Se nao existir, nao faz nada.
	 * @param in input de onde os dados vao ser lidos.
	 * @param cBook ContactBook no qual se pretende consultar o telefone de um contacto.
	 */
	private static void getPhone(Scanner in, ContactBook cBook) {
		String name;
		name = in.nextLine();
		if (cBook.hasContact(name)) {
			System.out.println(cBook.getPhone(name));
		}
		else System.out.println(Main.NAME_NOT_EXIST);
	}

	/**
	 * Consulta o email de um contacto, se ele existir. Se nao existir, nao faz nada.
	 * @param in input de onde os dados vao ser lidos.
	 * @param cBook ContactBook no qual se pretende consultar o email de um contacto.
	 */
	private static void getEmail(Scanner in, ContactBook cBook) {
		String name;
		name = in.nextLine();
		if (cBook.hasContact(name)) {
			System.out.println(cBook.getEmail(name));
		}
		else System.out.println(Main.NAME_NOT_EXIST);
	}

	/**
	 * Altera o telefone de um contacto, se ele existir. Se nao existir, nao faz nada.
	 * @param in input de onde os dados vao ser lidos.
	 * @param cBook ContactBook no qual se pretende alterar o telefone de um contacto.
	 */
	private static void setPhone(Scanner in, ContactBook cBook) {
		String name;
		int phone;
		name = in.nextLine();
		phone = in.nextInt(); in.nextLine();
		if (cBook.hasContact(name)) {
			cBook.setPhone(name,phone);
			System.out.println(Main.CONTACT_UPDATED);
		}
		else System.out.println(Main.NAME_NOT_EXIST);
	}

	/**
	 * Altera o email de um contacto, se ele existir. Se nao existir, nao faz nada.
	 * @param in input de onde os dados vao ser lidos.
	 * @param cBook ContactBook no qual se pretende alterar o email de um contacto.
	 */
	private static void setEmail(Scanner in, ContactBook cBook) {
		String name;
		String email;
		name = in.nextLine();
		email = in.nextLine();
		if (cBook.hasContact(name)) {
			cBook.setEmail(name,email);
			System.out.println(Main.CONTACT_UPDATED);
		}
		else System.out.println(Main.NAME_NOT_EXIST);
	}

	/**
	 * Lista todos os contactos.
	 * @param cBook ContactBook no qual se pretende listar os contactos.
	 */
	private static void listAllContacts(ContactBook cBook) {
		if (cBook.getNumberOfContacts() != 0) {
			java.util.Iterator<Contact> it = cBook.listContacts();
			while(it.hasNext()) 
				System.out.println(it.next());
		}
		else System.out.println(Main.BOOK_EMPTY);
	}
}
