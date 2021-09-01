package Project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class models the Vulcan language and allows alien messages to be read and sent
 * October, 26, 2018
 * @author Brian Tran, Alexandre Schein
 * @inputs - none
 * @output - none
 */
public class VulcanTexter implements AlienCellPhone{
	
	String file;		//Initializing string
	Scanner translator;	//scanner named translator
	VulcanTexter(){
		this.file = "C:\\Users\\Brohunder1\\Desktop\\text\\Vulcan.txt";		//pathway
	}
	
	/**
	 * This method sends a message in the alien language
	 * @param fileName - the name of the file to be interpreted
	 * @return - the message send/recieved and translated via Vulcan language
	 */
	@Override
	public void alienSendText(String fileName) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * This method reads a file of alien text
	 * @param fileName- name of the file to be read
	 * @return none
	 */
	@Override
	public void alienReadText(String fileName) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * THis method translates the text from the file
	 * @param fileName - name of the file with message to be translated
	 * @return- string of the translated message
	 */
	@Override
	public String translateText(String fileName) {
		String str = "";			//initializing variables
		String word;
		String line;
		boolean found;		//boolean to find the file
		try {
			Scanner text = new Scanner(new File(fileName));
			
			while(text.hasNextLine()) {
				word = text.nextLine().trim();
				found = false;
				
				translator = new Scanner(new File(file));
				while(!found && translator.hasNextLine()) {	//when found 
					line = translator.nextLine().trim();
					if (word.equals(line.substring(0, word.length()))) {		
						
						str += line.substring(word.length()+1) + " ";	//adding to the string
						found = true;
						translator.close(); 		//closing the scanner
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;		//returning the message
	}

}
