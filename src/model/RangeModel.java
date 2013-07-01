package model;

public class RangeModel
{
	private int min;
	private int max;
	private int size;
	
	public RangeModel(int min, int max)
	{
		this.min = min;
		this.max = max;
		size = (max - min)+1;
	}
	
	public Integer[] getRange()
	{
		Integer[] ints = new Integer[size];
		for (int i = 0; i < size; i++) {
			ints[i] = min + i;
		}
		return ints;
	}
	
	public int getMin()
	{
		return min;
	}

	public void setMin(int min)
	{
		this.min = min;
	}

	public int getMax()
	{
		return max;
	}

	public void setMax(int max)
	{
		this.max = max;
	}	
}
