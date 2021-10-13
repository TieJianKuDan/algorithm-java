package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/17 10:46
 * @Description 551. 学生出勤记录 I & II
 * @Since version-1.0
 */
public class CheckRecord {
    public static void main(String[] args) {
//        System.out.println(new CheckRecord().checkRecord("PPLALL"));
        System.out.println(new CheckRecord().checkRecord(10101));
    }

    public boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                ++absent;
            }
            if (s.charAt(i) != 'L') {
                late = 0;
            } else {
                late++;
            }
            if (absent >= 2 || late >= 3) {
                return false;
            }
        }
        return true;
    }

    public int checkRecord(int n) {
        final int MOD = 1000_000_007;
        // dp[i][j][k] 表示 i 天考勤记录有 j 次 A,最后有 k 天连续 L 的情况下拿到考勤奖的记录数
        long[][][] dp = new long[n + 1][2][3];
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        dp[1][1][0] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;
            dp[i][0][1] = dp[i - 1][0][0] % MOD;
            dp[i][0][2] = dp[i - 1][0][1] % MOD;
            dp[i][1][0] = dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2] + dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2] % MOD;
            dp[i][1][1] = dp[i - 1][1][0] % MOD;
            dp[i][1][2] = dp[i - 1][1][1] % MOD;
        }
        long res = 0;
        for (int i = 0; i < dp[n].length; i++) {
            for (int j = 0; j < dp[n][i].length; j++) {
                res = (res + dp[n][i][j]) % MOD;
            }
        }
        return (int)res;
    }
}
