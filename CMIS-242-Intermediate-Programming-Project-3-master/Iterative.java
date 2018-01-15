import java.util.Scanner;	// imports scanner

public class Iterative {

	  public static void main(String[] args){
		   
			 Scanner in = new Scanner(System.in);			// scanner open		
			 System.out.print("Please enter a number: ");	// prompts user to type in number
			 int n = in.nextInt();							// looks for next integer	
			
		    //int n = 7;  //hardcoded for now, input from JTextfield

		    int first_prev = 1;   //sequence (0 1 2 5 ...) , start at value 2, the first prev = 1
		    int second_prev = 0;  //sequence (0 1 2 5 ...) , start at value 2, the second prev = 0
		    int nth_term = 0;

		    if (n == 0) {                                //first term set to 0
		    	
		        System.out.println (n = 0);  
		    }

		    else if (n == 1) {                        //second term set to 1
		    	
		        System.out.println (n = 1);
		    }

		    else if (n >= 2) {                        //remaining terms calculated

		      for (int term = 2; term <= n; term++){
		        	
		         nth_term = 2 * first_prev + second_prev;	// 2 times the first previous term plus the second previous term
		         second_prev = first_prev;					// second previous term becomes first previous term.
		         first_prev = nth_term;						// first previous term becomes the nth term
		         System.out.println(nth_term);
		     }
		   }

	  }

}
