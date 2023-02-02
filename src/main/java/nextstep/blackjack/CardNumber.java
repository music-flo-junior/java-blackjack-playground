package nextstep.blackjack;

public enum CardNumber {
    ACE("A", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEM("10", 10),
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10);

    private final int score;
    private final String name;

    CardNumber(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public boolean isAce() {
        return this == ACE;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
