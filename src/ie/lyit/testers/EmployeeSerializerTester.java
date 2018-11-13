/**
 
 
 * @author Richie Mulhern
 
**/
package ie.lyit.testers;

import ie.lyit.serialize.EmployeeSerializer;
import ie.lyit.flight.Menu;

public class EmployeeSerializerTester {

	public static void main(String[] args) {
		EmployeeSerializer empSerializer = new EmployeeSerializer();

		// Read the ArrayList from the File in books
		// THIS DESERIALIZES THE ARRAYLIST
		empSerializer.deserializeEmployees();
		
	    // Create a Menu Object
		Menu menuObj = new Menu();
		
		do {
			// Call it's display() method
			menuObj.display();
			// Call it's readOption() method
			menuObj.readOption();
	
			// switch on the option and call the appropriate method
			switch(menuObj.getOption()){
			   case 1:empSerializer.add();break;
			   case 2:empSerializer.list();break;
			   case 3:empSerializer.view();break;
			   case 4:empSerializer.edit();break;
			   case 5:empSerializer.delete();break;
			   case 6:break;				
			   default:System.out.println("INVALID OPTION.");
			}
		}while(menuObj.getOption() != 6);
		
		// Write the books ArrayList to File
		// THIS SERIALIZES THE ARRAYLIST		
		empSerializer.serializeEmployees();
	}
}

