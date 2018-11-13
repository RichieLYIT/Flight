/**
 
 
 * @author Richie Mulhern
 
**/
package ie.lyit.flight;

import java.util.Scanner;
import java.io.Serializable;


public class Menu implements Serializable {

	//variables
	private int option;
	   //display method
	   public void display(){
	     System.out.println("\t1. Add");
		 System.out.println("\t2. List");
		 System.out.println("\t3. View");
		 System.out.println("\t4. Edit");
		 System.out.println("\t5. Delete");
		 System.out.println("\t6. Quit");		
	   }
	 //readOption method-  read the option selected by the user
	   public void readOption(){
	      Scanner keyboardin  = new Scanner(System.in);
	  	  System.out.println("\n\tEnter Option [1|2|3|4|5|6]");
	   	  option=keyboardin.nextInt();
	   }
	   //getOption method-  get the option selected by the user		
		public int getOption(){
		   return option;
		}	
	}

