package blackjack;

import blackjack.card.CardDeck;
import blackjack.person.Dealer;
import blackjack.person.Gamer;
import blackjack.util.InputView;
import blackjack.util.OutputView;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BlackJackGame {
    private static final int BLACKJACK_POINT = 21;
    private static final CardDeck cardDeck = new CardDeck();

    public void start(Dealer dealer, List<Gamer> gamers) {
        drawCard(dealer, gamers);
        System.out.println(dealer.getName() + "와 " + getGamerNames(gamers) + "에게 2장의 나누었습니다.");
        OutputView.printInitCard(dealer, gamers);

        if (isNotStay(dealer, gamers)) {

            calculateBettingMoney(dealer, gamers);
            // 힛(Hit): 처음 2장의 상태에서 카드를 더 뽑는 것
            // 이거 굳이 객체지향으로 빼야할까? 생각...!
            hit(dealer, gamers);
            OutputView.printResultCard(dealer, gamers);
            calculateBettingMoney(gamers);
            OutputView.printFinalProfit(gamers);
        }
    }

    private String getGamerNames(List<Gamer> gamers) {
        return gamers.stream().map(Gamer::getName).collect(Collectors.joining(","));
    }

    private void hit(Dealer dealer, List<Gamer> gamers) {
        gamers.stream().filter(Gamer::isIssueCard).forEach(
                gamer -> InputView.checkIssueCard(gamer, cardDeck)
        );

        if (dealer.isIssueCard()) {
            dealer.addCard(cardDeck.draw());
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        }
    }

    private void drawCard(Dealer dealer, List<Gamer> gamers) {
        dealer.setCards(cardDeck.getInitCard());
        gamers.forEach(gamer -> gamer.setCards(cardDeck.getInitCard()));
    }

    private Gamer getNearlyBlackJackGamer(List<Gamer> gamers) {
        return gamers.stream().min(Comparator.comparing(Gamer::getBlackJackBetweenCount)).orElse(null);
    }

    private void calculateBettingMoney(Dealer dealer, List<Gamer> gamers) {
        // 21 을 초과할 경우 배팅 금액을 모두 잃게 된다.
        // 처음 두 장의 카드 합이 21 일 경우 블랙잭이 되면 베팅 금액의 1.5 배를 딜러에게 받는다.
        // 딜러와 플레이어가 모두 동시에 블랙잭인 경우 플레이어는 베팅한 금액을 돌려받는다.
        for (Gamer gamer : gamers) {
            if (isBust(gamer)) {
                gamer.setBettingMoney(-gamer.getBettingMoney());
            }
            if (gamer.getPoint() == BLACKJACK_POINT) {
                if (dealer.getPoint() == BLACKJACK_POINT) {
                    gamer.setBettingMoney(gamer.getBettingMoney());
                }
                gamer.setBettingMoney(gamer.getBettingMoney() + (gamer.getBettingMoney() * 1.5));
            }
        }
    }

    private void calculateBettingMoney(List<Gamer> gamers) {
        Gamer nearlyBlackJackGamer = getNearlyBlackJackGamer(gamers);
        for (Gamer gamer : gamers) {
            if (isBust(gamer)) {
                gamer.setBettingMoney(-gamer.getBettingMoney());
            }
            if (gamer.equals(nearlyBlackJackGamer)) {
                gamer.setBettingMoney(gamer.getBettingMoney());
            } else {
                gamer.setBettingMoney(-gamer.getBettingMoney());
            }
        }
    }

    // 스테이(Stay): 카드를 더 뽑지 않고 차례를 마치는 것
    private boolean isNotStay(Dealer dealer, List<Gamer> gamers) {
        if (isBust(dealer)) {
            gamers.forEach(gamer -> gamer.setBettingMoney(-gamer.getBettingMoney()));
            return false;
        }
        return true;
    }

    private boolean isBust(Gamer gamer) {
        return gamer.getPoint() > BLACKJACK_POINT;
    }

    private boolean isBust(Dealer dealer) {
        return dealer.getPoint() > BLACKJACK_POINT;
    }
}
