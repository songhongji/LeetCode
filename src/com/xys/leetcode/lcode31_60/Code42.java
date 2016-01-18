package com.xys.leetcode.lcode31_60;

/**
 * 42. Trapping Rain Water
 */
public class Code42 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int result = trap(nums);

        System.out.println(result);
    }

    public static int trap(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > 0 && i + 1 < height.length) {
                int max = height[i + 1];
                int maxI = i + 1;
                int judge = 0;
                for (int j = i + 1; j < height.length; j++) {
                    if (height[j] >= height[i]) {
                        area += height[i] * (j - i - 1);
                        for (int k = i + 1; k < j; k++) {
                            area -= height[k];
                        }
                        i = j - 1;
                        judge = 1;
                        break;
                    }

                    if (max < height[j]) {
                        max = height[j];
                        maxI = j;
                    }
                }

                if (judge == 0) {
                    area += height[maxI] * (maxI - i - 1);
                    for (int k = i + 1; k < maxI; k++) {
                        area -= height[k];
                    }
                    i = maxI - 1;
                }
            }
        }

        return area;
    }
}
