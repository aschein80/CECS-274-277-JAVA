package demos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReaderDemo {
	
	public static void main(String[] args) throws FileNotFoundException {
		//STEP 1: Create the file object with the location + name of the text file
		File fileIN = new File("C:\\Users\\Evangelion\\Documents\\CECS 274\\Text Files\\textdemo.txt");
		
		//STEP 1: Create the Scanner Object, passing in the file object to the scanner
		Scanner fileReader = new Scanner(fileIN);
		
		//STEP 3: Process the file
		while (fileReader.hasNextLine()) {
			System.out.println(fileReader.nextLine());
		}
		
		//STEP 4: Close the reader
		fileReader.close();
	}
	

}
