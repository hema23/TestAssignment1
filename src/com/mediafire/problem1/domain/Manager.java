package com.mediafire.problem1.domain;

/**
 * Manager class having extra attribute parking slot ID.
 * aaa
 * @author Hemaanjana
 *
 */
public class Manager extends Employee
{
	/** parking id only for manager **/
	private String parkingSpaceID;
	
	public Manager(double weeklyWage, String name) {
		super(weeklyWage, name);
	}
	
	public Manager(double weeklyWage, String name, String parkingSpaceID) {
		super(weeklyWage, name);
		
		this.parkingSpaceID = parkingSpaceID;
	}

	public String getParkingSpaceID() {
		return parkingSpaceID;
	}

	public void setParkingSpaceID(String parkingSpaceID) {
		this.parkingSpaceID = parkingSpaceID;
	}

}
