package nextstep.blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2023/01/15
 */
class BlackJackDealerTest {

    @Test
    @DisplayName("딜러의 셔플 후 건네기 테스트")
    void shuffleAndGiveTest() {
        BlackJackDealer blackJackDealer = new BlackJackDealer();
        blackJackDealer.shuffleAndGive();
        // 무슨 테스트 메소드?
    }

    @DisplayName("문향 가져오기 테스트")
    @RepeatedTest(10)
    void shuffleShapeTest() {
        BlackJackDealer blackJackDealer = new BlackJackDealer();
        Method method = ReflectionUtils.findMethod(BlackJackDealer.class, "shuffleShape")
                .orElseThrow(() -> new RuntimeException("메소드 없음"));
        String result = (String) ReflectionUtils.invokeMethod(method, blackJackDealer);
        assertThat(List.of("하트", "다이아몬드", "스페이스", "클로바")).contains(result);
    }

    @DisplayName("문향 가져오기 테스트")
    @RepeatedTest(30)
    void shuffleContentTest() {
        BlackJackDealer blackJackDealer = new BlackJackDealer();
        Method method = ReflectionUtils.findMethod(BlackJackDealer.class, "shuffleContent")
                .orElseThrow(() -> new RuntimeException("메소드 없음"));
        String result = (String) ReflectionUtils.invokeMethod(method, blackJackDealer);
        assertThat(List.of("A","2","3","4","5","6","7","8","9","10","J","Q","K")).contains(result);
    }
}
