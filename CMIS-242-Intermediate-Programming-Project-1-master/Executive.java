
/*
 * Created by: Anthony Borza
 * CMIS-242
 * Project 1
 */

// Subclass Executive extends the functionality of the existing class Employees

public class Executive extends Employee{
	
	// Instance variable

	private int currentStockPrice; 
	
	
	public Executive() {
	}
	
	// Constructor Method that allows the name, monthly salary, and stock price to be initialized 
	
	public Executive(int year, String title, String employeesName, int monthlySalary, int currentStockPrice ) { 	// takes the parameters year, title, employeesName, monthlySalary, and currentstockPrice
		
		super(year, title, employeesName, monthlySalary);
		this.currentStockPrice = currentStockPrice;
	}
	
	// Overridden method annualSalary that returns the salary for the whole year

	public int annualSalary(){
		
		int  bonus; 								    // salary is denoted as a integer// amount is denoted as a integer
		
		if(currentStockPrice > 50){		
														
			bonus = 30000;								// bonus is 30000
		}
		else{
			
			bonus = 0;									// else commission is 0 
		}	
			
		return super.annualSalary()+bonus;				// annual salary plus bonus is returned					
	}
	
	// Overridden toString method that returns a string containing the name, monthly salary and stock price. 

	public String toString(){
		
		return super.toString() + " " + currentStockPrice;
	}
	

}
