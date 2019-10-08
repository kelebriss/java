package WS2;

import java.io.*;

public class ShipmentOrder 
{
	private static int nextOrderID = 1;
	private int orderID;
	Ore ore;
	private String customerName;
	private String shippingDest;
	private double orderedMetalWeight;
	private double unitPrice;
	private double shippedOreWeight;
	private boolean pending;
	
	public  ShipmentOrder () // constructor
	{
		ore = new Ore();
		customerName = "";
		shippingDest = "";
		orderedMetalWeight = 0.0;
		unitPrice = 0.0;
		shippedOreWeight = 0.0;
		pending = false; // not yet got any value so it does not turn pending
	}
	public ShipmentOrder ( String inCustName, String inDest, Ore inOre, double inMetalWt, double inPrice)
	{
		orderID = nextOrderID;
		nextOrderID++;
		setOre(inOre);
		setCustomerName(inCustName);
		setShippingDest(inDest);
		setOrderedMetalWt(inMetalWt);
		setUnitPrice(inPrice);
		pending = true; // got value so it turns pending
	}
	public ShipmentOrder (ShipmentOrder inShipmentOrder)
	{
		ore = inShipmentOrder.getOre();
		customerName = inShipmentOrder.getCustomerName();
		shippingDest = inShipmentOrder.getShippingDest();
		orderedMetalWeight = inShipmentOrder.getOrderedMetalWt();
		unitPrice = inShipmentOrder.getUnitPrice();
		shippedOreWeight = inShipmentOrder.getShippedOreWt();
		pending = inShipmentOrder.getIsPending();
	}
	public int getOrderID()
	{
		return orderID;
	}
	public Ore getOre()
	{
		return ore;
	}
	public String getCustomerName()
	{
		return customerName;
	}
	public String getShippingDest()
	{
		return shippingDest;
	}
	public double getOrderedMetalWt()
	{
		return orderedMetalWeight;
	}
	public double getUnitPrice()
    {
    	return unitPrice;
    }
	public double getShippedOreWt()
	{
		if(pending == true) // validation if process is pnding then do exception
			throw new IllegalArgumentException (" is pending ");
		return shippedOreWeight;
	}
	public boolean getIsPending()
	{
		return pending;
	}
	public void setOre(Ore inOre)
	{
		if(inOre == null) //validation if inOre is empty do exception
			throw new IllegalArgumentException(" ore must not be blank");
		ore = inOre;
	}
	public void setCustomerName(String inCustName)
	{
		if(inCustName.equals("")) // validation if enter the value is blank then do exception
			throw new IllegalArgumentException(" must enter the customer name");
		customerName = inCustName;
	}
	public void setShippingDest(String inShippingDest)
	{
		if(inShippingDest.equals("")) // validation if enter the value is blank then do exception
			throw new IllegalArgumentException(" must enter the customer name");
		shippingDest = inShippingDest;
	}
	public void setOrderedMetalWt(double inMetalWt)
	{
		if(inMetalWt <= 0.0) // validation if value is 0 or negative value then do exception
			throw new IllegalArgumentException(" must enter larger than 0.0");
		orderedMetalWeight = inMetalWt;
	}
	public void setUnitPrice(double inPrice)
	{
		if(inPrice <= 0.0) // validation if value is 0 or negative value then do exception
			throw new IllegalArgumentException(" must enter larger than 0.0");
		unitPrice = inPrice;
	}
	public void setShippedOreWt(double inShippedWt)
	{
		if(inShippedWt <= 0.0) // validation if value is 0 or negative value then do exception
			throw new IllegalArgumentException(" must enter larger than 0.0");
		shippedOreWeight = inShippedWt;
		pending = false;
	}
	public double calcAverageGrade()
	{
		if(pending == true) // validation if process is pending so can not calculate it so do exception
			throw new IllegalArgumentException (" is pending ");
		return (orderedMetalWeight * 100) / shippedOreWeight;
	}
	public double calcShipmentValue()
	{
		if(pending == true) // validation if process is pending so can not value it so do exception
			throw new IllegalArgumentException (" is pending ");
		return orderedMetalWeight * unitPrice;
	}
	public void save(String filename)
	{
		FileOutputStream fileStrm = null;
		DataOutputStream dataStrm;

		try
		{
			fileStrm = new FileOutputStream(filename); // file stream into file
			dataStrm = new DataOutputStream(fileStrm); // data stream into file stream
			
			// write function all type classes are same but UTF = String 
			dataStrm.writeInt(orderID);
			dataStrm.writeUTF(customerName);
			dataStrm.writeUTF(shippingDest);
			dataStrm.writeDouble(orderedMetalWeight);
			dataStrm.writeDouble(unitPrice);
			dataStrm.writeDouble(shippedOreWeight);
			dataStrm.writeBoolean(pending);
			ore.save(dataStrm); // Ore data is Object reference so save in Ore class then pass to dataStream
			
			fileStrm.close(); // close the file
		}
		catch (IOException e)
		{
			if (fileStrm != null) // if file is opened, then close
				try { fileStrm.close();}
			catch (IOException ex2){ }
		System.out.println("Error in file processing: " + e.getMessage());
	    }
	}
	public void open(String filename)
	{
		FileInputStream fileStrm = null; // try and catch method make warning condition because while doing try function,
		DataInputStream dataStrm;		 // get any error then fileStrm is not defined so set the null for to prevent warning
		
		try
		{
			fileStrm = new FileInputStream(filename); // read the file then into file stream
			dataStrm = new DataInputStream(fileStrm); // file stream into data stream

			// change the values from data stream(loading data)
			// function all type classes are same but UTF = String 
			this.orderID = dataStrm.readInt();
			this.customerName = dataStrm.readUTF();
			this.shippingDest = dataStrm.readUTF();
			this.orderedMetalWeight = dataStrm.readDouble();
			this.unitPrice = dataStrm.readDouble();
			this.shippedOreWeight = dataStrm.readDouble();
			this.pending = dataStrm.readBoolean();
			ore.load(dataStrm);
			
			fileStrm.close(); // close the file
		}
		catch (IOException e)
		{
			if (fileStrm != null) // if file is opened, then close
				try { fileStrm.close();}
			catch (IOException ex2){ }
		System.out.println("Error in file processing: " + e.getMessage());
	    }
	}
}
