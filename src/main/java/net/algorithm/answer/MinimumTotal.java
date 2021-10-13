package net.algorithm.answer;

import java.util.List;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/16 10:44
 * @Description 120. 三角形最小路径和
 * @Since version-1.0
 */
public class MinimumTotal {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[] dp = new int[row];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == row - 1) {
                    dp[j] = triangle.get(i).get(j);
                } else {
                    int min = Math.min(dp[j], dp[j + 1]);
                    dp[j] = triangle.get(i).get(j) + min;
                }
            }
        }
        return dp[0];
    }
}
