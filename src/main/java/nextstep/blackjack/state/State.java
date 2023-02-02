package nextstep.blackjack.state;

import nextstep.blackjack.Card;
import nextstep.blackjack.Cards;

public interface State {
    State draw(Card card);

    State stay();

    boolean isFinished();

    Cards cards();

    double profit(double money);

}
