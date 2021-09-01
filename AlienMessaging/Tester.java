package Project3;

import java.io.FileNotFoundException;

/**
 * Tester class for the program
 * @author Brian Tran, Alexandre Schein
 * October 26 2018
 */
public class Tester {
	public static void main(String[] args) {

		 //Create two earth cell phones
		EarthTexter eText = new EarthTexter();
		EarthTexter eText2 = new EarthTexter();

		try {
		 //sending a message with missing file
		       eText.sendMessage("Earth", "C:\\Users\\Brohunder1\\Desktop\\text\\text.txt");
		 //sending message
		       eText.sendMessage("Earth", "C:\\Users\\Brohunder1\\Desktop\\text\\text1.txt");
		 //reading message sent by e1
		       eText2.readMessage("C:\\Users\\Brohunder1\\Desktop\\text\\text1.txt");
		 //Earth1 sends a message to Klingon
		       EarthCellPhone e = new UniversalTranslator(new KlingonTexter());
		       e.sendMessage("Klingon", "C:\\Users\\Brohunder1\\Desktop\\text\\EarthToKlingon.txt");
		 //Before Klingon can read the message
		 //it needs to go to the universal translator
		 //for translation from earth to klingon
		       UniversalTranslator ut = new UniversalTranslator(new KlingonTexter());
		 //create a new cellphone from the universal
		 //translator to read the Klingon message
		       EarthCellPhone eText3 = ut;
		       eText3.readMessage("C:\\Users\\Brohunder1\\Desktop\\text\\EarthToKlingon.txt");
		 //Earth1 sends a message to Vulcan
		       eText.sendMessage("Vulcan", "C:\\Users\\Brohunder1\\Desktop\\text\\EarthToVulcan.txt");
		 //Before Vulcan can read the message
		 //it needs to go to the universal translator
		 //for translation from earth to vulcan
		       ut = new UniversalTranslator(new VulcanTexter());
		 //Read the Vulcan message
		       eText3 = ut;
		       eText3.readMessage("C:\\\\Users\\\\Brohunder1\\\\Desktop\\\\text\\\\EarthToVulcan.txt");
		 //Send a message to an unsupported language
		       eText.sendMessage("non-fed", "non-fed.txt");
		    } catch (InvalidLanguageException o)
		    {System.out.println(o.getMessage());}
		 }
}
