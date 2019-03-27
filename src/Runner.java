import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Play Black Jack!");
        System.out.println("Rules: The object of the game is to get cards with a sum of 21, or a sum that is closer to 21 than your opponent's. Each card is worth its number value, face cards are worth 10, and you can choose for aces to be worth 1 or 11. You hit to get another card, and pass to not get another card. The game ends when both players pass, and whoever is closest to 21 wins.");

        Scanner sc = new Scanner(System.in);

        Game g = new Game();
        g.gameDeck.shuffle();
/*
        for (int i=0; i<52; i++){
            System.out.println(g.gameDeck.cards[i].toString());
        }
*/

        boolean keepsHitting = true;

        while (keepsHitting || g.oppSum < 21) {
            System.out.println("Hit or pass? (Enter '1' for hit, and any other key to pass.)");
            if (sc.hasNextInt()) {
                int deal = sc.nextInt();
                if (deal == 1) {
                    g.playerCards.add(g.gameDeck.cards[g.deckCardCount]);

                    if (g.gameDeck.cards[g.deckCardCount].rank.equals("Ace")) {
                        Scanner acesc = new Scanner(System.in);
                        System.out.println("You got an ace. Enter '1' or '11' to choose its value.");
                        if (acesc.hasNextInt()) {
                            int val = acesc.nextInt();
                            if (val == 1) {
                                g.gameDeck.cards[g.deckCardCount].value = 1;
                            }
                            if (val == 11) {
                                g.gameDeck.cards[g.deckCardCount].value = 11;
                            }
                            else {
                                System.out.println("You entered an invalid number, your turn is forfeited.");
                            }
                        }
                    }

                    g.playerSum += g.gameDeck.cards[g.deckCardCount].value;
                    g.deckCardCount++;

                    System.out.println("Your cards: " + g.playerCards.toString() + " Your sum: " + g.playerSum);
                    keepsHitting = true;
                }
                else {
                    System.out.println("Your cards: " + g.playerCards.toString() + " Your sum: " + g.playerSum);
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

            if (g.oppSum < 21) {
                System.out.println("Opponent hits.");
                g.oppCards.add(g.gameDeck.cards[g.deckCardCount]);

                if (g.gameDeck.cards[g.deckCardCount].rank.equals("Ace")) {
                    if (g.oppSum <= 10) {
                        g.gameDeck.cards[g.deckCardCount].value = 11;
                    }else{
                        g.gameDeck.cards[g.deckCardCount].value = 1;
                    }
                }

                g.oppSum += g.gameDeck.cards[g.deckCardCount].value;
                g.deckCardCount++;
                System.out.println("Opponent's cards: " + g.oppCards.toString() + ". Opponent's sum: " + g.oppSum);
            }else{
                System.out.println("Opponent passes.");
                System.out.println("Opponent's cards: " + g.oppCards.toString() + ". Opponent's sum: " + g.oppSum);
            }
        }
        if ( java.lang.Math.abs(21 - g.playerSum) < java.lang.Math.abs(21 - g.oppSum)){
            System.out.println("You won!");
        }
        if ( java.lang.Math.abs(21 - g.playerSum) > java.lang.Math.abs(21 - g.oppSum)){
            System.out.println("Your opponent won. You lost.");
        }
        if ( java.lang.Math.abs(21 - g.playerSum) == java.lang.Math.abs(21 - g.oppSum)){
            System.out.println("It's a tie.");
        }
    }
}


