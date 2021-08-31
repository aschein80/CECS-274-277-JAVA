package demos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriterDemo2 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//STEP 1: Read the file using a scanner
		File fileIN= new File ("C:\\Users\\Evangelion\\Documents\\CECS 274\\Text Files\\test.txt");
		
		Scanner fileReader = new Scanner(fileIN);
		String contents = "";
		while (fileReader.hasNextLine()) {
			contents += String.format("%s%n", fileReader.nextLine());
		}
		
		PrintWriter fileOUT = new PrintWriter("C:\\Users\\Evangelion\\Documents\\CECS 274\\Text Files\\test.txt");
		
		fileOUT.println(contents);
		
		for (int i =11; i <= 20; i++) {
			fileOUT.printf("%d. EMPTY%n", i);
		}
		//STEP 3: CLosse reader and writer
			fileOUT.close();

			fileReader.close();
					
			
	}

}
