package demos;

import java.util.ArrayList;

/**
 * @author Alexandre Schein
 * August 30, 2018
 * This program prints out the contents of an arraylist called names. The arraylist is modified and printed out with its changes. 
 * The size of the arraylist is also printed and modified. 
 * Inputs: none
 * Outputs: String names and size of the arraylist
 */
public class ArrayListRunner {
	
	public static void main (String [] args) {	//main method 
		
		ArrayList<String> names = new ArrayList<String>();	//declaring arraylist names
		System.out.println(names);			//printing out the names
	
		//A) Invoking add to add and print names
		names.add("Alice");
		names.add("Bob");
		names.add("Connie");
		names.add("David");
		names.add("Edward");
		names.add("Fran");
		names.add("Gomez");
		names.add("Harry");
		System.out.println(names);		//all names in arraylist printed
		
		// B) Using get to retrieve and print first and last name;
		System.out.println(names.get(0));
		System.out.println(names.get(names.size() - 1));		//last name retrieved
		
		//C) Printing the size of the arraylist
		System.out.println(names.size());			
		
		//D) Using size to print the last name
		System.out.println(names.get(names.size() -1 ));	
		
		//E Use set to change Alice to Alice B. Toklas;
		names.set(0, "Alice B. Toklas");
		System.out.println(names);
		
		//F) Using alternate form of add to insert Doug after David
		names.add(4, "Doug");
		
		//G) using enhanced for loop to print each name in arraylist
		for (String name: names) {				//enhanced for loop
			System.out.println(name);			//outputting elements in arraylist
		}
			
		//H) Second ArrayList Names2
		ArrayList names2 = new ArrayList(names);		//new arraylist with names elements as parameter
		System.out.println(names2);					//printing out arraylist
		
		//I) Call names.remove(0)to remove the first element. print names and names2. 
		names.remove(0);
		System.out.println(names);				//printing out names
		System.out.println(names2);				//printing names 2
		
		
			
			
		}
		
		
		
		
	}


