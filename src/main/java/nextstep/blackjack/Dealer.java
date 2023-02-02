package nextstep.blackjack;

import java.util.List;

public class Dealer extends Gamer {
    private static final int GET_MORE_LIMIT_POINT = 16;

    public Dealer() {
    }

    public Dealer(List<Card> cardList) {
        super(cardList);
    }

    @Override
    public String getName() {
        return "딜러";
    }

    public boolean isNeedGetMoreCard() {
        return getPoint() <= GET_MORE_LIMIT_POINT;
    }
}
