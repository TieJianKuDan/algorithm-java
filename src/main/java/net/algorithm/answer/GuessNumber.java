package net.algorithm.answer;

import java.util.Arrays;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/12 15:38
 * @Description 375. 猜数字大小 II
 * @Since version-1.0
 */
public class GuessNumber {
    public static void main(String[] args) {
        GuessNumber self = new GuessNumber();
        System.out.println(self.getMoneyAmount(200));
    }

    public int getMoneyAmount(int n) {
        int[][] mem = new int[n + 2][n + 1];
        for (int i = 0; i < mem.length; i++) {
            Arrays.fill(mem[i], -1);
        }
        return help(1, n, mem);
    }

    private int help(int start, int end, int[][] mem) {
        if (start >= end) {
            return 0;
        }
        if (start + 1 == end) {
            return start;
        }
        if (mem[start][end] != -1) {
            return mem[start][end];
        }
        int res = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            res = Math.min(res, i + Math.max(help(start, i - 1, mem), help(i + 1, end, mem)));
        }
        mem[start][end] = res;
        return res;
    }
}
