package nextstep.blackjack;

import java.util.List;

public class BlackJackGame {
    private static final int BLACKJACK_POINT = 21;
    private final Gamblers gamblers;

    public BlackJackGame(List<Player> players) {
        this.gamblers = new Gamblers(new Dealer(), players);
    }

    public void play() {
        gamblers.getAllGamers().forEach(Gamer::initCard);
        OutputView.printInitInfo(gamblers.getPlayers(), gamblers.getDealer());
        if (checkPlayerBlackJackFirst(gamblers.getPlayers())) {
            OutputView.printEarnedMoney(gamblers.getAllGamers());
            return;
        }
        gamblers.getPlayers().forEach(InputView::getMoreCard);
        OutputView.printGetMoreDealerCard(gamblers.getDealer());
        if (checkDealerBlackJack(gamblers.getDealer(), gamblers.getPlayers())) {
            OutputView.printEarnedMoney(gamblers.getAllGamers());
            return;
        }
        gamblers.getPlayers().forEach(this::checkPlayerOverBlackJackPoint);
        gamblers.calculateTheResult();
        gamblers.getAllGamers().forEach(OutputView::printResultScore);
        OutputView.printEarnedMoney(gamblers.getAllGamers());
    }

    private boolean checkDealerBlackJack(Dealer dealer, List<Player> players) {
        if (dealer.getPoint() > BLACKJACK_POINT) {
            players.forEach(player -> player.setEarnedMoney(player.getEarnedMoney()));
            return true;
        }
        return false;
    }

    private boolean checkPlayerOverBlackJackPoint(Player player) {
        if (player.getPoint() > BLACKJACK_POINT) {
            player.setEarnedMoney(-player.getEarnedMoney());
            return true;
        }
        return false;
    }

    private boolean checkPlayerBlackJackFirst(List<Player> players) {
        boolean isExistBlackJackPlayer = false;
        for (Player player : players) {
            if (player.getPoint() == BLACKJACK_POINT) {
                player.setEarnedMoney((int) (player.getEarnedMoney() * 1.5));
                isExistBlackJackPlayer = true;
            }
        }
        return isExistBlackJackPlayer;
    }


}
