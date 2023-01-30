package blackjack.person;

import blackjack.card.Card;

import java.util.List;
import java.util.stream.Collectors;

public class Dealer {
    private final int DEALER_MIN_NUM = 17;
    private List<Card> cards;
    private int point;
    private String name = "딜러";
    private double bettingMoney; // TODO : 더 좋은 이름 없을까?

    public String getName() {
        return this.name;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
        this.point = cards.stream().map(Card::getPoint).reduce(Integer::sum).orElse(0);
    }

    public int getPoint() {
        return point;
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

    public boolean isIssueCard() {
        // 딜러는 처음에 받은 2 장의 합계가 16 이하이면 반드시 1 장의 카드를 추가로 받아야 하고, 17 점 이상이면 추가로 받을 수 없다.
        return this.point < DEALER_MIN_NUM;
    }

}
