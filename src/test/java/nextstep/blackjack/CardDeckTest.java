package nextstep.blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CardDeckTest {

    @Test
    void createCardDeckTest() {
        CardDeck cardDeck = CardDeck.getInstance();
        Assertions.assertThat(cardDeck.getCardListSize()).isEqualTo(4 * 12);

        while (cardDeck.getCardListSize() > 0) {
            System.out.println(cardDeck.getRandomCard().getName());
        }

    }
}
