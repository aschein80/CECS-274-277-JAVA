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
	        
	        //////////REQUIREMENT1///////////////
	        System.out.println("Enter the name for the .txt file");
	        String name= in.nextLine().trim(); //takes next input
	        PrintWriter fileOUT=new PrintWriter("C:\\Users\\Evangelion\\Documents\\CECS 274\\Text Files\\" + name + ".txt");
	        //writes the input as the name of the file + add .txt to doc
	    
	        /////////////requirement2 AND 3///////////
	        String fullRegex="(.+)[\\s]([\\d|.|-|/]{1,5}.+)\\s([\\d|.]{1,5})";
	        //Credit of Regex to DENNIS MAYA
	        
	        Pattern p = Pattern.compile(fullRegex);
	        
	        System.out.println("Enter product name and size. When done, type 'DONE'");
	        do {
	            File fileIN = new File("C:\\Users\\Evangelion\\Documents\\CECS 274\\Text Files\\PriceList.txt");
	            Scanner fileReader = new Scanner(fileIN);//scanner to read the file
	;
	            
	            String currentLine = fileReader.nextLine().replaceAll("[\\s]{2,}", " ");
	            //currentline removes all the white space
	            
	            System.out.println("Enter product name and size: ");
	            name=in.nextLine().trim();
	            
	            while (fileReader.hasNextLine() && !name.equals("DONE")){
	                Matcher m = p.matcher(currentLine);
	                Item product;

	                if(m.find()) {
	                    boolean pass = false;
	                    //set up boolean variable for condition
	                    
	                    if(name.trim().equals(m.group(1).trim()+" "+m.group(2).trim())) {
	                        
	                        for(Item element: products) {
	                            if (element.getName().equals(m.group(1).trim()) && element.getWeight().equals(m.group(2).trim() )) {
	                                element.Counter();        
	                                pass=true;
	                            }
	                            
	                        }
	                        if (!pass) {//if condition is true
	                            product=new Item(m.group(1).trim(), m.group(2).trim(), Double.parseDouble(m.group(3).trim()));
	                            products.add(product); //add the products
	                            pass=false; //reset condition
	                            
	                        }
	                        
	                    }
	                }
	                currentLine = fileReader.nextLine().replaceAll("[\\s]{2,}", " ");
	                //gets rid of white space
	            }
	            fileReader.close();
	            
	        }while(!name.equals("DONE"));//while loop : while the input is not DONE
	        
	        
	        double total=0.00;
	        for(Item element: products) {
	            total+=element.getIndividualPrice();
	            //updates the total with prices
	        }
	        
	                
	        System.out.printf("Total: $ %.2f", total);
	        System.out.println();
	        
	        //print receipt to the file 
	        fileOUT.println("Bradley's Market");
	        fileOUT.println("10 E. Cloverfield Lane");
	        fileOUT.println("Alabama, CA 92843");
	        fileOUT.println(); //skip two lines for the receipt
	        fileOUT.println();
	        
	        fileOUT.println("Item\t\t\t\tSubtotal");
	        
	        
	        ////////PRINT TO THE FILE
	        
	        for(Item element: products) {
	            fileOUT.println(element.toString());
	            
	        }
	        
	        //formatting the output on .txt file and console
	        fileOUT.println();
	        fileOUT.println();
	        fileOUT.printf("Total\t" +"$%.2f",total);
	        fileOUT.println();
	        
	        
	        
	        System.out.println("Payment:$ ");
	        name=in.nextLine().trim();
	        
	        System.out.println();
	        System.out.println("Payment: $"+name);
	        
	        fileOUT.println("Payment\t" +"$"+ name); 
	        double change = Double.parseDouble(name.trim()) - total;
	        fileOUT.printf("Change \t" + "$%.2f", change);
	        System.out.println();
	        System.out.printf("Change: $%.2f",change);
	    
	        fileOUT.close(); //close file after you're done
	    }

	}

