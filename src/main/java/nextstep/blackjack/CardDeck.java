package nextstep.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CardDeck {

    private static CardDeck instance;
    private static List<Card> cardList;

    private CardDeck() {
        cardList = settingTotalCardDeck();
    }

    private static List<Card> settingTotalCardDeck() {
        List<Card> cards = new ArrayList<>();
        for (Shape shape : Shape.values()) {
            for (CardNumber number : CardNumber.values()) {
                cards.add(new Card(shape, number));
            }
        }
        return cards;
    }

    public static CardDeck getInstance() {
        if (instance == null) {
            instance = new CardDeck();
        }
        return instance;
    }


    public Card getRandomCard() {
        Random random = ThreadLocalRandom.current();
        int randomIndex = random.nextInt(cardList.size());
        return cardList.remove(randomIndex);
    }

    public int getCardListSize() {
        if (cardList == null) {
            return 0;
        }
        return cardList.size();
    }

}
