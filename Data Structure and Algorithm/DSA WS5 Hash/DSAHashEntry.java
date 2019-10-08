package WS5;

import java.io.Serializable;

public class DSAHashEntry implements Serializable // make it can be serialization
{
	String key;
	Object value;
	int state;
	public DSAHashEntry() // default constructor
	{
		key = "";
		value = null;
		state = 0;
	}
	public DSAHashEntry(String inKey, Object inValue) // alternate constructor
	{
		key = inKey;
		value = inValue;
		state = 1;
	}
}
