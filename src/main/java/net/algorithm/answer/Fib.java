package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/4 10:02
 * @Description 剑指 Offer 10- I. 斐波那契数列
 * @Since version-1.0
 */
public class Fib {
    public static void main(String[] args) {
        System.out.println(new Fib().fib(6));
    }

    public int fib(int n) {
        final int MOD = 1000_000_007;
        int[] dp = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return dp[n];
    }
}
