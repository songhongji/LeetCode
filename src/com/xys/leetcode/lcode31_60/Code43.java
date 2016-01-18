package com.xys.leetcode.lcode31_60;

/**
 * 43. Multiply Strings
 */
public class Code43 {

    public static void main(String[] args) {
        String num1 = "9133";
        String num2 = "0";

        String result = multiply(num1, num2);

        System.out.println("result = " + result);
    }

    public static String multiply(String num1, String num2) {

        int len1 = num1.length();
        int len2 = num2.length();

        // 算出基本乘积，还没有处理进位
        int[] num = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                // 这里+ 1是因为可能最后一个积会大于10
                num[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        // 处理进位
        int carry = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            int tmp = (num[i] + carry) % 10;
            carry = (num[i] + carry) / 10;
            num[i] = tmp;
        }

        // 将结果放进一个数组里
        StringBuilder sb = new StringBuilder();
        for (int n : num) {
            sb.append(n);
        }

        // 处理前面数字为零的情况
        while (sb.length() != 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // 返回结果
        return sb.length() == 0 ? "0" : sb.toString();
    }

}
