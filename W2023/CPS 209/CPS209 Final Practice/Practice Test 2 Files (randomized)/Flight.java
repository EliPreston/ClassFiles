public class Flight
{
	private String flightNum;
	private String origin, dest;
	private String departureTime;
	private int passengers;
	private String[] seats;
	
	public Flight()
	{
		passengers = 0;
	}
	
	public void print()
	{
		System.out.printf("FLT: %-5s From: %-3s To: %-3s Time: %-5s Psngrs: %-2d Seats:", flightNum, origin, dest, departureTime, passengers);
		for (String seat: seats)
		{
			System.out.printf(" %-2s", seat);
		}
		System.out.println();
	}
		
	public String getflightNum()
	{
		return flightNum;
	}
	public void setFlightNum(String flightNum)
	{
		this.flightNum = flightNum;
	}
	public String getOrigin()
	{
		return origin;
	}
	public void setOrigin(String origin)
	{
		this.origin = origin;
	}
	public String getDest()
	{
		return dest;
	}
	public void setDest(String dest)
	{
		this.dest = dest;
	}
	public String getDepartureTime()
	{
		return departureTime;
	}
	public void setDepartureTime(String departureTime)
	{
		this.departureTime = departureTime;
	}
	
	public int getPassengers()
	{
		return passengers;
	}
	public void setPassengers(int passengers)
	{
		this.passengers = passengers;
	}
	public String[] getSeats()
	{
		return seats;
	}
	public void setSeats(String[] seats)
	{
		this.seats = seats;
	}
	
}
