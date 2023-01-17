package nextstep.blackjack;

import java.util.HashMap;
import java.util.Map;

/**
 * 설명:
 *
 * @author 최현범(Jayce) / hb.choi@dreamus.io
 * @since 2023/01/16
 */
public class BlackJackCard {

    private final String shape;
    private final String content;

    private static final Map<String, Integer> contentMap = new HashMap<>() {{
        put("a", 1);
        put("j", 10);
        put("q", 10);
        put("k", 10);
    }};

    public BlackJackCard(String shape, String content) {
        this.shape = shape;
        this.content = content;
    }

    public String getShape() {
        return shape;
    }

    public String getContent() {
        return content;
    }

    public int getContentValue() {
        if (NumberUtils.isNumeric(content)) {
            return Integer.parseInt(content);
        }
        return contentMap.get(content.toLowerCase());
    }
}
