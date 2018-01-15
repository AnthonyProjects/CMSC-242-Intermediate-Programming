/*  The Account class inherits the behaviors of the ATM class and contains the following methods:
 *  	Withdrawal method
 *  	Deposit method
 * 		Transfer method
 * 		Get Account Balance method
 * 		Get Service Fee method
 *  The Account class also throws a user defined exception called 'InsufficientFunds' and is defined
 *  the INsufficientFunds class
 */

public class Account {
	
	//instance variables
	

	private final static double SERVICE_FEE = 1.5;  //service fee deducted when more than 4 withdrawls from either account is made
	private double accountBalance;  				//the user's account balance for either account
	private int numberWithdrawls;    				//keeps track of the number of account withdrawls
	
	//default constructor with initialized variables'
	
	public Account (){
		
		accountBalance = 0;				//set initial account balance
		numberWithdrawls = 1;			//set initial number of withdrawls
	}
	
	/*	Withdrawal method
   		@param  double withdrawAmount  -the amount to be withdrawn  from either account (checking or savings) 
		@return  void 
	*/	
	
	public void withDraw(int withdrawAmount) throws InsufficientFunds{
		
		//InsufficientFunds is a user defined checked exception, thrown for insufficient funds in the account
		
		double serviceFee;								// assigns serviceFees as a double
		serviceFee = getServiceFee();					// serviceFee is the return value from the getServiceFee method
		double total = withdrawAmount + serviceFee;   	//sum of withdraw amount and service fee
		
		if(accountBalance < total) throw new InsufficientFunds();	
		accountBalance -= total; 	// account balance after the withdrawl amount and any service fee is deducted	
		numberWithdrawls++;			// post increments number of withdrawls	and keeps track
	}
	
	
	/*	Deposit method
	   	@param  double input  - the amount to be deposited into either account (checking or savings)
		@return  void 
	*/
	
	public void deposit(double deposit){	
		
		accountBalance += deposit;  //account balance after a deposit is made
	}
	
	/*	Transfer method
		@param  double withdrawAmount -amount to be withdrawn from either account (checking or savings)  
		@param	Account target - amount transferred to either account (checking or savings)   
		@return  void 
	*/	
	
	public void transfer(double withdrawAmount, Account target) throws InsufficientFunds{
		
	//InsufficientFunds is a user defined checked exception, thrown for insufficient funds in the account
		
		if(accountBalance < withdrawAmount) throw new InsufficientFunds();
		accountBalance -=  withdrawAmount;   // account balance after a withdrawl is made
		target.deposit(withdrawAmount);		 // deposits the withdrawn amount to the target account (either checking or savings)
	}
	
	/*	Get Account Balance method
		@return  double  - returns the account balance;
	 */
	
	public double getAccountBalance(){
		
		return accountBalance;  
	}
	
	/*	Get Service Fee method
		@return  double  - returns the account balance - the service fee OR 0 if the  number of withdrawls is less than 4;
	*/
	public double getServiceFee() throws InsufficientFunds {
		
		//InsufficientFunds is a user defined checked exception, thrown for insufficient funds in the account
				
		if(numberWithdrawls > 4){ 
			
		//service charge deducted when more than 4 withdrawls from either account is made	
			
			if ((accountBalance - SERVICE_FEE) < 0) throw new InsufficientFunds();
			return accountBalance - SERVICE_FEE;  // returns the new account balance after service fees are deducted
		}
		
		else{
			
			return 0.0;	//returned only if the number of withdrawls from account is less than 4
		}
	}	
}
