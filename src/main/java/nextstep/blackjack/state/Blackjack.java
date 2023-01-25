package nextstep.blackjack.state;

import nextstep.blackjack.Cards;

public class Blackjack extends Finished {

    public Blackjack(Cards cards) {
        super(cards);
    }

    @Override
    double earningRate() {
        return 1.5;
    }
}
