package application;

import java.util.ArrayList;

public class Pizza {
	
	private String type;
	private ArrayList<String> toppings;
	
	public Pizza() {
		type = "?";
		toppings = new ArrayList<String>();
	}
	public String getType()
	{
		return type;
	}
	public ArrayList<String> getToppings()
	{
		return toppings;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public void setToppings(ArrayList<String> toppings)
	{
		this.toppings = toppings;
	}
	public String toString()
	{
		if (toppings.isEmpty()) {
			return type;
		}
		return type + " with " + toppings;
	}
}
