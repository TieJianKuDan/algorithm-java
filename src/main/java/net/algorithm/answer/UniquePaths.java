package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/15 11:06
 * @Description 62.不同路径
 * @Since version-1.0
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 2));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m; i > 0 ; i--) {
            for (int j = n; j > 0 ; j--) {
                if (i == m && j == n) {
                    dp[i][j] = 1;
                }
                else if (i == m) {
                    dp[i][j] = dp[i][j + 1];
                }
                else if (j == n) {
                    dp[i][j] = dp[i + 1][j];
                }
                else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[1][1];
    }

    
}
