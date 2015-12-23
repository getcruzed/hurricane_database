package tc_data;

import java.util.ArrayList;

public class TropicalCyclone {
	
	/**
	 * This will maintain the object of each storm. 
	 * 
	 * Each storm will possess these base classes:
	 * -Hour (normalized by genesis time (hour 0 + 6x)
	 */
	
	
	/**
	 * Attributes for TropicalCyclones
	 */
	
	
	public String basin;		// region of storm
	public int month;
	public int year;			// year of storm
	public String name;			// name of storm
	
	public int duration;		// time from genesis to dissipation (hrs)
	public int max_intensity;	// highest intensity reached (kts)
	
	public boolean transition_ET;  // did storm under ET transition
	
	public int numRecords;		// Number of recorded 6-h entries
	
	public ArrayList<Hour> lifetime;
	
	/*
	 * Basic constructor with just the name.
	 */
	public TropicalCyclone( String name, int numRecords ) {
		this.name = name;
		this.numRecords = numRecords;
		
		// Create an array list of hours.
		lifetime = new ArrayList<Hour>();
	}
	
	/* * * * * * * * * * * * * * */
	
	public void addHour( Hour hr ) {
		// Add to array list.
		lifetime.add( hr );
	}
	
	
	
	

}
