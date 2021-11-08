package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/8 9:56
 * @Description 268. 丢失的数字
 * @Since version-1.0
 */
public class MissingNumber {
    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (len + 1) * len / 2;
        for (int i = 0; i < len; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
