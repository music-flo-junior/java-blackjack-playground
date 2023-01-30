package blackjack.card;

import blackjack.type.Denomination;
import blackjack.type.Suit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardDeck {
    private final int INIT_RECEIVE_CARD_COUNT = 2;
    private List<Card> cards;

    public CardDeck() {
        cards = new ArrayList<>();
        Arrays.stream(Suit.values()).forEach(
                suit -> Arrays.stream(Denomination.values()).forEach(
                        denomination -> cards.add(new Card(denomination, suit))
                )
        );
    }

    // 카드 뽑기
    public Card draw() {
        Card selectedCard = cards.get((int) (Math.random() * (cards.size() - 1)));
        cards.remove(selectedCard);
        return selectedCard;
    }

    public List<Card> getInitCard() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < INIT_RECEIVE_CARD_COUNT; i++) {
            cards.add(draw());
        }
        return cards;
    }

    public List<Card> getCards() {
        return cards;
    }
}
