/**
 * Source : https://leetcode.com/problems/two-sum/
 * Source(zh) : https://leetcode-cn.com/problems/two-sum/
 * Author : Jacob Yin
 * Date   : 2018-09-25
 * <p>
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */

package _0001twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {

    public int[] twoSum1(int[] nums, int target) {
        // Normal idea using double loop calculate.
        // time complexity is O(n^2) & space complexity is O(1)
        if (nums == null) {
            return null;
        }
        for (int i = 0, len = nums.length; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        // use sieve method to find out result by only single loop. It will use additional space to store some numbers.
        // It is a method of saving time by space strategy.
        // m is (max - min) of given numbers. so time complexity is O(n) & space complexity is O(m)
        // 使用筛法只需要单重循环遍历即可，需要额外的存储空间，使用的是空间换时间策略。
        // 如果m是给定数字中最大值和最小值的差，那么时间复杂度为O(n)，空间复杂度为O(m)
        if (nums == null) {
            return null;
        }
        int len = nums.length;
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int hashLen = max - min + 1;
        boolean[] hash = new boolean[hashLen];
        int[] result = new int[]{-1, -1};
        for (int i = 0; i < len; i++) {
            int another = target - nums[i] - min;
            if (another >= 0 && another < hashLen && hash[another]) {
                result[1] = i;
                break;
            } else {
                hash[nums[i] - min] = true;
            }
        }
        if (result[1] == -1) {
            return null;
        }
        int another = target - nums[result[1]];
        for (int i = 0; i < len; i++) {
            if (nums[i] == another) {
                result[0] = i;
                break;
            }
        }
        return result;
    }

    public int[] twoSum3(int[] nums, int target) {
        // Use hash map to store some numbers to help find out result
        // time complexity is O(n) & space complexity is O(n)
        // 使用哈希表来辅助计算，同样采用空间换时间的策略，但是空间利用率比筛法更高
        // 时间复杂度O(n)，空间复杂度O(n)
        if (nums == null) {
            return null;
        }
        int len = nums.length;
        Map<Integer, Integer> hash = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            Integer index = hash.get(target - nums[i]);
            if (index != null) {
                return new int[]{index, i};
            } else {
                hash.put(nums[i], i);
            }
        }
        return null;
    }

    public int[] twoSum4(int[] nums, int target) {
        // Sort first, then, find out result by single loop.
        // time complexity is O(nlog(n)) & space complexity is O(1)
        // 先进行排序，然后通过单重循环即可找到答案
        // 时间复杂度O(nlog(n))，空间复杂度O(1)
        if (nums == null) {
            return null;
        }
        int len = nums.length;
        int[] sortedNumbers = new int[len];
        System.arraycopy(nums, 0, sortedNumbers, 0, len);
        Arrays.sort(sortedNumbers);
        int minIndex = 0;
        int maxIndex = len - 1;
        while(minIndex < maxIndex) {
            int sum = sortedNumbers[minIndex] + sortedNumbers[maxIndex];
            if (sum == target) {
                break;
            } else if (sum < target) {
                minIndex++;
            } else {
                maxIndex--;
            }
        }
        if (minIndex >= maxIndex) {
            return null;
        }
        int[] result = new int[2];
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == sortedNumbers[minIndex]) {
                result[j++] = i;
            } else if (nums[i] == sortedNumbers[maxIndex]) {
                result[j++] = i;
            }
            if (j == 2) {
                break;
            }
        }
        return result;
    }
}