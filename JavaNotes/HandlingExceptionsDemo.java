package Demos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HandlingExceptionsDemo {
	
	public static void printText(String filePath) throws FileNotFoundException {
		
		Scanner reader = new Scanner(new File(filePath));
		
		while (reader.hasNextLine()) {
			System.out.println(reader.nextLine());
		}
	}
	
	public static void main(String[] args) {
		
		System.out.print("Enter the path and name of the file: ");
		Scanner in = new Scanner(System.in);
		
		String path = in.nextLine();
		boolean fileFound = false;
		do {
			try {
				printText(path);
				fileFound = true;
				
			} catch (FileNotFoundException exception) {
				System.out.println("File not found! Please try again: ");
				path = in.nextLine();
			}
			
	}while(!fileFound);

}
}