package nextstep.blackjack;

import java.util.List;

public class Player extends Gamer {
    private final String name;
    private final int betMoney;

    public Player(String name, int betMoney) {
        this.name = name;
        this.betMoney = betMoney;
    }

    public Player(String name, int betMoney, List<Card> cardList) {
        super(cardList);
        this.name = name;
        this.betMoney = betMoney;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getBetMoney() {
        return betMoney;
    }

}
