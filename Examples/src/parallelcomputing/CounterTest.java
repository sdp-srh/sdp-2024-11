package parallelcomputing;

import java.util.ArrayList;

public class CounterTest {
	public static void main(String args[]) throws InterruptedException {
		CallCounts callCounts = new CallCounts();
		CounterThread threadA = new CounterThread("Thread A", 0, callCounts);
		CounterThread threadB = new CounterThread("Thread B", 0, callCounts);
		CounterThread threadC = new CounterThread("Thread C", 0, callCounts);
		ArrayList<Thread> threads = new ArrayList<Thread>();
		threads.add(threadA);
		threads.add(threadB);
		threads.add(threadC);
		// start
		threadA.start();
		threadB.start();
		threadC.start();
		
		System.out.println("Amount of update calls :"+callCounts.getValue());
		
		for (Thread thread : threads) {
			thread.join();
		}
		System.out.println("Amount of update calls :"+callCounts.getValue());
	}
}



