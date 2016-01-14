package com.xys.leetcode.lcode31_60;

import java.util.HashSet;
import java.util.Set;

/**
 * Code 36
 */
public class Code36 {

    public static void main(String[] args) {

        char[][] board = {
                {'.', '.', '.', '.', '.', '5', '.', '.', '1'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '2'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'},
        };

        if (isValidSudoku(board)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }

    public static boolean isValidSudoku(char[][] board) {

        // 判断每行是否合格
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
        }


        // 判断每列是否合格
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) {
                        return false;
                    } else {
                        set.add(board[j][i]);
                    }
                }
            }
        }

        //判断9宫格是否合格
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Set<Character> set = new HashSet<>();
                for (int k = i * 3; k <= i * 3 + 2; k++) {
                    for (int l = j * 3; l <= j * 3 + 2; l++) {
                        if (board[k][l] != '.') {
                            if (set.contains(board[k][l])) {
                                return false;
                            } else {
                                set.add(board[k][l]);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
