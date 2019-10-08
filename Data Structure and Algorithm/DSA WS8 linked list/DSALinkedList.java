package WS8;
import java.util.*;
public class DSALinkedList implements Iterable
{
	private class DSAListNode //inner class for list
	{
		Object value; 
		DSAListNode next,prev;
		
		public DSAListNode() // default constructor
		{
			value = 0;
			next = null;
			prev = null;
		}
		public DSAListNode(Object inValue) // alternate constructor
		{
			value = inValue;
			next = null;
			prev = null;
		}
		public Object getValue() //function for getting value
		{
			return value;
		}
		public void setValue(Object inValue) //  function for setting value
		{
			value = inValue;
		}
		public DSAListNode getNext() // function for getting next node
		{
			return next;
		}
		public void setNext(DSAListNode node)// function for setting next node
		{
			next = node;
		}
		public DSAListNode getPrev() // function for getting previous node
		{
			return prev;
		}
		public void setPrev(DSAListNode node)// function for setting previous node
		{
			prev = node;
		}
	} // end inner class

	private class DSALinkedListIterator implements Iterator
	{
		private DSAListNode iterNext;
		public DSALinkedListIterator(DSALinkedList list)
		{
			iterNext = list.head;
		}
		public boolean hasNext()
		{
			return (iterNext != null);
		}
		public Object next()
		{
			Object val;
			if(iterNext == null)
				val = null;
			else
			{
				val = iterNext.getValue();
				iterNext = iterNext.getNext();
			}
			return val;
		}
		public void remove()
		{
			throw new UnsupportedOperationException("not supported");
		}
	}
	
	public Iterator iterator()
	{
		return new DSALinkedListIterator(this);
	}
	
	DSAListNode head,tail;
	
	public DSALinkedList() // default constructor
	{
		head = null;
		tail = null;
	}
	public void insertFirst(Object newValue) // insert value into linked list at first 
	{
		DSAListNode node = new DSAListNode(newValue); // allocate new node
		if(isEmpty() == true) // if linked list is empty then node is tail also head.
		{
			head = node;
			tail = node;
		}	
		else // if linked list has any node then do this
		{
			head.setPrev(node); // set head's previous node is new inserted node
			node.setNext(head); // set new inserted node next node is head node
			head = node; // set head node is new inserted node
		}
	}
	public void insertLast(Object newValue) // insert value into linked list at last
	{
		DSAListNode node = new DSAListNode(newValue); // allocate new node
		DSAListNode cNode; // for track the node's cursor
		if(isEmpty() == true) // if linked list is empty then node is tail also head.
		{
			head = node;
			tail = node;
		}
		else // if linked list has any node then do this
		{	
			cNode = head; // set current node cursor is head
		while(cNode.next != null) // make it reachs to end of linked list
		{
			cNode = cNode.getNext();
		}
		cNode.setNext(node); // now cNode is reached to end of linked list so set new inserted node is next node
		node.setPrev(cNode); // set new inserted  node previous node is cNode(because it was end of linked list)
		tail = node; // now new inserted node is last node in linked list
		}
	}
	public boolean isEmpty() // function for checking linked list is empty or not
	{
		boolean result = false; 
		if(head == null && tail == null) // check linked list has head or tail
			result = true; // if it has head and tail then set true
		return result;
	}
	public Object peekFirst() // function for peeking the first node value
	{
		Object val=null;
		if(isEmpty() == true) // if linked list is empty then abort it
			throw new IllegalArgumentException("Illegal Argument");
		else
			val = head.getValue(); // get head node's value
		return val;
	}
	public Object peekLast() // function for peeking the last node value
	{
		Object val;
		if(isEmpty() == true) // if linked list is empty then abort it
			throw new IllegalArgumentException("Illegal Argument");
		else
			val = tail.getValue(); // get tail node's value
		return val;	
	}
	public Object removeFirst() // function for removing the first node
	{
		Object val;
		if(isEmpty() == true) // if linked list is empty then abort it
			throw new IllegalArgumentException("Illegal Argument");
		else 
		{
			val = head.getValue(); // get the value of to be removed
			head = head.getNext(); // set head node points next of head node.
		}						   // then now head node is not pointed by any node
		return val;	// return the deleted value
	}
	public Object removeLast() // function for removing the last node
	{
		Object val;
		if(isEmpty() == true) // if linked list is empty then abort it
			throw new IllegalArgumentException("Illegal Argument");
		else
		{
			val = tail.getValue(); // get the value of to be removed
			tail = null; // set tail node points null point
		}				 // then now tail node is not pointed by any node
		return val; // return the deleted value
	}
}
