package pontus.osgi.fibonacciservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import pontus.osgi.fibonacci.FibonacciService;
import pontus.osgi.fibonacciservice.internal.MyFibonacciService;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		FibonacciService service = new MyFibonacciService();
		
		context.registerService(FibonacciService.class.getName(), service,
		        null);
		
		System.out.println("Fibbonaciservice is registered");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
