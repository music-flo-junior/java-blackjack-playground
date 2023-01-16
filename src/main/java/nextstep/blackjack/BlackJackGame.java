package nextstep.blackjack;

import java.util.List;

public class BlackJackGame {
    private final Gamblers gamblers;

    public BlackJackGame(List<Player> players) {
        this.gamblers = new Gamblers(new Dealer(), players);
    }

    public void play() {
        gamblers.getAllGamers().forEach(Gamer::initCard);
        OutputView.printInitInfo(gamblers.getPlayers(), gamblers.getDealer());
        gamblers.getPlayers().forEach(InputView::getMoreCard);
        OutputView.printGetMoreDealerCard(gamblers.getDealer());
        gamblers.getAllGamers().forEach(OutputView::printResultScore);
        gamblers.calculateTheResult();
        OutputView.printEarnedMoney(gamblers.getAllGamers());
    }


}
