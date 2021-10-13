package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/10 10:51
 * @Description 413. 等差数列划分
 * @Since version-1.0
 */
public class ArithmeticSlices {
    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 3, 3, 5, 1};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        short start = 0;
        short end = (short) (start + 2);
        short counter = 0;

        while (end < nums.length) {
            int d = nums[start + 1] - nums[start];
            if (d == (nums[start + 2] - nums[start + 1])) {
                while ((end < (nums.length - 1)) && ((nums[end + 1] - nums[end]) == d)) {
                    end++;
                }
                counter = (short) (counter + getNumberByLen((short)(end - start + 1)));
                start = end;
                end = (short) (start + 2);
            } else {
                start++;
                end++;
            }
        }

        return counter;
    }

    /**
     * @param len
     * @return 根据长度求得等差子数列的个数
     */
    public static short getNumberByLen(short len) {
        final int minLen = 3;
        if (len < minLen) {
            return 0;
        }
        return (short) ((len - 2) * (len - 1) / 2);
    }
}
