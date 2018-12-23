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
            System.out.println(card.getName());
        }
    }

    public void shuffle() {
        int swapLoc = 0;
        Random rand = new Random();
        Card temp;
        for (int i = 0; i < 52; i++) {
            swapLoc = rand.nextInt(52);
            temp = cards[i];
            cards[i] = cards[swapLoc];
            cards[swapLoc] = temp;
        }
    }

    public Card[] AllCards() {
        return cards;
    }

}
