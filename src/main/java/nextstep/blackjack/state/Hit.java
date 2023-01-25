package nextstep.blackjack.state;

import nextstep.blackjack.Card;
import nextstep.blackjack.Cards;

public class Hit extends Running {
    public Hit(final Cards cards) {
        super(cards);
    }

    @Override
    public State draw(final Card card) {
        cards.add(card);
        if (cards.isBust()) {
            return new Bust(cards);
        }
        return new Hit(cards);
    }

    @Override
    public State stay() {
        if (cards.isBlackjack()) {
            return new Blackjack(cards);
        }
        return new Stay(cards);
    }
}
