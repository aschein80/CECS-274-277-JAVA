package Project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class for the Earth language to send messages in English and read
 * @author Brian Tran, Alexandre Schein
 * October 26, 2018
 * inputs: language type and name of file(s)
 * outputs: none
 */
public class EarthTexter extends UniversalTranslator {
	EarthTexter(){
		
	}

	/**
	 * Allows a message from Earth to be sent in a file 
	 * @param languageType- the language of the message being sent
	 * @param fileName- name of the file to be sent to
	 * @return none
	 */
	@Override
	public void sendMessage(String languageType, String fileName) throws InvalidLanguageException {
		Scanner text;		//declaring variables
		String str = "";
		File inFile = new File(fileName);
		
		try {		//try catch block to write to file
			PrintWriter message = new PrintWriter(new File("SentEarthText.txt"));
			text = new Scanner(inFile);
			while(text.hasNextLine()) {
				str += text.nextLine() + " ";	//adding to string - message
			}
			message.println(str);
			message.close();
			System.out.println("Message sent from Earth Phone: " + str);		//confirming message sent from Earth
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " does not exist.");	//if file doesnt exist
		}
	}

	/**
	 * Reads a message from an Earth language
	 * @param filename- the name of the file to be read from 
	 * @return none
	 */
	@Override
    public void readMessage(String fileName)
    {

        try (Scanner fin = new Scanner(new File(fileName)))	//scanner reading file
        {
            System.out.print("New Message: ");	
            while(fin.hasNextLine())
            {
                String line = fin.nextLine();
                System.out.println(line); //displaying message from file
            }
        }
        catch(IOException exception)
        {
            System.out.println("Could not find file " + fileName);		//cant find the file
        }

    }

}
