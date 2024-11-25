package parallelcomputing;

public class CallCounts {
	int value = 0;
	
	
	public void update(int amount) {
		value+=amount;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

}
