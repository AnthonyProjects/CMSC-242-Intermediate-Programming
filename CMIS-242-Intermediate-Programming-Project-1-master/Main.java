
/*
 * Created by: Anthony Borza
 * CMIS-242
 * Project 1
 * 
 * Program Description: The program below acts as the following. Its job is to read in the
 * employee information from a text file line by line, and each line will represent the
 * following types of employees: Employee, Salesman, and Executive. The year will be the
 * first date element on the line, which will display either 2014 or 2015. After the date
 * the employee type followed by their name, and monthly salary. However, for the Salesman
 * their final value is annual sales, and for Executive their final value is stock price.
 * Each employee type will have an employee object that is created for their type, and
 * will be stored in one of two arrays depending upon the year. We can assume that the file
 * will not contain any more then 10 employees. Once all employee data in read in based on 
 * year, each line will contain original data supplied for each employee followed by the 
 * annual salary for that year. Lastly, for each of the two years an average salary will be
 * calculated and displayed.
 *  
 */

 // import statements

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	   public static void main(String[] args) throws IOException  {
		   
		   int index1 = 0;							    // index1 is denoted as an integer
		   int index2 = 0;								// index2 is denoted as an integer
		   int year2014 = 0;							// year2015 is denoted as an integer
		   int year2015 = 0;							// year2014 is denoted as an integer
		   Employee employee = null;					// null is denoted for employee
		   String line;									// each line in the input file
		   Employee [] data2014 = new Employee[10];		// array of type Employee for 2014
		   Employee [] data2015 = new Employee[10];		// array of type Employee for 2015
		   String [] emp;								// used to store index values for each position in the array

		   
		   FileReader inputFile = new FileReader("employee.txt");	// reads input file employee.txt
		   BufferedReader rd = new BufferedReader(inputFile);		// inputFile takes place of employee.txt
		   
		   while((line = rd.readLine()) != null) {		  		// checks each line of input file employee.txt

			 	emp = line.split(" ");					 		//  splits each line from the input file based on " " delimiter
			 	int year = Integer.parseInt(emp[0]);	 		//  year is denoted as an integer and is parsed to represent the index value 0 in the array
			 	String title = emp[1];							//  title is denoted as an string and represent the index value 1 in the array
			 	String employeesName = emp[2];					//  employeeName is denoted as an string and represent the index value 2 in the array
			 	int monthlySalary = Integer.parseInt(emp[3]);	//  monthlySalary is denoted as an integer and is parsed to represent the index value 3 in the array
			 	
			 // emp[1] denotes employees title "Employee, or Salesman, or Executive
			 	
				if("Employee".equals(emp[1])){			
					
					employee = new Employee(year, title, employeesName, monthlySalary);		// displays the year, title, employee's, and their monthly salary
				
				}
				
				else if("Salesman".equals(emp[1])){		
					
					int annualSales = Integer.parseInt(emp[4]);		// annualSales is at position for in the array				
					employee = new Salesman(year, title, employeesName, monthlySalary, annualSales);	// displays the year, title, employee's name, monthly salary, and annual sales
				}
				
				else if("Executive".equals(emp[1])){
					
					int currentStockPrice = Integer.parseInt(emp[4]);	// currentStocks is at position for in the array
					employee = new Executive(year, title, employeesName, monthlySalary, currentStockPrice);	// displays the year, title, employee's name, monthly salary, and current stock price
				}
				
				if(year == 2014){					// if statement for if year is equal to 2014
					
					data2014[index1] = employee;	// the array data2014 takes index1, which is denoted as 0
					index1++;						// Increments index1 each time until the end of the file
					
				}
				else if(year == 2015){				// else statement for if year is equal to 2015
						
					data2015[index2] = employee;	// the array data2015 takes index2, which is denoted as 0
					index2++;						// Increments index2 each time until the end of the file
					
				}
				
		   	}     
			   		System.out.println("Employee Data 2014");	// used as a header for Employee data for 2014
			   		System.out.println();						//prints a new line
			   		
			        for(Employee element : data2014){			// for loop for employ data for 2014
			        	
			            System.out.println(element);			// prints all employee types for 2014
			            year2014 += element.annualSalary();		// Gets annual salary and assigns it to the variable year2014
			            System.out.println("2014 Annual Salary = "+ element.annualSalary());	// prints out annual salary for each employee type
			            System.out.println();
			        }
			       
			        // Prints average salary for all employees during the year of 2014
			        
			        System.out.println("--------------------------------------------------");
		            System.out.println("2014 Average Salary = "+ (year2014/index1));			// the variable year2014 is divided by the number of elements in index1
		            System.out.println("--------------------------------------------------");
				
					System.out.println(); //prints a new line
					System.out.println("Employee Data 2015");	// used as a header for Employee data for 2015
			   		System.out.println(); //prints a new line
		   		
				for(Employee element : data2015){			// for loop for employ data for 2015
					
					 System.out.println(element);			// prints all employee types for 2015
					 year2015 += element.annualSalary();	// Gets annual salary and assigns it to the variable year2014
			         System.out.println("2015 Annual salary = "+ element.annualSalary());	// prints out annual salary for each employee type
			         System.out.println();	//prints a new line
			         
			        }
				
				   // Prints average salary for all employees during the year of 2015
					
					 System.out.println("--------------------------------------------------");
					 System.out.println("2015 Average Salary = "+ (year2015/index2));				// the variable year2014 is divided by the number of elements in index2
					 System.out.println("--------------------------------------------------");
					

					 rd.close();  // closes file
		   
	   }
}
		      
	 

	  
		   		  	  

	   


	     
	   		
	    


		   
		   

		    
		    


			  
		   
			  
		   
		   
		   
		   
		   
		   
		   

		  
	
       
		    	

	 
	
         

