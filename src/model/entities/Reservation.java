package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


  
public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
	
	public long  duration()
	{
		 long diff = checkout.getTime() - checkout.getTime();
		 return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	} 
 
	public String updateDates(Date checkin, Date checkout)
	{
		 Date now = new Date();
		if(checkin.before(now) || checkout.before(now))
		   {
			   return "Erro in reservation: Reservation dates for update must be future dates";
			   
		   }
		if(!checkout.after(checkin))
			{
				return "Erro in reservation: check-out date must be agter check-in date";
				
			}
		
		this.checkin = checkin;
		this.checkout = checkout;
		
		return null;
		
		
	}
	@Override
	public String toString()
	{
		
		return "Room "
			   + roomNumber
			   + ", check-in: "
               + sdf.format(checkin)
               + ", check-out: "
               + sdf.format(checkout)
               +", "
               + duration()
               + "nights";
		
	}
	
	
	
}
