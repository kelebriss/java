package a;


class Qn 
{
	int i;
	int count = 0;
	int default_capacity = 1000; // set the default capacity as 1000
	HNode [] queue; // set node array
	
	public Qn() // default constructor
	{
		queue = new HNode[default_capacity];
	}
	public boolean isEmpty() // check queue is Empty or not
	{
		boolean state = false;
		if(count == 0)
			state = true;
		return state;
	}
	public int numNodes() // check how many nodes are in queue
	{
		return count;
	}
	public boolean add(HNode node) // check the same node is exits in queue or not
	{
		boolean state = false;
		i=0;
		while(queue[i] != null || state == false)
		{
			if(queue[i] == node)
				state = true;
			i++;
		}
		return state;
	}
	public void merge(HNode node) // if same node exist then do merge
	{
		while(queue[i] != null)
		{
			if(queue[i] == node)
				queue[i].mergeInto(node);
			i++;
		}
	}
	public boolean isFull() // check the queue is full or not
	{
		boolean state = false;
		if(count >= default_capacity)
			state = true;
		return state;
	}
	public void insert(HNode node) // insert node into queue
	{
		int i;
		if(isFull()) // if full then make new queue array as double size
		{
			HNode[] oldQueue;
			oldQueue = queue;
			queue = new HNode[count*2];
			for(i = 0; i < oldQueue.length; i++)
			{
				queue[i] = oldQueue[i];
			}
		}
		queue[count] = node;
		count++;
	}
	public void swap(Qc current) // all of Qn data move to Qc and delete it
	{
		for(i=0; i<count; i++)
		{
			current.insert(queue[i]);
			queue[i] = null;
		}
	}
}
