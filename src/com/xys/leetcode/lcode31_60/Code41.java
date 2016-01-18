package com.xys.leetcode.lcode31_60;

/**
 * 41. First Missing Positive
 * 找到第一个丢失的正整数，一定是从1，2，3，向后的第一个不见的正整数
 * 例如 『1，2，5』第一个不见的是3，例如『4，6，7』第一个不见的是1
 */
public class Code41 {
    public static void main(String[] args) {
        int[] nums = {1, 1};

        int result = firstMissingPositive(nums);

        System.out.println(result);

    }

    public static int firstMissingPositive(int[] nums) {

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!(nums[i] <= 0 || nums[i] > len - 1 || nums[i] == i + 1)) {
                if (nums[nums[i] - 1] != nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                    i--;
                }

            }
        }
        int i;
        for (i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return i + 1;
    }

}
