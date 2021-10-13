package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/15 9:54
 * @Description 162.寻找峰值
 * @Since version-1.0
 */
public class PeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new PeakElement().findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    public int help(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return start;
        }
        if (nums[start] > nums[start + 1]) {
            return start;
        }
        if (nums[end] > nums[end - 1]) {
            return end;
        }
        return help(nums, ++start, --end);
    }
}
