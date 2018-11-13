/**
 
 
 * @author Richie Mulhern
 
**/
package ie.lyit.flight;


import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.io.Serializable; 

//INHERITANCE - Employee IS-A Person, and CAN-DO Payable methods
public class Employee extends Person implements Payable, Serializable {
    private Date startDate;	// Employee has name&dateOfBirth from Person		
    private double salary;	// AND startdate,salary, & number
    private int number;

	private static int nextNumber=1000;	// static for unique number - starts off at 1000    

	private final double MAX_SALARY = 150000.00;
	
    // Default Constructor
	// Called when object is created like this ==> 
	// Employee eObj = new Employee();	
    public Employee(){
    	super();
    	startDate=new Date();
 		salary=0.0;
		// Set number to static nextNumber before incrementing nextNumber
 		this.number=nextNumber++;
    }

    // Initialization Constructor
	// Called when object is created like this ==>
	//    Employee empObj = new Employee("Mr","joe","bloggs",
    //                                   30,07,1990,
    //									 new Date(10,11,2010),
    //                                   55000);
    //    NOTE:For dob and startDate you can either pass in a d,m,y OR a date object
    //         To show this, I have done dob as d,m,y, and startDate as a date object
    public Employee(String t, String fN, String sn, 
    		        int d, int m, int y,
    		        Date startDate, double salary){
       // Call super class constructor - Passing parameters required by Person ONLY!
	   super(t, fN, sn, d, m, y);
	   // And then initialise Employees own instance variables
	   this.startDate=startDate;	// Set instance variable to parameter
	   this.salary=salary;
	   
		// Set number to static nextNumber before incrementing nextNumber
	   this.number = nextNumber++;						
	}
    
    public void saveEmpNumber()
    {
    	number = nextNumber;
    	
    }

    public void setEmpNumber()
    {
    	nextNumber = number;
    }
	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding additional bits
	@Override
    public String toString(){
		return number + " " + super.toString() + " €" + salary;
	}

	// equals() method
	// ==> Called when comparing an object with another object, 
	//     e.g. - if(e1.equals(e2))				
	// ==> Probably sufficient to compare customer numbers as they're unique
	@Override
	public boolean equals(Object obj){
		Employee eObject;
		if (obj instanceof Employee)
		   eObject = (Employee)obj;
		else
		   return false;
		   
	    return(this.number==eObject.number);
	}

	public void setStartDate(Date startDate){
		this.startDate=startDate;
	}
	public Date getStartDate(){
		return startDate;
	}	
	public void setSalary(int salary){
		this.salary=salary;
	}
	public double getSalary(){
		return salary;
	}
	// You shouldn't be able to setNumber() as it is unique, 
	// so don't provide a setNumber() method
	public int getNumber(){
		return number;
	}	
	
	public double calculateWage(double taxPercentage) {
		// calculate and return the wage as salary/12 less taxPercentage
		double wage=salary/12;
		wage -= (wage * (taxPercentage/100));
		return wage;
	}

	public double incrementSalary(double incrementAmount) {
		// add incrementAmount to, and return the new salary
		// salary should not go over a maximum salary of €150,000
		salary += incrementAmount;
		
		if(salary > MAX_SALARY)
			salary = MAX_SALARY;
		
		return salary;
	}
	//read method
	public void read(){
	      JTextField txtEmployeeNo = new JTextField();
	      txtEmployeeNo.setText("" + this.getNumber());
	    //name as title, first name and surname
	      JTextField txtTitle = new JTextField();
	      JTextField txtFName = new JTextField();
	      JTextField txtSurname = new JTextField();
	      txtTitle.requestFocus();
	      JTextField txtDDOB = new JTextField();
	      JTextField txtMDOB = new JTextField();
	      JTextField txtYDOB = new JTextField();
	      JTextField txtStartD = new JTextField();
	      JTextField txtStartM = new JTextField();
	      JTextField txtStartY = new JTextField();
	      JTextField txtSalary = new JTextField();
	      
	      Object[] message = {
	              "Employee Number:", txtEmployeeNo,
	              "Title:", txtTitle,
	              "First Name:",txtFName,
	              "Surname:", txtSurname,
	              "Date of Birth[dd][mm][yyyy]:", txtDDOB, txtMDOB, txtYDOB,
	              "Start Date[dd][mm][yyyy]:", txtStartD,txtStartM, txtStartY,
	              "Salary:", txtSalary,
	          };
	      int option = JOptionPane.showConfirmDialog(null, message, "Enter employee details", JOptionPane.OK_CANCEL_OPTION);

	      if (option == JOptionPane.OK_OPTION){
	    	  super.name = new Name(txtTitle.getText(), txtFName.getText(), txtSurname.getText());
	    	  super.dateOfBirth = new Date(Integer.parseInt(txtDDOB.getText()), Integer.parseInt(txtMDOB.getText()),Integer.parseInt(txtYDOB.getText()));
	          this.startDate = new Date(Integer.parseInt(txtStartD.getText()), Integer.parseInt(txtStartM.getText()), Integer.parseInt(txtStartY.getText()));
	          this.salary = Double.parseDouble(txtSalary.getText());
	      }   
		
		}
	} 

