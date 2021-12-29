package parcel;

public class ParcelManager {
	
	public Parcel createParcel (Parcel parcel)
	{
		// Declare weight and return value
		double weight = parcel.getWeight();
		//Set the value of Weight
		parcel.setWeight(weight);
		
		double price = this.parcelPrice(parcel.getWeight());
		parcel.setPrice(price);
	
		return parcel;
		
	}
	
	private double parcelPrice(double weight) {
		double price = 0.0;
		double p1 = 8.00;
		double p2 = 9.00;
		double p3 = 10.05;
		double p4 = 10.60;
		
		if(weight >= 0.00 && weight <= 0.50) 
		{
			price = p1;

		}
		
		else if(weight >= 0.51 && weight <= 1.00) 
		{
			price = p2;

		}
		
		else if(weight >= 1.01 && weight <= 1.50) 
		{
			price = p3;
			

		}
		
		else if(weight >= 1.51 && weight <= 2.00) 
		{
			price = p4;
	
		}
		
		else
		{
			price = p1;
		}
		return price;
	}
	

}
