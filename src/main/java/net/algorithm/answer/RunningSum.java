package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/28 10:51
 * @Description 1480. 一维数组的动态和
 * @Since version-1.0
 */
public class RunningSum {
    public static void main(String[] args) {

    }

    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }
}
