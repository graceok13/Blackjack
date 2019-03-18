import java.util.Scanner;

public class Runner {


    public void main() {
        Scanner sc = new Scanner(System.in);

        Game g = new Game();

        System.out.println("Hit or pass? (Enter '1' for hit, '2' for pass.");

        if (sc.hasNextInt()) {
            int deal = sc.nextInt();
            if (deal == 1) {
                g.playerCards[0] = g.gameDeck.cards[g.deckCardCount];
                g.playerSum += g.gameDeck.cards[g.deckCardCount].value;
                System.out.println("Your cards: " + g.playerCards + ". Your sum: ");

                g.deckCardCount++;
            }if (deal == 2){
                //return g.playerCards;
                //return g.playerSum;
            }
            else {
                System.out.println("Not a valid number. Enter '1' for hit, '2' for pass.");
            }
        } else {
            System.out.println("Not a number. Enter '1' for hit, '2' for pass.");
        }
    }

}
