package com.xys.leetcode.lcode31_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * code: 39. Combination Sum
 * 从一个整数的set中找到加在一起等于目标数字的所有组合
 * 组合中可以重复出现相同的整数，组合要按照非降序排列
 * 例如set为『2，3，4，7』 目标整数为7 ，则可以得到一个合法解为 『2，2，3』
 */
public class Code39 {
    public static void main(String[] args) {

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> lists = combinationSum(candidates, target);

        for (List<Integer> list : lists) {
            for (int n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();

        getResult(candidates, lists, new ArrayList<Integer>(), target, 0);

        return lists;
    }

    public static void getResult(int[] candidates, List<List<Integer>> lists, List<Integer> cur, int target, int start) {

        if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                cur.add(candidates[i]);
                getResult(candidates, lists, cur, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }
        } else if (target == 0) {
            // 这里必须每次重新构造一个ArrayList
            lists.add(new ArrayList<>(cur));
        }

    }
}
