package com.xys.leetcode.lcode31_60;

/**
 * code: 38. Count and Say
 * n=1--> "1"
 * n=2--> "11"
 * n=3--> "21"
 * n=4--> "1211"
 * n=5--> "111221"
 * n=...
 */
public class Code38 {
    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            System.out.println("n = " + i + " result = " + countAndSay(i));
        }
    }

    public static String countAndSay(int n) {

        String result = "1";

        while (--n > 0) {
            result = change(result);
        }
        return result;
    }

    public static String change(String origin) {

        String result = "";
        int value = 1;
        for (int i = 0; i < origin.length(); i++) {
            if (i < origin.length() - 1) {
                if (origin.charAt(i) != origin.charAt(i + 1)) {
                    result += (value + "" + origin.charAt(i));
                    value = 1;
                } else {
                    value++;
                }
            } else {
                result += (value + "" + origin.charAt(i));
            }
        }

        return result;
    }
}
