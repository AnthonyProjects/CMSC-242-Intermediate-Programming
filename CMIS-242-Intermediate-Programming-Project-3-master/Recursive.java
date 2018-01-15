import java.util.Scanner;


public class Recursive {

	public static void main(String[] args) {
		
		 Scanner in = new Scanner(System.in);			// scanner open		
		 System.out.print("Please enter a number: ");	// prompts user to type in number
		 int n = in.nextInt();							// looks for next integer	

		for (int term = 0; term <= n; term++){
			
			System.out.println(rec(term));
		 }
	
	}

	private static int rec(int n) {
		
		if(n <= 1){					// n <= 1
			
			return n;				// return the value for n
		}
		else{
			
			int recSequence = 2*rec(n-1) + 3*rec(n-2); 	// recursive takes place
			
			return 	recSequence;	// returns recSequence
			
			
		}
	}
}
