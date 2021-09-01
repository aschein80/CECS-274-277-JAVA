package demos;


import java.util.*;

public class DeckLab
{
    ArrayList<CardLab> cards;


    public DeckLab()
    {
        cards = new ArrayList<CardLab>();
    }

    public void createDeck(){

        for(int i =0; i<4; i++){
            for(int j =1; j<14;j++){
                cards.add(new CardLab(j,i));


            }
        }
    }
	public void shuffleDeck() {
    	Collections.shuffle(cards);
    }
    public void sortDeck() {
	    	Collections.sort(cards);
    }
    public String toString(){
    	return "The deck has " + cards;
}

public static void main(String [] args) {
	DeckLab dl=new DeckLab();
	dl.createDeck();
	System.out.println("Deck Created: " + dl);
	dl.shuffleDeck();
	System.out.println("Deck Shuffled: " + dl);
	dl.sortDeck();
	System.out.println("Deck Sorted: " + dl);
}
}

