package a;


class FloatingPoint 
{
	static double precision = 0.00000001;
	
	public FloatingPoint()
	{
		precision = 0.00000001;
	}
	public FloatingPoint(double value)
	{
		precision = value;
	}
	public FloatingPoint(FloatingPoint num)
	{
		precision = num.precision;
	}
	public boolean isEqual(FloatingPoint num)
	{
		boolean result = false;
		if(precision == num.precision)
			result = true;
		return result;
	}
	public static void setPrecision(double value)
	{
		precision = value;
	}
	public void add(FloatingPoint num)
	{
		precision += num.precision;
	}
	public void add(int num)
	{
		precision += num;
	}
	public void invert()
	{
		precision = 1.0 - precision;
	}
	public void times(FloatingPoint num)
	{
		precision *= num.precision;
	}
	public String toString()
	{
		return Double.toString(precision);
	}
}
