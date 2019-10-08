package a;

import java.io.*;

class Qc 
{
	int count=0;
	int default_capacity = 1000; // set the default capacity as 1000
	HNode [] queue; // set node array
	
	
	public Qc(HNode root) // set the root node and initialize empty queue
	{
		queue = new HNode[default_capacity];
		queue[0] = root;
		count++;
	}
	public HNode front() throws IOException // it is same as dequeque whene take value then delete it on queue
	{
		HNode node;
		int i=1;
		if(!isEmpty()) // check queue is empty or not
		{
			throw new IOException("empty");
		}
		else
		{
			node = queue[0]; // take first value from queue
			while(queue[i] != null) // shuffling the queue
			{
				queue[i-1] = queue[i];
			}
			count--; 
		}
		return node;
	}
	public boolean isEmpty() // check the queue is empty or not
	{
		boolean state = false;
		if(count==0)
			state = true;
		return state;
	}
	public boolean isFull() // check the queue is full or not
	{
		boolean state = false;
		if(count >= default_capacity)
			state = true;
		return state;
	}
	public void insert(HNode node) // insert the node into queue
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
}
