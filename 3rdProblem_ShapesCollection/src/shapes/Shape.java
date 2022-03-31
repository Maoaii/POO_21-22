package shapes;

public interface Shape {
	
	/**
	 * @return this shape's id
	 */
	String getID();
	
	/**
	 * @return this shape's x coordinate
	 */
	int getCenterX();
	
	/**
	 * @return this shape's y coordinate
	 */
	int getCenterY();
	
	/**
	 * Moves this shape by (x, y)
	 * 
	 * @param x
	 * @param y
	 */
	void move(int x, int y);
	
	/**
	 * Does not belong to abstract class
	 * 
	 * @return this shape's area
	 */
	double area();
	
	/**
	 * Does not belong to abstract class.
	 * 
	 * @return this shape's type
	 */
	String getType();
}
