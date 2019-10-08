package a;

// to make Edge ADT as Linked List for easy storing data
class Edge 
{
	String name, type; 
	int cost;
	FloatingPoint reliability;
	Vertex from,to;
	Edge next;
	
	public Edge() // default constructor
	{
		name = " ";
		type = " ";
		cost = 0;
		reliability = new FloatingPoint();
		from = new Vertex();
		to = new Vertex();
		next = null;
	}
	public Edge(Edge copy) // copy constructor
	{
		name = copy.getName();
		type = copy.getType();
		cost = copy.getCost();
		reliability = new FloatingPoint(copy.getRel());
		from = copy.getFrom();
		to = copy.getTo();
		next = getNext();
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
	public void setFrom(Vertex ver)
	{
		from = new Vertex(ver);
	}
	public void setTo(Vertex ver)
	{
		to = new Vertex(ver);
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
	public Vertex getFrom()
	{
		return from;
	}
	public Vertex getTo()
	{
		return to;
	}
	public Edge getNext()
	{
		return next;
	}
	public void setNext(Edge node)// function for setting next node
	{
		next = node;
	}
}
