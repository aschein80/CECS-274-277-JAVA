package CatLab;

import java.util.Scanner;

public class CatTester {
	public static void main(String[] args){
		Cat kitty = new Cat();
		
		Scanner in=new Scanner(System.in);
		System.out.println("The Cat's sleeping..");
		
		boolean end=false;
		String input=in.nextLine();
		while(!end){
			if(input.toLowerCase().equals("sleep")){
				kitty.sleep();
			}
			else if(input.toLowerCase().equals("play")){
				kitty.play();
			}
			else if(input.toLowerCase().equals("eat")){
				kitty.eat();
			}
			else if(input.toLowerCase().equals("ignore")){
				kitty.ignore();
			}
			else if(input.toLowerCase().equals("quit")){
				System.out.println("Terminating..");
				end=true;
				in.close();
			}
			input=in.nextLine();
		}
	}
	
	
	
}
