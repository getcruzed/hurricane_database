package tc_data;

import java.util.ArrayList;

/**
 * A simple storage object that will create sorting types for our
 * overall TC database through HURDAT2.
 * 
 * The following containers will be included:
 * - List of all storms
 * - List of all storms that underwent RI
 * - List of all storms that did not undergo RI
 * - List of special cases...
 * @author thomashinson
 *
 */

public class TCDatabase {
	
	// ArrayList containing all storms.
	public ArrayList<TropicalCyclone> databaseAllStorms;
	// ArrayList containing all RI storms.
	public ArrayList<TropicalCyclone> databaseRIStorms;
	// ArrayList containing all non-RI storms.
	public ArrayList<TropicalCyclone> databaseNonRIStorms;
	
	
	/**
	 * Constructor that creates 3 empty array lists.
	 */
	public TCDatabase() {
		
		this.databaseAllStorms = new ArrayList<TropicalCyclone>();
		this.databaseRIStorms = new ArrayList<TropicalCyclone>();
		this.databaseNonRIStorms = new ArrayList<TropicalCyclone>();
		
	}

}
