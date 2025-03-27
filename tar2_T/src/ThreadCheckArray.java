
/**
 * class to run 2 threads on array and check with 2 threads if 
 * if a subset sum equals a given value.
 * @author 97250 alaa.barazi
 * 
 */
public class ThreadCheckArray implements Runnable 
{
	
	/**
	 * @param flag indicating whether a valid subset sum has been found.
	 * @param winArray elements in the subset sum
	 * @param sd syncronize the threads
	 * @param array
	 * 
	 */
	private boolean flag;
	private boolean [] winArray;
	SharedData sd;
	int[] array;
	int b;
	
	/**
	 * constructor that creates new new array from the shared data
	 * @param sd
	 */
	public ThreadCheckArray(SharedData sd) 
	{
		this.sd = sd;	
		synchronized (sd) 
		{
			array = sd.getArray();
			b = sd.getB();
		}		
		winArray = new boolean[array.length];
	}
	
	/**
	 * method to check if a subset sum equals b.
	 * If a subset is found, it updates the winArray and sets the flag.
	 * @param n current index checked in the array.
	 * @param b remaining sum needed to reach the target.
	 */
	void rec(int n, int b)
	{
		synchronized (sd) 
		{
			if (sd.getFlag())
				return;
		}	
		if (n == 1)
		{
			if(b == 0 || b == array[n-1])
			{
				flag = true;
				synchronized (sd) 
				{
					sd.setFlag(true);
				}			
			}
			if (b == array[n-1])
				winArray[n-1] = true;
			return;
		}
		
		rec(n-1, b - array[n-1]);
		if (flag)
			winArray[n-1] = true;
		synchronized (sd) 
		{
			if (sd.getFlag())
				return;
		}	
		rec(n-1, b);
	}

	/**
	 * method that threads will run -
	 *  each thread will check the sum in separate section of the array
	
	 */
	public void run() {
		if (array.length != 1)
			if (Thread.currentThread().getName().equals("thread1"))
				rec(array.length-1, b - array[array.length - 1]);
			else 
				rec(array.length-1, b);
		if (array.length == 1)
			if (b == array[0] && !flag)
			{
				winArray[0] = true;
				flag = true;
				synchronized (sd) 
				{
					sd.setFlag(true);
				}
			}
		if (flag)
		{
			if (Thread.currentThread().getName().equals("thread1"))
				winArray[array.length - 1] = true;
			synchronized (sd) 
			{
				sd.setWinArray(winArray);
			}	
		}
	}
}
