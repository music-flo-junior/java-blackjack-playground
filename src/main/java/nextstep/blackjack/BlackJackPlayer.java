package nextstep.blackjack;

import java.math.BigDecimal;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2023/01/16
 */
public abstract class BlackJackPlayer {

    protected String name;

    protected int selectCount;

    protected int amount;

    protected BlackJackCards blackJackCards;

    protected BlackJackPlayer(String name, int amount) {
        this.name = name;
        this.amount = amount;
        this.selectCount = 0;
        this.blackJackCards = new BlackJackCards();
    }

    public String getName() {
        return name;
    }

    public boolean isLessEqualsThen16() {
        return blackJackCards.getResult() <= 16;
    }

    public boolean isGreaterThen21() {
        return blackJackCards.getResult() > 21;
    }

    public int getResult() {
        return blackJackCards.getResult();
    }

    public void lostAll() {
        this.amount = 0;
    }

    public boolean isBlackJack() {
        return selectCount == 2 && blackJackCards.getResult() > 21;
    }

    public int getWin1_5Amount() {
        return new BigDecimal(amount).multiply(new BigDecimal("1.5")).intValue();
    }

    public int getAmount() {
        return amount;
    }

    public void addAmount(int amount) {
        this.amount += amount ;
    }

    public void addSelectCount() {
        selectCount++;
    }
}
