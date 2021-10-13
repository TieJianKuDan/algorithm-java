package net.algorithm.answer;

import java.util.Arrays;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/4 11:37
 * @Description 611. 有效三角形的个数
 * @Since version-1.0
 */
public class TriangleNumber {
    public static void main(String[] args) {
        int[] nums = {2,2,3,4};
        System.out.println(triangleNumber(nums));
    }

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1 ; j++) {
                count += (binarySearch(nums, j + 1, nums[i] + nums[j]) - j);
            }
        }
        return count;
    }

    public static int binarySearch(int[] nums, int start, int target) {
        // 找小于 target 的最大值
        int low = start;
        int hight = nums.length - 1;
        while (low <= hight) {
            int cen = (hight - low) /2 + low;
            if (nums[cen] >= target) {
                hight = cen - 1;
            } else {
                low = cen + 1;
            }
        }
        return hight;
    }
}
