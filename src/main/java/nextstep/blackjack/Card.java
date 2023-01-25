package nextstep.blackjack;

public class Card {
    private final Shape shape;
    private final CardNumber number;

    public Card(Shape shape, CardNumber number) {
        this.shape = shape;
        this.number = number;
    }

    public String getName() {
        return number.getName() + shape.getName();
    }

    @Override
    public String toString() {
        return "Card{" +
                "shape=" + shape +
                ", number=" + number +
                '}';
    }

    public int getPoint() {
        return number.getScore();
    }

    public boolean isAce() {
        return number.isAce();
    }

    public boolean isNotAce() {
        return !isAce();
    }
}
