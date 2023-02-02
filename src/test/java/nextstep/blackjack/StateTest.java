package nextstep.blackjack;

import nextstep.blackjack.state.Hit;
import nextstep.blackjack.state.State;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class StateTest {

    @Test
    @DisplayName("버스트된 경우")
    void testState() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(Shape.SPADE, CardNumber.KING));
        cardList.add(new Card(Shape.CLOVER, CardNumber.SEVEN));

        State state = new Hit(new Cards(cardList));
        System.out.println(state.cards().toString());
        Assertions.assertThat(state.cards().getPoint()).isEqualTo(17);
        State state2 = state.draw(new Card(Shape.DIAMOND, CardNumber.KING));
        Assertions.assertThat(state2.isFinished()).isTrue();
        Assertions.assertThat(state2.profit(10000)).isEqualTo(-10000);
        Assertions.assertThat(state2.cards().getPoint()).isEqualTo(27);
    }

    @Test
    @DisplayName("블랙잭인 경우")
    void testState2() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card(Shape.SPADE, CardNumber.KING));
        cardList.add(new Card(Shape.CLOVER, CardNumber.ACE));
        State state = new Hit(new Cards(cardList));
        State resultState = state.stay();
        System.out.println(resultState.cards().toString());
        Assertions.assertThat(resultState.cards().getPoint()).isEqualTo(21);
        Assertions.assertThat(resultState.isFinished()).isTrue();
        Assertions.assertThat(resultState.profit(10000)).isEqualTo(15000);
    }
    
}
