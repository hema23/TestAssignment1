package com.mediafire.problem1.domain;

/**
 * Employee class that defines the employee domain model.
 * 
 * @author Hemaanjana
 */
public class Employee {

	/** Weekly wage for the employee.**/
	private double weeklyWage;
	
	/** Name of the employee*/
	private String name;

	public Employee(double weeklyWage, String name) {
		this.weeklyWage = weeklyWage;
		this.name = name;
	}

	public double getWeeklyWage() {
		return weeklyWage;
	}

	public String getName() {
		return name;
	}
	
	
	
	
}
