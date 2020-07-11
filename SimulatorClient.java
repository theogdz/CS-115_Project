import java.io.FileNotFoundException;
import java.util.Scanner;

public class SimulatorClient {
	public static void main(String[] args) throws FileNotFoundException {
		final String NON_RUSH_HOUR="nonrushhour.txt";
		final String RUSH_HOUR="rushhour.txt";
		Scanner input = new Scanner(System.in);
		String fileName;
		System.out.println("Enter N for nonrushhour and R for rushhour: ");
		String in = input.next();
		
		try
		{
			if(in.equalsIgnoreCase("N"))
			{
				fileName= NON_RUSH_HOUR;
			}
			else if(in.equalsIgnoreCase("R"))
			{
				fileName = RUSH_HOUR;
			}
			else
			{
				System.out.println("Error invalid entry");
				return;
			}
			
			System.out.println("How many manual tollbooths do you want?");
			int numManual = input.nextInt();
			if(numManual>=1 && numManual<=6)
			{
				numManual = numManual;
			}
			else
			{
				numManual =1;
			}
			System.out.println("How many automatic tollbooths do you want?");
			int numAuto = input.nextInt();
			if(numAuto>=1 && numAuto<=6)
			{
				numAuto = numAuto;
			}
			else
			{
				numAuto =1;
			}
			Simulator s = new Simulator(fileName, numManual, numAuto);
			s.start();
			s.tollStats();
			s.vehicleStats();
		}
		catch(Exception ex)
		{
			System.out.println("File not found or invalid input");
		}
		finally {
	        input.close();
	    }
	}
}
