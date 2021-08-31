package demos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Phonebookdemo {
	
	
	/*
	 * TASK: Write a program that behaves like a phonebook, with menu options 
	 * to add a new Contact, edit an existing one, delete a contact, display all the contacts, 
	 * or exit the program. The program should initially ask the user to store as many contacts
	 * as desired, stopping when the user enters "DONE" 
	 */
	
	public static void main(String[] args) {
		
		ArrayList<String> contacts = new ArrayList<String>(); //this is to store the input
		System.out.println("Welcome to your phone book! Please enter as many contacts when desired. Type \"DONE\" when finished.");
		Scanner in = new Scanner (System.in);
		String response;
		do {
			response = in.nextLine().trim();
			if (!response.equals("DONE")) {//if the use didn't not enter "DONE" then store it
				contacts.add(response); 
			}
		}while (!response.equals("DONE"));
		
		String menu = "1. Add a new contact.\n2. Edit an existing contact. \n3. Delete a contact.\n4. Display all contacts. \n5. Exit";
	
		int selection;
		do {
			System.out.println("What would you like to do now? \n" + menu);
			selection = Integer.parseInt(in.nextLine().trim());
			if (selection == 1) {
				System.out.println("Enter the new name and number: ");
				contacts.add(in.nextLine().trim()); //prompting for the name/num and storing it
			}
			else if (selection == 2) {
				System.out.println("Edit an existing contact: ");
				Collections.sort(contacts);//sorting the list in alphabetical order
				int i = 1;
				for(String c: contacts) {
					System.out.printf("%d. %s\n", i, c);
					i++;
				}
				System.out.println("Which contact would you like to replace? \n ");
				int replacement = Integer.parseInt(in.nextLine().trim());
				//String replacement = in.nextLine().trim();
				System.out.println("Please print the edit\n ");
				String edit = in.nextLine().trim();
				contacts.set(replacement - 1, edit);
				
				}
				 
			else if (selection == 3) {
				System.out.println("Delete a contact\n ");
				Collections.sort(contacts);//sorting the list in alphabetical order
				int i = 1;
				for(String c: contacts) {
					System.out.printf("%d. %s\n", i, c);
					i++;
				}
				System.out.println("Please enter the complete contact to be removed \n ");
				String choice  = in.nextLine().trim();
				contacts.remove(choice);
				
				
				
			}
			
			
			else if (selection ==4) {
				Collections.sort(contacts);//sorting the list in alphabetical order
				int i = 1;
				for(String c: contacts) {
					System.out.printf("%d. %s\n", i, c);
					i++;
				}
			}
			
			
			else if (selection == 5) {
				System.out.println("Goodbye!");
			}
			
			else {
				System.out.println("ERROR: Invalid selection. Please try again.");
				
			}
			
			
		}while(selection != 5);
				
		
	}
	
	
	
	
	
	
	
}
