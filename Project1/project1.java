package Project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class project1 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(System.in); 
		
		int productcount; //not used
		productcount = 0; //not used
		
	//REQUIREMENT 1
			
		//requesting for the text file name they wish to give
		
		System.out.println("Please enter the name of the .txt file\n"); //prompting input
		String textfilename = in.nextLine().trim(); //returns the input to textfilename and removes any whitespaces
		PrintWriter fileOUT = new PrintWriter("C:\\Users\\Evangelion\\Documents\\CECS 274\\Text Files\\" + textfilename + ".txt");
		
		//String pathway = ("C:\\Users\\Evangelion\\Documents\\CECS 274\\Text Files\\" + textfilename + ".txt");
		//File fileIN = new File (pathway); //creating the new .txt file using pathway 
		//Scanner fileReader = new Scanner(fileIN);
		//PrintWriter fileOUT = new PrintWriter(pathway); //closing the printwriter
		//File fileIN = new File ("C:\\Users\\Evangelion\\Documents\\CECS 274\\Text Files\\PriceList.txt");
		
		//imported the PriceList.txt (ACTIVE EARLIER)
		//	Scanner fileReader = new Scanner(fileIN); 
		//(ACTIVE EARLIER)
		
		
		//REQUIREMENT 2 continuously ask the user to enter the name and size of the product until "Done"
		
		ArrayList<String> products = new ArrayList<String>();		//arraylist products (product added to this)
		
		String product = ""; //initializing string product to ""
		//int i =0;
		
		//REQUIREMENT 3: String Regex Pattern Matching to the PriceList.txt file
		
		String regex = "(.+)\\s(\\d.+)\\s([\\d|.]+)"; //string regex pattern to create groups
		
		Pattern p = Pattern.compile(regex); //creating the pattern object
		System.out.println("\"Please enter the name and weight/size of the product: (Enter 'Done' to end.)\n");  //asking for product + description
		
		String userInput; //declaring userInput for the product entered
		
		do {     //using do while loop to test for "Done" and receive user input for text file
			File fileIN = new File("C:\\Users\\Evangelion\\Documents\\CECS 274\\Text Files\\PriceList.txt");
			Scanner fileReader = new Scanner(fileIN); //accessing PriceList.txt
			
			
			String currentLine = fileReader.nextLine().replaceAll("[\\s]{2,}", " ");  //removing whitespaces
			
			System.out.println("Please enter the name and weight/size of the product: "); //prompting for name and weight
			
			userInput= in.nextLine(); 
			System.out.println(""); //printing empty line
			
			while(fileReader.hasNextLine() && !userInput.equals("Done")) { //checking if user input != done
				Matcher m = p.matcher(currentLine);  
				if(m.find()) { 
					if (userInput.equals(m.group(1).trim() + " " + m.group(2).trim())){
						System.out.println();
						products.add(m.group(1) + " " + m.group(2) + " " + m.group(3));
						
					}
				}
				currentLine = fileReader.nextLine().replaceAll("[\\s]{2,}",  " ");
				
			}
			
		}while(!userInput.equals("Done"));
		
		Collections.sort(products); //sorting the products in the array list products
		double total = 0; 			//initializing double total = 0
		Matcher m = null;			//setting Matcher m
		int i;						//initializing int i, used in for loop
		
		for (i = 0; i < products.size(); i++) {       //using for loop to match products to PriceList.txt
			System.out.println(products.get(i));		
			m=p.matcher(products.get(i).trim());		
			
			if (m.find()) {
				total += Double.parseDouble(m.group(3).trim());
				
			}
			
		}
		System.out.println(products);			//testing - printing to console
		
		System.out.printf("%.2f",  total);
		
		fileOUT.println("Alex's Store");					//printing out the heading
		fileOUT.println("950 Tomate Dr.");
		fileOUT.println("PizzaTown, NY 55555");
		
		fileOUT.println("");							//spacing two lines
		fileOUT.println("");
		
		fileOUT.println("Item" + "\t\t\t\t\t" + "Subtotal"); 				//heading for Item and sub-total
		fileOUT.println("");
		
		for (i = 0; i < products.size(); i++) {					//for loop to go through the products and match to the PriceList.txt
			m = p.matcher(products.get(i));						//matching products
			if (m.find()) {										
				fileOUT.println(m.group(1) + "\t\t\t\t" + m.group(3));			//items printed out if found 
				
			}
		}
		
		fileOUT.println(); //printing the 2 newlines
		fileOUT.println();
		
		fileOUT.printf("Total \t %.2f", total );
		fileOUT.close();      //close everything
		
		
	}
}
		//REQUIREMENT 3: Program searches the file "PriceList.txt" for the prices of items entered
		//need to use the regex from PatternMatcherDemo
		//compares the items entered in the arrayList [products] and [sizes]
		//once the item is matched using the regex, the system will select the appropriate price. 

		//Requirement 4
			//format out item-left; subtotal-right
			//in text file

		//Requirement 5
			//if item count  (prodcuts) > 1:
				//prints quantity with "@"
				//list price per 1 item to the left of subtotal
				//total at the end after 2 blank liness
		
		
		
