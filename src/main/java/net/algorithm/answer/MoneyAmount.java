package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/11 11:09
 * @Description 375. 猜数字大小 II
 * @Since version-1.0
 */
public class MoneyAmount {
    public static void main(String[] args) {
        System.out.println(new MoneyAmount().getMoneyAmount(10));
    }

    public int getMoneyAmount(int n) {
        // dp[i][j] 表示在 i - j 猜数字所需的最小金额
        int[][] dp = new int[n + 1][n + 1];
        for (int i = dp.length - 2; i > 0; i--) {
            for (int j = i + 1; j < dp.length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    min = Math.min(min, k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n];
    }
}
