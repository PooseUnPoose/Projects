package TermProject;
public class RandomCard{

    public static String CardSuit() {
        double SuitDouble = Math.random()*4+1;
        int Suit = (int)SuitDouble;
        String CardSuit = "";
        switch (Suit) {
            case 1:
                CardSuit="S";
                break;
            case 2:
                CardSuit="C";
                break;
            case 3:
                CardSuit="H";
                break;
            case 4:
                CardSuit="D";
                break;
        }
        return CardSuit;
    }
    public static String CardValue(){
        String CardFace="";
        double CardDouble = Math.random()*13+1;
        int CardNum = (int)CardDouble;
        switch (CardNum) {
            case 1:
                CardFace = "A";
                break;
            case 11:
                CardFace = "J";
                break;
            case 12:
                CardFace = "Q";
                break;
            case 13:
                CardFace = "K";
                break;
            default:
                CardFace = CardNum+"";
                break;
        }
        return CardFace;
    }
}

