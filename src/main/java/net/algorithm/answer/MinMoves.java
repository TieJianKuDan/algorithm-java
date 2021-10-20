package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/20 8:54
 * @Description 453. 最小操作次数使数组元素相等
 * @Since version-1.0
 */
public class MinMoves {
    public static void main(String[] args) {

    }

    /**
     * n - 1 个数加 1 是不是相当于有一个数减 1
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            res = res + (nums[i] - min);
        }
        return res;
    }
}