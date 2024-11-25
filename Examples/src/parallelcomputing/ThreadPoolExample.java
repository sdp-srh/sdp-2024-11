package parallelcomputing;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
	public static void main(String[] args) {

		// ExecutorService executor = Executors.newSingleThreadExecutor();
		ExecutorService executor = Executors.newFixedThreadPool(5);

		CallCounts callCounts = new CallCounts();
		for (int i = 1; i <= 3; i++) {
			CounterThread ct = new CounterThread("" + i + " Name", 0, callCounts);
			executor.execute(ct);
		}

		System.out.println(callCounts.getValue());
		shutdownAndAwaitTermination(executor);
		System.out.println(callCounts.getValue());
	}

	static void shutdownAndAwaitTermination(ExecutorService pool) {
		// Disable new tasks from being submitted
		pool.shutdown();
		try {
			// Wait a while for existing tasks to terminate
			if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
				// Cancel currently executing tasks forcefully
				pool.shutdownNow();
				// Wait a while for tasks to respond to being cancelled
				if (!pool.awaitTermination(60, TimeUnit.SECONDS))
					System.err.println("Pool did not terminate");
			}
		} catch (InterruptedException ex) {
			// (Re-)Cancel if current thread also interrupted
			pool.shutdownNow();
			// Preserve interrupt status
			Thread.currentThread().interrupt();
		}
	}
}
