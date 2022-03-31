package shapes;

class RectangleClass extends AbstractShapeClass {

	// Constants
	private static final String TYPE = "RECTANGLE";
	
	// Instance variables
	private String type;
	private int height;
	private int width;
	
	/**
	 * Rectangle constructor
	 * 
	 * @param id:	shape id
	 * @param centerX: shape x coordinate
	 * @param centerY: shape y coordinate
	 * @param width: rectangle width
	 * @param height: rectangle height
	 * @pre id != null
	 */
	public RectangleClass(String id, int centerX, int centerY, int height, int width) {
		super(id, centerX, centerY);
		this.height = height;
		this.width = width;
		type = TYPE;
	}

	@Override
	public double area() {
		return width*height;
	}

	@Override
	public String getType() {
		return type;
	}

}
