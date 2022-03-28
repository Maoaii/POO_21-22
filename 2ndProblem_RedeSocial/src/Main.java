import java.util.Scanner;

import FriendsBook.*;

public class Main {
	// Constants
	private static final String PERSON_REGISTERED = "Pessoa registada.";
	private static final String PERSON_NOT_REGISTERED = "Sem registo.";
	private static final String PERSON_REGISTERED_SUCCESS = "Pessoa registada com sucesso.";
	private static final String FRIENDSHIP_EXISTS = "Amizade existente.";
	private static final String FRIENDSHIP_NOT_EXISTS = "Amizade inexistente.";
	private static final String FRIENDSHIP_CREATED = "Amizade criada.";
	private static final String FRIENDSHIP_INVALID = "Amizade invalida.";
	private static final String NO_FRIENDS = "Nao tem amigos registados.";
	private static final String FRIENDS_LIST = "Lista de amigos:";
	private static final String STATUS_ALTERED = "Estado alterado.";
	private static final String NO_PEOPLE = "Rede Social vazia.";
	private static final String PEOPLE_LIST = "Lista de pessoas registadas:";
	private static final String PEOPLE_LISTING = "%s; %s\n";
	private static final String POST_REGISTERED = "Post registado.";
	private static final String MURAL_LIST = "Mural de %s\n";
	private static final String MURAL_LISTING = "%s; %s\n";
	private static final String QUIT_MESSAGE = "Adeus.";
	
	private static final String CHECK_PERSON = "CONSULTAPESSOA";
	private static final String REGISTER_PERSON = "REGISTA";
	private static final String CHECK_FRIENDSHIP = "CONSULTAAMIZADE";
	private static final String REGISTER_FRIENDSHIP = "AMIGOS";
	private static final String LIST_FRIENDS = "CONSULTAAMIGOS";
	private static final String NEW_STATUS = "NOVOESTADO";
	private static final String CHECK_STATUS = "CONSULTAESTADO";
	private static final String LIST_PEOPLE = "PESSOAS";
	private static final String POST_PUBLIC = "POSTARPUBLICO";
	private static final String POST = "POSTAR";
	private static final String MURAL = "MURAL";
	private static final String QUIT = "SAIR";
	private static final String COMANDO_DESCONHECIDO = "Comando desconhecido.";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		FriendsBook fb = new FriendsBookClass();
		
		String command;
		do {
			command = in.nextLine().toUpperCase();
			interpretCommands(command, fb, in);
		} while(!command.equals(QUIT));
		
		in.close();
	}
	
	/**
	 * Interprets user's commands
	 * 
	 * @param command: input by user
	 * @param fb: friends book
	 * @param in: input reader
	 * @pre command != null && fb != null && in != null
	 */
	private static void interpretCommands(String command, FriendsBook fb, Scanner in) {
		switch (command) {
			case CHECK_PERSON:
				checkPerson(fb, in);
				break;
			case REGISTER_PERSON:
				registerPerson(fb, in);
				break;
			case CHECK_FRIENDSHIP:
				checkFriendship(fb, in);
				break;
			case REGISTER_FRIENDSHIP:
				registerFriendship(fb, in);
				break;
			case LIST_FRIENDS:
				listFriends(fb, in);
				break;
			case NEW_STATUS:
				setNewStatus(fb, in);
				break;
			case CHECK_STATUS:
				checkStatus(fb, in);
				break;
			case LIST_PEOPLE:
				listPeople(fb);
				break;
			case POST_PUBLIC:
				postPublic(in, fb);
				break;
			case POST:
				post(in, fb);
				break;
			case MURAL:
				//checkMural(in, fb);
				break;
			case QUIT:
				handleQuit();
				break;
			default:
				 System.out.println(COMANDO_DESCONHECIDO);
		}
		System.out.println();
	}
	
	/**
	 * Checks if a person is in friends book
	 * 
	 * @param fb: friends book
	 * @param in: input reader
	 * @pre fb != null & in != null
	 */
	private static void checkPerson(FriendsBook fb, Scanner in) {
		String name = in.nextLine();
		if (fb.doesPersonExist(name))
			System.out.println(PERSON_REGISTERED);
		else
			System.out.println(PERSON_NOT_REGISTERED);
	}
	
	/**
	 * Registers a person in friends book
	 * 
	 * @param fb: friends book
	 * @param in: input reader
	 * @pre fb != null & in != null
	 */
	private static void registerPerson(FriendsBook fb, Scanner in) {
		String name = in.nextLine();
		String email = in.nextLine();
		String status = in.nextLine();
		
		if (fb.doesPersonExist(name))
			System.out.println(PERSON_REGISTERED);
		else {
			fb.registerPerson(name, email, status);
			System.out.println(PERSON_REGISTERED_SUCCESS);
		}
	}
	
	/**
	 * Checks if two people are friends
	 * 
	 * @param fb
	 * @param in
	 * @pre fb != null && in != null
	 */
	private static void checkFriendship(FriendsBook fb, Scanner in) {
		String name1 = in.nextLine();
		String name2 = in.nextLine();
		
		if (!fb.doesPersonExist(name1) || !fb.doesPersonExist(name2))
			System.out.println(FRIENDSHIP_NOT_EXISTS);
		else if (fb.checkFriendship(name1, name2))
			System.out.println(FRIENDSHIP_EXISTS);
		else
			System.out.println(FRIENDSHIP_NOT_EXISTS);
	}
	
	/**
	 * Registers a friendship between two people
	 * 
	 * @param fb
	 * @param in
	 * @pre fb != null && in != null
	 */
	private static void registerFriendship(FriendsBook fb, Scanner in) {
		String name1 = in.nextLine();
		String name2 = in.nextLine();
		
		if (!fb.doesPersonExist(name1) || !fb.doesPersonExist(name2))
			System.out.println(PERSON_NOT_REGISTERED);
		else if (fb.checkFriendship(name1, name2))
			System.out.println(FRIENDSHIP_EXISTS);
		else if (name1.equals(name2))
			System.out.println(FRIENDSHIP_INVALID);
		else {
			fb.registerFriendsip(name1, name2);
			System.out.println(FRIENDSHIP_CREATED);
		}
	}
	
	/**
	 * Lists a person's friends
	 * 
	 * @param fb
	 * @param in
	 * @pre fb != null && in != null
	 */
	private static void listFriends(FriendsBook fb, Scanner in) {
		String name = in.nextLine();
		
		if (!fb.doesPersonExist(name))
			System.out.println(PERSON_NOT_REGISTERED);
		else if (!fb.hasFriends(name))
			System.out.println(NO_FRIENDS);
		else {
			PersonIterator it = fb.getFriendsIterator(name);
			System.out.println(FRIENDS_LIST);
			while (it.hasNext()) {
				Person person = it.next();
				System.out.printf(PEOPLE_LISTING, person.getName(), person.getEmail());
			}
		}
			
	}
	
	/**
	 * Sets a new status for a person
	 * 
	 * @param fb
	 * @param in
	 * @pre fb != null && in != null
	 */
	private static void setNewStatus(FriendsBook fb, Scanner in) {
		String name = in.nextLine();
		String status = in.nextLine();
		
		if (fb.doesPersonExist(name)) {
			fb.changePersonStatus(name, status);
			System.out.println(STATUS_ALTERED);
		}	
		else
			System.out.println(PERSON_NOT_REGISTERED);
	}
	
	/**
	 * Checks what's this person's status
	 * 
	 * @param fb
	 * @param in
	 * @pre fb != null && in != null
	 */
	private static void checkStatus(FriendsBook fb, Scanner in) {
		String name = in.nextLine();
		
		if (fb.doesPersonExist(name)) {
			System.out.println(fb.getPersonStatus(name));
		}
		else
			System.out.println(PERSON_NOT_REGISTERED);
	}
	
	/**
	 * Lists all the people in friends book
	 * 
	 * @param fb
	 * @param in
	 * @pre fb != null && in != null
	 */
	private static void listPeople(FriendsBook fb) {
		PersonIterator it = fb.getIterator();
		
		if (!it.hasNext())
			System.out.println(NO_PEOPLE);
		else
			System.out.println(PEOPLE_LIST);
		
		while (it.hasNext()) {
			Person person = it.next();
			System.out.printf(PEOPLE_LISTING, person.getName(), person.getEmail());
		}
	}
	
	
	private static void postPublic(Scanner in, FriendsBook fb) {
		String author = in.nextLine();
		String post = in.nextLine();
		
		if (fb.doesPersonExist(author)) {
			fb.postPublic(author, post);
			System.out.println(POST_REGISTERED);
		}
		else
			System.out.println(PERSON_NOT_REGISTERED);
	}
	
	private static void post(Scanner in, FriendsBook fb) {
		String author = in.nextLine();
		String post = in.nextLine();
		String destination = in.nextLine();
		
		if (!fb.doesPersonExist(author) || !fb.doesPersonExist(destination))
			System.out.println(PERSON_NOT_REGISTERED);
		else if (!fb.checkFriendship(author, destination)) {
			System.out.println(FRIENDSHIP_NOT_EXISTS);
		}
		else {
			fb.post(author, post, destination);
			System.out.println(POST_REGISTERED);
		}
	}
	
	/**
	 * Prints out the quit message
	 */
	private static void handleQuit() {
		System.out.println(QUIT_MESSAGE);
	}
}
