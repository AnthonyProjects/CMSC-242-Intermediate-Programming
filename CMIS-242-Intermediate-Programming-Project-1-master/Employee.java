/*
 * Created by: Anthony Borza
 * CMIS-242
 * Project 1
 */

public class Employee {

		// Instance variables
	
		private int year;					// year is denoted as as a integer
		private String title;				// title is denoted as a String
		private String employeesName;		// employeesName is denoted as a String
		private int monthlySalary;			// monthlySalary is denoted as as a integer
	
		// Constructor Method that allows the name and monthly salary to be initialized 
		
		public Employee(){
		}
		
		public Employee(int year, String title, String employeesName, int monthlySalary){	// takes the parameters employeesName, and monthlySalary
			
			// Chapter 10.4 page 373, shows proper way to use 'this'
			
			this.year = year;
			this.title = title;
			this.employeesName = employeesName;						
			this.monthlySalary = monthlySalary;
		}
		
		// Method named annualySalary that returns the salary for a whole year
		
		public int annualSalary(){
			
			return 	monthlySalary * 12;   // returns monthlySalary multiplied by 12, which represents months
		}

		// toString method that returns a string containing the name and monthly salary, appropriately labeled 
		
		public String toString(){
			
			return year + " " + title + " " + employeesName + " " + monthlySalary;		// returns year, title, employeesName plus their monthly salary
		}
		

}


