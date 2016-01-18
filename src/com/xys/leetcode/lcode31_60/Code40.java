package com.xys.leetcode.lcode31_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 */
public class Code40 {
    public static void main(String[] args) {

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> lists = combinationSum2(candidates, target);

        for (List<Integer> list : lists) {
            for (int n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> lists = new ArrayList<>();
        getResult(candidates, lists, new ArrayList<Integer>(), target, 0);

        return lists;
    }

    public static void getResult(int[] candidates, List<List<Integer>> lists,
                                 List<Integer> cur, int target, int start) {

        if (target > 0) {

            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {

                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                cur.add(candidates[i]);

                getResult(candidates, lists, cur, target - candidates[i], i + 1);

                cur.remove(cur.size() - 1);
            }

        } else if (target == 0) {
            lists.add(new ArrayList<>(cur));
        }

    }
}
