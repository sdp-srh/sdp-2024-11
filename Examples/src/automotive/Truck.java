package automotive;

public class Truck extends Car implements LoadingArea {
	
	private int capacity;

	@Override
	public int getCapacity() {
		return this.capacity;
	}

	@Override
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
