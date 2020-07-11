public class TollBoothLine
{
	private Vehicle[] line;
	private int limit,current,actualMax;
	
	//non-default constructor. Creates an object tollBoothLine
	public TollBoothLine(int size)
	{
		limit = size;
		line = new Vehicle[limit];
	}
	
	//getters
	public int getLength(){return current;}
	public int getActualMax(){return actualMax;}
	
	public boolean addVehicleEnd(Vehicle car)
	{
		if(current<limit)
		{
			line[current] = car;
			current++;
			if (current > actualMax)
			{
				actualMax++;
			}
			return true;
		}
		return false;
	}
	
	public Vehicle removeVehicleStart() 
	{
		Vehicle remove = line[0];
		
		for (int i = 0; i<(current-1); ++i)
		{
			line[i] = line[i+1];
		}
		current--;
		return remove;
	}	
	
	public Vehicle copyVehicleStart()
	{
		return line[0];
	}
	
	public boolean replaceVehicleStart(Vehicle car)
	{
		boolean flag = true;
		if (line[0] == null)
		{
			flag = false;
		}
		else
		{
			line[0] = car;
			flag = true;
		}
		return flag;
	}
	
	public String toString()
	{
		String test = "";
		for (int i =0;i<current;i++)
		{
			test = test+"ID: " +line[i].getId()+", Number of axles: "+line[i].getAxles()+", Time the Vehicle arrives to the toll booth line: "
			+line[i].getArriveLineTime()+", Time the Vehicle gets to the toll booth: "+line[i].getArriveBoothTime()+
			", Time the Vehicle leaves the toll booth: "+line[i].getLeaveTime()+"\nMaximum length: " + actualMax +"\n";
		}
		return test;	
	}
}