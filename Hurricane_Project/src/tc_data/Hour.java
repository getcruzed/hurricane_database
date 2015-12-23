package tc_data;

public class Hour {
	
	
	/*
	 * Attributes specific to 6H time period of the storm.
	 */
	public String yr_mn_dy;			// year+month+day (YYYMMDD)
	public String hour_utc;			// hour in UTC
	public String rd_identifier;	// record identifier:
									// C,G,I,L,P,R,S,T,W
	public String status;			// status of system:
									// TD,TS,HU,EX,SD,SS,LO,WV,DB
	public String latitude;			// storm latitude and hemisphere
									// (XX.X N/S)
	public String longitude;		// storm longitude and hemisphere
									// (XX.X E/W)
	public int max_sus_wind;		// max sustained wind (knots)
	public int min_pressure;		// minimum pressure (millibars)
	
	/*
	 * 34, 50,and 64 kt wind radii maximum by quadrant measured 
	 * in nautical miles.
	 */
	public int rad_34_NE;
	public int rad_34_SE;
	public int rad_34_SW;
	public int rad_34_NW;
	
	public int rad_50_NE;
	public int rad_50_SE;
	public int rad_50_SW;
	public int rad_50_NW;
	
	public int rad_64_NE;
	public int rad_64_SE;
	public int rad_64_SW;
	public int rad_64_NW;
	
	
	/*
	 * (null) Constructor for an hour.
	 */
	public Hour() {
		
	}
	
	/*
	 * Simple constructor with just the hour.
	 * 
	 */
	public Hour( String hour ) {
		this.hour_utc = hour;
	}
}
