package nextstep.blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class GamblersTest {


    @Test
    void calculateGamblerTest() {
        List<Card> dealerCardList = Arrays.asList(
                new Card(Shape.DIAMOND, CardNumber.THREE),
                new Card(Shape.CLOVER, CardNumber.NINE),
                new Card(Shape.DIAMOND, CardNumber.EIGHT));

        List<Card> player1CardList = Arrays.asList(
                new Card(Shape.HEART, CardNumber.TWO),
                new Card(Shape.SPADE, CardNumber.EIGHT),
                new Card(Shape.CLOVER, CardNumber.ONE));

        List<Card> player2CardList = Arrays.asList(
                new Card(Shape.CLOVER, CardNumber.SEVEN),
                new Card(Shape.SPADE, CardNumber.KING));

        Dealer dealer = new Dealer(dealerCardList);
        Player player1 = new Player("pobi", 10000, player1CardList);
        Player player2 = new Player("jason", 20000, player2CardList);

        Assertions.assertThat(dealer.getPoint()).isEqualTo(20);
        Assertions.assertThat(player1.getPoint()).isEqualTo(21);
        Assertions.assertThat(player2.getPoint()).isEqualTo(17);

        Gamblers gamblers = new Gamblers(dealer, Arrays.asList(player1, player2));
        gamblers.calculateTheResult();

        Assertions.assertThat(dealer.getEarnedMoney()).isEqualTo(10000);
        Assertions.assertThat(player1.getEarnedMoney()).isEqualTo(10000);
        Assertions.assertThat(player2.getEarnedMoney()).isEqualTo(-20000);


    }
}
