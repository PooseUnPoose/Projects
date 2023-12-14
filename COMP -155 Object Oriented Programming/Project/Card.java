package TermProject;
public class Card {
    private static String[] GeneratedCards = new String[52];
    private String CardSuit;
    private String CardNumber;
    private String CardFace;

    public Card() {
        GenerateUniqueCard();
        this.CardFace = CardNumber + CardSuit;
    }

    private void GenerateUniqueCard() {
        do {
            this.CardSuit = RandomCard.CardSuit();
            this.CardNumber = RandomCard.CardValue();
        } while (ContainsCard(GeneratedCards, CardSuit + CardNumber));

        AddCard(GeneratedCards, CardSuit + CardNumber);
    }

    private boolean ContainsCard(String[] Cards, String card) {
        for (String GenCard : Cards) {
            if (GenCard != null && GenCard.equals(card)) {
                return true;
            }
        }
        return false;
    }

    private void AddCard(String[] Cards, String card) {
        for (int i = 0; i < Cards.length; i++) {
            if (Cards[i] == null) {
                Cards[i] = card;
                break;
            }
        }
    }

    public String GetCardImage() {
        String cardImage = "TermProject/Cards/" + CardFace + ".jpg";
        return cardImage;
    }

    public int GetCardValue() {
        int cardValue;
        switch (CardNumber) {
            case "A":
                cardValue = 1;
                break;
            case "J":
                cardValue = 11;
                break;
            case "Q":
                cardValue = 12;
                break;
            case "K":
                cardValue = 13;
                break;
            default:
                cardValue = Integer.parseInt(CardNumber);
                break;
        }
        return cardValue;
    }

    @Override
    public String toString() {
        return CardFace;
    }
}
