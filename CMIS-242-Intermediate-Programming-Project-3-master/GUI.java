/** @author Anthony Borza
 *  Due Date 4/24/16
 *  Project 3: involves writing a program to calculate the terms of the following sequence of numbers: 0 1 2 5 12 29 ... where 
 *  each term of the sequence is twice the previous term plus the second previous term.The 0th term of the sequence is 0 and the
 *  1st term of the sequence is 1. 
 *  
 *  The GUI class creates the GUI Graphical User Interface and has the following properties:
	 *  import java.awt.*
	 *  import java.awt.event.ActionEvent
	 *  import java.awt.event.ActionListener
	 *  import java.awt.event.WindowAdapter
	 *  import java.awt.event.WindowEvent
	 *  import java.io.BufferedWriter
	 *  import java.io.FileWriter
	 *  import java.io.IOException
 *  Creates the GUI constructor which implements 
 	 *  creates three text fields: nText(user input), resultsText, and efficiencyText (users output)
 	 *  creates two radio buttons: iterative, and recursive to allow the user to select which method
 	 *  they chose to get as an output
 	 *  creates one button: compute button, and this computes the output results and efficiency of what the
 	 *  user choose for their input. 
 	 *  The GUI class also catches various exceptions with custom defined messages displayed in a message block
 	 *  The GUI class calls the Sequence class which contains corresponding methods which handled the
 	 *  action performed by each button.
 */

// Imports used

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class GUI extends JFrame {
	
	// Private Instance Variables
	
	private final static int FRAME_WIDTH = 400;   				//window width
	private final static int FRAME_HEIGHT = 250; 	 			//window height
	private JLabel n;											//JLabel declared as private and assigned n
	private JLabel results;										//JLabel declared as private and assigned results
	private JLabel efficiency;									//JLabel declared as private and assigned efficiency
	private JTextField nText ;									//JTextField declared as private and assigned nText
	private JTextField resultsText;								//JTextField declared as private and assigned resultsText
	private JTextField efficiencyText;							//JTextField declared as private and assigned efficiencyText
	private JRadioButton iterativeRadialButton = new JRadioButton("Iterative", true); 	//iterative  option is initially set to selected
	private JRadioButton recursiveRadialButton = new JRadioButton("Recursive");			//recursive option
	private JButton computeButton;								//JButton declared as private and assigned computeButton
	private Sequence iterative = new Sequence();				//define iterative as type Sequence		
	private Sequence selection1 = new Sequence();				//define selection1 as type Sequence		
	private Sequence recursion = new Sequence();				//define recursion as type Sequence				
	private Sequence selection2 = new Sequence();				//define selection2 as type Sequence		
	private int iterativeCount = 0;								//iterativeCount declared as private with a data type int
	private int recursiveCount = 0;								//recursive Count declared as private with a data type int
	
	/** GUI constructor 
	 * Creates the layout of the GUI using the GridLayout format. 
	 * Adds the following to the panel:
	 	* iterativeRadialButton,and JLabel Iterative
	 	* recursiveRadialButton,and JLable1 Recursive
	 	* JLabel Enter n:,and nText as a JTextField
	 	* computeButton,and JLabel Compute
	 	* JLabel Results:,and resultsText as a JTextField
	 	* JLabel Efficiency:,and efficiencyText as a JTextField
	 	* Adds Action Listeners for the following:
	 	* iterativeRadialButton
	 	* recursiveRadialButton
	 	* computeButton
	 	* resultsText
	 	* efficiencyText
	 	* Adds the variable win to the inner class Window that extends WindowAdapter
	 */
	
	public GUI(){
		
		JPanel panel1 = new JPanel(new GridLayout(6,2,2,8)); // Creates a first panel called panel1
		
		iterativeRadialButton = new JRadioButton("Iterative",true);
		recursiveRadialButton = new JRadioButton("Recursive");
		
		ButtonGroup group = new ButtonGroup();						//creating a new Button Group initialized as group
		group.add(iterativeRadialButton);							//iterativeRadialButton added to the group
		group.add(recursiveRadialButton);							//recursiveRadialButton added to the group
		
		panel1.add(new JLabel());									//adds a new JLabel with no parameter
		panel1.add(iterativeRadialButton);							//adds iterativeRadialButton to panel1
		panel1.add(new JLabel());									//adds a new JLabel with no parameter
		panel1.add(recursiveRadialButton);							//adds recursiveRadialButton to panel 1	
		
		n = new JLabel("Enter n: ");								//adds a new JLabel with that will display Enter n:
		nText = new JTextField();									//nText declared as a new JTextField
		panel1.add(n);												//adds JLabel to panel1
		panel1.add(nText);											//adds JTextField to panel1
		
		computeButton = new JButton("Compute"); 					//creates a new JButton with using the variable computeButton, and will display Computer on the button
		panel1.add(new JLabel());									//adds a new JLabel with no parameter
		panel1.add(computeButton);									//adds computeButton to panel1
		
		results = new JLabel("Results: ");							//adds a new JLabel with that will display Results:
		resultsText = new JTextField();								//resultsText declared as a new JTextField
		panel1.add(results);										//adds JLabel to panel1
		panel1.add(resultsText);									//adds JTextField to panel1
		
		efficiency = new JLabel("Efficiency: ");					//adds a new JLabel with that will display Efficiency: 
		efficiencyText = new JTextField();							//efficiencyText declared as a new JTextField
		panel1.add(efficiency);										//adds JLabel to panel1
		panel1.add(efficiencyText);									//adds JTextField to panel1
		
		add(panel1);												//adds all of the above to panel1 

		iterativeRadialButton.addActionListener(new Select());		//registers action listener for iterative radio button
		recursiveRadialButton.addActionListener(new Select());		//registers action listener for recursive radio button
		computeButton.addActionListener(new Enable());				//registers action listener for compute button
		resultsText.addActionListener(new Enable());				//registers action listener for resultsText as a JTextField
		efficiencyText.addActionListener(new Enable());				//registers action listener for Efficiency as a JTextField
	
		Window win = new Window();									//This is an inner class of the name Window, and extends the windowAdapter function
		addWindowListener(win);										//Adds the window listener to receive window events from this window
		
	}
	
	/** The Select class implements an Action Listener for the following:
	 	* 		iterativeRadialButton
	 	* 		recursiveRadialButton
	 * The class sets the sequence type based on the button selected, either iterative or recursive
	 */
	
	public class Select implements ActionListener{ 
		
		public void actionPerformed(ActionEvent event){
			
	        if(iterativeRadialButton.isSelected()){			 // if statement for if the iterative button is selected
	        	
	        	selection1 = iterative;    					 // user selects selection 1 for iterative
	        	selection2 = recursion;    					 // user selects selection 2 for recursive
	        }
	        else if(recursiveRadialButton.isSelected()){	 // else if statement for if the recursive button is selected
	        	
	        	selection1 = iterative;    					 // user selects selection 1 for iterative
	        	selection2 = recursion;   					 // user selects selection 2 for recursive
	        
	        }
	    }
	}
	
	/** The Enable class implements an Action Listener for the following:
	 * 
 	* IterativeRadialButton: 
 	* if selected nthTerm gets the coputeIterative method from the class sequence, and gets the text from the nText 
 	* JTextField created and casts it so the JTextField can be read in as an integer. Than changes resultsText, and efficiencyText data type 
 	* Integer to a string and takes the parameter of the value entered in for n, and stores it in the declared variable nthTerm of type int.
 	* Lastly, calls the getEfficiecny method from the class Sequence, and keeps count of the efficiency for iterative.
 	* 
 	* RecursiveRadialButton: if selected nthTerm gets the computeRecursive method from the class sequence, and gets the text from the nText 
 	* JTextField created and casts it so the JTextField can be read in as an integer. Than changes resultsText, and efficiencyText data type 
 	* Integer to a string and takes the parameter of the value entered in for n, and stores it in the declared variable nthTerm of type int.
 	* Lastly, calls the getEfficiecny method from the class Sequence, and keeps count of the efficiency for iterative.
 	* 
 	* The class sets the sequence type based on the button selected, either iterative or recursive Declares the nthTerm variable as a data type int
 	* from the sequence class. This is done by using a try catch block that catches various exceptions for invalid input. We use an if and else if
 	* statement to determine this. 
 */

	public class Enable implements ActionListener{ 
		
		public void actionPerformed(ActionEvent event){
			
			int nthTerm;	// nthTerm declare with data of type int
			
			//try/catch block that catches various exceptions for invalid input
			
			try{
				
				if(iterativeRadialButton.isSelected()){			// if statement for if the iterative button is selected
					
					nthTerm = Sequence.computeIterative(Integer.parseInt(nText.getText()));	// gets computeIterative method from the class sequence, reads value for n as an integer
					resultsText.setText(Integer.toString(nthTerm));							// changes resultsTect to a data type int, takes parameter of the vale n and stores in nthTerm
					iterativeCount = Sequence.getEfficiency();								// gets efficiencyText method from the class sequence, and keeps count of the efficiency
					efficiencyText.setText(Integer.toString(iterativeCount));				// changes efficiencyText to a data type int, takes parameter of the vale n and and keeps count
				}
			
				else if(recursiveRadialButton.isSelected()){	// else if statement for if the recursive button is selected
			
					nthTerm = Sequence.computeRecursive(Integer.parseInt(nText.getText())); // gets computeRecursive method from the class sequence, reads value for n as an integer.
					resultsText.setText(Integer.toString(nthTerm));							// changes resultsTect to a data type int, takes parameter of the vale n and stores in nthTerm
					recursiveCount = Sequence.getEfficiency();								// gets efficiencyText method from the class sequence, and keeps count of the efficiency
					efficiencyText.setText(Integer.toString(recursiveCount));				// changes efficiencyText to a data type int, takes parameter of the vale n and and keeps count

				}

			}
			
			//a user defined a character exception, caught for not entering a integer value
			
			catch(NumberFormatException e){
				
				JOptionPane.showMessageDialog(null, "Error: Please enter a integer value");  	// message box appears asking the user to type in a integer value
			}
		
		}
	}
	
	/** This is an inner class of the name windowAdapter, and extends the windowAdapter function
	 	* The windowAdapter class Contains the following:
	 	* Action event listener
	 	* try/catch block that catches various exceptions for invalid written file
	 	* FileWiter, and BufferedWritter
	 	* The class uses a For loop that writes the efficiency values computed for n from 0 to 10. Each line of the file
	 	* contains the value of n, the efficiency of the iterative method for that value of n and the efficiency
	 	* of the recursive method. We do this by appending the data read in by the GUI, and using a delimiter "," to
	 	* separate the the values for n, and "/n" to write to a new line. 
	 */ 
	
	class Window extends WindowAdapter{


		public void windowClosing(WindowEvent e){  
		
			//try/catch block that catches various exceptions for invalid written file

			try {
				
				FileWriter bw = new FileWriter("results.csv"); 			// sets up a new file to be written as results.csv
				bw.append("n");											// Appends the specified character 'n' to this writer.
				bw.append(",");											// Appends the specified character ',' to this writer. 
				bw.append("Recursive");									// Appends the specified characters 'Recursive' to this writer. 
				bw.append(",");											// Appends the specified character ',' to this writer. 
				bw.append("Iterative");									// Appends the specified characters 'Iterative' to this writer. 
				bw.append("\n");										// Appends the specified character '/n' to this writer 

				// For loop to compute the efficiency values for n from 0 to 10 and write them to a file.
				
				for(int i = 0; i <= 10; i++){
					
					bw.append(String.valueOf(i));							// appends a string.value of i
					bw.append(",");											// Appends the specified character ',' to this writer
					Sequence.computeRecursive(i);							// gets the computeRecursive method from the sequence class and appends results to file
					bw.append(String.valueOf(Sequence.getEfficiency()));	// gets the getEfficiency method from the sequence class and appends results to file
					bw.append(",");											// Appends the specified character ',' to this writer 
					Sequence.computeIterative(i);							// gets the computeIterative method from the sequence class and appends results to file
					bw.append(String.valueOf(Sequence.getEfficiency()));	// gets the getEfficiency method from the sequence class and appends results to file
					bw.append("\n");										// Appends the specified character '/n' to this writer 
						
				}
				
					bw.flush();												// flushes out the output and make sure everything is written to a file
					bw.close();												// closes file
				
			} 
			
			// catches any error that may result in writing to a file
			
			catch (IOException explanation) {

				// prints "Error: cannot write to file", plus the IOException explanation, and returns the detail message string of this throwable
				
				System.out.println("Error: cannot write to file"+explanation.getMessage());	
				
				System.exit(0);				// terminates the process of writing to file and exits
			}
			
		}
	}
	
	/** GUI main method
	 	* Creates the frame from the GUI class.Than sets the title to Project 3
	 	* Sets the Size of the frame by the declared size in the GUI class
	 	* Sets the location to relative and takes the parameter null
	 	* Sets the visible to true, so the content is seen
	 	* Sets the close operation to Exit_ON_CLOSE, so when all actions are complete the frame closes 
	 	* @param  String[]  args
	 	* @return void
	*/
	
	public static void main(String[] args) {
	
		GUI frame = new GUI();										//new frame object
		frame.setTitle("Project 3");								//assigns Project 3 as title to frame
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);					//sets GUI frame size
		frame.setLocationRelativeTo(null);							//sets location relative to null				
		frame.setVisible(true);										//sets frame as visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//gracefully closes on exit
	}

}

