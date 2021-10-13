package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/15 15:07
 * @Description 576. 出界的路径数
 * @Since version-1.0
 */
public class BoundaryPaths {
    public static void main(String[] args) {
        int paths = new BoundaryPaths().findPaths(8, 50, 23, 5, 26);
        System.out.println(paths);
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        final int MOD = 1000_000_007;
        int[][][] dp = new int[maxMove + 1][m][n];
        int[][] dirctions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        dp[0][startRow][startColumn] = 1;
        int res = 0;
        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    for (int[] dirction : dirctions) {
                        int _j = j + dirction[0];
                        int _k = k + dirction[1];
                        if (_j >= 0 && _j < m && _k >= 0 && _k < n) {
                            dp[i + 1][_j][_k] = (dp[i + 1][_j][_k] + dp[i][j][k]) % MOD;
                        } else {
                            res = (res + dp[i][j][k]) % MOD;
                        }
                    }
                }
            }
        }
        return res;
    }
}
