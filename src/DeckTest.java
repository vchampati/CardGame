import gherkin.lexer.De;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DeckTest {
    Deck deck;



    @Before
    public void setUp() throws Exception {
        deck = new Deck();


    }

    //Test case for creating the deck
    @Test
    public void Deck(){
        //assert total 52 cards
        assertEquals(52,deck.AllCards().length);


        int[][] isThere = new int[4][13];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                isThere[i][j]=0;
            }
        }
        // assert no copied cards
        for (Card card : deck.AllCards()) {
            assertEquals(true,card.getSuit().ordinal() < 4);
            assertEquals(true,card.getSuit().ordinal() >= 0);
            assertEquals(true,card.getValue().ordinal() >= 0);
            assertEquals(true,card.getValue().ordinal() < 13);
            if (card.getSuit().ordinal() < 4 && card.getSuit().ordinal() >= 0 && card.getValue().ordinal() >= 0 && card.getValue().ordinal() < 13) {
                assertEquals(0,isThere[card.getSuit().ordinal()][card.getValue().ordinal()]);
                isThere[card.getSuit().ordinal()][card.getValue().ordinal()] = 1;
            }

        }

        //assert all cards present
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                assertEquals(1,isThere[i][j]);
            }
        }
    }

    //test case for shuffling
    @Test
    public void shuffle() {
        // assert unique
        int[][] isThere = new int[4][13];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                isThere[i][j]=0;
            }
        }

        for (Card card : deck.AllCards()) {
            assertEquals(true,card.getSuit().ordinal() < 4);
            assertEquals(true,card.getSuit().ordinal() >= 0);
            assertEquals(true,card.getValue().ordinal() >= 0);
            assertEquals(true,card.getValue().ordinal() < 13);
            if (card.getSuit().ordinal() < 4 && card.getSuit().ordinal() >= 0 && card.getValue().ordinal() >= 0 && card.getValue().ordinal() < 13) {
                assertEquals(0,isThere[card.getSuit().ordinal()][card.getValue().ordinal()]);
                isThere[card.getSuit().ordinal()][card.getValue().ordinal()] = 1;
            }

        }
        //assert all cards present
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                assertEquals(1,isThere[i][j]);
            }
        }

    }

    //test case for distribution for 3 players
    @Test
    public void distribute() {

        ArrayList<Card>[] hands = deck.distribute(3);

        // assert correct number of cards for each player
        assertEquals(18,hands[0].size());
        assertEquals(17,hands[1].size());
        assertEquals(17,hands[2].size());
        //assert total 52 cards
        assertEquals(52,hands[0].size() + hands[1].size()+ hands[2].size());


        int[][] isThere = new int[4][13];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                isThere[i][j]=0;
            }
        }
        // assert unique
        for (int i = 0; i < 3; i++) {
            for (Card card: hands[i]) {
                assertEquals(true,card.getSuit().ordinal() < 4);
                assertEquals(true,card.getSuit().ordinal() >= 0);
                assertEquals(true,card.getValue().ordinal() >= 0);
                assertEquals(true,card.getValue().ordinal() < 13);
                if (card.getSuit().ordinal() < 4 && card.getSuit().ordinal() >= 0 && card.getValue().ordinal() >= 0 && card.getValue().ordinal() < 13) {
                    assertEquals(0,isThere[card.getSuit().ordinal()][card.getValue().ordinal()]);
                    isThere[card.getSuit().ordinal()][card.getValue().ordinal()] = 1;
                }
            }
        }
        //assert all cards present
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                assertEquals(1,isThere[i][j]);
            }
        }

        //test cases for correct distribution
        Card[] allCards= deck.AllCards();
        for (int i = 0; i < allCards.length; i++) {
            assertEquals(true, hands[i%3].contains(allCards[i]));
        }

    }
}