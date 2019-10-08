package WS5;
import java.io.*;

public class DSAHashTable implements Serializable // make it can be serialization
{
	private DSAHashEntry[] m_hashTable;
	int count, actualSize;
	DSAHashEntry hashEntry;
	findNextPrime prime = new findNextPrime();
	boolean found, giveUp;
	public DSAHashTable(int maxSize) // constructor
	{
		actualSize = prime.function(maxSize);// get maxsize number netx to prime number
		m_hashTable = new DSAHashEntry[actualSize]; // allocate DSAHashEntry array
		for(int i=0; i<actualSize; i++)
		{
			m_hashTable[i] = hashEntry; // initialize table array contain hash entry
		}
	}
	public void put(String key, Object value) // insert value into hashtable
	{
		int hashIdx = hash(key);
		int count = 0;
		//if hash index hash table is not null and contain key is not same as key then do it
		while((m_hashTable[hashIdx] != null) && (!m_hashTable[hashIdx].key.equals(key)))	{
			hashIdx = (hashIdx + 1) % m_hashTable.length; // linear probing method
			if(count == m_hashTable.length)// check the table is full or not
			{
				reSize(prime.function(m_hashTable.length*2)); // do resize multiply 2 table's length then find the next prime number.
				put(key,value);// put value again into resize table
			}
			count++; // check the count for full or not
		}
		if((m_hashTable[hashIdx] == null) && (containKey(key) == false)) // if hash index table is not contain value then do this
		 m_hashTable[hashIdx] = new DSAHashEntry(key,value); // enter the value;
		 
	}
	public void put(DSAHashEntry entry)
	{
		put(entry.key, entry.value); // enter the value to table from entry
	}
	public int find (String key) // find the hash index function
	{
		int hashIdx = hash(key); // hashing the key
		int origIdx = hashIdx;	 
		boolean found = false;
		boolean giveUp = false;
		while((found != true) && (giveUp != true))
		{	
			if((m_hashTable[hashIdx] != null)&&(m_hashTable[hashIdx].state == 0)) // if hash index table is not null but state is 0(not initialized) then do this
				giveUp = true;
			else if((m_hashTable[hashIdx] != null)&&(m_hashTable[hashIdx].key.equals(key))) // if hash index table is not null and cotain key is same as key then do this
				found = true;
			else
			{
				hashIdx = (hashIdx + 1) % m_hashTable.length;//linear probing method
				if (hashIdx == origIdx) // original indext and hash index are same then do this(it means check all of item)
					giveUp = true;
			}
		}
		if(found != true) // if not found the item then do this
			throw new IllegalArgumentException("item not found"); // throw exception that it is not exist in table
		return hashIdx; // return hash index
	}
	public Object get(String key) // get the value from table
	{
		return m_hashTable[find(key)].value;
	}
	public void remove(String key) // remove the value function
	{
		if((m_hashTable[find(key)]!=null) && (m_hashTable[find(key)].key.equals(key)))// if hash index table is not null and contain key is same as key then do this
			m_hashTable[find(key)] = new DSAHashEntry("deleted","deleted"); // replace the value and key as "deleted"
		
	}
	public boolean containKey(String key) // check the table cotain the key or not
	{
		boolean status = false;
		
		for(int i=0; i<m_hashTable.length;i++) // doing loop for to check from first key to last key
		{
		if((m_hashTable[i] != null)&&(m_hashTable[i].key.equals(key))) // if hash index talbe is not null and contain key is same as key then do this
		 status = true;
		}
		 return status;
			
	}
	private void reSize(int size) // resize function
	{
		DSAHashEntry[] oldTable = m_hashTable; // copy the hash table
		m_hashTable = new DSAHashEntry[size]; // reallocate hash table with new size
		for(int i=0; i<size; i++)
		{
			m_hashTable[count] = hashEntry;// initialize table array contain hash entry
		}
		for(int j=0; j<oldTable.length; j++) // copy the copied hash table to resize hash table
		{
			if((oldTable[j] != null) && (oldTable[j].state != 0) && (oldTable[j].value != "deleted"))
				put(oldTable[j]); // insert old hash table into resize table
		}
	}
	private int hash(String key) // hashing function
	{
		int hashIdx = 0;
		for(int i=0; i<key.length(); i++)
		{
			hashIdx = (3 * hashIdx) + key.charAt(i); // usually use 31 but randomname.csv key is too large to hash into integer
		}											// if use 31, it returns negative value so change into small value
		return (hashIdx % m_hashTable.length);
	}
}
