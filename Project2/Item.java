package project2;

/**
 * 
 * @author Alexandre Schein
 * @since 2-22-2018
 * @version 0.0.1
 *
 */
public class Item {
	private String name;
	private String weight;
	private double price;
	private int count;
	
	/**
	 * initializes the name, weight, price, and count
	 */
	public Item(){
		name = "N/A";				//name
		weight = "0 oz";			//weight set to 0
		price = 0.0;				//price set to 0
		count = 0;					//count of items = 0
}
	
	/**
	 * overloaded constructor which declares this.name, this.weight, etc..
	 * @param name - the name of the item
	 * @param weight -the weight of the item
	 * @param price - the price of the double price
	 */
	public Item(String name, String weight, double price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
		this.count = 1;
		
	}
	
	/**
	 * updates the count of the items
	 */
	public void Counter() {
		count ++;
		
	}
	
	/**
	 * @return the name of the item
	 */
	public String getName(){
		return name;		//name returned
		}
	
	/**
	 * @return the weight/size of the item
	 */
	public String getWeight() {
		return weight;
	}
	
	/**
	 * gets the double item price and multiplies it by the count to find the cost
	 * @return total cost per item
	 */
	
	public double getItemPrice() {
		double ItemPrice = price * count;
		return ItemPrice;
	}
	
	/**
	 * if count of item is greater than 1, then formats string str accordingly to account for repeats
	 * if count = 1, then the price is formatted to that one item
	 * @return the formatted string 
	 */
	public String toString(){
		String str = null;
		double ItemPrice = price * count;
		
		if (count == 1) {
			str = String.format("%s\t\t\t$%.2f",name, price);
			
		}
		else {
			str= String.format("%s\t\t%d@($%.2f) $%.2f", name, count, price, ItemPrice);
		}
		
		return str;
		
		
		
	}
}
