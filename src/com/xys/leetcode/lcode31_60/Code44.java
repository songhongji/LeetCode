package com.xys.leetcode.lcode31_60;

/**
 * 44. Wildcard Matching
 */
public class Code44 {
    public static void main(String[] args) {

        String s = "aa";
        String p = "a";

        if (isMatch(s, p)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }


    public static boolean isMatch(String s, String p) {

        int sLen = 0, pLen = 0, starIdx = -1, match = 0;
        while (sLen < s.length()) {
            if (pLen < p.length() && (p.charAt(pLen) == '?' || s.charAt(sLen) == p.charAt(pLen))) {
                sLen++;
                pLen++;
            }
            // 当遇到*时，记录下*的位置，和S字符串所到达的位置
            else if (pLen < p.length() && p.charAt(pLen) == '*') {
                starIdx = pLen;
                match = sLen;
                pLen++;
            }
            // 如果前面都不匹配，看看是否p中已经出现了*，如果是则将pLen定位到*的后面，sLen向后走，继续进行匹配
            else if (starIdx != -1) {
                pLen = starIdx + 1;
                match++;
                sLen = match;
            }
            // 其他情况返回错误
            else {
                return false;
            }
        }

        // 取出p后面所有的*
        while (pLen < p.length() && p.charAt(pLen) == '*') {
            pLen++;
        }

        return pLen == p.length();
    }
}
