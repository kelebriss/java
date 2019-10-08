package WS2;

public class test //test harness for binary data files shipmentOrder class
{
	public static void main(String args[])
	{
		ShipmentOrder shipOrder;
		Ore ore, ore2;

		ore = new Ore(Ore.ORETYPE_IRON, "t");
		ore2 = new Ore(Ore.ORETYPE_NICKEL, "kg");
		
		// testing normal condition and saving this
		shipOrder = new ShipmentOrder("John Smith", "Exmouth", ore, 400, 500);
		System.out.println("==============saving the data================");
		System.out.println(shipOrder.getOrderID());
		System.out.println(shipOrder.getCustomerName());
		System.out.println(shipOrder.getShippingDest());
		System.out.println(ore.getOreType()); // if write Ore object then that is Object reference
		System.out.println(ore.getUnits());  // so save in Oreclass and import to datastream and save it together
		System.out.println(shipOrder.getOrderedMetalWt());
		System.out.println(shipOrder.getUnitPrice());
		
		shipOrder.save("C:/Users/kelebriss/Desktop/java/DSA 1 sem 16/src/WS2/test"); // save the data into file 
		
		// after saving data to change the value and check it
		System.out.println("==============after saving change the data================");
		shipOrder = new ShipmentOrder("Smith John", "SharkBay", ore2, 200, 250);
		System.out.println(shipOrder.getOrderID());
		System.out.println(shipOrder.getCustomerName());
		System.out.println(shipOrder.getShippingDest());
		System.out.println(ore2.getOreType());
		System.out.println(ore2.getUnits());
		System.out.println(shipOrder.getOrderedMetalWt());
		System.out.println(shipOrder.getUnitPrice());

		
		// loading the data and check the values are same as before changed value
		System.out.println("==============loading the data================");
		shipOrder = new ShipmentOrder();
		shipOrder.open("C:/Users/kelebriss/Desktop/java/DSA 1 sem 16/src/WS2/test"); // load the data from file
		
		System.out.println(shipOrder.getOrderID());
		System.out.println(shipOrder.getCustomerName());
		System.out.println(shipOrder.getShippingDest());
		System.out.println(ore.getOreType()); // load data from file which before saved in Ore class and ShipmentOrder class
		System.out.println(ore.getUnits()); 
		System.out.println(shipOrder.getOrderedMetalWt());
		System.out.println(shipOrder.getUnitPrice());
	}
}