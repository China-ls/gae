package weixin.popular.util;

import com.vdurmont.emoji.EmojiParser;

public class EmojiUtil {

    /**
     * 转换emoji <br>
     * Example: <code>🍀</code> 将转变为
     * <code>&amp;#x1f340;</code><br>
     *
     * @param emoji_str emoji_str
     * @return emoji_result
     */
    public static String parseToHtmlHexadecimal(String emoji_str) {
        return EmojiParser.parseToHtmlHexadecimal(emoji_str);
    }

    /**
     * 转换emoji <br>
     * Example: <code>🍀</code> 将转变为
     * &lt;span class='emoji emoji1f340'&gt;&lt;/span&gt;<br>
     *
     * @param emoji_str emoji_str
     * @return emoji_result
     */
    public static String parseToHtmlTag(String emoji_str) {
        if (emoji_str != null) {
            String str = EmojiParser.parseToHtmlHexadecimal(emoji_str);
            return htmlHexadecimalToHtmlTag(str);
        }
        return null;
    }

    /**
     * 转换emoji <br>
     * Example: <code>🍀</code> 将转变为
     * :four_leaf_clover:<br>
     *
     * @param emoji_str emoji_str
     * @return emoji_result
     */
    public static String parseToAliases(String emoji_str) {
        return EmojiParser.parseToAliases(emoji_str);
    }

    /**
     * @param emoji_str emoji_str
     * @return emoji_result
     */
    public static String parseToHtmlDecimal(String emoji_str) {
        return EmojiParser.parseToHtmlDecimal(emoji_str);
    }

    /**
     * 纯文本 删除表情
     *
     * @param emoji_str emoji_str
     * @return emoji_result
     */
    public static String removeAllEmojis(String emoji_str) {
        return EmojiParser.removeAllEmojis(emoji_str);
    }

    /**
     * @param emoji_str emoji_str
     * @return emoji_result
     */
    public static String htmlHexadecimalToHtmlTag(String emoji_str) {
        if (emoji_str != null) {
            return emoji_str.replaceAll("&#x([^;]*);", "<span class='emoji emoji$1'></span>");
        }
        return null;
    }

    /**
     * 解析emoji
     *
     * @param emoji_str emoji_str
     * @param type      0,1,2,3,4,5
     * @return emoji_result
     */
    public static String parse(String emoji_str, int type) {
        switch (type) {
            case 1:
                return parseToHtmlHexadecimal(emoji_str);
            case 2:
                return parseToHtmlTag(emoji_str);
            case 3:
                return parseToAliases(emoji_str);
            case 4:
                return parseToHtmlDecimal(emoji_str);
            case 5:
                return removeAllEmojis(emoji_str);
            default:
                return null;
        }
    }

}
