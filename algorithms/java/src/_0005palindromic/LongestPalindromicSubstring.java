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

package _0005palindromic;

public class LongestPalindromicSubstring {

    private boolean isPalindromic(String s) {
        int len = s.length();
        int i = 0, j = len - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public String longestPalindrome1(String s) {
        // 暴力法
        // 从最大的子串开始，遍历所有的子串，检查是否是回文子串。
        // 这是最笨的方法，也是耗时最长的方法。
        // 时间复杂度O(n^3)，空间复杂度O(1)
        int len = s.length();
        for (int i = len; i > 0; i--) {
            for (int j = 0; j < len - i + 1; j++) {
                String substring = s.substring(j, j + i);
                if (isPalindromic(substring)) {
                    return substring;
                }
            }
        }
        return null;
    }

}
