package nextstep.blackjack.state;

import nextstep.blackjack.Card;
import nextstep.blackjack.Cards;

public abstract class Finished extends Started {

    protected Finished(Cards cards) {
        super(cards);
    }

    @Override
    public State draw(final Card card) {
        throw new IllegalStateException("게임이 종료되어 카드를 뽑을 수 없습니다.");
    }

    @Override
    public State stay() {
        return this;
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public double profit(double money) {
        return earningRate() * money;
    }

    abstract double earningRate();
}
