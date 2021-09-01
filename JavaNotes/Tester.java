package Classes;

import java.util.*;
public class Tester {

	public static void main(String[] args) {
		vendingmachine v1 = new vendingmachine();
		ArrayList<String> coins = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		String input;
		
		v1.addProduct("Lolipop", 0.50, 3);
		v1.addProduct("Gatorade", 1.00, 1);
		v1.addProduct("Hot Cheeto", 1.50,5);
		v1.addProduct("Water", 1.00, 6);
		boolean cont = true;
		boolean done;
		while (cont) {
			System.out.println(v1.displayProducts());
			done = false;
			System.out.println("Enter Exact Change(No change is returned): Enter 'DONE' when finished");
			while(!done) {
				input = in.nextLine().trim();
				if (!input.equals("DONE")) {
					v1.addCoin(Double.parseDouble(input));
				}
				else {
					done = true;
				}
			}
			System.out.printf("Available Funds: $%.2f\n", v1.getCoinTotal());
			System.out.println("Please enter the number of the item you would like to buy: ");
			input = in.nextLine().trim();
			System.out.println(v1.buyProduct(Integer.parseInt(input)));
			

			System.out.println(v1.displayProducts());
			
			System.out.println("Would you like to buy another product? (Y/N)");
			input = in.nextLine().trim();
			if(!(input.equals("Y") || input.equals("y"))) {
				cont = false;
			}
			v1.removeCoins();
		}
		
	}

}
