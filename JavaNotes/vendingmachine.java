package Classes;
import java.util.*;

/**
 * 
 * @author Alexandre Schein, Brian Tran
 * @since October 9, 2018
 * @version 1.0.1
 * This class simulates a vending machine that adds and displays products to a customer, and computes the purchasing of products.
 */
class vendingmachine {
	private ArrayList<product> products;		//arraylist for products
	private ArrayList<coin> coins;				//new arraylist of coins
	private double coinTotal;					//total coins set to variable coinToal
	
	/**
	 * This method uses the vendingmachine constructor to create an arraylist of products and coins.
	 * @return none
	 */
	public vendingmachine() {
		products = new ArrayList<product>();
		coins = new ArrayList<coin>();
		coinTotal = 0;
	}
	
	/**
	 * This methodadds a product with a name, price and quantity to the arraylist products.
	 * @param name - the name of the product
	 * @param price- the price of the product
	 * @param quantity - quantity of the item
	 */
	public void addProduct(String name, double price, int quantity) {
		products.add(new product(name,price,quantity)); //adding to the arraylist products
		sortProducts(); //sorting the products
	}
	
	/**
	 * This method adds coinsto the total coins in the vending machine.
	 * @param value - a double that describes the worth of the inserted coin
	 */
	public void addCoin(double value) {
		coins.add(new coin(value)); //adding to arraylist coins the new coin
		coinTotal += value;	//updating the coinTotal for the number of coins inserted
	}
	
	/**
	 * This methods retuns total number of coins
	 * @return coinTotal- the number of coins
	 */
	public double getCoinTotal() {
		return coinTotal;		//returning coin total
	}
	
	/**
	 * Removes the coins from the arraylist coins.
	 */
	public void removeCoins() {
		coins.clear();		//removing the coins from the vending machine
	}
	
	/**
	 * Returns the number of coins if the 
	 * @return
	 */
	public String returnCoins() {
		String str = "Insufficent Funds\n";
		while(coins.size() > 0) {
			str += coins.remove(coins.size()-1) + "\n";
		}
		return str + "returned";
	}
	public String displayProducts() {
		String str = "";
		for(int i = 0; i < products.size(); i++) {
			str += String.format("%d: %s\n", i,products.get(i).toString());
		}
		return str;
	}
	
	public void sortProducts() {
		Collections.sort(products);
	}
	
	public String buyProduct(int i) {
		getCoinTotal();
		String str;
		if (coinTotal < products.get(i).getPrice()) {
			str = returnCoins();
			return str;
		}
		str = String.format("%s bought for %.2f", products.get(i).getName(), products.get(i).getPrice());
		coinTotal -=  products.get(i).getPrice();
		products.get(i).updateQuantity();
		
		return str;
	}

}
