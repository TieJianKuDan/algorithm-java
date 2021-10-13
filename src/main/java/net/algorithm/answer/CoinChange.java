package net.algorithm.answer;

import java.util.Arrays;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/10 10:03
 * @Description 322. 零钱兑换
 * @Since version-1.0
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(new CoinChange().coinChange(coins, 11));
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = coins.length - 1; j >= 0; j--) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE / 2 ? -1 : dp[amount];
    }
}
