package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/11 11:19
 * @Description 629. K个逆序对数组
 * @Since version-1.0
 */
public class KInversePairs {
    public static void main(String[] args) {
        KInversePairs self = new KInversePairs();
        System.out.println(self.kInversePairs(45, 67));
    }

    public int kInversePairs(int n, int k) {
        final int MOD = 1000_000_007;
        int[][] dp = new int[n + 1][k + 1];
        int[][] preSum = new int[2][dp[0].length];
        dp[1][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int now = i % 2;
            int last = (i - 1) % 2;
            for (int j = 0; j < dp[0].length; j++) {
                int temp = Math.max(j + 1 - i, 0);
                if (i == 1) {
                    for (int l = j; l >= temp; l--) {
                        dp[i][j] += dp[i - 1][l];
                        dp[i][j] %= MOD;
                    }
                } else {
                    if (preSum[last][j] < preSum[last][temp]) {
                        dp[i][j] = (preSum[last][j] + MOD - preSum[last][temp] + dp[i - 1][temp]) % MOD;
                    } else {
                        dp[i][j] = (preSum[last][j] - preSum[last][temp] + dp[i - 1][temp]) % MOD;
                    }
                }
                if (j == 0) {
                    preSum[now][j] = dp[i][j];
                } else {
                    preSum[now][j] = preSum[now][j - 1] + dp[i][j];
                    preSum[now][j] %= MOD;
                }
            }
        }
        return dp[n][k];
    }

    public int kInversePairsL(int n, int k) {
        final int MOD = 1000_000_007;
        int[][] dp = new int[n + 1][k + 1];
        dp[1][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int temp = Math.max(j + 1 - i, 0);
                for (int l = j; l >= temp; l--) {
                    dp[i][j] += dp[i - 1][l];
                    dp[i][j] %= MOD;
                }
            }
        }
        return dp[n][k];
    }
}
