package net.algorithm.answer;

import java.util.PriorityQueue;

/**
 * @Author TieJianKuDan
 * @Date 2021/12/3 16:31
 * @Description 1005. K 次取反后最大化的数组和
 * @Since version-1.0
 */
public class LargestSumAfterKNegations {
    public static void main(String[] args) {
        int[] nums = {-4, 4, -3, 3, -4, -1, 8, -7, -7};
        LargestSumAfterKNegations self = new LargestSumAfterKNegations();
        System.out.println(self.largestSumAfterKNegations(nums, 3));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        int min = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && (queue.size() < k)) {
                queue.offer(nums[i]);
            } else if (nums[i] < 0 && nums[i] < queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        for (int i = 0; queue.peek() != null && (i < nums.length) && k > 0; i++) {
            if (nums[i] < queue.peek()) {
                nums[i] = -nums[i];
                k--;
            }
        }
        for (int i = 0; queue.peek() != null && (i < nums.length) && k > 0; i++) {
            if (nums[i] <= queue.peek()) {
                nums[i] = -nums[i];
                k--;
            }
        }
        if (k % 2 != 0) {
            min = findMinNumIndex(nums);
            nums[min] = -nums[min];
        }
        return getSum(nums);
    }

    private int findMinNumIndex(int[] nums) {
        int min = nums[0];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                res = i;
            }
        }
        return res;
    }

    private int getSum(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }
}
