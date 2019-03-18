public class Card {
    public String rank;
    public String suit;
    public int value;

    Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
        this.value = getValue();
    }
    private int getValue(){
        if (rank.equals("Ace")){
            value = 11;
            //user input to choose value 11 or 1?
        }
        if (rank.equals("One")){
            value = 1;
        }
        if (rank.equals("Two")){
            value = 2;
        }
        if (rank.equals("Three")){
            value = 3;
        }
        if (rank.equals("Four")){
            value = 4;
        }
        if (rank.equals("Five")){
            value = 5;
        }
        if (rank.equals("Six")){
            value = 6;
        }
        if (rank.equals("Seven")){
            value = 7;
        }
        if (rank.equals("Eight")){
            value = 8;
        }
        if (rank.equals("Nine")){
            value = 9;
        }
        if (rank.equals("Ten")){
            value = 10;
        }
        if (rank.equals("Jack")){
            value = 10;
        }
        if (rank.equals("Queen")){
            value = 10;
        }
        if (rank.equals("King")) {
            value = 10;
        }
        return value;
    }

    @Override
    public String toString() {
        return this.rank + " of " + this.suit + ". Value = " + this.value;
    }
}
