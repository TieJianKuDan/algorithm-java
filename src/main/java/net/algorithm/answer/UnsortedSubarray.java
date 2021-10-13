package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/3 9:32
 * @Description 581. 最短无序连续子数组
 * @Since version-1.0
 */
public class UnsortedSubarray {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int start = 0;
        boolean flag = false;
        while (start < nums.length) {
            for (int i = start + 1; i < nums.length; i++) {
                if (nums[i] < nums[start]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            start++;
        }
        int end = nums.length - 1;
        flag = false;
        while (end > start) {
            for (int i = end - 1; i >= start; i--) {
                if (nums[i] > nums[end]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            end--;
        }
        int len = end - start + 1;
        return len;
    }
}
