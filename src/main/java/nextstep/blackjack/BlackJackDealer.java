package nextstep.blackjack;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2023/01/15
 */
public class BlackJackDealer extends BlackJackPlayer {

    private static final String NAME = "딜러";
    private static final List<String> SHAPE_PATTERN = List.of("하트", "다이아몬드", "스페이스", "클로바");
    private static final List<String> CONTENT_PATTERN = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");

    public BlackJackDealer() {
        super(NAME, 0);
    }

    public void addCardToMe() {
        blackJackCards.addCard(shuffleAndGive());
        addSelectCount();
    }

    public BlackJackCard shuffleAndGive() {
        return new BlackJackCard(shuffleShape(), shuffleContent());
    }

    public void settleAmount(List<BlackJackUser> blackJackUsers) {
        if (isGreaterThen21()) {
            blackJackUsers.forEach(user -> {
                int amount = user.getAmount();
                depositUser(user, amount);
            });
            return;
        }

        for (BlackJackUser user : blackJackUsers) {
            if (user.isGreaterThen21()) {
                addAmount(user.getAmount());
                user.lostAll();
                continue;
            }

            if (user.isBlackJack()) {
                if (isBlackJack()) {
                    continue;
                }
                int value = user.getWin1_5Amount();
                depositUser(user, value);
                continue;
            }

            if (user.getResult() == getResult()) {
                continue;
            }

            if (user.getResult() > getResult()) {
                int amount = user.getAmount();
                depositUser(user, amount);
                continue;
            }

            if (user.getResult() < getResult()) {
                int amount = user.getAmount();
                withdrawUser(user, amount);
            }

        }
    }

    private void depositUser(BlackJackUser user, int amount) {
        user.addAmount(amount);
        addAmount(amount * -1);
    }

    private void withdrawUser(BlackJackUser user, int amount) {
        addAmount(amount);
        user.addAmount(amount * -1);
    }

    private String shuffleShape() {
        int shapeRandomNumber = ThreadLocalRandom.current().nextInt(SHAPE_PATTERN.size());
        return SHAPE_PATTERN.get(shapeRandomNumber);
    }

    private String shuffleContent() {
        int contentRandomNumber = ThreadLocalRandom.current().nextInt(CONTENT_PATTERN.size());
        return CONTENT_PATTERN.get(contentRandomNumber);
    }
}
