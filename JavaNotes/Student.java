package demos;

import java.util.ArrayList;


/**
 * 
 * This is called a Javadoc comment
 * Student class creates student objects with a name, ID #, and list of courses
 *
 */

public class Student {
		//This is the encapsulated attribute data
		private String name; 
		private String ID;
		private ArrayList<String> courses;
	
		/**
		 * constructs a new student object with default values
		 * "N/A" for the name, "000" for the ID, and empty list
		 * of courses
		 */
		public Student() {
			name = "N/A";
			ID = "000";
			courses = new ArrayList<String>(); //EMPTY
		}
		
		/**
		 * Sets the name of the student
		 * @param newName - this is a string containing the new Name 
		 ***/
		public void setName(String newName) {
			name = newName;
		}
		
		/**
		 * sets the ID of the student
		 * @param newID - this is the ID of the student, as a string
		 ***/
		public void setID(String newID) {
			ID = newID;
			
		}
		
		/**
		 * adds a new course to the list of courses
		 * @param course - a string representing the name of the course 
		 */
		public void addCourse(String course) {
			courses.add(course);
			
		}
		
		/**
		 * gets the name of the student
		 * @return a string representation of the student name
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * gets the ID of this student
		 * @return the ID as a string
		 */
		public String getID() {
			return ID;
		}
		
		/**
		 * Prints the list of courses currently associated with this student
		 */
		public void printCourses() {
			int i = 1;
			for (String c : courses) {
				System.out.printf("%d. %s%n", i,c);
				i++;
				
			}
		}
}
