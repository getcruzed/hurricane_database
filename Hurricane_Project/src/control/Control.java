package control;

import java.io.File;
import java.io.IOException;
import java.util.*;

import tc_data.Hour;
import tc_data.TropicalCyclone;


/**
 * This is the primary control file for populating the database
 * from the HURDAT text files.
 * @author thomashinson
 *
 */


public class Control {
	
	/**
	 * SET PATH HERE.
	 * 
	 */
	static String path = "C:\\Users\\thomashinson\\Documents\\MyProject\\hurdat\\";
	
	/**
	 * ArrayList of TropicalCyclones
	 * 
	 */
	static ArrayList<TropicalCyclone> database = new ArrayList<TropicalCyclone>();
	
	/****************
	 * METHODS
	 ***************/

	/**
	 * createHour()
	 * @param scanner for file
	 * @param hr - hour object
	 * @param tc - TropicalCyclone object
	 * @author thomashinson
	 *
	 */
	public static void createHour( Scanner scanner, Hour hr ) {
		
		hr.yr_mn_dy = scanner.next().trim();
		hr.hour_utc = scanner.next().trim();
		hr.rd_identifier = scanner.next().trim();
		hr.status = scanner.next().trim();
		hr.latitude = scanner.next().trim();
		hr.longitude = scanner.next().trim();
		
		hr.max_sus_wind = Integer.parseInt( scanner.next().trim() );
		hr.min_pressure = Integer.parseInt( scanner.next().trim() );
		
		hr.rad_34_NE = Integer.parseInt( scanner.next().trim() );
		hr.rad_34_SE = Integer.parseInt( scanner.next().trim() );
		hr.rad_34_SW = Integer.parseInt( scanner.next().trim() );
		hr.rad_34_NW = Integer.parseInt( scanner.next().trim() );
		
		hr.rad_50_NE = Integer.parseInt( scanner.next().trim() );
		hr.rad_50_SE = Integer.parseInt( scanner.next().trim() );
		hr.rad_50_SW = Integer.parseInt( scanner.next().trim() );
		hr.rad_50_NW = Integer.parseInt( scanner.next().trim() );
		
		hr.rad_64_NE = Integer.parseInt( scanner.next().trim() );
		hr.rad_64_SE = Integer.parseInt( scanner.next().trim() );
		hr.rad_64_SW = Integer.parseInt( scanner.next().trim() );
		hr.rad_64_NW = Integer.parseInt( scanner.next().trim() );
		
	}
	
	/**
	 * Tests for whether or not the storm underwent rapid intensification.
	 * 
	 * @param TropicalCyclone object
	 * @return true if storm underwent RI, false otherwise.
	 * @throws IOException
	 */
	public static boolean testForRI( TropicalCyclone storm ) {
		
		int numHours = storm.lifetime.size();
		int dv = 0;
		
		for( int i = 0; i < numHours - 4; i++ ) {
			dv = ( storm.lifetime.get(i + 3).max_sus_wind ) -
					( storm.lifetime.get( i ).max_sus_wind );
			if( dv >= 30 ) {
				return true;
			}
		}
		
		// No RI period detected.
		return false;
	}

	// Main.
	public static void main(String[] args) throws IOException {
		/*
		 * Brief welcome with version number.
		 */
		// Scanner for input
		Scanner cin = new Scanner(System.in);
		System.out.println("Welcome to an experimental database for TC research.");
		System.out.print("Please enter your input file name: ");
		System.out.flush();
			String infile = cin.nextLine();
		
		/* Open file */
		File file = new File( path + infile );
		//@SuppressWarnings("resource")
		Scanner scanner = new Scanner( file );
		scanner.useDelimiter(",");
		System.out.println();
		
		// Begin loop to move through file.
		// Use a counter to ensure total storms is correct.
		int numStorms = 0;
		while( scanner.hasNext() ) {
	
			/*
			 * Grab info from header form HURDAT in the following layout:
			 * AL092011, IRENE, 39
			 * AL - Basin (1,2)
			 * 09 - ATCF cyclone number for that year (3,4)
			 * 2011 - Year (5-8)
			 * IRENE - Name (19-28)
			 * 39 - # of entries (rows)
			 */
			String basin = scanner.next().trim();
			String name = scanner.next().trim();
			int numEntries = Integer.parseInt( scanner.next().trim() );
			
			// Display information to console.
			System.out.println("***");
			System.out.println( "Basin info: " + basin );
			System.out.println( "Storm name: " + name );
			System.out.println( "Entries detected: " + numEntries );

			// Create a new TC
			TropicalCyclone temp = new TropicalCyclone( name, numEntries );
			Hour hr = new Hour();
			
			for( int i = 0; i < numEntries; i++ ) {
				// Method gathers data by hour.
				createHour( scanner, hr );
				temp.addHour( hr );
			}
			
			// Analyze whether the storm underwent rapid intensification
			// Loose definition: 30kts in 24 hrs ( v(t2) - v(t1) >= 30 )
			testForRI( temp );
			
			// Ensure entries added is entries detected.
			System.out.println( "Entries added: " + temp.lifetime.size() );
			System.out.println("***");
			System.out.println();
			database.add(temp);
			numStorms++;
			
			System.out.println( "Number of storms input: " + numStorms );
			System.out.println();
			
		}
		
		// Report number of storms read in.
		System.out.println( "Size of database: " + database.size() );
		
		// Close Scanners
		scanner.close();
		cin.close();
		
		// Program ending message.
		System.out.println();
		System.out.println("Program complete.");
		
	}

}


