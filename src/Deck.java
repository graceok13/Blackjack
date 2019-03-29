import java.util.*;

public class Deck {
    Card[] cards = new Card[52];

    private static String[] ranks = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    private static String[] suits = {"Clubs","Diamonds","Hearts","Spades"};

    public Deck (){
        int count = 0;
        for (int i=0; i<4; i++){
            for (int j=0; j<13; j++){
            Card x = new Card(ranks[j],suits[i]);
            cards[count] = x;
            count ++;
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(Arrays.asList(cards));
    }

}

