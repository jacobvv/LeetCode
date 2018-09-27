package _0004mediansortedarrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianSortedArraysTest {

    private int[][][] inputNumbers = new int[][][]{
            {{1,3},{2}},
            {{1, 2}, {3, 4}},
    };
    private double[] outputResult = new double[]{2.0, 2.5};

    @Test
    void twoSum1Test() {
        for (int i = 0; i < inputNumbers.length; i++) {
            assertEquals(outputResult[i],
                    new MedianSortedArrays().findMedianSortedArrays1(inputNumbers[i][0], inputNumbers[i][1]));
        }
    }

    @Test
    void twoSum2Test() {
        for (int i = 0; i < inputNumbers.length; i++) {
            assertEquals(outputResult[i],
                    new MedianSortedArrays().findMedianSortedArrays2(inputNumbers[i][0], inputNumbers[i][1]));
        }
    }

}