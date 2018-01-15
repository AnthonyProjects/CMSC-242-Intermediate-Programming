
/*
 * InsufficientFunds class. It extends a RunitmeException, and is
 * a defined Checked Exception. Checks and takes care of exception 
 * at compile time. 
 * 
 */

public class InsufficientFunds extends RuntimeException{

	public InsufficientFunds(){
		
	// Invokes RutimeException constructor to set the error message
		
		super();	//super calls the parent class constructor 
	}
	
	// Constructor that accepts a explanation
	
	public InsufficientFunds(String explanation){
		
		super(explanation);
	}
}
