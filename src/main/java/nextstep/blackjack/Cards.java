package nextstep.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cards {
    private final List<Card> cardList;

    public Cards(List<Card> cardList) {
        if (cardList != null) {
            this.cardList = cardList;
            return;
        }
        this.cardList = new ArrayList<>();
    }

    public int getSize() {
        return this.cardList.size();
    }

    public Card remove(int index) {
        return cardList.remove(index);
    }

    public void add(Card card) {
        this.cardList.add(card);
    }

    /**
     * 카드의 총합이 21이 넘는 경우
     */
    public boolean isBust() {
        return getPoint() > 21;
    }

    public int getPoint() {
        int point = getSumPoint(cardList.stream().filter(Card::isNotAce).collect(Collectors.toList()));
        if (isIncludeAce()) {
            int aceCount = (int) cardList.stream().filter(Card::isAce).count();
            for (int i = 0; i < aceCount; i++) {
                if (point <= 10) {
                    point = point + 11;
                    continue;
                }
                point = point + 1;
            }
        }
        return point;
    }

    private int getSumPoint(List<Card> cardList) {
        return cardList.stream()
                .map(Card::getPoint)
                .reduce(0, Integer::sum);
    }

    @Override
    public String toString() {
        return "Cards{" +
                "cardList=" + cardList +
                '}';
    }

    public boolean isBlackjack() {
        return getSize() == 2 && getPoint() == 21 && isIncludeAce();
    }

    private boolean isIncludeAce() {
        return this.cardList.stream().anyMatch(Card::isAce);
    }

    public String getName() {
        return this.cardList.stream()
                .map(Card::getName)
                .collect(Collectors.joining(", "));
    }
}
