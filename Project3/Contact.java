
package project3;

/**
 * @author Alex Schein, Bradley Hoang, Dennis Maya, Brian Tran
 * @version 1.0.1
 * @Class Description - This class creates a contact object, and sets and gets contact information.
 */


public class Contact implements Comparable{
		private String name; 	//name of contact
		private String number;	//number of contact
		private String email;	//email of contact
		private String notes;	//notes of contact
		
		/**
		 * Creates an instance of the contact object with default values
		 */
		public Contact() {
			this.name = "N/A";
			this.number = "(XXX)XXX-XXXX";
			this.email = "N/A";
			this.notes = "N/A";
			
		}
		
		/**
		 * 
		 * @param name - A name given for the contact as a string
		 * @param number - The contacts phone number as a string
		 */
		public Contact(String name,String number,String email,String notes) {
			this.name = name;
			this.number = number;
			this.email = email;
			this.notes = notes;
			
		}
		
		/**
		 * @param name- the name of the person associated with the contact/number
		 * sets the name of the contact
		 */
		public void setName(String name) {
			this.name = name;
		}
		
		/**
		 * @param number - the number of the contact
		 * sets the number of the contact
		 */
		public void setNumber(String number) { 
			this.number = number;
		}
		
		/**
		 * @param email - the email of contact
		 * set the email of the contact
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		
		/**
		 * @param notes- any notes of the contact
		 * sets the notes of the contact
		 */
		public void setNotes(String notes) {
			this.notes = notes;
		}
		
		/**
		 * @return the name of the contact
		 * gets the name of the contact
		 */
		public String getName() {
			return this.name;
		}
		
		/**
		 * gets the number associated with the contact
		 * @return number- number of the contact
		 */
		public String getNumber() {
			return this.number;
		}
		
		/**
		 * @return the email of the contact
		 * gets the email of the contact
		 */
		public String getEmail() {
			return this.email;
		}
		
		/**
		 * @return the notes of the contact
		 * gets the notes of the contact
		 */
		public String getNotes() {
			return this.notes;
		}
		
		/**
		 * compares contacts to sort alphabetically
		 */
		public int compareTo(Object o) {
			Contact other = (Contact) o;
			
			return name.compareTo(other.name);
		}
		
		/**
		 * formats the name, number, email, and notes of the contact
		 */
		public String toString() {
			String str = "";
			
			str = String.format("Name: %s\n\tNumber: %s\n\tEmail: %s\n\tNotes: %s", this.name,this.number, this.email,this.notes);
			
			return str;
		}
		
		

	}
