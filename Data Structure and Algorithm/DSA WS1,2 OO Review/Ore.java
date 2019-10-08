package WS1;

public class Ore 
{
	public static final char ORETYPE_IRON = 'I';
	public static final char ORETYPE_NICKEL = 'N';
	
	public static final String UNIT_TONNES = "t";
	public static final String UNIT_KILOGRAMS = "kg";
	public static final String UNIT_GRAMS = "g";
	
	
	private char oreType;
	private String units;
	
	public Ore() // constructor
	{
		oreType = ' ';
		units = " ";
	}
	public Ore(char inOreType, String inUnits)
	{
		if ((inOreType != Ore.ORETYPE_IRON) && (inOreType != Ore.ORETYPE_NICKEL)) // validation for proper oreType , if entered not specific value than do exception
		 throw new IllegalArgumentException ("invalid ore type provided");
		oreType = inOreType;
		if((inUnits == null) || (inUnits.equals(""))) //validation for proper inUnits value, if entered blank or null value then do exception
			throw new IllegalArgumentException("Unit must not be blank");
		setUnits(inUnits);

	}
	public Ore (Ore inOre)
	{
		oreType = inOre.getOreType();
		units = inOre.getUnits();
	}
	public char getOreType()
	{
		return oreType;
	}
	public String getUnits()
	{
		return units;
	}
	public void setUnits(String inUnits)
	{
		if((inUnits == null) || (inUnits.equals(""))) //validation for proper inUnits value, if entered blank or null value then do exception
			throw new IllegalArgumentException("Unit must not be blank");
		else if((inUnits != Ore.UNIT_TONNES) && (inUnits != Ore.UNIT_KILOGRAMS) && (inUnits != UNIT_GRAMS))  // validation for proper inUnits value, if entered not specific value than do exception
			throw new IllegalArgumentException("Unit must be 't','kg' or 'g'");
		else
			units = inUnits;
			
	}
}
