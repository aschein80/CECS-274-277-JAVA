package Classes;
import java.util.*;
public class product implements Comparable{
	private String name;
	private double price;
	private int quantity;
	
	public product() {
		this.name = "";
		this.price = 0;
		this.quantity = 0;
	}
	
	public product(String name, double price, int quantity){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void updateQuantity() {
		this.quantity--;
	}
	
	@Override
	public int compareTo(Object prod) {
		product other = (product) prod;
		if (this.price < other.price) {
			return -1;
		}
		else if(this.price > other.price) {
			return 1;
		}
		
		return 0;
	}

	public String toString() {
		if (this.quantity > 1) {
			return String.format("%d %s @ $%.2f", this.quantity, this.name, this.price);
		}
		else if(this.quantity == 0) {
			return String.format("%s is out of stock", this.name);
		}
		return String.format("%d %s @ $%.2f", this.quantity, this.name, this.price);
	}


}
