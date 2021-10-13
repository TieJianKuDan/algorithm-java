package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/23 10:51
 * @Description 1646. 获取生成数组中的最大值
 * @Since version-1.0
 */
public class MaximumGenerated {
    public static void main(String[] args) {
        System.out.println(new MaximumGenerated().getMaximumGenerated(100));
    }

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        for (int i = 2; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
