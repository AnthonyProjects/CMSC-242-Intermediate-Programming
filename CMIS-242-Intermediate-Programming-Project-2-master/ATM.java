/** Anthony Borza
 * Due Date 4/10/16
 * Project 2:  ATM GUI
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**  The ATM class creates the ATM Graphical User Interface and has the following properties:
 		*  	imports from java.awt and java.swing
 		*  	extends JFrame and implements ActionListener
 *  Creates the ATM Constructor which implements:
 		*  	creates 4 buttons:  withdraw, deposit, transfer and balance
 		*  	creates 2 radial button: checking and savings
 		*  	creates a test field for user numeric input
 		*  The Account class also catches various exceptions with custom defined messages displayed in a message block
 		*  The ATM class calls the Account class which contains corresponding methods which handled the
 		*  action performed by each button.
 */

public class ATM extends JFrame  { 
	
	//instance variables
	

	private final static int FRAME_WIDTH = 400;   		//window width
	private final static int FRAME_HEIGHT = 250; 	 	//window height
	private JTextField amountText;						//account input field, used for depositing, withdrawing and transferring money
	private JButton withdrawButton;						//account withdraw option from either checking or savings account
	private JButton depositButton;						//account deposit option from either checking or savings account  		
	private JButton transferButton;						//account transfer option from either checking or savings account
	private JButton balanceButton;						//account balance option for either checking or savings account
	private JRadioButton checkingRadialButton;			//select checking account option
	private JRadioButton savingsRadialButton;			//select savings account option
	private Account checking = new Account();			//define checking as type Account
	private Account savings = new Account();		   	//define savings as type Account
	private Account accountTypeSrc = new Account();    	//define  'account type source' as type Account
	private Account accountTypeDest = new Account();   	//define 'account type destination' as type Account

	/** ATM constructor - creates ATM GUI
	 * creates 4 buttons:  withdraw, deposit, transfer and balance
	 * creates 2 radial button:  checking and savings
	 * creates a test field for user numeric input
	 */
		
	public ATM(){
		
		JPanel panel1 = new JPanel(new GridLayout(3,2,10,10));	//creates panel using gridlayout - 3 rows, 2 columns with vertical and horizontal gaps of 10
		
		withdrawButton = new JButton("Withdraw");				//new withdraw button
		depositButton = new JButton("Deposit");					//new deposit button
		transferButton = new JButton("Transfer to");			//new transfer to button
		balanceButton = new JButton("Balance");					//new balance to button
		
		panel1.add(withdrawButton);		//adds withdraw button to panel 1
		panel1.add(depositButton);		//adds deposit button to panel 1
		panel1.add(transferButton);		//adds transfer to button to panel 1
		panel1.add(balanceButton);		//adds balance button to panel 1
		
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));	//creates panel using flowlayout centered
		checkingRadialButton = new JRadioButton ("Checking");			//new checking account radial button
		savingsRadialButton = new JRadioButton ("Savings");				//new savings account radial button
		amountText  = new JTextField(20);								//new textfield, displayed at the width 20, for user account input
		
		panel2.add(checkingRadialButton);	//adds checking account radial button to panel 2
		panel2.add(savingsRadialButton);	//adds savings account radial button to panel 2
		panel2.add(amountText);				//adds text field (amountText) to panel 2

		add (panel1, BorderLayout.NORTH);		//adds panel 1 to border layout, NORTH
		add (panel2, BorderLayout.CENTER);		//adds panel 2 to border layout, CENTER
		
		checkingRadialButton.addActionListener(new Enable());	//registers action listener for checking
		savingsRadialButton.addActionListener(new Enable());	//registers  action listener for savings
		withdrawButton.addActionListener(new Select());			//registers  action listener for withdraw
		depositButton.addActionListener(new Select());			//registers  action listener for deposit
		transferButton.addActionListener(new Select());			//registers  action listener for transfer
		balanceButton.addActionListener(new Select());			//registers  action listener for balance
		
	}	
	
	
	/** The Enable class implements an Action Listener for the following:
	 * 		checkingRadialButton
	 * 		savingsRadialButton
	 * The class sets the account type based on the button selected, either checking or savings
	 */
	
	public class Enable implements ActionListener{ 
		
		public void actionPerformed(ActionEvent event){
			
	        if(checkingRadialButton.isSelected()){
	        	
	        	accountTypeSrc = checking;    //account type source is checking
	            accountTypeDest = savings;    //account type destination is savings
	        }
	        else if(savingsRadialButton.isSelected()){
	        	
	        	accountTypeSrc= savings;	  //account type source is checking
	            accountTypeDest = checking;	  //account type destination is savings	
	        }
	    }
	}

	/** The Select class implements an Action Listener for the following:
	 * 		withdrawButton
	 * 		depositButton
	 * 		transferButton
	 * 		balanceButton
	 * The class performs contains various try/catch block which which throws and exception for
	 * invalid input.  It also contains a user defined InsufficientFunds  exception, caught 
	 * for insufficient funds in either account
	 */
	
	public class Select implements ActionListener{ 
		
		public void  actionPerformed(ActionEvent event){
			
			int withdrawAmount = 0;
			double deposit, transfer = 0;
			
			// nested if / else if statements implemented based on the button selected by the user
			
			if (event.getSource() == withdrawButton){	 //user selects the withdraw button 
				
				//try/catch block that catches various exceptions for invalid input
				
				try { 
					
					//user enters the amount to be withdrawn - must be in $20 increments
					
					withdrawAmount = Integer.parseInt(amountText.getText()); 
					
					//a check to verify the amount to be withdrawn is in $20 increments
					
					if(withdrawAmount % 20 == 0){  //the modulus of the amount must be 0 if an increment of $20
						
						accountTypeSrc.withDraw(withdrawAmount);
						
						JOptionPane.showMessageDialog(null, "Amount withdrawn is: $" + withdrawAmount);
					}
					
					else{
						
						JOptionPane.showMessageDialog(null, "Must withdraw in increments of $20");
					}
				} 
				//a check to verify the amount is numeric ONLY
				
				catch (NumberFormatException e) {
					
					JOptionPane.showMessageDialog(null, "Error: Please enter a numeric value");
				}
				
				//a user defined InsufficientFunds exception, caught for insufficient funds in either account
				
				catch(InsufficientFunds e){
					
		               JOptionPane.showMessageDialog(null, "There are insufficient funds in this account");
		           }
			}
			
			else if (event.getSource() == depositButton){ //user selects the deposit button
				
				//try/catch block that catches various exceptions for invalid input
				
				try {
					
					//user enters the amount to be deposited 
					
					deposit = Double.parseDouble(amountText.getText());
					accountTypeSrc.deposit(deposit);
					JOptionPane.showMessageDialog(null, "Amount deposited is: $" + deposit);
				} 
				
				//a check to verify the amount is numeric ONLY, throws the exception if not
				
				catch (NumberFormatException e){
					
					JOptionPane.showMessageDialog(null, "Error: Please Enter a numeric value");
				}
			}
			
			else if (event.getSource() == transferButton){  //user selects the transfer button
				
				//try/catch block that catches various exceptions for invalid input
				
				try {
					
					transfer = Double.parseDouble(amountText.getText());
					accountTypeSrc.transfer(withdrawAmount, accountTypeDest);  //transfer from source account to destination account
					JOptionPane.showMessageDialog(null, "Amount transferred is: $" + transfer);
				} 
				
				//a check to verify the amount is numeric ONLY, throws the exception if not
				
				catch (NumberFormatException e){
					
					JOptionPane.showMessageDialog(null, "Error: Please Enter a numeric value");
				}
				
				//a user defined InsufficientFunds  exception, caught for insufficient funds in either account
				
				catch(InsufficientFunds e){
					
		               JOptionPane.showMessageDialog(null, "There are insufficient funds in this account");
		         }
			}
			
			else if (event.getSource() == balanceButton){ //user selects the balance button
					
				JOptionPane.showMessageDialog(null, "Account balance is: $" + accountTypeSrc.getAccountBalance() );
			}
		}
	}
	
/**ATM main method
 * @param  String[]  args
 * @return void
*/

public static void main(String[] args) {							
		JFrame frame = new ATM();									//new frame object
		frame.setTitle("ATM Machine");								//assigns ATM machine as title to frame
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);					//sets ATM frame size
		frame.setLocationRelativeTo(null);							//sets centers ATM content in frame
		frame.setVisible(true);										//sets frame as visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//gracefully closes on exit
		
	}
} 

