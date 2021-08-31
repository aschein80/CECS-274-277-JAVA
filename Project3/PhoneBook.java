
package project3;

/** Simulates a phonebook
 * @author Alex Schein, Bradley Hoang, Dennis Maya, Brian Tran
 * @version 1.0.1
 * @Class Description - This class formats the phone numbers, creates contacts, edits contacts displays favorites, makes calls from contacts, favorites, or the dial pad.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PhoneBook {
	
	private ArrayList<Contact> contacts;
	private ArrayList<callLog> calls;
	private String[] favorites;
	
	/**
	 * creates new array lists for contacts, calls and favorites
	 * creates an array of favorites
	 * favorites empty
	 */
	public PhoneBook() {
		contacts = new ArrayList<Contact>();
		calls = new ArrayList<callLog>();
		favorites = new String[5];
		for (int i = 0; i<5;i++) {
			favorites[i] = "";
		}
	}
	
	
	/**
	 * searches for a contact entered and asks user if they would like to call contact if found 
	 * if contact not found, asks user to enter another name or return to menu
	 */
	public void searchForContact() {
		String input;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a Contact to search for:");
		input = in.nextLine().trim();
		for (Contact element : contacts) {
			if (element.getName().equals(input)) {
				System.out.println(element.toString());
				System.out.println("Call Contact?\n1.Yes\n2.No\n");
				input = in.nextLine().trim();
				if(input.equals("1")) {
					makeCall(element.getName());
					return;
				}
				else if(input.equals("2")) {
					return;
				}
				
			}
		}
		System.out.println("Contact does not exist\n1.Enter another name\n2.Return to menu");
		input = in.nextLine().trim();
		if(input.equals("1")) {
			searchForContact();
		}
		
	}
	
	/**
	 * formats the phone number to include specific characters		
	 * @param number - the phone number of the person
	 * @return num - the phone number formatted
	 */	
	private String formatNumber(String number) {
		String num = "";
		String threeDigits;
		String lastDigits;
		if(number.length() == 10) {
			String areacode = "(" + number.substring(0,3)+") ";
			threeDigits = number.substring(3,6) + "-";
			lastDigits = number.substring(6);
			num = areacode + threeDigits + lastDigits;
		}
		else if(number.length() == 7) {
			threeDigits = number.substring(0,3);
			lastDigits = number.substring(3);
			num = threeDigits + "-" + lastDigits;
		}
		return num;
	}
	
	/**
	 * logs the calls made for contacts
	 * @param callType- string outgoing or incoming call
	 * @param call- contacts name, number, or preset number
	 */
	private void logCall(String callType, String call) {
		String num = "";
		String type = "";
		if((call.length() == 7 || call.length() == 10) && call.matches("\\d+")) {
			type = "Number";
			num = formatNumber(call);
		}
		else if(call.equals("1")|| call.equals("2") || call.equals("3")|| call.equals("4")|| call.equals("5")) {
			if (!favorites[Integer.parseInt(call) - 1].equals("")) {
				type = "Favorite";
				num = favorites[Integer.parseInt(call) - 1];
			}				
			else {
				System.out.println("Favorite Contact does not exist");
				return;
			}
		}
		else {
			boolean found = false;
			for(Contact element : contacts) {
				if(element.getName().equals(call)) {
					type = "Contact";
					num = call;
					found = true;
				}
			}
			if (!found) {
				Scanner in = new Scanner(System.in);
				System.out.println("Contact does not exist\n1.Enter another name\n2.Return to menu");
				String input = in.nextLine().trim();
				if(input.equals("1")) {
					System.out.println("Enter another Contact name: ");
					input = in.nextLine().trim();
					makeCall(input);
					return;
				}
				else {
					return;
				}
			}
		}
		String callLog;
		String now = LocalDateTime.now().toString();
		String year = now.substring(0,4);
		String month = now.substring(5,7);
		String day = now.substring(8,10);
		String date = month +"/"+ day+"/"+year;
		String hour_24 = now.substring(11,13);
		String time;
		String min = now.substring(14,16);
		if(Integer.parseInt(hour_24) > 12) {
			time = Integer.toString(Integer.parseInt(hour_24)-12) +":"+ min +" PM";
		}
		else {
			time = Integer.toString(Integer.parseInt(hour_24)) +":"+ min + " AM";			
		}
		
		if(callType.equals("incoming")) {
			System.out.println("Call Received from " + num);
		}
		else {
			System.out.println("Call Made to " + num);
		}
		for(callLog element : calls) {
			if (element.getNum().equals(num)) {
				element.setDate(date);
				element.setTime(time);
				element.setCallType(callType);
				element.setCount();
				return;
			}
		}
		
		calls.add(new callLog(type,num,date,time,callType));
		
	}
	
	/**
	 * makes a phone call to the outgoing number
	 * @param outgoingNum- the outgoing call as a string
	 */	
	public void makeCall(String outgoingNum) {
		String callType = "outgoing";
		logCall(callType, outgoingNum);
		
	}
	
	/**
	 * receives the phone call made
	 * @param incomingNum- the number that tried to contact the phone
	 */
	public void receiveCall(String incomingNum) {
		String callType = "incoming";
		logCall(callType, incomingNum);
	}
	
	/**
	 * displays the sorted contacts in the Arraylist
	 */
	public void displayContacts() {
		Collections.sort(contacts);
		
	  	int i = 1;
			for (Contact element: contacts) {
				System.out.println(i + ": "+ element.toString());
				i++;
			}
		}
	
	/**
	 * allows a selected contact to be deleted and removed
	 * the selected contact is removed from the arraylist
	 */
	public void deleteContact() {
		displayContacts();
		System.out.println("Select which contact you would like to delete.");
		Scanner in = new Scanner(System.in);
		int Select;
		Select = Integer.parseInt(in.nextLine().trim());
		contacts.remove(Select - 1);
	}
	
	/**
	 * selects a contact and edits information regarding the contact (name, number, email, notes)
	 */
	public void editContact(){
		displayContacts();
    	System.out.println("Select the contact to edit.");
    	Scanner in = new Scanner(System.in);
		int Select;
		Select = Integer.parseInt(in.nextLine().trim());
		int option;
		do{
			System.out.println("What would you like to edit?: \n1.Name\n2.Number\n3.Email\n4.Notes\n5.Terminate");
			option = Integer.parseInt(in.nextLine().trim());
			
			if (option == 1){
				System.out.println("Enter the new name for this contact");
				String name = in.nextLine().trim();
				(contacts.get(Select-1)).setName(name);
			}
			if (option == 2){
				System.out.println("Enter the new number for this contact");
				String number = in.nextLine().trim();
				(contacts.get(Select-1)).setNumber(number);
			}
			if (option == 3){
				System.out.println("Enter the new email for this contact");
				String email = in.nextLine().trim();
				(contacts.get(Select-1)).setEmail(email);
			}
			if (option == 4){
				System.out.println("Enter the new notes for this contact");
				String Notes = in.nextLine().trim();
				(contacts.get(Select-1)).setNotes(Notes);
			}
		}while(option != 5);
	}
	
	/**
	 * displays the favorites from the array
	 */
	public void displayFavorites() {
	  	int i = 1;
			for (String element: favorites) {
				System.out.println(i + ": "+ element.toString());
				i++;
			}
	}

	/**
	 * displays the contacts and allows chosen contacts to be set to a favorite
	 */
	public void setFavorites() {
		displayContacts();
		String favorite;
		Scanner input = new Scanner(System.in);
		System.out.println("Which contact do you want to set as a favorite?");
		favorite = contacts.get(Integer.parseInt(input.nextLine()) - 1).getName();
		
		System.out.println("Which number do you want to set your favorite to?(1-5)");
		int select = Integer.parseInt(input.nextLine()) - 1;
		
		favorites[select] = favorite;
	}
	
	/**
	 * displays all the contacts in favorites
	 * selects a favorite contact and deletes it from the phonebook (array favorites)
	 */
	public void deleteFavorite() {
		displayFavorites();
		System.out.println("Select which favorite you would like to delete.");
		Scanner in = new Scanner(System.in);
		int Select;
		Select = Integer.parseInt(in.nextLine().trim()) - 1;
		favorites[Select] = "";
	}
	
	
	/**
	 * displays the elements in the array favorites and rearranges the selection chosen
	 */
	public void arrangeFavorites() {
		String placeHolder;
		displayFavorites();
		System.out.println("Which favorite contact do you want to rearrange?");
		Scanner in = new Scanner(System.in);
		int input = Integer.parseInt(in.nextLine()) - 1;
		System.out.println("Which number do you want to set this favorite to?(1-5)");
		int favorite = Integer.parseInt(in.nextLine()) - 1;
		placeHolder = favorites[favorite];
		favorites[favorite] = favorites[input];
		favorites[input] = placeHolder;
				
		
	}
	
	/**
	 * creates a new contact with user input for name, number, email and notes
	 */
	public void createContact() {
		Scanner input = new Scanner(System.in);
		
		String name = "";
		String number = "";
		String email= "";
		String notes= "";
		
		System.out.println("Enter contact name:");
		name = input.nextLine().trim();
		System.out.println("Enter your contacts number:");
		number = formatNumber(input.nextLine().trim());
		System.out.println("Enter your contacts email: ");
		email = input.nextLine().trim();
		System.out.println("Enter any notes for your contact:");
		notes = input.nextLine().trim();
		contacts.add(new Contact(name, number,email,notes));
	}
	
	/**
	 * displays the full log of phone calls for a name or number if found
	 */
	public void displayFullLog() {
		
		for (callLog element : calls) {
			if (element.getCount() > 1) {
				System.out.println(element.toString());
			}
		}

		System.out.println("Which one of these logs do you want to see a full log for?(Enter name or number)");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine().trim();
		
		if (input.matches("\\d+")) {
			input = formatNumber(input);
		}
		
		for (callLog element : calls) {
			if (element.getNum().equals(input)) {
				for (int j = 0; j < element.getCount(); j++) {
					System.out.printf("\n%s: %s\tDate:\t%s\tTime: %s\tType: %s\n",element.getType(),element.getNum(),element.getDate(j),element.getTime(j),element.getCallType(j));
				}
			}
		}
		
	}
	
	/**
	 * formats and displays the phone calls from the arrayList
	 */
	public void displayCalls() {
		System.out.println(String.format("-------------------------Call History------------------------\n"));
		
		for (int i = 0; i < calls.size();i++) {
			System.out.println((i + 1) + ": " + calls.get(i) + "\n");
		}
		
		
	}
	
	/**
	 * asks for a favorite to display and presents the information associated with the person (name, number, email , notes, image)
	 */
	public void favoriteDisplay() throws FileNotFoundException {
		displayFavorites();
		System.out.println("Select which favorite you would like to display");
		Scanner in = new Scanner(System.in);
		int Select;
		Select = Integer.parseInt(in.nextLine().trim());
		String name = "";
		String number = "";
		String email= "";
		String notes= "";
		for(Contact element: contacts) {
			if(favorites[Select - 1].equals(element.getName())) {
				number = element.getNumber();
				name = element.getName();
				email = element.getEmail();
				notes = element.getNotes();
				int fWidth = 1024;
				int fHeight = 768;
				String path = "C:\\Users\\Nayu\\Desktop\\Contact Photos\\"+ name +".JPG";
				
				File f = new File(path);
				if(f.exists() && !f.isDirectory()) { 
					FavoriteContactFrame Fave = new FavoriteContactFrame(path , fWidth, fHeight, name, number, email, notes);
					Fave.displayContactFrame();
				}
				else {
					path = "C:\\Users\\Nayu\\Desktop\\Contact Photos\\nopic.JPG";
					FavoriteContactFrame Fave = new FavoriteContactFrame(path , fWidth, fHeight, name, number, email, notes);
					Fave.displayContactFrame();
				}
			}
		}
	}
	
}