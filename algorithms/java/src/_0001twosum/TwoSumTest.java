package _0001twosum;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TwoSumTest {

    private int[][] inputNumbers = new int[][]{
            {2, 7, 11, 15},
            {2, 7, 11, 15},
            {3, 2, 3}
    };
    private int[] inputTarget = new int[]{9, 10, 6};
    private int[][] outputResult = new int[][]{
            {0, 1},
            null,
            {0, 2}
    };

    @Test
    void twoSum1Test() {
        for (int i = 0; i < inputNumbers.length; i++) {
            assertArrayEquals(outputResult[i], new TwoSum().twoSum1(inputNumbers[i], inputTarget[i]));
        }
    }

    @Test
    void twoSum2Test() {
        for (int i = 0; i < inputNumbers.length; i++) {
            assertArrayEquals(outputResult[i], new TwoSum().twoSum2(inputNumbers[i], inputTarget[i]));
        }
    }

    @Test
    void twoSum3Test() {
        for (int i = 0; i < inputNumbers.length; i++) {
            assertArrayEquals(outputResult[i], new TwoSum().twoSum3(inputNumbers[i], inputTarget[i]));
        }
    }

    @Test
    void twoSum4Test() {
        for (int i = 0; i < inputNumbers.length; i++) {
            assertArrayEquals(outputResult[i], new TwoSum().twoSum4(inputNumbers[i], inputTarget[i]));
        }
    }

}