/**
 * Anthony Borza
 * Due Date: 5/8/16
 * Project 4: involves writing a program to manage a students records in a database. 
 * The Database GUI class creates the GUI Graphical User Interface and has the following properties:
	 *import java.awt.GridLayout;
	 *import java.awt.event.ActionEvent;
	 *import java.awt.event.ActionListener;
	 *import java.util.HashMap;
	 *import javax.swing.JButton;
	 *import javax.swing.JComboBox;
	 *import javax.swing.JFrame;
	 *import javax.swing.JLabel;
	 *import javax.swing.JPanel;
	 *import javax.swing.JTextField;
 */

// Imports used

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DatabaseGUI extends JFrame{
	
	// Private Instance Variables

	private final static int FRAME_WIDTH = 400;  	//window width
	private final static int FRAME_HEIGHT = 250; 	//window height
	private JLabel id;								//JLabel declared as private and assigned id
	private JLabel name;							//JLabel declared as private and assigned name
	private JLabel major;							//JLabel declared as private and assigned major
	private JLabel selection;						//JLabel declared as private and assigned selection
        private JTextField idText;						//JTextField declared as private and assigned idText
	private JTextField nameText;					//JTextField declared as private and assigned nameText
	private JTextField majorText;					//JTextField declared as private and assigned majorText
	private JButton processRequest;					// JButton declared as private and assigned as processRequest
	private JComboBox<String> choice;				//JComboBox declared as private and assigned as choice
	
	
	HashMap<Object, Student> studentDatabase = new HashMap<Object, Student>();
	
	
	/** Constructor
	    *Creates the layout of the DatabaseGUI using the GridLayout format. 
	 	* Adds the following to the panel:
	 	* idText as a JTextField,and JLabel Id
	 	* nameText as a JTextField,and JLabel Name
	 	* majorText as a JTextField,and JLabel Major
	 	* Choose Selection as a JLabel
	 	* JComboBox with an array of Objects "Insert","Delete","Find","Update" add to the ComboBox
	 	* Process Request Button
	 */
	
	public DatabaseGUI(){
		
		JPanel panel1 = new JPanel(new GridLayout(8,2,2,6));
		
		id = new JLabel("   Id: ");									//adds a new JLabel with that will display Id:
		idText = new JTextField();									//idText declared as a new JTextField
		panel1.add(id);												//adds JLabel to panel1
		panel1.add(idText);											//adds JTextField to panel1
		panel1.add(new JLabel());									//adds a new JLabel with no parameter
		
		panel1.add(new JLabel());									//adds a new JLabel with no parameter
		name = new JLabel("   Name: ");								//adds a new JLabel with that will display Name:
		nameText = new JTextField();								//nameText declared as a new JTextField
		panel1.add(name);											//adds JLabel to panel1
		panel1.add(nameText);										//adds JTextField to panel1
		panel1.add(new JLabel());									//adds a new JLabel with no parameter
		
		panel1.add(new JLabel());									//adds a new JLabel with no parameter
		major = new JLabel("   Major: ");							//adds a new JLabel with that will display Major:
		majorText = new JTextField();								//majorText declared as a new JTextField
		panel1.add(major);											//adds JLabel to panel1
		panel1.add(majorText);										//adds JTextField to panel1
		
		selection = new JLabel("   Choose Selection: ");			//adds a new JLabel with that will display Choose Selection::
		panel1.add(selection);										//adds JLabel to panel1
		
		choice = new JComboBox(new Object[]{"Insert","Delete","Find","Update"});	// creates a new JComboBox called choice, which is an array of Objects
		panel1.add(choice);
		
		processRequest = new JButton("Process Request"); 			//creates a new JButton with using the variable computeButton, and will display Computer on the button
		panel1.add(processRequest);									//adds computeButton to panel1


		add(panel1);												//adds all of the above to panel1 

		processRequest.addActionListener(new Select());				//registers action listener for processRequest button
	
	}
	
	/**	 The Select class implements an Action Listener.
	 *
		 * The main portion of the class, Select requires a sequence of, If, else if, and else statements that control and manage what is
		 * inserted, deleted, found, and updated. The following 4 statements can be understood by the following:
		 * 
		 * Insert: is an if statement that compares the string to the variable chose. within the if statement lies a nested if statement,
		 * which if the map contains a mapping for the specified key, it returns as true. It than displays a message box saying, 
		 * Our records shows you already as a student. If that fails, it than drops to the else statement, which associates the value
		 * with the specified key in this map; thus, if the map previously contained a mapping for the key, the old value is replaced.
		 * It than prints a JOptionPane dialog box that displays: Student Record was Inserted.
		 * 
		 * Delete: is an else if statement that compares the string to the variable chose. within the if statement lies a nested if statement,
		 * which if the map contains a mapping for the specified key, it returns as true. It than will remove the student records from 
		 * the database, and than display a message box saying, Student has been removed from database. If that fails, it than drops to the else statement,
		 * and prints a JOptionPane dialog box that displays: Error: Cannot delete student. No records found. 
		 * 
		 * Find: is an else if statement that compares the string to the variable chose. within the if statement lies a nested if statement,
		 * which if the map contains a mapping for the specified key, it returns as true. It than will than get the student records from 
		 * the database, and than, override to String method, and display a message box that returns a labeled string containing the student name, major and GPA.
		 * If that fails, it than drops to the else statement, and  prints a JOptionPane dialog box that displays: Error: No student records to be found
		 * 
		 * Update: is an else if statement that compares the string to the variable chose. It contains two arrays of type strings. They are grades, and credit. The grade
		 * values are letters: "A","B", "C","D","E","F", and the credit array values are: "3","6". It than declares studentGrades, and studentCredits as a data type String,
		 * and display a input dialog box that allows the student to update their grade or grades for a course, and a second input dialog box that allows them to select
		 * the amount of credits earned, either 3 or 6. It than calls over to the courseCompleted method is the class Students, and returns the char value at the specified index: 
		 * 0 being A, 1 being B, 2 being C, 3 being D, 4 being E, and 5 being F. On the same line, it parses the string argument StudentCredits as a signed decimal integer.
		 * Finally, it associates the specified value with the specified key in this map. If the map previously contained a mapping for the key, the old value is replaced
		 * 
		 * Try and catch block to make sure student id is a numeric value. If not throws exception: Error: ID must be a numeric value, and an if statement that checks
		 * that both the nameText field, and majorText field are not empty
	 * 	 
	 * @param event
	 */
		
	public class Select implements ActionListener{ 
		
		public void actionPerformed(ActionEvent event){
			
			// try/catch block used to ensure all fields are entered with the properly data type
			
			try{

				int id = Integer.parseInt(idText.getText().toString());				// parses the string argument as a integer.
				String name = nameText.getText().toString();						// gets the text from the name field and overrides it to a string
				String major = majorText.getText().toString();						// gets the text from the major field and overrides it to a string
				Student holder = new Student(name, major);							// calls over to the Student class for the data type string of name, and major
						
				String chose = choice.getSelectedItem().toString();					// gets the selected item from the Combo box that was declared above as choice with a data type string
	
				// checks to make sure both the nameText field, and majorText field are not empty
				
				if(nameText.getText().isEmpty() || majorText.getText().isEmpty()){
					
					 JOptionPane.showMessageDialog(null, "One or more of the required fields is empty", "Error", JOptionPane.ERROR_MESSAGE); // displays a message box if one or more fields are empty
				}
				
				// Compares this string "Insert" to the variable chose 
				
				else if(chose.equals("Insert")){											
				
					if (studentDatabase.containsKey(id)){							// Returns true if this map contains a mapping for the specified key.
						
						JOptionPane.showMessageDialog(null, "Our records shows you already as a student");	// displays a message box if you are a student
					}
				
					else{
					
						studentDatabase.put(id, holder);										// Associates holder with the specified key in this map. 
						JOptionPane.showMessageDialog(null, "Student Record was Inserted.");	// displays a message box if not a student
					}
				}
				
				// Compares this string "Delete" to the variable chose 
				
				else if(chose.equals("Delete")){									
					
					if (studentDatabase.containsKey(id)){							// Returns true if this map contains a mapping for the specified key
						
						studentDatabase.remove(id);									//Removes the mapping for the specified key from this map if present.
						JOptionPane.showMessageDialog(null, "Student has been removed from database");	// displays a message box verifying the student records have been removed
					}
			
					else{
						
						JOptionPane.showMessageDialog(null, " Cannot delete student records","Error", JOptionPane.ERROR_MESSAGE);	// displays a message box saying can not delete student
					}
				}
				
				// Compares this string "Find" to the variable chose 
				
				else if(chose.equals("Find")){										
					
					if(studentDatabase.containsKey(id)){							// Returns true if this map contains a mapping for the specified key
						
						Student student = studentDatabase.get(id);					//Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key. 
						JOptionPane.showMessageDialog(null, student.toString());	//override to String method: returns a labeled string containing the student name, major and GPA.
					}
					
					else{
						
						JOptionPane.showMessageDialog(null, "No student records to be found","Error", JOptionPane.ERROR_MESSAGE);	// displays a message box saying student records cannot be found
					}
				
				}
				
				// Compares this string "Update" to the variable chose 
				
				else if(chose.equals("Update")){							  		// Compares this string to the variable chose 
					
					String grade[] = {"A" , "B", "C","D","E","F"};			  		// grade of data type string of an array of student grades
					String credit[] = {"3","6"};							 		// credit of data type string of an array of student credit
					
			
					 // studentGrades, and studentCredits display a input dialog box that allows the student to update their grade or grades for a course,
					 // and a second input dialog box that allows them to select the amount of credits earned, wither 3 or 6. 
				
					String studentGrades = (String) JOptionPane.showInputDialog(null, "Choose grade:", "Grades", JOptionPane.QUESTION_MESSAGE, null, grade, grade[0]);
					String StudentCredits = (String) JOptionPane.showInputDialog(null, "Choose credits:", "Credits", JOptionPane.QUESTION_MESSAGE, null, credit, credit[0]);
					
				
					 // The variable holder calls the courseCompleted method: Accepts the course grade and credit hours and than updates the variables used to compute the GPA. 
					 // This method will be called when an Update request is made.
					 
					holder.courseCompleted(studentGrades.charAt(0), Integer.parseInt(StudentCredits)); 	// gets the char value, and parses StudentCredits from a string to an integer
					studentDatabase.put(id,holder); 													// Associates holder with the specified key in this map. 
					displayMessage("Updated" +"\n" + holder.toString());		// Displays a message "Updated" with updated records for the student. Overrides to String method: returns a updated GPA.
					
				}
			
			}
			catch(Exception e){	// catches any exceptions
				
	              JOptionPane.showMessageDialog(null,"Student ID must be a numeric value", "Error", JOptionPane.ERROR_MESSAGE);		// displays message if exception is caught
	        }
		
		}

	/**
	* Displays a message with updated records for the student
	* @param holder
	*/
		
	 private void displayMessage(String holder) {
			
			JOptionPane.showMessageDialog(null, holder);	// displays message box 	
			
	 }
  }
	
	/** DatabseGUI main method
 	* Creates the frame from the GUI class.Than sets the title to Project 4
 	* Sets the size of the frame by the declared size in the GUI class
 	* Sets the location to relative and takes the parameter null
 	* Sets the visible to true, so the content is seen
 	* Sets the close operation to Exit_ON_CLOSE, so when all actions are complete the frame closes 
 	* @param  String[]  args
 	* @return void
*/
	
	public static void main(String[] args){
		
		DatabaseGUI frame = new DatabaseGUI();						//new frame object
		frame.setTitle("Project 4: Student Records");				//assigns Project 4 as title to frame
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);					//sets GUI frame size
		frame.setLocationRelativeTo(null);							//sets location relative to null				
		frame.setVisible(true);										//sets frame as visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//gracefully closes on exit
	}

}
	


