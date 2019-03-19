package jacobvv._0005palindromic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LongestPalindromicSubstringTest {

    private String[] inputs = new String[]{
            "babad",
            "cbbd",
    };
    private String[][] outputs = new String[][]{
            {"bab", "aba"},
            {"bb"}
    };

    @Test
    void longestPalindrome1Test() {
        LongestPalindromicSubstring target = new LongestPalindromicSubstring();
        for (int i = 0; i < inputs.length; i++) {
            boolean isOk = false;
            for (int j = 0; j < outputs[i].length; j++) {
                isOk |= outputs[i][j].equals(target.longestPalindrome1(inputs[i]));
            }
            assertTrue(isOk);
        }
    }

}