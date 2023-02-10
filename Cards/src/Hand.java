import java.util.ArrayList;
public class Hand {
    ArrayList<Card> cards = new ArrayList<Card>();
    //Adds seven cards to the hand
    public Hand(){
        for(int i = 0; i< 7; i++){
            cards.add(new Card());
        }
    }
    public String toString(){
        return cards + "";
    }
    //Returns if the suit is in the hand
    public boolean checkSuit(String suit){
        for(Card c: cards){
            if(c.getSuit() == suit){
                return true;
            }
        }
        return false;

    }
    //returns if a num is in the hand
    public boolean checkNum(int num){
        for(Card c: cards){
            if(c.getVal()== num){
                return true;
            }
        }
        return false;
    }
    //Returns if the hand is able to play any cards
    public boolean canPlay(String suit, int num){
        if(checkSuit(suit) || checkNum(num)){
            return true;
        }
        return false;
    }
    //Adds a card from the deck to the hand
    public void addCard(){

        cards.add(new Card());
        //Creates a new deck if all cards are used
        if(Card.getTotal() == 52){
            Deck.newDeck();
        }
    }
    //Plays the card and removes it from the hand
    public void playCard(String suit, int num){
        for(int i = 0; i<cards.size();i++){
            if(cards.get(i).getVal()==num && cards.get(i).getSuit().equals(suit)){
                cards.remove(i);
            }
        }
    }
    //Returns the card that matches the suit
    public Card getCard(String suit, int num){
        for(Card c: cards){
            if(c.getSuit().equals(suit)&& c.getVal() == num){
                return c;
            }
        }
        return null;
    }
    //Returns if the user has won by having no cards in their hand
    public boolean hasWon(){
        if(cards.size()== 0){
            return true;
        }
        return false;
    }
}
