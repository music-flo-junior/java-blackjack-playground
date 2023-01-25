package nextstep.blackjack.state;

import nextstep.blackjack.Cards;

public class Stay extends Finished {

    protected Stay(Cards cards) {
        super(cards);
    }

    @Override
    double earningRate() {
        return 1;
    }
}
