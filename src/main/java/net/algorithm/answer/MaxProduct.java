package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/23 11:11
 * @Description 乘积最大子数组
 * @Since version-1.0
 */
public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(new MaxProduct().maxProduct(new int[]{-2, 3, -4}));
    }

    public int maxProduct(int[] nums) {
        int len = nums.length;
        // dp[i][j] 数组长度为 i + 1 时，最后一个数是否包含在连续子数组中的最大乘积
        int[][] dp = new int[len][4];
        dp[0][0] = Integer.MIN_VALUE;
        dp[0][1] = nums[0];
        dp[0][2] = Integer.MIN_VALUE;
        dp[0][3] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            int max = Math.max(dp[i - 1][1] * nums[i], nums[i]);
            dp[i][1] = Math.max(max, dp[i - 1][3] * nums[i]);
            dp[i][2] = Math.min(dp[i - 1][2], dp[i - 1][1]);
            int min = Math.min(dp[i - 1][3] * nums[i], nums[i]);
            dp[i][3] = Math.min(min, dp[i - 1][1] * nums[i]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
