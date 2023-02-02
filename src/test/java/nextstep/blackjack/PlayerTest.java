package nextstep.blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void createPlayerTest() {
        Player player = new Player("pobi", 10000);
        Assertions.assertThat(player.getBetMoney()).isEqualTo(10000);
        Assertions.assertThat(player.getName()).isEqualTo("pobi");
        Assertions.assertThat(player.getCardList()).isEmpty();
        player.initCard();
        Assertions.assertThat(player.getCardList()).hasSize(2);
    }
}
