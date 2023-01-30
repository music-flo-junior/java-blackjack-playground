package blackjack.card;

import blackjack.type.Denomination;
import blackjack.type.Suit;

public class Card {
    private Suit suit;
    private Denomination denomination;

    public Card(Denomination denomination, Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public String getCardName() {
        return denomination.getDisplayName() + suit.toString();
    }

    public int getPoint() {
        return this.denomination.getPoint();
    }
}
