package nextstep.blackjack.state;

import nextstep.blackjack.Cards;

public class Bust extends Finished {

    public Bust(Cards cards) {
        super(cards);
    }

    @Override
    double earningRate() {
        return -1;
    }
}
