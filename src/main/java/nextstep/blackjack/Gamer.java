package nextstep.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Gamer {
    private static final int INIT_CARD_COUNT = 2;
    private final CardDeck cardDeck;
    protected final List<Card> cardList;
    protected int point;
    protected int earnedMoney;

    protected Gamer() {
        this.cardList = new ArrayList<>();
        this.cardDeck = CardDeck.getInstance();
        this.point = 0;
        this.earnedMoney = 0;
    }

    protected Gamer(List<Card> cardList) {
        this.cardList = cardList;
        this.cardDeck = CardDeck.getInstance();
        this.point = cardList.stream().map(Card::getPoint).reduce(Integer::sum).orElse(0);
        this.earnedMoney = 0;
    }

    public void initCard() {
        for (int i = 0; i < INIT_CARD_COUNT; i++) {
            addCard();
        }
    }

    protected void addCard() {
        Card card = cardDeck.getRandomCard();
        this.cardList.add(card);
        this.point = point + card.getPoint();
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public String getCardNameList() {
        return cardList.stream()
                .map(Card::getName)
                .collect(Collectors.joining(", "));
    }

    public CardDeck getCardDeck() {
        return cardDeck;
    }

    public int getPoint() {
        return point;
    }

    protected abstract String getName();

    public int getEarnedMoney() {
        return earnedMoney;
    }

    public void setEarnedMoney(int earnedMoney) {
        this.earnedMoney = earnedMoney;
    }
}
