package pontus.osgi.clienta;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import pontus.osgi.clienta.internal.ClientThread;
import pontus.osgi.fibonacci.FibonacciService;

public class Activator implements BundleActivator {
	private ClientThread thread;

	private BundleContext context;
	private FibonacciService service;

	@Override
	public void start(BundleContext context) throws Exception {
		this.context = context;

		ServiceReference reference = context
				.getServiceReference(FibonacciService.class.getName());
		service = (FibonacciService) context.getService(reference);
		thread = new ClientThread(service);
		thread.start();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		thread.stopThread();
		thread.join();

	}

}
