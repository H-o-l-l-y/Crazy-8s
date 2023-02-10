import java.sql.SQLOutput;
import java.util.Scanner;
import java.lang.*;

public class Main {
    static Card inPlay;
    static Hand a;
    static Hand b;
    static Deck d = new Deck();
    public static void main(String[] args) {
        setup();
        turn();

    }
    //Creates a hand for both the user and computer
    public static void setup(){
        inPlay = new Card();
        a = new Hand();
        b = new Hand();
        System.out.println("User hand: " + a);
        System.out.println("Card: " + inPlay);
        turn();
    }
    //Allows the user to play or draw cards
    public static void turn(){
        Scanner scanner = new Scanner(System.in);
        if(a.canPlay(inPlay.getSuit(), inPlay.getVal())){
            System.out.println("\nPlay or Draw?");
            String ans = scanner.nextLine();
            ans = ans.toLowerCase();
            for(char c: ans.toCharArray()){
                if(c == 'p'){
                    play(a);
                }
                else if(c == 'd'){
                        draw(a);
                }
                else{
                    System.out.println("Please answer play or draw");
                    turn();
                }
            }

        }else{
            System.out.println("\nDraw?");
            String ans = scanner.nextLine();
            ans = ans.toLowerCase();
            for(char c: ans.toCharArray()){
                if(c == 'd'){
                    draw(a);
                }
                else{
                    System.out.println("Too bad lmao");
                    draw(a);
                }
            }

        }

    }
//Adds cards into the user's hand
    public static void draw(Hand h){
        h.addCard();
        System.out.println("You drew: " + h.cards.get(h.cards.size()-1));
        System.out.println(h);
        while(!h.canPlay(inPlay.getSuit(), inPlay.getVal())){
           
            try{
                Thread.sleep(1000);

            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
            h.addCard();
            System.out.println("You drew: " + h.cards.get(h.cards.size()-1));
            System.out.println(h);
        }
        play(h);
    }
    //Returns the value of the face card
    public static int checkFace(String s){
        s = s.toLowerCase();
        char c = s.charAt(0);
        if(c == 'j'){
            return 11;
        }
        else if(c == 'q'){
            return 12;
        }
        else if(c== 'k'){
            return 13;
        }
        else if(c=='a'){
            return 1;
        }
        return 0;
    }
    //Lower cases user's input to play
    public static String capFirst(String s){
        s = s.toLowerCase();
        char c = s.charAt(0);
        if(c == 'd'){
            return "Diamonds";
        }else if(c== 's'){
            return "Spades";
        }else if(c == 'c'){
            return "Clubs";
        }else if (c == 'h'){
            return "Hearts";
        }
        return "no";

    }
    //Allows the user to choose which card to play
    public static void play(Hand h){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Which number or face?");
        int n = 0;
        try {
            n = scanner.nextInt();
            if (!h.checkNum(n)) {
                System.out.println("You don't have that number");
                play(h);

            }
        }catch(Exception e){
            String s = scanner.nextLine();
            n = checkFace(s);
            if(n == 0){
                System.out.println("Enter a valid face");
                play(h);
            }
            else if(!h.checkNum(n)){
                System.out.println("You don't have that face");
                play(h);
            }




        }
        scanner = new Scanner(System.in);
        System.out.println("Which suit?");
        String s = capFirst(scanner.nextLine());

        if(s.equals("no")){
            System.out.println("Imput a valid suit");

        }else if(!h.checkSuit(s)){
            System.out.println("You don't have that suit");
            play(h);
        }
        if(s.equals(inPlay.getSuit())||n==inPlay.getVal()){
          inPlay = h.getCard(s, n);
          h.playCard(s, n);
          System.out.println("You played " + inPlay);
        }else{
          System.out.println("You cannot play that card");
          play(h);
        }
        if(h.hasWon()){
            playerWin();
        }
        System.out.println("Cards: "+h);
        comPlay();


    }
    //Plays a card from the computer's hand
    public static void comPlay(){
        if(b.canPlay(inPlay.getSuit(), inPlay.getVal())){
            for (int i = 0; i < b.cards.size(); i++) {
                if (b.cards.get(i).getSuit().equals(inPlay.getSuit()) || b.cards.get(i).getVal() == inPlay.getVal()) {
                    inPlay = b.cards.get(i);
                    b.playCard(b.cards.get(i).getSuit(), b.cards.get(i).getVal());
                    System.out.println("\nThe computer played: " + inPlay);
                    if(b.hasWon()){
                        comWon();
                    }
                    turn();

            }
        }
        }else{
                comDraw();
        }

    }
//Draws cards into the computer's hand
    public static void comDraw(){
            while(!b.canPlay(inPlay.getSuit(), inPlay.getVal())){
                b.addCard();
                try{
                    Thread.sleep(1000);

                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                //System.out.println(b);
            }

            comPlay();
    }
    //Restarts the game if the user uses all cards in their hand
    public static void playerWin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Congrats! You won");
        System.out.println("\n Do you want to play again?");
        String s = scanner.nextLine();
        s = s.toLowerCase();
        for(char c: s.toCharArray()){
            if(c == 'y'){
                setup();
            }
            else if(c == 'n'){
                System.out.println("Goodbye");
                System.exit(0);
            }

        }
        System.out.println("Goodbye");
        System.exit(0);
    }
    //Restarts the game if the computer has no cards left
    public static void comWon(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("LOSER you lost. Do you want to play again?");
        String s = scanner.nextLine();
        s = s.toLowerCase();
        for(char c: s.toCharArray()){
            if(c == 'y'){
                setup();
            }
            else if(c == 'n'){
                System.out.println("Goodbye");
                System.exit(0);
            }

        }
        System.out.println("Goodbye");
        System.exit(0);

    }




}


