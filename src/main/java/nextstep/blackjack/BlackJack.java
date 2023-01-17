package nextstep.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2023/01/15
 */
public class BlackJack {

    private final BlackJackDealer blackJackDealer;

    private final List<BlackJackUser> blackJackUsers;

    private final BlackJackInputAndOutputView blackJackInputAndOutputView;

    public BlackJack(BlackJackDealer blackJackDealer,
                     List<BlackJackUser> blackJackUsers,
                     BlackJackInputAndOutputView blackJackInputAndOutputView) {
        this.blackJackDealer = blackJackDealer;
        this.blackJackUsers = blackJackUsers;
        this.blackJackInputAndOutputView = blackJackInputAndOutputView;
    }

    public void gameStart() {

        BlackJackStatistics blackJackStatistics = new BlackJackStatistics(getAllPlayer());
        String stringNames = getNamesString();

        blackJackInputAndOutputView.printf("%s에게 2장의 나누었습니다. \n",stringNames);

        for (int i = 0; i < 2; i++) {
            blackJackDealer.addCardToMe();
            addCardToAllUser();
        }
        blackJackInputAndOutputView.printPlayersCard(getAllPlayer());

        blackJackUsers.forEach(this::suggestAndAddCard);

        if (blackJackDealer.isLessEqualsThen16()) {
            blackJackInputAndOutputView.printAddCardForDealer();
            blackJackDealer.addCardToMe();
        }

        blackJackInputAndOutputView.printPlayersCardWithResult(getAllPlayer());
        blackJackDealer.settleAmount(blackJackUsers);

        Map<String,Integer> statisticsMap = blackJackStatistics.compareStatistics(getAllPlayer());
        blackJackInputAndOutputView.printTotalRevenue(statisticsMap);
    }

    private void suggestAndAddCard(BlackJackUser user) {
        blackJackInputAndOutputView.printAddCardQuestion(user);
        while (blackJackInputAndOutputView.isOk()) {
            user.addCard(blackJackDealer.shuffleAndGive());
            blackJackInputAndOutputView.printAddCardQuestion(user);
        }
        blackJackInputAndOutputView.printPlayerCard(user);
    }

    private String getNamesString() {
        String userStringNames = blackJackUsers.stream()
                .map(BlackJackUser::getName)
                .collect(Collectors.joining(","));
        return blackJackDealer.name + "와 " + userStringNames;
    }

    private List<BlackJackPlayer> getAllPlayer() {
        List<BlackJackPlayer> players = new ArrayList<>();
        players.add(blackJackDealer);
        players.addAll(blackJackUsers);
        return players;
    }

    private void addCardToAllUser() {
        blackJackUsers
                .forEach(user -> user.addCard(blackJackDealer.shuffleAndGive()));
    }
}
