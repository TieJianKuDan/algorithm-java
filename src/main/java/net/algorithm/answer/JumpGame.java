package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/14 11:07
 * @Description 45. 跳跃游戏 II
 * @Since version-1.0
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 0};
//        System.out.println(new JumpGame().jumpFast(nums));
        System.out.println(new JumpGame().canJump(nums));
    }

    // 从后往前推
    public int jump(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] += i;
        }
        int count = 0;
        int destination = nums.length - 1;
        while (destination > 0) {
            for (int i = 0; i <= destination; i++) {
                if (nums[i] >= destination) {
                    destination = i;
                }
            }
            count++;
        }
        return count;
    }

    // 从前往后
    public int jumpFast(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    // 能否到达终点
    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    public boolean canJump(int[] nums, int start) {
        if (start >= nums.length - 1) {
            return true;
        }
        if (nums[start] == 0) {
            return false;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = Math.min(start + nums[start], nums.length - 1);
        for (int i = start + 1; i <= maxIndex; i++) {
            if (nums[i] + i > max) {
                start = i;
                max = nums[i] + i;
            }
        }
        return canJump(nums, start);
    }
}
