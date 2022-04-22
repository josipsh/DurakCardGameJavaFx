package hr.algebra.gameComponent.model;

public class Card {
    private CardRank cardRank;
    private CardSuit cardSuit;

    public String getCardFileName() {
        return cardRank.toString() + "_" + cardSuit.toString() + ".png";
    }
}
