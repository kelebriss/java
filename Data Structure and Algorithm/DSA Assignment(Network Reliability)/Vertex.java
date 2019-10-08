package a;
//to make Vertex ADT as Linked List for easy storing data
class Vertex 
{
	String name,type;
	int cost, order;
	FloatingPoint reliability;
	boolean source, target;
	Vertex next;
	public Vertex() // default constructor
	{
		name = "";
		type = "";
		cost = 0;
		reliability = new FloatingPoint();
		source = false;
		target = false;
		next = null;
	}
	public Vertex(Vertex copy) // copy constructor
	{
		name = copy.getName();
		type = copy.getType();
		cost = copy.getCost();
		reliability = new FloatingPoint(copy.getRel());
		source = copy.isSource();
		target = copy.isTarget();
		next = copy.getNext();
	}
	//////////////////////
	//Mutator functions///
	//////////////////////
	public void setName(String name)
	{
		this.name = name;		
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public void setCost(int cost)
	{
		this.cost = cost;
	}
	public void setRel(double num)
	{
		reliability = new FloatingPoint(num);
	}
	public void setSource()
	{
		source = true;
	}
	public void setTarget()
	{
		target = true;
	}
	public void setOrder(int num)
	{
		order = num;
	}
	//////////////////////
	//Accessor functions///
	//////////////////////
	public FloatingPoint getRel()
	{
		return reliability;
	}
	public String getName()
	{
		return name;
	}
	public String getType()
	{
		return type;
	}
	public int getCost()
	{
		return cost;
	}
	public Vertex getNext()
	{
		return next;
	}
	public boolean isSource()
	{
		return source;
	}
	public boolean isTarget()
	{
		return target;
	}
	public int getOrder()
	{
		return order;
	}
	public void setNext(Vertex node)// function for setting next node
	{
		next = node;
	}
}
