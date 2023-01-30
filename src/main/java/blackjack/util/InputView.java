package blackjack.util;

import blackjack.card.CardDeck;
import blackjack.person.Gamer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static List<Gamer> scanGamers() {
        String[] gamerNameArr = scanGamerNames();
        List<Gamer> gamers = createGamerByNameArr(gamerNameArr);
        return gamers;
    }

    private static String[] scanGamerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String inputText = sc.nextLine();

        while (StringUtil.isEmpty(inputText)) {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("다시 입력해주세요 : ");
            inputText = sc.nextLine();
        }

        return StringUtil.splitToArray(inputText, ",");
    }

    private static List<Gamer> createGamerByNameArr(String[] gamerNameArr) {
        List<Gamer> gamers = new ArrayList<>(gamerNameArr.length);
        Arrays.stream(gamerNameArr).forEach(gamerName -> {
            System.out.println(gamerName + "의 배팅 금액은?");
            int inputInt = sc.nextInt();
            gamers.add(new Gamer(gamerName, inputInt));
        });
        return gamers;
    }

    public static void checkIssueCard(Gamer gamer, CardDeck cardDeck) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(gamer.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
            String answer = scanner.nextLine();
            if ("y".equals(answer)) {
                gamer.addCard(cardDeck.draw());
                break;
            } else if ("n".equals(answer)) {
                break;
            } else {
                System.out.println("잘못된 값을 입력했습니다. 다시 입력해주세요.");
            }
        }
        OutputView.printInitCard(gamer);
    }
}
