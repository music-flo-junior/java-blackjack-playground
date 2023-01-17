package nextstep.blackjack;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2023/01/16
 */
public class BlackJackStatistics {

    private final Map<String, Integer> blackJackUserAmountMap;

    public BlackJackStatistics(List<BlackJackPlayer> players) {
        blackJackUserAmountMap = players.stream().collect(Collectors.toMap(BlackJackPlayer::getName, BlackJackPlayer::getAmount));
    }

    public Map<String, Integer> compareStatistics(List<BlackJackPlayer> currentPlayers) {
        currentPlayers
                .forEach(user -> {
                    int amount = user.getAmount() - blackJackUserAmountMap.get(user.name);
                    blackJackUserAmountMap.put(user.name, amount);
                });
        return blackJackUserAmountMap;
    }
}
