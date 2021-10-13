package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/27 10:57
 * @Description 最大正方形
 * @Since version-1.0
 */
public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = { {'1', '0', '1', '0', '0'},
                            {'1', '0', '1', '1', '1'},
                            {'1', '1', '1', '1', '1'},
                            {'1', '0', '0', '1', '0'} };
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        // 以 (row, col) 为右下角的正方形边长
        int[][] dp = new int[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != '1') {
                    continue;
                }
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                    dp[i][j] += 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
