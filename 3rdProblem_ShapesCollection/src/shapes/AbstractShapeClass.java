package shapes;

abstract class AbstractShapeClass implements Shape {

	// Constants
	private static final int COORDINATES = 2;
	private static final int CENTER_X = 0;
	private static final int CENTER_Y = 1;
	
	// Instance variables
	private String id;
	private int[] center;
	
	public AbstractShapeClass(String id, int centerX, int centerY) {
		this.id = id;
		center = new int[COORDINATES];
		center[CENTER_X] = centerX;
		center[CENTER_Y] = centerY;
	}
	

	@Override
	public String getID() {
		return id;
	}

	
	@Override
	public int getCenterX() {
		return center[CENTER_X];
	}

	
	@Override
	public int getCenterY() {
		return center[CENTER_Y];
	}

	
	@Override
	public void move(int x, int y) {
		center[CENTER_X] = x;
		center[CENTER_Y] = y;
	}

	
	@Override
	public abstract double area();
	
	@Override
	public abstract String getType();
	
}
