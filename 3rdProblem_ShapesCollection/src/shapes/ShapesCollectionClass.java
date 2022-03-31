package shapes;

public class ShapesCollectionClass implements ShapesCollection {

	// Constants
	private static final int COLLECTION_SIZE = 50;
	private static final int GROWTH_FACTOR = 2;
	
	// Instance variables
	private Shape[] shapes;
	private int size;
	
	/**
	 * Shapes collection constructor
	 */
	public ShapesCollectionClass() {
		shapes = new Shape[COLLECTION_SIZE];
		size = 0;
	}
	
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean hasShape(String ID) {
		boolean found = false;
		int index = 0;
		
		if (!isEmpty()) {
			while(!found && index < size) {
				if (ID.equals(shapes[index].getID()))
					found = true;
				index++;
			}
		}
		
		return found;
	}

	@Override
	public void addCircle(String ID, int x, int y, int radius) {
		shapes[size] = new CircleClass(ID, x, y, radius);
		size++;
	}

	@Override
	public void addRectangle(String ID, int x, int y, int height, int width) {
		shapes[size] = new RectangleClass(ID, x, y, height, width);
		size++;
	}

	@Override
	public void move(String ID, int x, int y) {
		boolean found = false;
		int index = 0;
		
		if (!isEmpty()) {
			while(!found && index < size) {
				if (ID.equals(shapes[index].getID()))
					found = true;
				index++;
			}
		}
		
		shapes[index-1].move(x, y);
	}

	@Override
	public Shape smallestArea() {
		
		int index = 0;
		int smallestAreaIndex = 0;
		
		if (!isEmpty()) {
			double area = shapes[index].area();
			
			while(index < size) {
				double compareArea = shapes[index].area();
				
				if (compareArea <= area) {
					area = compareArea;
					smallestAreaIndex = index;
				}
				index++;
			}
		}
		
		
		return shapes[smallestAreaIndex];
	}

	@Override
	public Iterator allShapesIterator() {
		return new IteratorClass(shapes, size);
	}
	
}
