package blackjack.util;

public class StringUtil {
    public static String[] splitToArray(String inputText, String splitStr) {
        return inputText.split(splitStr);
    }

    public static boolean isEmpty(String inputText) {
        return inputText == null || inputText.isEmpty();
    }
}
