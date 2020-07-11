public class Vehicle
{
	private int id;
	private int axles;
	private String tollType;
	private int arriveLineTime;
	private int arriveBoothTime;
	private int leaveTime;
	private static int noVehicles;
	
	//non-default. Used to create objects
	public Vehicle(int axleNo, String toll, int timeArrive)
	{
		noVehicles++;
		id = Vehicle.noVehicles;
		axles = axleNo;
		tollType = toll;
		arriveLineTime = timeArrive;
	}
	
	//getters
	public int getId(){return id;}
	public int getAxles(){return axles;	}
	public String getTollType()	{return tollType;}
	public int getArriveLineTime(){return arriveLineTime;}
	public int getArriveBoothTime(){return arriveBoothTime;}
	public int getLeaveTime(){return leaveTime;}
	
	//setters
	public void setAxles(int axleNo)
	{
		if (axleNo > 0)
			axles = axleNo;
	}
	public void setTollType(String type)
	{
		tollType = type;
	}
	public void setArriveLineTime(int timeArrive)
	{
		if(timeArrive>0 ){
			this.arriveLineTime = timeArrive;
		}
		else{
			this.arriveLineTime = 0;
		}
	}
	public void setArriveBoothTime(int timeBooth)
	{
		if(timeBooth>0 && timeBooth>=getArriveLineTime()){
			this.arriveBoothTime = timeBooth;
		}
		else{
			this.arriveBoothTime = 0;
		}
	}
	public void setLeaveTime(int exitTime)
	{
		if (exitTime>0 && exitTime>=getArriveBoothTime()){
			this.leaveTime = exitTime;
		}
		else{
			this.leaveTime = 0;
		}
	}
	
	//toString method
	public String toString()
	{
		String toString = "";
		toString= "ID: " + getId()+ " Number of Axles: " + getAxles()+ " Toll Type: " + getTollType()+ " Time Vehicle Arrives to Line: " + getArriveLineTime()
		+" Time Vehicle gets to Toll Booth: " + getArriveBoothTime()+" Time Vehicle Leaves Toll Booth: " + getLeaveTime();
		return toString;
	}

}