package nextstep.blackjack.state;

import nextstep.blackjack.Cards;

public abstract class Started implements State {

    protected final Cards cards;

    protected Started(Cards cards) {
        this.cards = cards;
    }

    @Override
    public Cards cards() {
        return cards;
    }
}
