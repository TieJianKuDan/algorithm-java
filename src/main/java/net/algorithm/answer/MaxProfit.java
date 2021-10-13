package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/9 10:37
 * @Description 309. 最佳买卖股票时机含冷冻期
 * @Since version-1.0
 */
public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    public int maxProfit(int[] prices) {
        // dp[i][0] 表示在第 i 天，没有持有股票的最大利润
        // dp[i][1] 表示在第 i 天，持有股票的最大利润
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        if (prices.length > 1) {
            dp[1][1] = Math.max(-prices[0], -prices[1]);
            dp[1][0] = Math.max(0, dp[0][1] + prices[1]);
        }
        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }
}
