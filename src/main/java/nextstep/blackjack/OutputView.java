package nextstep.blackjack;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printInitInfo(List<Player> players, Dealer dealer) {
        String playerNames = players.stream().map(Player::getName).collect(Collectors.joining(","));
        System.out.printf("딜러와 %s에게 2장의 카드를 나누었습니다.\n", playerNames);
        System.out.printf("%s: %s\n", dealer.getName(), dealer.getCardNameList());
        for (Player player : players) {
            System.out.printf("%s: %s\n", player.getName(), player.getCardNameList());
        }
    }

    public static void printGamerCardInfo(Gamer gamer) {
        System.out.printf("%s 카드: %s\n", gamer.getName(), gamer.getCardNameList());
    }

    public static void printResultScore(Gamer gamer) {
        System.out.printf("%s 카드: %s - 결과:%d\n", gamer.getName(), gamer.getCardNameList(), gamer.getPoint());
    }

    public static void printEarnedMoney(List<Gamer> gamers) {
        System.out.println("## 최종 수익\n");
        for (Gamer gamer : gamers) {
            System.out.printf("%s : %d\n", gamer.getName(), gamer.getEarnedMoney());
        }
    }

    public static void printGetMoreDealerCard(Dealer dealer) {
        if (dealer.isNeedGetMoreCard()) {
            dealer.addCard();
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        }
    }
}
