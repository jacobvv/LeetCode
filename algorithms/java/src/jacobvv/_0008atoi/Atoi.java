package jacobvv._0008atoi;

/**
 * Source: https://leetcode.com/problems/longest-palindromic-substring/
 * Source(zh): https://leetcode-cn.com/problems/longest-palindromic-substring/
 * Author: Jacob Yin
 * Date: 2018-09-27
 * <p>
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Atoi {

    public static final char[] DIGITAL = {'+', '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int atoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int i = 0;
        int result = 0;
        int sign = 1;
        boolean isStarted = false;
        while (i < s.length()) {
            char c = s.charAt(i);
            i++;
            if (!isStarted && (c == ' ' || c == '\t')) {
                continue;
            }
            if (c == '+' || c == '-') {
                if (isStarted) {
                    return result * sign;
                } else if (c == '-') {
                    sign = -1;
                }
                isStarted = true;
            } else if (Character.isDigit(c)) {
                isStarted = true;
                int current = Character.digit(c, 10);
                if (sign == -1) {
                    if ((Integer.MAX_VALUE - current) / 10 >= result) {
                        result = result * 10 + current;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if ((Integer.MAX_VALUE - current) / 10 >= result) {
                        result = result * 10 + current;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
            } else {
                return result * sign;
            }
        }
        return result * sign;
    }

}
