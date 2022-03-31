package shapes;

public class IteratorClass implements Iterator {
	private Shape[] shapes;
	private int size;
	private int index;
	
	
	public IteratorClass(Shape[] shapes, int size) {
		this.shapes = shapes;
		this.size = size;
		init();
	}
	
	
	@Override
	public void init() {
		index = 0;
	}

	@Override
	public boolean hasNext() {
		return index < size;
	}

	@Override
	public Shape next() {
		return shapes[index++];
	}

}
