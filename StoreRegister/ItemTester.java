package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemTester {
	
	public static void main(String[] args) throws FileNotFoundException {
        
		Scanner in = new Scanner(System.in);
        
        ArrayList<Item> products = new ArrayList<Item>();

        System.out.println("Enter the name for the .txt file");
        String userInput= in.nextLine().trim(); 
        
        PrintWriter fileOUT=new PrintWriter("C:\\Users\\Evangelion\\Documents\\CECS 274\\Text Files\\" + userInput + ".txt");

        String fullRegex="(.+)[\\s]([\\d|.|-|/]{1,5}.+)\\s([\\d|.]{1,5})";
        Pattern p = Pattern.compile(fullRegex);
        
        System.out.println("Enter the name and size/weight of the product.  Enter 'done' to stop");
        
        do {
            File fileIN = new File("C:\\Users\\Evangelion\\Documents\\CECS 274\\Text Files\\PriceList.txt");
            Scanner fileReader = new Scanner(fileIN);//scanner to read the file
;
            
            String currentLine = fileReader.nextLine().replaceAll("[\\s]{2,}", " ");
            
            System.out.println("Enter product name and size: ");
            userInput=in.nextLine().trim();
            
            while (fileReader.hasNextLine() && !userInput.equals("DONE")){
                Matcher m = p.matcher(currentLine);
                Item product;

                if(m.find()) {
                    boolean test = false;
                    //set up boolean variable for condition
                    
                    if(userInput.trim().equals(m.group(1).trim()+" "+m.group(2).trim())) {
                        
                        for(Item element: products) {
                            if (element.getName().equals(m.group(1).trim()) && element.getWeight().equals(m.group(2).trim() )) {
                                element.Counter();        
                                test=true;
                            }
                            
                        }
                        if (!test) {//if condition is true
                            product=new Item(m.group(1).trim(), m.group(2).trim(), Double.parseDouble(m.group(3).trim()));
                            products.add(product); //add the products
                            test=false; //reset condition
                            
                        }
                        
                    }
                }
                currentLine = fileReader.nextLine().replaceAll("[\\s]{2,}", " ");

            }
            fileReader.close();
            
        }
        
        while(!userInput.equals("DONE"));	//while loop : while the input is not DONE
        
        
        double sum =0;
        for(Item element: products) {
            sum +=element.getItemPrice();

        }
        
                
        System.out.printf("Total: $ %.2f", sum);
        System.out.println();
        
        //print receipt to the file 
        fileOUT.println("Alex's Supermarket");
        fileOUT.println("333 Boston Ave.");
        fileOUT.println("Long Beach, CA 77777");
        
        fileOUT.println();
        fileOUT.println();
        
        fileOUT.println("Item\t\t\t\tSubtotal");
        
        
        for(Item element: products) {
            fileOUT.println(element.toString());
            
        }
        

        fileOUT.println();
        fileOUT.println();
        fileOUT.printf("Total\t  $%.2f", sum);
        fileOUT.println();
        
        
        
        System.out.println("Payment:$ ");
        userInput=in.nextLine().trim();
        
        System.out.println();
        System.out.println("Payment: $"+userInput);
        
        fileOUT.println("Payment\t" +"$"+ userInput); 
        double change = Double.parseDouble(userInput.trim()) - sum;
        
        fileOUT.printf("Change \t" + "$%.2f", change);
        System.out.println();
        System.out.printf("Change: $%.2f",change);
    
        fileOUT.close(); 
	}
}

