package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/12 10:23
 * @Description 516. 最长回文子序列
 * @Since version-1.0
 */
public class PalindromeSubseq {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }

    public static int longestPalindromeSubseq(String s) {
        // dp[i][j] 表示 s[i][j] 的最长回文子序列的长度
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j) && (j - i) > 1) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else if (s.charAt(i) == s.charAt(j) && (j - i) == 1) {
                    dp[i][j] = 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
