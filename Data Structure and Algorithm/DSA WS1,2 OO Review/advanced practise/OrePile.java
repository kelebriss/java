package WS2;

import java.io.*;

public class OrePile implements Serializable // can do serializing (one of container class)
{
	Ore ore;
	private double weight;
	private double grade;
	
	public OrePile ( )// constructor
	{
		ore = new Ore();
		weight = 0.0;
		grade = 0.0;
	}
	public OrePile (Ore inOre, double inWeight, double inGrade)
	{
		if(inWeight <= 0.0) //validation for proper weight value
			throw new IllegalArgumentException(" the value is larger than 0.0 or not negative");
		setWeight(inWeight);
		if(inGrade <= 0.0 || inGrade >100) // validation for proper grade value
			throw new IllegalArgumentException(" the value is larger than 0.0, not negative and not over 100");
		setGrade(inGrade);
		ore = new Ore(inOre);
	}
	public OrePile (OrePile inOrePile)
	{
		ore = inOrePile.getOre();
		weight = inOrePile.getWeight();
		grade = inOrePile.getGrade();
	}
	public Ore getOre()
	{
		return ore;
	}
	public double getWeight()
	{
		return weight;
	}
	public double getGrade()
	{
		return grade;
	}
	public void setWeight(double inWeight)
	{
		if(inWeight <= 0.0)  //validation for proper weight value
			throw new IllegalArgumentException(" must enter proper value");
		weight = inWeight;
	}
	public void setGrade (double inGrade)
	{
		if(inGrade <= 0.0 || inGrade >100) // validation for proper grade value
			throw new IllegalArgumentException(" must enter proper value");
		grade = inGrade;
	}
	public double calcMetalWeight()
	{
		return (weight * grade / 100);
	}

}
