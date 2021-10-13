package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/6 9:41
 * @Description 704. 二分查找
 * @Since version-1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int cen = (high - low) / 2 + low;
            if (nums[cen] > target) {
                high = cen - 1;
            } else if (nums[cen] < target) {
                low = cen + 1;
            } else {
                return cen;
            }
        }
        return -1;
    }
}
