package blackjack;

import blackjack.card.CardDeck;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardDeckTest {

    @Test
    void createCardDeckTest() {
        CardDeck cardDeck = new CardDeck();
        Assertions.assertThat(cardDeck.getCards().size()).isEqualTo(4 * 14);

        cardDeck.getCards().forEach(card -> System.out.println(card.getCardName()));

    }
}
