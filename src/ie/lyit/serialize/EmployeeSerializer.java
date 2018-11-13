/**
 
 
 * @author Richie Mulhern
 
**/
package ie.lyit.serialize;

import java.util.*;
import java.util.ArrayList;
import ie.lyit.flight.Employee;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EmployeeSerializer {

	//ArrayList Called Employee
private ArrayList<Employee> employees = new ArrayList <Employee>();

final String FILENAME = new String("employees.ser");

Path f = Paths.get(FILENAME);

public void add()
{
	Employee employee = new Employee();
	employee.read();
	employees.add(employee);
	
}
public Employee view()
{
	Scanner keyboardin = new Scanner(System.in);
			System.out.print("Enter the employee number");
			int num = keyboardin.nextInt();
			
			for(Employee emp: employees)
			{ 
				if(emp.getNumber()==num)
				{
					System.out.print(num);
					return emp;
					
				}
			}
			return null;
			
}
public void list()
{
	for(Employee emp: employees)
	{
		System.out.println(emp);
		
	}
}
public void edit()
{
	Employee emp = view();
	if(emp !=null)
	{
		int index = employees.indexOf(emp);
		emp.read();
		employees.set(index,  emp);
	}
}
	
	public void delete() {
		// use view() to find and return the employee to delete
		Employee emp = view();
		if (emp != null) // if found
			employees.remove(emp);
	}
	public void saveEmpNumber() {
		if(employees.size() > 0)
		{
			employees.get(employees.size()- 1).saveEmpNumber();
			
		}
	}
 
	public void restoreEmpNumber() {
		if(employees.size() > 0)
		{
			employees.get(employees.size() -1).setEmpNumber();
			
		}
			
	}
public void serializeEmployees(){
	try {
		// Serialize the ArrayList...
		FileOutputStream fileStream = new FileOutputStream(FILENAME);
	
		ObjectOutputStream os = new ObjectOutputStream(fileStream);
			
		os.writeObject(employees);
		saveEmpNumber();
		os.close();
	}
	catch(FileNotFoundException fNFE){
		System.out.println("Cannot create file to store employees.");
	}
	catch(IOException ioE){
		System.out.println(ioE.getMessage());
	}
}

// This method will deserialize the employees ArrayList when called, 
// i.e. it will restore the ArrayList from the file employees.ser
public void deserializeEmployees(){
	try {
		if(Files.exists(f)) {
			// Deserialize the ArrayList...
			FileInputStream fileStream = new FileInputStream(FILENAME);
	
			ObjectInputStream is = new ObjectInputStream(fileStream);
			
			employees = (ArrayList<Employee>)is.readObject();	
			restoreEmpNumber();
			is.close();
		}
	}
	catch(FileNotFoundException fNFE){
		System.out.println("Cannot create file to store Employees.");
	}
	catch(IOException ioE){
		System.out.println(ioE.getMessage());
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
}

}