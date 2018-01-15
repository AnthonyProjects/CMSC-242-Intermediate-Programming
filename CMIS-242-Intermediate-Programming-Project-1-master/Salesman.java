/*
 * Created by: Anthony Borza
 * CMIS-242
 * Project 1
 */

// Subclass Salesman extends the functionality of the existing class Employees

 public class Salesman extends Employee {

	 // Instance variables
	 
	private int annualSales;		// annualSales denoted as a integer
	static double rate = .02;		// Commission rate 
	
	public Salesman(){
	}
	
	// Constructor Method that allows the name, monthly salary, annual sales to be initialized 

	public Salesman(int year, String title, String employeesName, int monthlySalary, int annualSales ){	// takes the parameters year, title, employeesName, monthlySalary, and annualSales
		
		super(year, title, employeesName, monthlySalary); 	// chapter 11 Page 415, shows what and how to use the word super
		this.annualSales = annualSales;
	}
	
	// Overridden method annualSalary that returns the salary for the whole year
	
	public int annualSalary(){
		
		int commission;									// commission is denoted as a integer
							
		
		commission = (int) ((rate) * annualSales);		// commission is rate * annualSales 
		if(commission > 20000){							// If statement that shows if commission is greater than 20000
			
			commission = 20000;							// set Commission to 20000
		}	
		
		return super.annualSalary()+commission;			// annual salary plus commision is returned		
	}
	
	// Overridden toString method that returns a string containing the name, monthly salary and annual sales. 
	
	public String toString(){
		
		return super.toString() + " " + annualSales;
	}
	
}
