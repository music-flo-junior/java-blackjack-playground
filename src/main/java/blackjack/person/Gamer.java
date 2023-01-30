package blackjack.person;

import blackjack.card.Card;

import java.util.List;
import java.util.stream.Collectors;

public class Gamer {
    private static final int BLACKJACK_POINT = 21;
    private List<Card> cards;
    private int point;
    private String name;
    private double bettingMoney; // TODO : 더 좋은 이름 없을까?

    public Gamer(String name, int bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
        this.point = cards.stream().map(Card::getPoint).reduce(Integer::sum).orElse(0);
    }


    public String getName() {
        return this.name;
    }

    public int getPoint() {
        return point;
    }

    public void setBettingMoney(double bettingMoney) {
        this.bettingMoney = bettingMoney;
    }

    public double getBettingMoney() {
        return bettingMoney;
    }

    public String getCardNameList() {
        return cards.stream()
                .map(Card::getCardName)
                .collect(Collectors.joining(", "));
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void printCards() {
        System.out.println(this.name + " 카드 : " + this.getCardNameList());
    }

    public void printCardsWithResult() {
        System.out.println(this.name + " 카드 : " + this.getCardNameList() + " - 결과 : " + this.point);
    }

    public static int getBlackJackBetweenCount(Gamer gamer) {
        return BLACKJACK_POINT - gamer.getPoint();
    }

    public void printBettingMoney() {
        System.out.println(this.name + " : " + (int) Math.round(this.getBettingMoney()));
    }

    public boolean isIssueCard() {
        return this.point < BLACKJACK_POINT;
    }
}
