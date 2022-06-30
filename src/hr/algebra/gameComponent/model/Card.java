package hr.algebra.gameComponent.model;

public enum Card {
    THREE_CLUB(0, 13, 0),
    TWO_CLUB(1, 12, 0),
    ACE_CLUB(2, 11, 0),
    KING_CLUB(3, 10, 0),
    QUEEN_CLUB(4, 9, 0),
    JACK_CLUB(5, 8, 0),
    TEN_CLUB(6, 7, 0),
    NINE_CLUB(7, 6, 0),
    EIGHT_CLUB(8, 5, 0),
    SEVEN_CLUB(9, 4, 0),
    SIX_CLUB(10, 3, 0),
    FIVE_CLUB(11, 2, 0),
    FOUR_CLUB(12, 1, 0),

    THREE_DIAMOND(13, 13, 1),
    TWO_DIAMOND(14, 12, 1),
    ACE_DIAMOND(15, 11, 1),
    KING_DIAMOND(16, 10, 1),
    QUEEN_DIAMOND(17, 9, 1),
    JACK_DIAMOND(18, 8, 1),
    TEN_DIAMOND(19, 7, 1),
    NINE_DIAMOND(20, 6, 1),
    EIGHT_DIAMOND(21, 5, 1),
    SEVEN_DIAMOND(22, 4, 1),
    SIX_DIAMOND(23, 3, 1),
    FIVE_DIAMOND(24, 2, 1),
    FOUR_DIAMOND(25, 1, 1),

    THREE_HEART(26, 13, 2),
    TWO_HEART(27, 12, 2),
    ACE_HEART(28, 11, 2),
    KING_HEART(29, 10, 2),
    QUEEN_HEART(30, 9, 2),
    JACK_HEART(31, 8, 2),
    TEN_HEART(32, 7, 2),
    NINE_HEART(33, 6, 2),
    EIGHT_HEART(34, 5, 2),
    SEVEN_HEART(35, 4, 2),
    SIX_HEART(36, 3, 2),
    FIVE_HEART(37, 2, 2),
    FOUR_HEART(38, 1, 2),

    THREE_SPADE(39, 13, 3),
    TWO_SPADE(40, 12, 3),
    ACE_SPADE(41, 11, 3),
    KING_SPADE(42, 10, 3),
    QUEEN_SPADE(43, 9, 3),
    JACK_SPADE(44, 8, 3),
    TEN_SPADE(45, 7, 3),
    NINE_SPADE(46, 6, 3),
    EIGHT_SPADE(47, 5, 3),
    SEVEN_SPADE(48, 4, 3),
    SIX_SPADE(49, 3, 3),
    FIVE_SPADE(50, 2, 3),
    FOUR_SPADE(51, 1, 3);

    private final int value;
    private final int suit;
    private final int rank;

    Card(int value, int rank, int suit) {
        this.value = value;
        this.rank = rank;
        this.suit = suit;
    }

    public static Card getCardFromValue(int val) throws Exception {
        Card[] cards = Card.values();

        for (Card card : cards) {
            if (card.getValue() == val) {
                return card;
            }
        }

        throw new Exception("Val is out of range");
    }

    public int getValue() {
        return value;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public boolean isDefenseStronger(Card defenseCard, Card adutCard) {
        boolean isDefenseCardAdut = defenseCard.getSuit() == adutCard.getSuit();
        boolean isAttackCardAdut = suit == adutCard.getSuit();

        return isDefenseCardAdut && isAttackCardAdut && defenseCard.getRank() >= rank
            || !isDefenseCardAdut && !isAttackCardAdut && defenseCard.getRank() >= rank
            || isDefenseCardAdut && !isAttackCardAdut;
    }
}
