package net.algorithm.answer;

import java.util.Arrays;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/20 10:03
 * @Description 673. 最长递增子序列的个数
 * @Since version-1.0
 */
public class NumberOfLIS {
    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(new NumberOfLIS().findNumberOfLIS(nums));
    }

    /**
     * 超时，需要拆成两个一维数组
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        // dp[i][j] 表示以 nums[j] 尾项且长度为 i 的递增子序列的个数
        int len = nums.length;
        int[][] dp = new int[len + 1][len];
        int maxlen = 1;
        Arrays.fill(dp[1], 1);
        for (int i = 2; i < len + 1; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < j; k++) {
                    if (nums[k] < nums[j]) {
                        dp[i][j] += dp[i - 1][k];
                    }
                }
                if (dp[i][j] != 0) {
                    maxlen = i;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += dp[maxlen][i];
        }
        return res;
    }
}
