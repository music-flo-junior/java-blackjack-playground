package nextstep.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Gamblers {
    private static final int BLACKJACK_POINT = 21;

    private final Dealer dealer;
    private final List<Player> players;
    private final List<Gamer> allGamers = new ArrayList<>();

    public Gamblers(Dealer dealer, List<Player> players) {
        this.dealer = dealer;
        this.players = players;
        setAllGamers();
    }

    public List<Gamer> getAllGamers() {
        return allGamers;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Player> getPlayers() {
        return players;
    }

    private void setAllGamers() {
        allGamers.add(dealer);
        allGamers.addAll(players);
    }

    /**
     * 결과 계산해서 각 도박꾼들한테 돈넣어주기
     * 처음 두 장의 카드 합이 21일 경우 블랙잭이 되면 베팅 금액의 1.5 배를 딜러에게 받는다.
     * 딜러와 플레이어가 모두 동시에 블랙잭인 경우 플레이어는 베팅한 금액을 돌려받는다.
     * 딜러가 21을 초과하면 그 시점까지 남아 있던 플레이어들은 가지고 있는 패에 상관 없이 승리해 베팅 금액을 받는다.
     * 단, 카드를 추가로 뽑아 21을 초과할 경우 배팅 금액을 모두 잃게 된다.
     */
    public void calculateTheResult() {
        int closedBlackJackPoint = dealer.getPoint();
        int closedBlackJackPointIndex = -1;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getEarnedMoney() != 0) {
                continue;
            }
            int playerPoint = players.get(i).getPoint();
            if (playerPoint <= BLACKJACK_POINT && playerPoint > closedBlackJackPoint) {
                closedBlackJackPointIndex = i;
                closedBlackJackPoint = playerPoint;
            }
        }
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getPoint() > BLACKJACK_POINT) {
                player.setEarnedMoney(-player.getBetMoney());
            }
            if (player.getEarnedMoney() != 0) {
                continue;
            }
            if (closedBlackJackPointIndex == i) {
                player.setEarnedMoney(player.getBetMoney());
                continue;
            }
            player.setEarnedMoney(-player.getBetMoney());
        }
    }
}
