package nextstep.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String Y = "y";
    private static final String N = "n";

    private InputView() {
    }

    public static List<Player> getPlayers() {
        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList<>();
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String[] names = scanner.nextLine().split(",");
        for (String name : names) {
            System.out.printf("%s의 배팅 금액은?%n", name);
            int betMoney = scanner.nextInt();
            players.add(new Player(name, betMoney));
        }
        return players;
    }

    public static void getMoreCard(Player player) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)\n", player.getName());
            String answer = scanner.nextLine();
            if (Y.equals(answer)) {
                player.addCard();
            } else if (N.equals(answer)) {
                break;
            } else {
                System.out.println("잘못된 값을 입력했습니다. 다시 입력해주세요.");
            }
            OutputView.printPlayerCardInfo(player);
        }
    }
}
