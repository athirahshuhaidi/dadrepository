package parcel;

import java.io.Serializable;

public class Parcel implements Serializable {
	
public static final long serialVersionUID = 1L;
	
	private double weight;
	private double price;
	
	public Parcel() 
	{
		this.weight = 0.0;
		this.price = 0.0;
	   
	}
	
	public void setWeight (double weight) 
	{
		this.weight = weight;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public double getPrice()
	{
		return price;
	}

}
