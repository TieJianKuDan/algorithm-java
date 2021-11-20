package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/19 18:20
 * @Description 397. 整数替换
 * @Since version-1.0
 */
public class IntReplace {
    public static void main(String[] args) {
        IntReplace self = new IntReplace();
        System.out.println(self.integerReplacementR(2147483647));
    }

    /**
     * 超出内存限制
     * @param n
     * @return
     */
    public int integerReplacement(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 1;
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, dp[(i + 1) / 2] + 2);
            }
        }
        return dp[n];
    }

    public int integerReplacementR(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return integerReplacementR(n / 2) + 1;
        } else if (n % 2 != 0 && n != 2147483647) {
            return Math.min(integerReplacementR((n - 1) / 2), integerReplacementR((n + 1) / 2)) + 2;
        } else {
            return 32;
        }
    }
}
