package blackjack.util;

import blackjack.person.Dealer;
import blackjack.person.Gamer;

import java.util.List;

public class OutputView {

    public static void printInitCard(Dealer dealer, List<Gamer> gamers) {
        dealer.printCardsWithResult();
        gamers.forEach(Gamer::printCardsWithResult);
    }

    public static void printInitCard(Gamer gamer) {
        gamer.printCards();
    }

    public static void printResultCard(Dealer dealer, List<Gamer> gamers) {
        dealer.printCards();
        gamers.forEach(Gamer::printCardsWithResult);
    }

    public static void printFinalProfit(List<Gamer> gamers) {
        gamers.forEach(Gamer::printBettingMoney);
    }
}
