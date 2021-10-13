package net.algorithm.answer;

import java.util.HashSet;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/7 13:37
 * @Description 457. 环形数组是否存在循环
 * @Since version-1.0
 */
public class CircularArrayLoop {
    public static void main(String[] args) {
        int[] nums = {2,-1,1,2,2};
        System.out.println(circularArrayLoop(nums));
    }

    public static boolean circularArrayLoop(int[] nums) {
        HashSet<Integer> black = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (getNext(nums, i) == i) {
                black.add(i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            boolean flag = nums[i] > 0 ? true : false;
            int next = i;
            while (true) {
                if (black.contains(next)) {
                    break;
                }
                if (set.contains(next) && set.size() > 1) {
                    return true;
                }
                if ((set.contains(next) && set.size() == 1) || (flag && nums[next] < 0) || (!flag && nums[next] > 0)) {
                    break;
                }
                set.add(next);
                next = getNext(nums, next);
            }
        }
        return false;
    }

    public static int getNext(int[] nums, int index) {
        int next = (index + nums[index]) % nums.length;
        if (next < 0) {
            next = nums.length + next;
        }
        return next;
    }
}
