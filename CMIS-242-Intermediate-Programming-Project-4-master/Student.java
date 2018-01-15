/**
 * Anthony Borza
 * Due Date: 5/8/16
 * Student class: Defines the students records. This class contains the instance variables for the student name, major 
 * and two variables that are used to compute the GPA. A variable that contains the total number of credits completed 
 * and a second variable that contains the total quality points, which are the numeric value of the grade received in
 * a course times the number of credit hours. It should not contain the student ID. 
 * The class has the following three methods:
	 * Student constructor method
	 * courseCompleted method
	 * String Method
 */

public class Student {
	
	// instance variables
	
	private String name;					// name declared as a type string
	private String major;					// major declared as a type string
	private double totalNumberCredit;		// totalNumeberCredit declared as a type int
	private double totalQualityPoints;		// totalQualityPoints declared as a type int

	/**constructor: is used when new student records are created. Accepts a type string of name and major as parameters.
	 * It than initialize the fields that are used to compute the GPA to zero.
	 * @param name
	 * @param major
	 */

	public Student(String name, String major){
		
		this.name = name;					// this.name is used to pass the argument name in the constructor Student
		this.major = major;					// this.major is used to pass the argument name in the constructor Student
		totalNumberCredit = 0;				// this.totalNumberCredit is assigned 4 in the constructor Student
		totalQualityPoints = 0;				// this.totalQualityPoints is assigned 1 in the constructor Student
	}
	
	
	/**courseCompleted method: Accepts the course grade and credit hours and than updates the variables used to compute the GPA. 
	 * This method will be called when an Update request is made. The following method consist of if, else, if and else statements
	 * that are used to check if the grade and number of credits selected match the courseGrade and number in the below statements.
	 * 
	 * @param courseGrade
	 * @param CreditHours
	 */

	
	public void courseCompleted(char courseGrade, int CreditHours){
		
		int number = 0;									// number declared as data type int and assigned 0
		
		if(courseGrade == 'A'){							// courseGrade is equal to 'A'

			number = 4;									// number is equal to 4
		}
		
		else if(courseGrade == 'B'){					// courseGrade is equal to 'B'
	
			number = 3;									// number is equal to 3
		}
		
		else if(courseGrade == 'C'){					// courseGrade is equal to 'C'
	
			number = 2;									// number is equal to 2
		}
		
		else if(courseGrade == 'D'){					// courseGrade is equal to 'D'
	
			number = 1;									// number is equal to 4
		}
		
		else{

			number = 0;									// number is equal to 0 to represent grade values 'E' and 'F'
		}
		
		totalNumberCredit = CreditHours;
		totalQualityPoints =(number * CreditHours);

	}		
	
	/**override to String method: returns a labeled string containing the student name, major and GPA.
	 * This method contains an if statement: that sets totalNumberCredit to 0.0, which is a data type
	 * double. If this is the case it returns Student name, major and GPA of 4.0. If that is not the case,
	 * the variable gpa is assigned a data type double, and divides the totalQualityPoints by the totalNumberCredit.
	 * Than it will return Student name, major and current gpa. 
	 * this.name
	 * this.major
	 * gpa
	 * @return
	 */

	@Override
	public String toString(){

		if(totalNumberCredit == 0.0){
			
			
			return "Student Name: " + name + "\n" + "Major: " +  major + "\n" + "Current GPA: 4.0";
		}
		
		double gpa = totalQualityPoints/totalNumberCredit;
		return "Student Name: " + name + "\n" + "Major: " +  major + "\n" + "Current GPA: " + gpa;

	}
}

