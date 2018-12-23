import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {

    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("Initial Deck::");
        deck.printDeck();

        System.out.println("Shuffling deck...");
        deck.shuffle();
        System.out.println("Deck After shuffling::");
        deck.printDeck();

        int numberPlayers = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of players:");
        numberPlayers = sc.nextInt();


        ArrayList<Card>[] hands = deck.distribute(numberPlayers);

        for (int i = 0; i < numberPlayers; i++) {
            System.out.println("Player "+ (i+1) + " has " + hands[i].size()+ " cards. They are:");
            for (Card card: hands[i]) {
                System.out.println("\t" + card.getName());
            }
        }

    }
}
