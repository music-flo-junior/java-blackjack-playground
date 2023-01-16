package nextstep.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Gamblers {
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

    public void calculateTheResult() {
        // 결과 계산해서 각 도박꾼들한테 돈넣어주기
        

    }

}
