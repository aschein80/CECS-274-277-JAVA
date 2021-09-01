package Project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * THi class translates between all the languages- its a "universal translator"
 * @author Brian Tran
 * @author Alexandre Schein
 * @since October 26, 2018
 * @version 1.0.1
 * @inputs- language and message
 * @output- translated message
 */
public class UniversalTranslator implements EarthCellPhone  {
	ArrayList<String> languages;	//arraylist of the languages
	AlienCellPhone phone;			//AlienCellPhone object -phone
	
	/**
	 * Constructor to add languages to arraylist
	 */
	UniversalTranslator(){
		languages = new ArrayList<String>();	//adding languages to the arraylist
		languages.add("Vulcan");
		languages.add("Klingon");
		languages.add("Earth");
	}
	
	/**
	 * overloaded constructor to add vulcan language to universal translator
	 * @param language- the language to be added
	 */
	UniversalTranslator(VulcanTexter language){
		languages = new ArrayList<String>();
		languages.add("Vulcan");
		languages.add("Klingon");
		languages.add("Earth");
		
		phone = new VulcanTexter();				//VulcanTexter object created
	}
	
	/**
	 * overloaded constructor to add klingon to universal translator
	 * @param language - klingon language added to universal translator, new KlingonText object created
	 */
	UniversalTranslator(KlingonTexter language){
		languages = new ArrayList<String>();
		languages.add("Vulcan");
		languages.add("Klingon");
		languages.add("Earth");
		
		phone = new KlingonTexter();			//KlingonTexter object created
	}
	
	/**
	 * Sends a message to a file given a specified language
	 * @param languageType - The specified language to be translated to/from
	 * @param fileName - 
	 * @throws InvalidLanguageException - 
	 */
	@Override
	public void sendMessage(String languageType, String fileName) throws InvalidLanguageException {
		try {
			String text = "";
			if (!languages.contains(languageType)) {		//testing whether the language exists
				throw new InvalidLanguageException(languageType + " is not a supported language");
			}
			else{
				if (languages.get(0).equals(languageType)) { //going through arraylist to identify language
					phone = new VulcanTexter();
					PrintWriter msg = new PrintWriter(new File("C:\\Users\\Brohunder1\\Desktop\\text\\SentVulcanText.txt")); //pathway
					text = phone.translateText(fileName);   			
					System.out.println("Translated Message to Vulcan: " + text);	//displays the translated text 
					msg.println(text);			
					msg.close();				//closing printwriter
					System.out.println("Earth to Vulcan message sent");			//confirming message sent
				}
				
				else if(languages.get(1).equals(languageType)) {		//if language is Klingon
					phone = new KlingonTexter();
					PrintWriter msg = new PrintWriter(new File("C:\\Users\\Brohunder1\\Desktop\\text\\SentKlingonText.txt"));
					text = phone.translateText(fileName);
					System.out.println("Translated Message to Klingon: " + text);
					msg.println(text);
					msg.close();
					System.out.println("Earth to Klingon message sent");
				}
				
				else if(languages.get(2).equals(languageType)) {		//if language is Earth
					PrintWriter msg = new PrintWriter(new File("C:\\Users\\Brohunder1\\Desktop\\text\\SentEarthText.txt"));
					Scanner in = new Scanner(new File(fileName));
					while(in.hasNextLine()) {
						text+= in.nextLine().trim() + " ";
					}
					System.out.println("Earth Message: " + text);
					msg.println(text);
					msg.close();
					System.out.println("Earth to Earth message sent");
				}
				

			}
		} catch (FileNotFoundException e) { 
			System.out.println("File: " + fileName + " does not exist");	//file doesnt exist
			e.printStackTrace();
		}
		
	}

	/**
	 * Reads a message from a file
	 * @param fileName - file containing the message to be read 
	 */
	@Override
	public void readMessage(String fileName) {
		Scanner msg;
		String text = "";
		try {
			if(phone instanceof VulcanTexter) {
				text = phone.translateText(fileName);
			}
			else if(phone instanceof KlingonTexter) {
				text = phone.translateText(fileName);
			}
			else {
				msg = new Scanner(new File(fileName));
				while(msg.hasNextLine()) {
					text += msg.nextLine() + " ";
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println();
			e.printStackTrace();
		}
		System.out.println("Message Reads: " + text);
	}

}
