package _0005palindromic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LongestPalindromicSubstringTest {

    private String[] inputNumbers = new String[]{
            "babad",
            "cbbd",
    };
    private String[][] outputResult = new String[][]{
            {"bab", "aba"},
            {"bb"}
    };

    @Test
    void longestPalindrome1Test() {
        LongestPalindromicSubstring target = new LongestPalindromicSubstring();
        for (int i = 0; i < inputNumbers.length; i++) {
            boolean isOk = false;
            for (int j = 0; j < outputResult[i].length; j++) {
                isOk |= outputResult[i][j].equals(target.longestPalindrome1(inputNumbers[i]));
            }
            assertTrue(isOk);
        }
    }

}