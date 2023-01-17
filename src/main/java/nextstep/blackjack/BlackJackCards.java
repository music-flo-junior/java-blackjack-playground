package nextstep.blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2023/01/15
 */
public class BlackJackCards {

    private final List<BlackJackCard> cards;

    public BlackJackCards() {
        this.cards = new ArrayList<>();
    }

    public void addCard(BlackJackCard card) {
        cards.add(card);
    }

    public String getCardsString() {
        return cards.stream()
                .map(card -> card.getContent() + card.getShape())
                .collect(Collectors.joining(", "));
    }

    public String getCardsResultString() {
        return String.valueOf(getResult());
    }

    public int getResult() {
        int sum = 0;
        for (BlackJackCard card : cards) {
            int value = card.getContentValue();
            if (sum < 11 && value == 1) {
                sum += 11;
                continue;
            }
            sum += value;
        }
        return sum;
    }
}
