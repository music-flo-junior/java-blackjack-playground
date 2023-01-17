package nextstep.blackjack;

import java.util.List;

public class BlackJackApplication {
    public static void main(String[] args) {
        List<Player> players = InputView.getPlayers();
        BlackJackGame blackJackGame = new BlackJackGame(players);
        blackJackGame.play();
    }
}
