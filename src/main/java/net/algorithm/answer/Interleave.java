package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/22 10:20
 * @Description 97. 交错字符串
 * @Since version-1.0
 */
public class Interleave {
    public static void main(String[] args) {

    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j == 0 && i == 0) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = (i > 0 && dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1))) ||
                            (j > 0 && dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
