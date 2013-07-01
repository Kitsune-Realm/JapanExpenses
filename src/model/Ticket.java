package model;

import java.io.Serializable;
import java.util.Calendar;

public class Ticket implements Serializable
{
	private Calendar cal;
	private double price;
	private String description;
	private String method;
	
	public Ticket(int year, int month, int day, double price, String description, String method)
	{
		this.cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		this.price = price;
		this.description = description;
		this.method = method;
	}

	public Calendar getCal()
	{
		return cal;
	}

	public int getMonth()
	{
		return cal.get(Calendar.MONTH);
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public String toString()
	{
		return "*T* " + cal.get(Calendar.YEAR) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH) + 
				" Price: " + price + 
				" by: " + method + 
				" - " + description;
	}
}
