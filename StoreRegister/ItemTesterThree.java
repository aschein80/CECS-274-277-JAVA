package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Alexandre Schein
 * @since 2-22-2018
 * @version 0.0.1
 *
 */

public class ItemTesterThree {
	
	/**
	 * declares a boolean, initializes double sum = 0, gets text file name
	 * create empty arrayList to store items
	 * Prompts for name and description of the item
	 * do-while loop to prompt for name and weight using boolean value
	 */
	public static void main(String[] args) throws FileNotFoundException {				//FileNotFoundException
		
		boolean test;			//boolean to be used to test program
		double sum = 0;        //setting the total cost of the items = 0;
        
        ArrayList<Item> products = new ArrayList<Item>();			//Creating empty ArrayList of the class Item
        Scanner in = new Scanner(System.in);						//Scanner In
        
        System.out.println("Please enter a name for the .txt file: ");
        String userInput = in.nextLine();
        
        PrintWriter fileOUT = new PrintWriter("C:\\Users\\Evangelion\\Documents\\CECS 274\\Text Files\\" + userInput + ".txt"); 
        System.out.println("\"Please enter the name and weight/size of the product: (Enter 'Done' to end.)\n");
        
        do {							//do while loop to test test if they entered done
            test = false;				//initializing boolean to be false
            while(!test) {					//while boolean is True, program asks for the name and weight of the items
                
            	System.out.println("Enter the products name and size/weight:");				//prompting user input
                userInput = in.nextLine().trim();
                test = ProductComparison(userInput,products);							
            }
            
        }while(!userInput.equals("Done")); //while user input does not = done:

        sum = getSum(products);					//setting sum = the calling method getTotal
        
        outputFile(fileOUT, sum, products);		//calling writeToFile method
        
        fileOUT.close();					//closing the file
        in.close();
        
    }

	/**
	 * formatting the output of the receipt when they shop at the store
	 */
	private static void outputFile(PrintWriter fileOUT, double sum, ArrayList<Item> products) {		//formats & outputs to textfile 
        
        fileOUT.println("Alex Mart");						//output
        fileOUT.println("456 NewFood Ave.");
        fileOUT.println("New York City 93838");
        
        fileOUT.println("");							//2 blank lines
        fileOUT.println("");
        
        fileOUT.println("Item\t\t\t\tSubtotal");			//subtotal
        
        for (Item element: products) {
            fileOUT.println(element.toString());
        }
        fileOUT.println("");					//2 blank lines
        fileOUT.println("");
        
        fileOUT.printf("Total\t$%.2f", sum);			//outputs the total to 2 decimal places
        
    }

	/**
	 * gets the Total amount due when they checkout
	 * @param products the products they entered into the arraylist
	 * @return0 the sum of all the items being purchased
	 */
    private static double getSum(ArrayList<Item> products) {			
        double sum = 0;					//initialzing value of sum to 0
        
        for (Item element: products) {			//for loop to get the Sum of the products
            sum += element.getItemPrice();
        }
        
        return sum;
    }

    /**
     * compares the user input and the products to the PriceList.txt
     * tests if item is or isn't in the PriceList.txt
     * uses the regex to group and removes whitespaces
     * if item found, count goes up and item gets added to reciept
     * @param userInput - input from the user 
     * @param products - Arraylist of the products
     * @return the value of the boolean "test" 
     * @throws FileNotFoundException
     */
    private static boolean ProductComparison(String userInput, ArrayList<Item> products) throws FileNotFoundException {
        
    	File fileIN = new File("C:\\Users\\Evangelion\\Documents\\CECS 274\\Text Files\\PriceList.txt");		//using PriceList.txt
        Scanner fileReader = new Scanner(fileIN);
        
        String fullRegex = "(.+)\\s(\\d.+)\\s([\\d|.]+)";				//regex code
        Pattern p = Pattern.compile(fullRegex);					//creating Pattern p
        
        Matcher m = null;					//initialzing Matcher m = null
        String currentLine = fileReader.nextLine().replaceAll("[\\s]{2,}", " ");    		//whitespaces removed
        
        boolean test = false;				//setting boolean test = false
        
        if(userInput.equals("Done")) {			//boolean reassigned value if
            test = true;
        }
        
        while(fileReader.hasNextLine() && !test) { //searches the PriceList file for the given input
            m = p.matcher(currentLine);                //if found returns the boolean true
            Item product;
            
            if(m.find()) {					//if item is found
                if(userInput.trim().equals(m.group(1).trim()+" "+m.group(2).trim())) {
                    test = true;			//boolean = true
                    
                    for (Item element : products) {
                        
                    	if (element.getName().equals(m.group(1).trim()) && element.getWeight().equals(m.group(2).trim())){
                            
                        	element.Counter();			//calling item method counter to update count
                            fileReader.close();
                            return test;			//boolean returned
                        }
                    }
                    
                    product = new Item(m.group(1).trim(),m.group(2).trim(), Double.parseDouble(m.group(3).trim()));
                    products.add(product); //product added to receipt
                }
            }
            currentLine = fileReader.nextLine().replaceAll("[\\s]{2,}", " ");    //removing whitespace
        }    
        
        if (!test) {			//If boolean is not valid
            System.out.println("Error, cannot compute input.");
        }
        
        fileReader.close();				//closing the file reader
        return test;					//boolean returned
    
    }

}
