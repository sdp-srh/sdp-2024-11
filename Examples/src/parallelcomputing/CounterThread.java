package parallelcomputing;

public class CounterThread extends Thread {
	String name;
	int start;
	CallCounts callCounts;
	public CounterThread(String name, int start, CallCounts callCounts) {
		this.name = name;
		this.start = start;
		this.callCounts = callCounts;
	}
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name+": "+(start+i));
			callCounts.update(1);
		}
		System.out.println(name+" has finished");
	}
}




