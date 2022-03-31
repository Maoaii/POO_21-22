package shapes;

class CircleClass extends AbstractShapeClass {

	// Constants
	private static final String TYPE = "CIRCLE";
	
	// Instance variables
	private String type;
	private int radius;
	
	/**
	 * Circle constructor
	 * 
	 * @param id:	shape id
	 * @param centerX:	shape x coordinate
	 * @param centerY: shape y coordinate
	 * @param radius: circle radius
	 * @pre id != null
	 */
	public CircleClass(String id, int centerX, int centerY, int radius) {
		super(id, centerX, centerY);
		this.radius = radius;
		type = TYPE;
	}

	
	@Override
	public double area() {
		return Math.PI*radius*radius;
	}

	
	@Override
	public String getType() {
		return type;
	}
}
