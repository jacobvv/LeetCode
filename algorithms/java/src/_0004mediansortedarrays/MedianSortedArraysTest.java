package _0004mediansortedarrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianSortedArraysTest {

    private int[][][] inputs = new int[][][]{
            {{1,3},{2}},
            {{1, 2}, {3, 4}},
    };
    private double[] outputs = new double[]{2.0, 2.5};

    @Test
    void findMedianSortedArrays1Test() {
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(outputs[i],
                    new MedianSortedArrays().findMedianSortedArrays1(inputs[i][0], inputs[i][1]));
        }
    }

    @Test
    void findMedianSortedArrays2Test() {
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(outputs[i],
                    new MedianSortedArrays().findMedianSortedArrays2(inputs[i][0], inputs[i][1]));
        }
    }

}