/** Description
 *  @author Nur.Zid.Elkelani
 */
public class SharedData 
{
	
	/**
	 * Array to store data.
	 */
	private int [] array;
	/**
	 *Array to store boolean values, possibly representing states or results.

	 */
	private boolean [] winArray;
	/**
	 *Flag to indicate a particular state.

	 */
	private boolean flag;
	/**
	 * Final integer value 
	 */
	private final int b;
	
	/**Constructor to initialize array and final integer b.
	 * @param array  The array to be stored.
	 * @param b  The final integer value.
	 */
	public SharedData(int[] array, int b) {
		
		this.array = array;
		this.b = b;
	}

	/**Returns the winArray
	 * @return winArray
	 */
	public boolean[] getWinArray() 
	{
		return winArray;
	}

	/**Sets the winArray.
	 * @param winArray
	 */
	public void setWinArray(boolean [] winArray) 
	{
		this.winArray = winArray;
	}

	/** Returns the array
	 * @return array
	 */
	public int[] getArray() 
	{
		return array;
	}

	/**Returns the b
	 * @return b
	 */
	public int getB() 
	{
		return b;
	}

	/**Returns the flag
	 * @return flag 
	 */
	public boolean getFlag() 
	{
		return flag;
	}

	/** Sets the setFlag.
	 * @param flag 
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
