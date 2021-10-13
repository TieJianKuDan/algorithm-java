package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/27 10:56
 * @Description 300. 最长递增子序列
 * @Since version-1.0
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {4, 10, 4, 3, 8, 9};
        System.out.println(new LengthOfLIS().lengthOfLISPro(nums));
    }

    // 时间复杂度高
    public int lengthOfLIS(int[] nums) {
        // dp[i] 以 nums[i] 为结尾的严格递增子序列
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += 1;
            max = Math.max(dp[i], max);
        }
        return max;
    }

    // 贪心 + 二分查找
    public int lengthOfLISPro(int[] nums) {
        // tail[i] 表示子序列长度为 i+1 时，最后一个数字
        int[] tail = new int[nums.length];
        tail[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tail[len - 1]) {
                tail[len] = nums[i];
                len++;
            } else {
                // 二分查找，找最后一个比 num[i] 小的 tail[j]，用 num[i] 更新 tail[j + 1]
                // 这就说明可以在 tail[j] 对应的数字后接上 num[i]，构成长度为 j + 2 的子串，而且这个子串的末尾项即 num[i] 小于 目前的 tail[j + 1]
                // 所以为了维护 tail 数组要进行替换
                int low = 0, high = len - 1;
                while (low <= high) {
                    int cen = (high - low) / 2 + low;
                    if (tail[cen] >= nums[i]) {
                        high = cen - 1;
                    } else {
                        low = cen + 1;
                    }
                }
                tail[high + 1] = nums[i];
            }
        }
        return len;
    }
}
