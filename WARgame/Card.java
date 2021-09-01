package WAR;

/**
 * @author Brian Tran
 * @author Alex Schein
 * Due : 9-11-18
 * CECS 277
 * this class creates the "card" by creating a constructor and methods for attributes of the card. The toString method is also created.
 */
public class Card {

	private int rank;
	private String suit;
	private boolean faceup;
	
	
	//default constructor
	public Card(){
		rank = 0;
		suit = null;
		faceup = true;
		
	}
	
	//Overloaded constructor with rank and suit as parameters
	public Card(int rank, String suit) {
		this.rank = rank;
		this.suit = suit;
		this.faceup = true;
		
	}
	
	//Returns rank of the card
	public int getRank() {
		return rank;
	}
	
	//Returns the suit of the card
	public String getSuit() {
		return suit;
	}
	
	//Sets the rank of the card
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	//Sets the suit of the card
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	//Checks if card is face up or face down
	public void faceTest(Boolean test) {
		this.faceup = test;
	}
	
	
	
	//Converts card object to a string
	public String toString() {
		String str = " ";
		if(faceup == true) {
			if(rank ==14) {
				str = "the Ace of " + suit;
			}else if(rank ==13) {
				str= "the King of " + suit;
			}else if (rank ==12) {
				str = "the Queen of " + suit;
			}else if (rank ==11) {
				str= "the Jack of " + suit;
			}else if (rank <= 10) {
				str = "the " + rank + " of " + suit;
			}
		}else {
			str = "Card is xx";
		}
		return str;				//returns string
	}
}
