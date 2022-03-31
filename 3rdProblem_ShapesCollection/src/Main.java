import java.util.Scanner;

import shapes.Iterator;
import shapes.Shape;
import shapes.ShapesCollection;
import shapes.ShapesCollectionClass;

public class Main {
	// Constants
		// Commands
	private static final String CIRCLE = "CIRCLE";
	private static final String RECTANGLE = "RECTANGLE";
	private static final String LIST = "LIST";
	private static final String MOVE = "MOVE";
	private static final String MINAREA = "MINAREA";
	private static final String EXIT = "EXIT";
	
	
		// Output messages
	private static final String CIRCLE_ADDED = "A new circle was added.";
	private static final String RECTANGLE_ADDED = "A new rectangle was added.";
	private static final String ID_ALREADY_EXISTS = "Identifier already exists.";
	private static final String ID_NOT_EXISTS = "Identifier does not exist.";
	private static final String LIST_MESSAGE = "All shapes in the collection:";
	private static final String LISTING_SHAPES = "%s (%d, %d) %s\n";
	private static final String SHAPE_MOVED = "Shape was moved.";
	private static final String LISTING_AREA = "%s (%d, %d) %s\n";
	private static final String EMPTY_COLLECTION = "Empty collection.";
	private static final String EXIT_MESSAGE = "Exiting...";
	private static final String UNKNOWN_COMMAND = "Unknown command.";
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ShapesCollection col = new ShapesCollectionClass();
		
		String command;
		do {
			command = in.next().toUpperCase();
			interpretCommands(command, col, in);
		} while(!command.equals(EXIT));
		
		in.close();
	}
	
	/**
	 * Interprets user's commands
	 * 
	 * @param command: input by user
	 * @param col: shapes collection
	 * @param in: input reader
	 * @pre command != null && col != null && in != null
	 */
	private static void interpretCommands(String command, ShapesCollection col, Scanner in) {
		switch (command) {
			case CIRCLE:
				handleAddCircle(col, in);
				break;
			case RECTANGLE:
				handleAddRectangle(col, in);
				break;
			case LIST:
				handleList(col, in);
				break;
			case MOVE:
				handleMove(col, in);
				break;
			case MINAREA:
				handleMinArea(col, in);
				break;
			case EXIT:
				handleExit();
				break;
			default:
				 System.out.println(UNKNOWN_COMMAND);
		}
		System.out.println();
	}
	
	/**
	 * 
	 * 
	 * @param col:	shapes collection
	 * @param in: input reader
	 * @pre col != null && in != null
	 */
	private static void handleAddCircle(ShapesCollection col, Scanner in) {
		
		String id = in.next();
		int x = in.nextInt();
		int y = in.nextInt();
		int radius = in.nextInt(); in.nextLine();
		
		if (col.hasShape(id))
			System.out.println(ID_ALREADY_EXISTS);
		else {
			col.addCircle(id, x, y, radius);
			System.out.println(CIRCLE_ADDED);
		}	
	}
	
	/**
	 * 
	 * 
	 * @param col:	shapes collection
	 * @param in: input reader
	 * @pre col != null && in != null
	 */
	private static void handleAddRectangle(ShapesCollection col, Scanner in) {
		
		String id = in.next();
		int x = in.nextInt();
		int y = in.nextInt();
		int height = in.nextInt();
		int width = in.nextInt(); in.nextLine();
		
		if (col.hasShape(id))
			System.out.println(ID_ALREADY_EXISTS);
		else {
			col.addRectangle(id, x, y, height, width);
			System.out.println(RECTANGLE_ADDED);
		}	
	}
	
	/**
	 * 
	 * 
	 * @param col:	shapes collection
	 * @param in: input reader
	 * @pre col != null && in != null
	 */
	private static void handleList(ShapesCollection col, Scanner in) {
		if (col.isEmpty())
			System.out.println(EMPTY_COLLECTION);
		else {
			System.out.println(LIST_MESSAGE);
			Iterator it = col.allShapesIterator();
			
			while (it.hasNext()) {
				Shape shape = it.next();
				System.out.printf(LISTING_SHAPES, 
						shape.getID(), 
						shape.getCenterX(), shape.getCenterY(),
						shape.getType());
			}
		}
	}
	
	/**
	 * 
	 * 
	 * @param col:	shapes collection
	 * @param in: input reader
	 * @pre col != null && in != null
	 */
	private static void handleMove(ShapesCollection col, Scanner in) {
		String id = in.next();
		int x = in.nextInt();
		int y = in.nextInt(); in.nextLine();
		
		if (!col.hasShape(id))
			System.out.println(ID_NOT_EXISTS);
		else {
			col.move(id, x, y);
			System.out.println(SHAPE_MOVED);
		}
	}
	
	/**
	 * 
	 * 
	 * @param col:	shapes collection
	 * @param in: input reader
	 * @pre col != null && in != null
	 */
	private static void handleMinArea(ShapesCollection col, Scanner in) {
		if (col.isEmpty())
			System.out.println(EMPTY_COLLECTION);
		else {
			Shape shape = col.smallestArea();
			
			System.out.printf(LISTING_AREA, 
					shape.getID(),
					shape.getCenterX(), shape.getCenterY(),
					shape.getType());
		}
	}
	
	/**
	 * 
	 * 
	 * @param col:	shapes collection
	 * @param in: input reader
	 * @pre col != null && in != null
	 */
	private static void handleExit() {
		System.out.println(EXIT_MESSAGE);
	}
}
