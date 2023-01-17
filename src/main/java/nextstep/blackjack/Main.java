package nextstep.blackjack;

import java.util.List;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2023/01/15
 */
public class Main {

    public static void main(String[] args) {
        BlackJackInputAndOutputView inputAndOutput = new BlackJackInputAndOutputView();
        List<String> userNames = inputAndOutput.getUserNames();
        List<BlackJackUser> users = inputAndOutput.getBlackJackUsers(userNames);

        BlackJackDealer blackJackDealer = new BlackJackDealer();
        BlackJack blackJack = new BlackJack(blackJackDealer, users, inputAndOutput);
        blackJack.gameStart();
    }
}
