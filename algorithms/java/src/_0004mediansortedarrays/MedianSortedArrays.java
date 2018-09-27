/**
 * Source: https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Source(zh): https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * Author: Jacob Yin
 * Date: 2018-09-26
 * <p>
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * <p>
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * <p>
 * 你可以假设 nums1 和 nums2 不同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 中位数是 (2 + 3)/2 = 2.5
 */

package _0004mediansortedarrays;

public class MedianSortedArrays {

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        // 将两个数组按序合并为一个数组，并计算中位数
        // 时间复杂度为O(m+n)，空间复杂度为O(m+n)
        if (nums1 == null && nums2 == null) {
            return -1;
        }
        int[] numbers;
        int len, midLen;
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            numbers = nums1 == null || nums1.length == 0 ? nums2 : nums1;
            len = numbers.length;
            midLen = len / 2;
            if ((len & 0x1) == 1) {
                return numbers[midLen];
            } else {
                return (double) (numbers[midLen - 1] + numbers[midLen]) / 2;
            }
        } else {
            len = nums1.length + nums2.length;
            midLen = len / 2;
            numbers = new int[len];
            int i = 0, i1 = 0, i2 = 0;
            while (i < len / 2 + 1) {
                if (i1 >= nums1.length) {
                    numbers[i++] = nums2[i2++];
                } else if (i2 >= nums2.length) {
                    numbers[i++] = nums1[i1++];
                } else {
                    int num1 = nums1[i1];
                    int num2 = nums2[i2];
                    if (num1 < num2) {
                        numbers[i++] = num1;
                        i1++;
                    } else {
                        numbers[i++] = num2;
                        i2++;
                    }
                }
            }
            if ((len & 0x1) == 1) {
                return numbers[midLen];
            } else {
                return (double) (numbers[midLen - 1] + numbers[midLen]) / 2;
            }
        }
    }

    private int findMidIndex(int[] numbers1, int[] numbers2, int min, int max) {
        int i = (min + max) / 2;
        int j = (numbers1.length + numbers2.length + 1) / 2 - i;
        if ((i == 0 && numbers2[j - 1] <= numbers1[i])
                || (i == numbers1.length && numbers1[i - 1] <= numbers2[j])) {
            return i;
        } else if (i == 0 && numbers2[j - 1] > numbers1[i]) {
            return findMidIndex(numbers1, numbers2, i + 1, max);
        } else if (i == numbers1.length && numbers1[i - 1] > numbers2[j]) {
            return findMidIndex(numbers1, numbers2, min, i - 1);
        } else {
            if (numbers1[i - 1] > numbers2[j]) {
                return findMidIndex(numbers1, numbers2, min, i - 1);
            } else if (numbers2[j - 1] > numbers1[i]) {
                return findMidIndex(numbers1, numbers2, i + 1, max);
            } else {
                return i;
            }
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        // 两个数组都是有序的，必然想到可以使用折半查找的方式，找到中位数可能所在的位置
        // 这里不需要将两个数组进行合并，只需要两个数组进行拆分，数组A和B都拆成两部分L和H，分别记为Al，Ah，Bl和Bh，
        // Al元素均小于Ah，Bl元素均小于Bh，并且Al和Bl元素个数和等于Ah和Bh元素个数和。
        // 这时只要保证Al，Bl所有元素均小于Ah和Bh，即可确定，中位数必然在两个数组拆分处产生。
        // 而拆分处的索引值可以通过折半查找的方式找出，这里使用递归的方式进行查找，注意边界情况。
        // 时间复杂度为O(log(m+n))，空间复杂度为O(1)
        if (nums1 == null && nums2 == null) {
            return -1;
        }
        int[] numbers;
        int len, midLen;
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            numbers = nums1 == null || nums1.length == 0 ? nums2 : nums1;
            len = numbers.length;
            midLen = len / 2;
            if ((len & 0x1) == 1) {
                return numbers[midLen];
            } else {
                return (double) (numbers[midLen - 1] + numbers[midLen]) / 2;
            }
        }
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int i = findMidIndex(nums1, nums2, 0, nums1.length);
        int j = (nums1.length + nums2.length + 1) / 2 - i;
        boolean isOdd = ((nums1.length + nums2.length) & 0x1) == 1;
        if (isOdd) {
            if (i == 0) {
                return nums2[j - 1];
            } else {
                return Math.max(nums1[i - 1], nums2[j - 1]);
            }
        } else {
            if (i == 0 && j == nums2.length) {
                return (double) (nums2[j - 1] + nums1[i]) / 2;
            } else if (i == 0) {
                return (double) (nums2[j - 1] + Math.min(nums1[i], nums2[j])) / 2;
            } else if (i == nums1.length && j == 0) {
                return (double) (nums1[i - 1] + nums2[j]) / 2;
            } else if (i == nums1.length) {
                return (double) (Math.max(nums1[i - 1], nums2[j - 1]) + nums2[j]) / 2;
            } else {
                return (double) (Math.max(nums1[i - 1], nums2[j - 1]) + Math.min(nums1[i], nums2[j])) / 2;
            }
        }
    }

}
