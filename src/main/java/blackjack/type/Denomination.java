package blackjack.type;

public enum Denomination {
    ACE(1, "A"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(10, "J"),
    QUEEN(10, "Q"),
    KING(10, "K"),
    NONE(0, "3");

    private final int point;
    private final String displayName;

    Denomination(int score, String displayName) {
        this.point = score;
        this.displayName = displayName;
    }

    public boolean isAce() {
        return this == ACE;
    }

    public int getPoint() {
        return point;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}