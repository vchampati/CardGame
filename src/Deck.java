import gherkin.lexer.Ca;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    Card[] cards;

    public Deck() {
        cards = new Card[52];
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                cards[i++] = new Card(value, suit);
            }

        }
    }

    public void printDeck() {
        for (Card card : cards) {
            System.out.println("\t"+card.getName());
        }
    }


    public void shuffle() {
        int swapLoc = 0;
        Random rand = new Random();
        Card temp;
        for (int i = cards.length-1; i >0; i--) {
            swapLoc = rand.nextInt(i+1);
            temp = cards[i];
            cards[i] = cards[swapLoc];
            cards[swapLoc] = temp;
        }
    }

    public Card[] AllCards() {
        return cards;
    }

    public ArrayList<Card>[] distribute(int numPlayers){
        System.out.println("Distributing cards to " + numPlayers + " players.");
        ArrayList<Card>[] hands = new ArrayList[numPlayers];

        //initialize with empty arraylists
        for(int i=0;i<numPlayers;i++){
            hands[i]= new ArrayList<Card>();
        }

        for (int i = 0; i < cards.length; i++) {
            hands[i%numPlayers].add(cards[i]);
        }
        return hands;
    }
}
