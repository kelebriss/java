package WS4;

public class DSAStack 
{
	Object[] stack;
	int count;
	int default_capacity = 100;
	
	public DSAStack() // default constructor
	{
		stack = new Object[default_capacity];
		count = 0;
	}
	public DSAStack(int maxCapacity) // alternate constructor
	{
		stack = new Object[maxCapacity];
		count = 0;
	}
	public int getCount() 
	{
		return count; 
	}
	public boolean isEmpty() //check the stack is empty or not
	{
		boolean status = false;
		if( getCount() == 0)
			status = true;	
		return status;
	}
	public boolean isFull()//check the stack is empty or not
	{
		boolean status = false;
		if( getCount() == stack.length)
			status = true;
		return status;
	}
	public void push(Object value) //add the value in stack
	{
		if(isFull() == true) // if stack is full then throw exception
			throw new ArrayIndexOutOfBoundsException ("stack is full");
		else
		{   stack[getCount()] = value; // add value in stack
			count++; // increase count
		}
	}
	public Object pop() // return the value from stack.
	{
		Object topVal = top(); // return the top value
		count--; //decrease count
		return topVal;
	}
	public Object top()
	{
		Object topVal;
		if(isEmpty() == true) // if stack is empty then throw exception
			throw new ArrayIndexOutOfBoundsException(" stack is empty");
		else
			topVal = stack[getCount()-1];// return the last entered value
		return topVal;
	}
}
