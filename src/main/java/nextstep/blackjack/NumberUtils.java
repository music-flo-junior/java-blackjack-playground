package nextstep.blackjack;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2023/01/16
 */
public class NumberUtils {

    public static boolean isNumeric(String parameter) {
        try {
            Integer.parseInt(parameter);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }
}
