package pontus.osgi.clienta.internal;

import pontus.osgi.fibonacci.FibonacciService;

public class ClientThread extends Thread {
	private volatile boolean active = true;
	private final FibonacciService service;

	public ClientThread(FibonacciService service) {
		this.service = service;
	}

	public void run() {
		int counter = 0;
		while (active) {
			System.out.println("Client-A: " + service.getNextFib());
			if (counter == 3) {
				stopThread();
			}
			counter++;
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println("Thread interrupted " + e.getMessage());
			}
		}
	}

	public void stopThread() {
		System.out.println("Closing Client-A");
		active = false;
	}

}
