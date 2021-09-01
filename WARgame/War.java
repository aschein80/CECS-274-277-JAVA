/**
 * Brian Tran 01548742
 * Alexandre Schein 015863378
 * Project 1
 * Professor Mimi Opkins
 * Due : 9-11-18
 * CECS 277
 * Inputs : none
 * Outputs : Cards that are played by each player and the victorious player.
 * A program that simulates two players playing the card game WAR.
 */
package WAR;

import java.util.ArrayList;
import java.util.Collections;

public class War {
	
	/**
	 * Creates a standard deck of 52 cards
	 * @param CardDeck - an empty array list that the card objects will be stored in
	 * @return CardDeck - returns the array list with 52 card objects
	 */
	public static ArrayList<Card>CreateDeck(ArrayList<Card>CardDeck){
		//for loop to create each card with each suit
		for(int i = 2 ; i< 14 ; i++) {
			for(int j =1 ; j <= 4 ; j++) {
				if(j==1) {
					CardDeck.add(new Card(i, "Hearts"));			//adding hearts
				}
				else if(j == 2) {
					CardDeck.add(new Card(i, "Diamonds"));			//adding diamonds
				}
				else if(j == 3) {	
					CardDeck.add(new Card(i,"Club"));				//adding clubs
				}
				else{
					CardDeck.add(new Card(i, "Spades"));			//adding spades
				}
			}
		}
		return CardDeck;
	}

	/**
	 * Shuffles the deck of cards
	 * @param cards - takes in a sorted array list for the deck of cards
	 * @return cards - returns a shuffled array list
	 */
	public static ArrayList<Card>ShuffleDeck(ArrayList<Card>cards){
		Collections.shuffle(cards);					//using collections to shuffle
		return cards;			
	}
	
	/**
	 * In the case of a tie, both players go to war placing 3 cards face down and the 4th one face up.
	 * The higher rank 4th card wins the war. If it ties this will loop
	 * @param Player_1 - An array list containing the cards player 1 has
	 * @param Player_2 - An array list containing the cards player 2 has
	 * @return end_Game - returns a boolean to check whether a winner has been decided
	 */
	public static boolean war(ArrayList<Card>Player_1, ArrayList<Card>Player_2) {
		
		//initializing the boolean and creating empty array lists separate from the player's hand in order to go to war
		boolean winner = false;
		boolean end_Game = false;
		ArrayList<Card>war_P1 = new ArrayList<Card>();				//player 1 arraylist
		ArrayList<Card>war_P2 = new ArrayList<Card>();				//player 2 arraylist
		ArrayList<Card>temp = new ArrayList<Card>();
		ArrayList<Card>temp1 = new ArrayList<Card>();

		//Checking if the player has enough cards to go to war
		while(!winner) {							//while loops as long as no winner
			if(Player_1.size() < 4) {							
				end_Game = true;
				winner = true;
				System.out.println("WAR Player 1 does not have enough cards to go to war. Player 2 wins!");
				return end_Game;				
			}
			else if (Player_2.size() < 4) {				//testing size of arraylist for player 2
				end_Game = true;
				winner = true;
				System.out.println("WAR Player 2 does not have enough cards to go to war. Player 1 wins!");
				return end_Game
						;
			}
			
			//If the player has enough cards to to war 4 cards will be taken out of their hand
			for(int i = 0; i < 4; i++) {
				war_P1.add(Player_1.get(0));
				war_P1.get(war_P1.size()-1).faceTest(false);
				Player_1.remove(0);
	
				war_P2.add(Player_2.get(0));
				war_P2.get(war_P1.size()-1).faceTest(false);
				Player_2.remove(0);
			}
			
			//Flips over the 4th card to go to war
			war_P1.get(3).faceTest(true);
			war_P2.get(3).faceTest(true);
			for(int i = 0; i < 4; i++) {
				System.out.println("war card for player 1 is: " + war_P1.get(i));
				System.out.println("war card for player 2 is: " + war_P2.get(i));
			}
			
			//Checks if player 1's card is a higher value than player 1's
			if(war_P1.get(3).getRank() > war_P2.get(3).getRank()) {
				winner = true;
				//Empties out the temporary array list in the case that there was previously a tie in the War
				//in order to add it back to the player's war array list then to the hand array list
				if(temp.size()>0) {
					for(Card e : temp) {
						war_P1.add(e);
					}
				}
				if(temp1.size()>0) {
					for(Card e : temp) {
						war_P2.add(e);
					}
				}
				//Changes the cards back to all face up like the rest of the cards in the player's hand
				for(int i = 0; i < war_P2.size(); i++) {
					war_P2.get(i).faceTest(true);
				}
				for(int i = 0; i < war_P1.size(); i++) {
					war_P1.get(i).faceTest(true);
				}
				//Adding the war cards to the victor's hand
				temp.removeAll(temp);
				temp1.removeAll(temp1);
				Player_1.addAll(war_P1);
				Player_1.addAll(war_P2);
				System.out.println("Player 1 wins the war round and now has " + Player_1.size() + " cards!\n");		
			}
			//Checks if player 2's card is a higher value than player 1's
			else if(war_P1.get(3).getRank() < war_P2.get(3).getRank()) {
				winner = true;
				//Empties out the temporary array list in the case that there was previously a tie in the War
				//in order to add it back to the player's war array list then to the hand array list
				if(temp.size()>0) {
					for(Card e : temp) {
						war_P1.add(e);
					}
				}
				if(temp1.size()>0) {
					for(Card e : temp1) {
						war_P2.add(e);
					}
				}
				//Changes the cards back to all face up like the rest of the cards in the player's hand
				for(int i = 0; i < war_P1.size(); i++) {
					war_P1.get(i).faceTest(true);
				}
				for(int i = 0; i < war_P2.size(); i++) {
					war_P2.get(i).faceTest(true);
				}
				//Adding the war cards to the victor's hand
				temp.removeAll(temp);
				temp1.removeAll(temp1);
				Player_2.addAll(war_P2);
				Player_2.addAll(war_P1);
				System.out.println("Player 2 wins the war round and now has " + Player_2.size() + " cards!\n");
			}	
			
			//In the case that the war card ranks are equivalent, all 4 war cards will be moved to temp to make room
			//for the next round of war
			else if(war_P1.get(3).getRank() == war_P2.get(3).getRank()) {
				for(Card element:war_P1) {
					temp.add(element);
				}
				for(Card element:war_P2) {
					temp1.add(element);
				}
				for(Card element:temp) {
					war_P1.remove(element);
				}
				for(Card element:temp1) {
					war_P2.remove(element);
				}
			}
			
		}	
		return end_Game;
	}
	
	/**
	 * Both players play their top card face up. Higher rank wins. If there is a tie both players go to war.
	 * @param Player_1 - An array list containing the cards player 1 has
	 * @param Player_2 - An array list containing the cards player 2 has
	 * @return end_Game - returns a boolean to check whether a winner has been decided
	 */
	public static boolean roundStart(ArrayList<Card>Player_1,ArrayList<Card>Player_2) {
		boolean end_Game = false;
		boolean winner = false;
		while(!winner) {
			
			//Checks if player 1's hand is empty
			if(Player_1.isEmpty()){
				winner = true;
				end_Game = true;
				System.out.println("\nPlayer 1 has run out of cards!\nPlayer 2 wins!");
				return end_Game;
			}
			//Checks if player 2's hand is empty
			if(Player_2.isEmpty()){
				winner = true;
				end_Game = true;
				System.out.println("\nPlayer 2 has run out of cards!\nPlayer 1 wins!");
				return end_Game;
			}
			
			//Prints out the card each player played for the round 
			System.out.println("Player 1 plays " + Player_1.get(0).toString());
			System.out.println("Player 2 plays " + Player_2.get(0).toString());
			
			//Checks if the rank of player 1's card is greater than player 2's
			if(Player_1.get(0).getRank() > Player_2.get(0).getRank()) {
				System.out.println("Player 1 wins the round\n");
				Player_1.add(Player_2.get(0));
				Player_1.add(Player_1.get(0));
				Player_1.remove(0);
				Player_2.remove(Player_2.get(0));
				System.out.println("Player 1 now has " + Player_1.size() + " cards.\n");
				System.out.println("Player 2 now has " + Player_2.size() + " cards.\n");
			}
			//checks if the rank of player 2's card is greater than player 1's
			else if(Player_2.get(0).getRank()> Player_1.get(0).getRank()) {
				System.out.println("Player 2 wins the round\n");
				Player_2.add(Player_1.get(0));
				Player_2.add(Player_2.get(0));
				Player_2.remove(0);
				Player_1.remove(Player_1.get(0));
				System.out.println("Player 2 now has " + Player_2.size() + " cards.\n");
				System.out.println("Player 1 now has " + Player_1.size() + " cards.\n");
			}
			//If the rank of both player's cards are equal then they will go to war
			else {
				//Checks if the player has enough cards to go to war
				if(Player_1.size() < 4) {
					end_Game = true;
					winner = true;
					System.out.println("ROUND START Player 1 does not have enough cards to go to war. Player 2 wins!");
					return end_Game;
				}
				//Checks if the player has enough cards to go to war
				else if (Player_2.size() < 4) {
					end_Game = true;
					winner = true;
					System.out.println("ROUND START Player 2 does not have enough cards to go to war. Player 1 wins!");
					return end_Game;
				}
				end_Game = war(Player_1, Player_2);
				if(end_Game == true) {
					winner = true;
				}
				
			}
		}
		
		
		return end_Game;
	}	
	
	/**
	 * Starts the game with player 1 and 2's hand
	 * @param Player_1 - An array list containing the cards player 1 has
	 * @param Player_2 - An array list containing the cards player 2 has
	 */
	public static void runGame(ArrayList<Card>Player_1,ArrayList<Card>Player_2) {
		boolean end_Game = false;
		//While loop to continuously play the game until there is a victor then end_Game will be set to true
		while(!end_Game) {
			end_Game = roundStart(Player_1, Player_2);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Card> Deck = new ArrayList<Card>();
		ArrayList<Card> p1Hand = new ArrayList<Card>();
		ArrayList<Card> p2Hand = new ArrayList<Card>();
		CreateDeck(Deck);
		ShuffleDeck(Deck);
		while(!Deck.isEmpty()) {
			p1Hand.add(Deck.get(Deck.size()-1));
			Deck.remove(Deck.size()-1);
			p2Hand.add(Deck.get(Deck.size()-1));
			Deck.remove(Deck.size()-1);
		}
		runGame(p1Hand, p2Hand);
	}
}
