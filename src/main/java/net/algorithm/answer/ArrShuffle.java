package net.algorithm.answer;

import java.util.*;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/22 11:14
 * @Description 384. 打乱数组
 * @Since version-1.0
 */
public class ArrShuffle {
    private int[] init;
    private List<Integer> helper;
    private int[] result;

    public ArrShuffle(int[] nums) {
        result = new int[nums.length];
        init = new int[nums.length];
        helper = new ArrayList<Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            helper.add(nums[i]);
            result[i] = nums[i];
            init[i] = nums[i];
        }
    }

    public int[] reset() {
        for (int i = 0; i < init.length; i++) {
            result[i] = init[i];
        }
        return result;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < result.length; i++) {
            int index = random.nextInt(helper.size());
            result[i] = helper.get(index);
            // 直接移除复杂度高
            // helper.remove(index);
            // 稍微修改后
            helper.set(index, helper.get(helper.size() - 1));
            helper.remove(helper.size() - 1);
        }
        return result;
    }
}
