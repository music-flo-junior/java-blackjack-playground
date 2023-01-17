package nextstep.blackjack;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2023/01/15
 */
public class BlackJackUser extends BlackJackPlayer {

    public BlackJackUser(String name, int amount) {
        super(name, amount);
        this.blackJackCards = new BlackJackCards();
    }

    public String getName() {
        return name;
    }

    public void addCard(BlackJackCard card) {
        blackJackCards.addCard(card);
        addSelectCount();
    }

}
