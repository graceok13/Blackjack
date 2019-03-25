import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Game g = new Game();
       g.gameDeck.shuffle();
        boolean keepsHitting = true;

        while (keepsHitting || g.dealerSum < 21) {
            System.out.println("Hit or pass? (Enter '1' for hit, and any other key to pass.)");
            if (sc.hasNextInt()) {
                int deal = sc.nextInt();
                if (deal == 1) {
                    g.playerCards.add(g.gameDeck.cards[g.deckCardCount]);
                    g.playerSum += g.gameDeck.cards[g.deckCardCount].value;
                    g.deckCardCount++;

                    for(int d=0; d<g.playerCards.size();d++) {

                        //build string with card values

                    }

                    System.out.println("Your cards: " + g.playerCards + ". Your sum: " + g.playerSum);
                    keepsHitting = true;
                }
                else {
                    System.out.println("Your cards: " + g.playerCards + ". Your sum: " + g.playerSum);
                    keepsHitting = false;
                }
            } else {
                System.out.println("Not a number. Enter '1' to hit, and any other key to pass.)");
            }
            if (g.playerSum == 21){
                System.out.println("Good job you got 21! Stop Hitting!");
            }
            if (g.playerSum > 21){
                System.out.println("Bust! Stop Hitting!");
            }

            if (g.dealerSum < 21) {
                System.out.println("Opponent hits.");
                g.dealerCards.add(g.gameDeck.cards[g.deckCardCount]);
                g.dealerSum += g.gameDeck.cards[g.deckCardCount].value;
                g.deckCardCount++;
                System.out.println("Opponent's cards: " + g.dealerCards + ". Opponent's sum: " + g.dealerSum);
            }else{
                System.out.println("Opponent passes.");
                System.out.println("Opponent's cards: " + g.dealerCards + ". Opponent's sum: " + g.dealerSum);
            }
        }
        if ( java.lang.Math.abs(21 - g.playerSum) < java.lang.Math.abs(21 - g.dealerSum)){
            System.out.println("You won!");
        }
        if ( java.lang.Math.abs(21 - g.playerSum) > java.lang.Math.abs(21 - g.dealerSum)){
            System.out.println("Your opponent won. You lost.");
        }
        if ( java.lang.Math.abs(21 - g.playerSum) == java.lang.Math.abs(21 - g.dealerSum)){
            System.out.println("It's a tie.");
        }
    }
}


