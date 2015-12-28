package file_handle;
// Imports
import tc_data.*;

/**
* This will create the individual text files for 
* specific processing and file creation of each inidividual storm
* within HURDAT.
*
* File name structure: name_year.txt
*/

public class FileHandler {


	/**
	* Makes a file with all the hours and in the same format
	* as the HURDAT2.
	*/
	public static void createIndStormFiles( String path, String infile ) {

		// Open file.
		File file = new File( path + infile );
		Scanner info = new Scanner( file );
		info.useDelimeter(",");

		// Get the name of the storm and year for file name.
		String basin = info.next().trim();
		String name = info.next().trim();
		info.close();

		// Create new scanner.
		Scanner scanner = new Scanner( file );

		// Create file to write to.
		File outfile = new File( basin + "_" + name + ".txt" );
		FileWriter fWriter = new FileWriter( outfile );
		PrintWriter pWriter = new PrintWriter( fWriter );

		while ( scanner.hasNext() ) {
			pWrinter.println( scanner.nextLine() );
		}

	}
	
}
