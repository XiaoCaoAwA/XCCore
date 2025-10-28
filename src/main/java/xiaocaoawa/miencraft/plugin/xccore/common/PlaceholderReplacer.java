package xiaocaoawa.miencraft.plugin.xccore.common;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 字符串占位符替换工具类
 * <p>
 * 提供在字符串和字符串列表中替换占位符的功能。
 * 占位符格式为 {key}，将被映射中对应的值替换。
 * </p>
 *
 * @author langle__
 * @version 1.0
 */
public class PlaceholderReplacer {

    private PlaceholderReplacer() {}

    /**
     * 替换单个字符串中的占位符
     * <p>
     * 将输入字符串中的所有 {key} 格式的占位符替换为映射中对应的值。
     * 如果输入字符串为 null，则返回空字符串。
     * 如果输入字符串中不包含占位符，则直接返回原字符串。
     * </p>
     *
     * @param input        包含占位符的输入字符串，可以为 null
     * @param placeholders 占位符键值对映射，键为占位符名称(不包括花括号)，值为替换内容
     * @return 替换占位符后的字符串，如果输入为 null 则返回空字符串
     */
    @NotNull
    public static String replaceInString(@NotNull String input, @NotNull Map<String, String> placeholders) {
        if (!input.matches(".*\\{.+}.*") || placeholders.isEmpty()) return input;
        String result = input;
        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null) continue;
            result = result.replace("{" + key + "}", value);
        }
        return result;
    }

    /**
     * 替换字符串列表中的占位符
     * <p>
     * 对列表中的每个字符串执行占位符替换操作。
     * 如果输入列表为 null，则返回空列表。
     * </p>
     *
     * @param inputList    包含占位符的字符串列表，可以为 null
     * @param placeholders 占位符键值对映射，键为占位符名称(不包括花括号)，值为替换内容
     * @return 替换占位符后的字符串列表，如果输入为 null 则返回空列表
     */
    @NotNull
    public static List<String> replaceInList(@NotNull List<String> inputList, @NotNull Map<String, String> placeholders) {
        if (placeholders.isEmpty()) return inputList;
        List<String> result = new ArrayList<>();
        for (String line : inputList) {
            result.add(replaceInString(line, placeholders));
        }
        return result;
    }

}
