package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/11 9:52
 * @Description 357. 计算各个位数不同的数字个数
 * @Since version-1.0
 */
public class NumbersWithUniqueDigits {
    public static void main(String[] args) {
        System.out.println(new NumbersWithUniqueDigits().countNumbersWithUniqueDigits(2));
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 10;
        } else if (n == 2) {
            return 91;
        }
        // dp[i] 表示 [0, 10^i) 结果
        int len = Math.min(10, n);
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 10;
        dp[2] = 91;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + (10 - i + 1) * (dp[i - 1] - dp[i - 2]);
        }
        return dp[len];
    }
}
