package WS5;
import java.io.*;
import java.util.*;
public class test 
{		
	public static void main(String [] args)
	{
		DSAHashTable table = new DSAHashTable(100); //declare default size of hash table
		DSAHashTable table1; // hash table for testing deserialization
		test t=new test();
		
		FileInputStream fileIStrm = null; 
		InputStreamReader rdr;
		BufferedReader bufRdr;
		
		String line;
		DSAHashEntry entry = new DSAHashEntry();
		try
		{
			// read file(randomname.csv) then through streamreader and bufferedreader, then read the line of file
			fileIStrm = new FileInputStream("C:\\Users\\kelebriss\\Desktop\\java\\DSA 1 sem 16\\src\\WS5\\RandomNames.csv");
			rdr = new InputStreamReader(fileIStrm);
			bufRdr = new BufferedReader(rdr);
			line = bufRdr.readLine();
			
			while(line != null)// until file return the null do this
			{
				entry = t.process(line); //process is paring into single string
				table.put(entry);// insult entry which processed entry above
				line = bufRdr.readLine(); // read line again
			}
			fileIStrm.close();
		}
		catch(IOException e)
		{
			if(fileIStrm !=null) // if file does not contain anythimg then do this
			{
				try{fileIStrm.close();}
				catch(IOException e2){}
			}
		}
		//serialization the table into file serial.txt
		t.save(table,"C:\\Users\\kelebriss\\Desktop\\java\\DSA 1 sem 16\\src\\WS5\\serial.txt" );
		//deserialization into table1 
		table1 = t.load("C:\\Users\\kelebriss\\Desktop\\java\\DSA 1 sem 16\\src\\WS5\\serial.txt");
		//testing for deserialization(get the valuse of entered key)
		System.out.println(table1.get("14441115"));
	}

	private DSAHashEntry process(String str) // parsing into single string and initialize entry value and key
	{
		DSAHashEntry entry = new DSAHashEntry();
		StringTokenizer strTok;
		strTok = new StringTokenizer(str,",");// parsing by comma
		while(strTok.hasMoreTokens())
		{
			entry.key = strTok.nextToken(); //initializing key 
			entry.value = strTok.nextToken();//initializing value
		}
		return entry; //return hash entry 
	}
	private void save(DSAHashTable table, String filename) // serialization function
	{
		FileOutputStream fileOStrm;
		ObjectOutputStream objStrm;
		try
		{
			fileOStrm = new FileOutputStream(filename);
			objStrm = new ObjectOutputStream(fileOStrm);
			objStrm.writeObject(table);
			objStrm.close();
		}
		catch (Exception e)
		{
			throw new IllegalArgumentException("unable to save");
		}
	}
	private DSAHashTable load(String filename) // deserialization function
	{
		FileInputStream fileStrm;
		ObjectInputStream objStrm;
		DSAHashTable obj = null;
		try
		{
			fileStrm = new FileInputStream(filename);
			objStrm = new ObjectInputStream(fileStrm);
			obj = (DSAHashTable)objStrm.readObject();
			objStrm.close();
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("class containerclass not found" + e.getMessage());
		}
		catch (Exception e)
		{
			throw new IllegalArgumentException("unable to load ");
		}
		
		return obj;
	}
}
