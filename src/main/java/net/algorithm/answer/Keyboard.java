package net.algorithm.answer;

import java.util.Arrays;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/19 14:33
 * @Description 650. 只有两个键的键盘
 * @Since version-1.0
 */
public class Keyboard {
    public static void main(String[] args) {
        System.out.println(new Keyboard().minSteps(3));
    }

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + (i / j));
                }
            }
        }
        return dp[n];
    }
}
