package nextstep.blackjack;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2023/01/15
 */
public class BlackJackInputAndOutputView {

    private static final Scanner scanner = new Scanner(System.in);

    public List<String> getUserNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String input = scanner.nextLine();
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<BlackJackUser> getBlackJackUsers(List<String> names) {
        return names.stream()
                .map(name -> {
                    System.out.printf("%s의 배팅 금액은?%n", name);
                    return new BlackJackUser(name, scanner.nextInt());
                })
                .collect(Collectors.toList());
    }

    public void printPlayersCard(List<BlackJackPlayer> players) {
        players.forEach(this::printPlayerCard);
    }

    public void printPlayersCardWithResult(List<BlackJackPlayer> players) {
        players.forEach(this::printPlayerCardWithResult);
    }

    public void printAddCardForDealer() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void printAddCardQuestion(BlackJackPlayer player) {
        System.out.printf("%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)", player.name);
    }

    public boolean isOk() {
        return "Y".equalsIgnoreCase(scanner.next());
    }

    private void printPlayerCardWithResult(BlackJackPlayer player) {
        String cardsString = player.blackJackCards.getCardsString() + "- 결과: " + player.blackJackCards.getCardsResultString();
        System.out.printf("%s: %s %n", player.name, cardsString);
    }

    public void printTotalRevenue(Map<String, Integer> parameterMap) {
        System.out.println("## 최종 수익");
        parameterMap
                .forEach((name, amount) -> {
                    System.out.printf("%s: %d %n", name, amount);
                });
    }

    public void printPlayerCard(BlackJackPlayer player) {
        String cardsString = player.blackJackCards.getCardsString();
        System.out.printf("%s: %s %n", player.name, cardsString);
    }

    public void printf(String format, Object... args) {
        System.out.printf(format, args);
    }
}
