package blackjack;

import blackjack.person.Dealer;
import blackjack.person.Gamer;
import blackjack.util.InputView;

import java.util.List;

public class BlackJackApplication {
    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        List<Gamer> gamers = InputView.scanGamers();
        BlackJackGame blackJackGame = new BlackJackGame();
        blackJackGame.start(dealer, gamers);
    }
}