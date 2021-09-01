package Project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class translates messages to and from the alien Klingon language.
 * @author Brian Tran, Alexandre Schein
 * October 26, 2018
 * @inputs - file to be translated
 * @output - converted message string
 */
public class KlingonTexter implements AlienCellPhone{
	String file;			//initializing file 
	Scanner translator;		//scanner named translator
	KlingonTexter(){
		this.file = "C:\\Users\\Brohunder1\\Desktop\\text\\Klingon.txt";		//pathway to open file
	}

	/**
	 * Sends a message of klingon language
	 * @param fileName - the name of the file containing alien message
	 * @return none
	 */
	@Override
	public void alienSendText(String fileName) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Reads in text from file containing klingon
	 * @param fileName - name of the file containing message to be read
	 * @return - none
	 */
	@Override
	public void alienReadText(String fileName) {
		// TODO Auto-generated method stub
	}

	/**
	 * Translates the text in the inputted file
	 * @param fileName - name of the file to be translated
	 * @return string properly translated from the message
	 */
	@Override
	public String translateText(String fileName) {
		
		String str = "";	//empty string
		String word;			//Initializing
		String line;
		boolean found;		//boolean for finding filen
		
		try {			//beginning of try-catch block to read and write file
			Scanner text = new Scanner(new File(fileName));
			while(text.hasNextLine()) {
				word = text.nextLine().trim();
				found = false;
				translator = new Scanner(new File(file));
				while(!found && translator.hasNextLine()) {		//testing if file is found and another line of input of scanner
					line = translator.nextLine().trim();
					if (word.equals(line.substring(0, word.length()))) {
						str += line.substring(word.length()+1) + " ";		//adding to string
						found = true;
						translator.close();
					}
				}
			}
			
		} catch (FileNotFoundException e) {			//catch block
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;		//returning the translated string
	}

}
