package pontus.osgi.fibonacciservice.internal;

import pontus.osgi.fibonacci.FibonacciService;

public class MyFibonacciService implements FibonacciService {
	private long iteration;
	
	public MyFibonacciService(){
		iteration = 0;
	}
	@Override
	public long getNextFib() {
		
			//Två if-satser som sköter de tre första iterationerna i serien
			if (iteration == 0){
				iteration++;
				return 0;
				}
				
				if(iteration == 1 || iteration == 2){
				iteration++;
				return 1;
				}
				
				long nbr1 = 1;
				long nbr2 = 1;

				long fib = 0;

				//startar från n==3
				for(int i = 1; i<=iteration-2; i++ )
				{
				fib = nbr1 + nbr2;
				//Byt ut till nya värden
				nbr2 = nbr1;
				nbr1 = fib;
				}
				iteration++;
				return fib;
	}

}
