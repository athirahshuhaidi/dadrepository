package payment;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;

import staff.Staff;

public class Payment extends Staff implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private int paymentId;
	private Date transactionDate;
	private Staff recordedBy;
	
	public Payment() 
	{
		
		
	}
	
	public void setPaymentID (int paymentId)
	{
		this.paymentId = paymentId;
	}
	
	public int getPaymentID ()
	{
		return paymentId;
	}
	
	public void setTransactionDate (Date date)
	{
		this.transactionDate = date;
	}
	
	public Date getTransactionDate()
	{
		return transactionDate;
	}
	
	public void setRecordedBy(Staff recordedBy)
	{
	 
	   super.name = name;
	}
	
	public String getRecordedBy()
	{
		return super.name;
	}

}
