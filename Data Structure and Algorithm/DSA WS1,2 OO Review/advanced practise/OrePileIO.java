package WS2;

import java.io.*;

public class OrePileIO  // class for testing OrePile Serialization 
{
	public static void main(String [] args)
	{
		Ore ore = new Ore(Ore.ORETYPE_IRON, "t"); // set value
		Ore ore2 = new Ore(Ore.ORETYPE_NICKEL, "kg"); // set value different to ore
		OrePile op1 = new OrePile(ore, 300, 60); // set value for tes
		OrePileIO io = new OrePileIO(); 
		
		// testing normal values and saving this
		System.out.println("==============saving the data================");
		System.out.println(op1.getWeight());
		System.out.println(op1.getGrade());
		System.out.println(ore.getOreType());
		System.out.println(ore.getUnits());
		io.save(op1, "C:/Users/kelebriss/Desktop/java/DSA 1 sem 16/src/WS2/test2");
		
		// after saving data to change the values and check it is changed
		System.out.println("==============saving after change the data================");
		op1 = new OrePile(ore2, 800, 40);
		System.out.println(op1.getWeight());
		System.out.println(op1.getGrade());
		System.out.println(ore2.getOreType());
		System.out.println(ore2.getUnits());
		
		// loading the data and check the values are same as before changed value
		System.out.println("==============loading the data================");
		op1 = new OrePile(io.load("C:/Users/kelebriss/Desktop/java/DSA 1 sem 16/src/WS2/test2"));
		System.out.println(op1.getWeight());
		System.out.println(op1.getGrade());
		System.out.println(ore.getOreType());
		System.out.println(ore.getUnits());
	}
	private void save (OrePile objToSave, String filename) throws IllegalArgumentException
	{
		FileOutputStream fileStrm;
		ObjectOutputStream objStrm;
		try
		{
			fileStrm = new FileOutputStream(filename);  // file stream pass to file
			objStrm = new ObjectOutputStream(fileStrm); // object stream pass to file stream
			objStrm.writeObject(objToSave);				// OrePile container class save as Object into Object stream
			objStrm.close(); // close the object stream
		}
		catch(IOException e)
		{
			throw new IllegalArgumentException("Unable to save object to file");
		}
	}
	private OrePile load (String filename) throws IllegalArgumentException
	{
		FileInputStream fileStrm; 
		ObjectInputStream objStrm;
		OrePile inObj = new OrePile();
		try
		{
			fileStrm = new FileInputStream(filename); // file data pass to file stream
			objStrm = new ObjectInputStream(fileStrm); // file stream data pass to object stream
			inObj = (OrePile)objStrm.readObject(); // replace the object data from object stream
			objStrm.close(); // close the object stream
			
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("class containerclass not found"+e.getMessage()); // if container class is not exist then print this
		}
	    catch (Exception e) 
		{
	        throw new IllegalArgumentException("Unable to load object from file");
	    }
		return inObj; // returning the loaded data
	}
}
