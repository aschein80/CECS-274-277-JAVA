package demos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherWriteDemo {
	public static void main(String[] args) throws FileNotFoundException {
		
		//GOAL: To write a text file from tollfree.txt that contains only
		//company names and associated phone numbers
		
		//STEP 1: Create the File and Scanner objects 
		
		File fileIN = new File("C:\\Users\\Evangelion\\Documents\\CECS 274\\Text Files\\tollfreee.txt");
		
		Scanner fileReader = new Scanner(fileIN);
		String currentLine;
		
		//STEP 2: Create Pattern object
		String regex = "([\\w | \\s]+)\\s[.]+\\s([\\d|-]+)";
		Pattern p = Pattern.compile(regex);
		Matcher m;
		
		//STEP 3: Create a PrintWriter object
		PrintWriter fileOUT = new PrintWriter("C:\\Users\\Evangelion\\Documents\\CECS 274\\Text Files\\tollfreeeUpdated.txt");
		
		//STEP 4: Try to match each line to the pattern
		while(fileReader.hasNextLine()) {
			currentLine = fileReader.nextLine();
			m = p.matcher(currentLine);
			
			if (m.find()) { //STEP 5: If the line matches, write to the new file 
				//the company name and the telephone num
				fileOUT.println("Company Name: " + m.group(1) + "   Ph: " + m.group(2));
								
			}			
		}
		
		//STEP 6: Close everything
		fileReader.close();
		fileOUT.close();
	}
}
