import java.io.File;
import java.io.EOFException;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Reads a text file containing information about flights from Toronto Pearson (YYZ airport code). 
// The first line of the file contains an integer number representing the number of flight "records" stored
// in the file. A flight record has the following format (demonstrated with an example):

// AC801
// YYZ->LIS
// 1030
// 4
// 1A;2B;3B;4A

// That is, each record consists of 5 lines. Line 1: flight number string Line 2: origin airport (3 letter code) followed
// by "->" followed by destination airport code (3 letters)
// Line 3: departure time string Line 4: the number of passengers on the flight
// Line 5: The 2-character seat number for each of the passengers on the flight, each seat is separated by a ";" 
// 
// The expected output is as follows:
// FLT: AC801 From: YYZ To: LIS Time: 1030  Psngrs: 4  Seats: 1A 2B 3B 4A
// FLT: AA312 From: YYZ To: LAX Time: 0800  Psngrs: 3  Seats: 1B 2B 3B
// FLT: US653 From: YYZ To: JFK Time: 1450  Psngrs: 6  Seats: 1A 1B 2B 3A 3B 4A
// FLT: AC123 From: YYZ To: CDG Time: 2230  Psngrs: 0  Seats:
// FLT: WJ433 From: YYZ To: LHR Time: 2315  Psngrs: 1  Seats: 1A



public class FE2
{
	public static void main(String[] args)
	{
		ArrayList<Flight> flights = null;

		try
		{
			flights = loadFlightsFile();
			for (Flight s: flights)
				s.print();
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("No file found " + e);  
		}
		catch (IOException exception)        
		{
			System.out.println("Input/output error " + exception); 
		}
		catch (NumberFormatException exception)
		{         
			System.out.println("Invalid Number");
		} 

		System.out.print("EXPECTED:\n");
		System.out.println("FLT: AC801 From: YYZ To: LIS Time: 1030  Psngrs: 4  Seats: 1A 2B 3B 4A\n"
				+ "FLT: AA312 From: YYZ To: LAX Time: 0800  Psngrs: 3  Seats: 1B 2B 3B\n"
				+ "FLT: US653 From: YYZ To: JFK Time: 1450  Psngrs: 6  Seats: 1A 1B 2B 3A 3B 4A\n"
				+ "FLT: AC123 From: YYZ To: CDG Time: 2230  Psngrs: 0  Seats:\n"
				+ "FLT: WJ433 From: YYZ To: LHR Time: 2315  Psngrs: 1  Seats: 1A");
	}

	// Load the information for all flights from the flights.txt file 
	// into an array list of Flight objects. Return a reference to the array list.
	// This method should not catch any IO Exceptions. Modify the method signature line accordingly
    //-----------Start below here. To do: approximate lines of code = 1
    // the method should be called loadFlightsFile() and is static. It should return an
	// ArrayList of Flight objects
    public static ArrayList<Flight> loadFlightsFile() throws FileNotFoundException
    // -----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	{
		ArrayList<Flight> flights = new ArrayList<Flight>();
		Scanner in = new Scanner(new File("flights.txt"));
		int numFlights;

		//-----------Start below here. To do: approximate lines of code = 4
		// Read the first line of the file and convert to an integer and store in numFlights.
		// This represents the number of flight records in the flights.txt file
		// Call the method readNextFlight() numFlights times (hand in the reference to the scanner)
		// Add each returned Flight object to the array list
		numFlights = in.nextInt();
		in.nextLine();

		for (int i = 0; i < numFlights; i++) {
			flights.add(readNextFlight(in));
		}
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
		return flights;
	}

	// Reads one Flight "record" from a file and creates and returns a Flight object
	// A Flight record takes up 5 lines. See the top of this file for the exact record format. 
	// This method should not catch any IO Exceptions. Modify the method signature line accordingly
    //-----------Start below here. To do: approximate lines of code = 1
    // public static Flight readNextFlight(Scanner sc)
    
	public static Flight readNextFlight(Scanner sc)
    //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	{  
		//-----------Start below here. To do: approximate lines of code = 24
		//
		// A flight record has the following format (demonstrated with an example):
		// AC801
		// YYZ->LIS
		// 1030
		// 4
		// 1A;2B;3B;4A

		Flight newFlight = new Flight();

		String flightNum = sc.nextLine();

		String originDest =  sc.nextLine();
		String origin = originDest.substring(0, 3);
		String dest = originDest.substring(5);

		String departureTime = sc.nextLine();

		int passenegers = sc.nextInt();
		sc.nextLine();

		String seats = sc.nextLine();
		String[] seatsArr = seats.split(";");
		

		newFlight.setFlightNum(flightNum);
		newFlight.setOrigin(origin);
		newFlight.setDest(dest);
		newFlight.setDepartureTime(departureTime);
		newFlight.setPassengers(passenegers);
		newFlight.setSeats(seatsArr);

		return newFlight;
		
		
		
		//-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
	}
}

