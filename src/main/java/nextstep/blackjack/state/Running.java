package nextstep.blackjack.state;

import nextstep.blackjack.Cards;

public abstract class Running extends Started {

    protected Running(Cards cards) {
        super(cards);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public double profit(double money) {
        return money;
    }
}
