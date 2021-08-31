package demos;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriterDemo {
	public static void main(String[] args) throws FileNotFoundException {
		
		//STEP 1: Create a PrintWriter object
		PrintWriter fileOUT = new PrintWriter("C:\\Users\\Evangelion\\Documents\\CECS 274\\Text Files\\test.txt");
		
		//STEP 2: Use the object to write the information into the textfile
		for (int i= 1; i<=10; i++) {
			
			fileOUT.printf("%d. Empty%n", i);
			
		}
		
		//STEP 3 : Close the writer
		fileOUT.close();
		
	}
	
	
	

}
