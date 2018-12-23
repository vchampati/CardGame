import java.util.Scanner;

public class CardGame {

    public static void main(String[] args) {
        Deck deck = new Deck();
        int numberPlayers = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of players:");
        numberPlayers = sc.nextInt();
        System.out.println("Distributing cards to " + numberPlayers + " players. Each player gets " + 52 / numberPlayers + " cards.");
        deck.printDeck();
        deck.shuffle();
        deck.printDeck();

    }
}
