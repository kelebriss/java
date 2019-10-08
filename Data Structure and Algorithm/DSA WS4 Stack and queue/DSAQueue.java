package WS4;

public class DSAQueue 
{
	Object[] queue;
	int count;
	int default_capacity = 100;
	
	public DSAQueue() //default constructor
	{
		queue = new Object[default_capacity];
		count = 0;
	}
	public DSAQueue(int maxCapacity) //alternate constructor
	{
		queue = new Object[maxCapacity];
		count = 0;
	}
	public int getCount()
	{
		return count;
	}
	public boolean isEmpty()//check the queue is empty or not
	{
		boolean status = false;
		if( getCount() == 0)
			status = true;	
		return status;
	}
	public boolean isFull()//check the queue is full or not
	{
		boolean status = false;
		if( getCount() == queue.length)
			status = true;
		return status;
	} 
	public void enqueue(Object value)//add the value in queue
	{
		if(isFull() == true) // if full throw exception
			throw new ArrayIndexOutOfBoundsException("queue is full");
		else //if not full add value and increase count
		{
			queue[count]=value;
		    count++;
		}
	}
	public Object dequeue() // return the value from queue
	{
		int i;
		Object frontVal;
		if(isEmpty() == true) // if empty then throw exception
			throw new ArrayIndexOutOfBoundsException("queue is empty");
		else
		{
			frontVal = queue[0];// passing the value in to frontVal
			
			for(i=0; i<count-1; i++)//shuffle the value, it means delete first value
			{
				queue[i] = queue[i+1];
			}
			queue[count-1] = null; // make last queue place to be empty
			count--; // reduce count because dequeque the value
		}
		return frontVal;
	}
	public Object peek()// check the first value but do not delete it
	{
		Object frontVal;
		if(isEmpty() == true) // if empty then throw exception
			throw new ArrayIndexOutOfBoundsException("queue is empty");
		else
			frontVal = queue[0];// passing the value in to frontVal
		
		return frontVal;
	}
}
