package net.algorithm.answer;

import java.util.Arrays;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/20 10:16
 * @Description 594. 最长和谐子序列
 * @Since version-1.0
 */
public class HarmonSubseq {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        HarmonSubseq self = new HarmonSubseq();
        System.out.println(self.findLHS(nums));
    }

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int temp = 0;
            int index = bSearch(nums, i + 1, nums[i] + 1);
            temp = index >= i + 1 && index < len ? index - i + 1 : 0;
            res = Math.max(res, temp);
        }
        return res;
    }

    public int bSearch(int[] nums, int start, int target) {
        int low = start;
        int high = nums.length - 1;
        while (low <= high) {
            int cen = (high - low) / 2 + low;
            if (nums[cen] > target) {
                high = cen - 1;
            } else {
                low = cen + 1;
            }
        }
        return nums[high] == target ? high : -1;
    }
}
