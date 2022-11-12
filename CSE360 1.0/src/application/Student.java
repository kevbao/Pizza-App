package application;

public class Student {
	
	private String name;
	private String pickup;
	private int id;
	private Pizza order;
	
	public Student() {
		
		name = "?";
		pickup = "?";
		id = 0;
		order = new Pizza();
		
	}
	
	public String getName() 
	{
		return name;
	}
	public String getTime() {
		return pickup;
	}
	public int getId() 
	{
		return id;
	}
	public Pizza getOrder()
	{
		return order;
	}
	public void setName (String name) 
	{
		this.name = name;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public void setTime(String pickup) 
	{
		this.pickup = pickup;
	}
	public void setOrder(Pizza order)
	{
		this.order = order;
	}
	public String toString()
	{
		return "\nStudent: " + name + " " + id + "\n" + order.toString() + "\nPickup Time: " + pickup;
	}
}
