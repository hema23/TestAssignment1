package com.mediafire.problem1.services;

import java.util.ArrayList;
import java.util.List;

import com.mediafire.problem1.domain.Employee;
import com.mediafire.problem1.domain.Manager;

/**
 * Service instantiates all the employees and computes their weekly wages.
 * 
 * @author Hemaanjana
 */
public class DepartmentService 
{
	public static void main(String[] args) 
	{
		// Creating a separate collection for test department
		List<Employee> testDepartment = new ArrayList<Employee>();
		
		testDepartment.add(new Manager(1000.0, "Bob", "Paking slot 1"));
		testDepartment.add(new Employee(900.0, "Sue"));
		testDepartment.add(new Employee(800.0, "Bill"));
		testDepartment.add(new Employee(700.0, "Joe"));
		
		// Creating a separate collection for manufacturing department
		List<Employee> manufacturingDepartment = new ArrayList<Employee>();

		manufacturingDepartment.add(new Manager(1005, "Richard", "Parking slot 2"));
		manufacturingDepartment.add(new Employee(905.0, "Helen"));
		manufacturingDepartment.add(new Employee(805.0, "Jake"));
		manufacturingDepartment.add(new Employee(705.0, "Tony"));
		
		DepartmentService service = new DepartmentService();
		
		//displays the individual totals of the departments
		System.out.println("Test Department Weekkly compted wage = " + service.computeWage(testDepartment));
		
		System.out.println("Manufacturing Department Weekkly compted wage = " + service.computeWage(manufacturingDepartment));
		
		// combining both the departments into one collection
		List<Employee> allDepartments = new ArrayList<Employee>();
		
		allDepartments.addAll(testDepartment);
		allDepartments.addAll(manufacturingDepartment);
		
		// displays the grand total
		System.out.println("Grand Total for all the departments Weekkly compted wage = " + service.computeWage(allDepartments));
		
	}
	
	/**
	 * Computes the sum of weekly wages for all the employees in the list.
	 * @param employees The list of employees
	 * @return The computed sum of wages.
	 */
	public double computeWage(List<Employee> employees)
	{
		double result = 0;
		
		for(Employee employee:employees)
		{
			result = result + employee.getWeeklyWage();
		}
		
		return result;
	}

}
