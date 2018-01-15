/**
 * @author Anthony Borza
 * Sequence Class
 * The Sequence Class inherits the behaviors of the GUI class and contains the following methods:
	 	*  	computeIterative method: Performs iteration of the value entered in for 'n'.
	 	*  	Recursive method: Initializes efficenyCount  as 0, and returns the method Recursive with the parameter n
	 	*  	computeRecursive method: Performs recursion for the value entered in for 'n'
	 	* 	getEfficiency; gets the number of counts for both iterative, and recursive
 *  The Sequence Class also contains:
 	*  two private instance variables: n, and efficiency count
 *  
 */


public class Sequence {
	
	// Private Instance Variables

	private static int n;											// n declare as private with data of type int
	private static int efficiencyCount;								// efficiencyCount declared as private with data of type int
	
	
	/**
	 * ComputeIterative method declared as public static int
	 * @param n
	 * @return nthTerm
	 */
	
	public static int computeIterative(int n) {
		
		int firstPrev = 1;   						//sequence (0 1 2 5 ...) , start at value 2, the firstPrev = 1
		int secondPrev = 0;  						//sequence (0 1 2 5 ...) , start at value 2, the secondPrev = 0
		int nthTerm = 0;	  						// nth_term declared as an int and assigned 0;
		efficiencyCount = 0;						// efficenyCount initialized as 0
		
		 if (n == 0) {                               // n == 0 
		    		
			 nthTerm = 0;							// return the value for nth_term
		  }

		  else if (n == 1) {                        // n == 1 
		    	
			  nthTerm = 1;							// return the value 1 for nth_term
		  }
		 
		  else if (n >= 2) {                        //remaining terms calculated

		    for (int term = 2; term <= n; term++){
		        
		    	efficiencyCount++;							// counts the number time the loop goes through when computing the efficiency for the iterative
		    	nthTerm = 2 * firstPrev + secondPrev;		// 2 times the first previous term plus the second previous term
		        secondPrev = firstPrev;						// second previous term becomes first previous term.
		        firstPrev = nthTerm;						// first previous term becomes the nth term
		     }
		      
		   }
		 		return nthTerm;							// returns the iterative value for the nth_term
	}
	
	/**Recursive method declared as public static int
	 * @param n
	 * @return n
	 */
	
	public static int Recursive(int n)
	{
		efficiencyCount = 0;		// efficenyCount initialized as 0
		return Recursive(n);		// returns the method Recursive with the parameter n
	}
	
	/**
	 * computeRecursive method declared as public static int
	 * @param n
	 * @return nthTerm
	 */

	public static int computeRecursive(int n) {
	
		int nthTerm;				// nth term declare with data of type int	
    	efficiencyCount++;			// keeps count of the number of efficiency for the computeRecursive method

		if(n == 0){					// n == 0 
			
			return nthTerm = 0;	// return the value for nth term
		}
		
		else if(n == 1){			// n == 1 
			
			return nthTerm = 1;	// return the value 1 for nthTerm
		}
		
		else{
			
			nthTerm = 2*computeRecursive(n-1) + computeRecursive(n-2); 	// recursive takes place
			
		}
		
		return 	nthTerm;	// returns the recursive value for the nth_term
	}
	
	/** Sample output for if the users enters in the value 5 for 'n'
	 *
		 * 0+0+0=0
		 * 1+1+0 =2
		 * 2+2+1 = 5
		 * 5+5+2=12
		 * 12+12+5 =29
		 * Results: 29
	 */

	/**
	 * getEfficiency method declared as public static int
	 * @return efficiencyCount
	 */
	
	public static int getEfficiency() {
		
		return efficiencyCount;			// returns efficiencyCount of both iterative and recursive
	}
	

	
}
