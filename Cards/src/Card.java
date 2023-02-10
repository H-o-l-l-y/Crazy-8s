import java.util.Random;
public class Card {
    private String suit = "";
    private int value = 0;
    private String face = "";
    private static int total = 0;
//Creates a card with a suit a value
    public Card(){
        boolean cardFound = false;
        while(!cardFound) {


            Random r = new Random();
            //Assigns a card a random suit
            int temp = r.nextInt(4) + 1;
            if (temp == 1) {
                suit = "Clubs";
            } else if (temp == 2) {
                suit = "Spades";
            } else if (temp == 3) {
                suit = "Diamonds";
            } else {
                suit = "Hearts";
            }
            //Creates a random value to a card and removes it from the deck
            value = r.nextInt(13)+1;
            if(Deck.checkCard(suit, value)){
                Deck.removeCard(suit, value);
                cardFound = true;
            }
            total++;
        }


        if(value>10 || value == 1){
            //Assigns a face value to the card
            if(value == 11){
                face = "Jack";
            }
            else if(value == 12){
                face = "Queen";
            }
            else if(value == 13){
                face = "King";
            }
            else{
                face = "Ace";
            }
        }else{
            face = null;
        }



    }
    //returns the value of the card
    public int getVal(){
        return value;
    }
    //returns if the card is a face value
    public boolean isFace(){
        if(face!=null){
            return true;
        }
        return false;
    }
    //returns the face of the card
    public String getFace(){
        if(isFace()){
            return face;
        }else{
            return null;
        }
    }
    //returns the suit of the card
    public String getSuit(){
        return suit;
    }
    public static int getTotal(){
        return total;
    }

    public String toString(){
        String s = "";
        if(getFace()!=null){
            s+=getFace();
        }else{
            s+=getVal() + "";
        }
        return s +" of " + getSuit();
    }

}
