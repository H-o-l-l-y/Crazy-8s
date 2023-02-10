import java.util.ArrayList;
import java.util.HashMap;
public class Deck {
    private static HashMap<String, ArrayList<Integer>> ava = new HashMap<String, ArrayList<Integer>>();

    public Deck(){
        //Creates an array list for each suit
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        ArrayList<Integer> z = new ArrayList<Integer>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i = 1; i<14; i++){
            x.add(i);
            y.add(i);
            z.add(i);
            a.add(i);
        }
        ava.put("Clubs", x);
        ava.put("Spades", y);
        ava.put("Diamonds", z);
        ava.put("Hearts", a);

    }
    //Returns if the card in is the deck
    public static boolean checkCard(String suit, int val){
        for(int n: ava.get(suit)){
            if(n == val){
                return true;
            }
        }
        return false;
    }
    //Creates an arrayList for each suit
    public static void newDeck(){
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        ArrayList<Integer> z = new ArrayList<Integer>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i = 1; i<14; i++){
            x.add(i);
            y.add(i);
            z.add(i);
            a.add(i);
        }
        ava.put("Clubs", x);
        ava.put("Spades", y);
        ava.put("Diamonds", z);
        ava.put("Hearts", a);
    }
    //Removes a card from the deck
    public static void removeCard(String suit, int val){
        ava.get(suit).remove(Integer.valueOf(val));
    }
}
