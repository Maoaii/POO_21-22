package shapes;

public interface ShapesCollection {
	
	/**
	 * @return true if there are no shapes in collection
	 */
	boolean isEmpty();
	
	/**
	 * @param ID: shape id
	 * @pre ID != null
	 * @return true if there's another shape with same id
	 */
	boolean hasShape(String ID);
	
	/**
	 * Adds a new circle to the collection
	 * 
	 * @param ID: circle id
	 * @param x: circle x coordinate
	 * @param y: circle y coordinate
	 * @param radius: circle radius
	 * @pre ID != null
	 */
	void addCircle(String ID, int x, int y, int radius);
	
	/**
	 * Adds a new rectangle to the collection
	 * 
	 * @param ID: rectangle id
	 * @param x: rectangle x coordinate
	 * @param y: rectangle y coordinate
	 * @param height: rectangle height
	 * @param width: rectangle width
	 * @pre ID != null
	 */
	void addRectangle(String ID, int x, int y, int height, int width);
	
	/**
	 * Moves the shape with <code>id</code> by <code>(x, y)</code>
	 * 
	 * @param ID: shape to move with id
	 * @param x: shape x coordinate
	 * @param y: shape y coordinate
	 * @pre ID != null
	 */
	void move(String ID, int x, int y);
	
	/**
	 * @return the shape with the smallest area
	 */
	Shape smallestArea();
	
	/**
	 * @return and iterator for all shapes
	 */
	Iterator allShapesIterator();
}
