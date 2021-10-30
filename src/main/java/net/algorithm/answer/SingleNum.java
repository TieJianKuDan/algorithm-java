package net.algorithm.answer;

import java.util.HashMap;
import java.util.Set;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/30 9:25
 * @Description 260. 只出现一次的数字 III
 * @Since version-1.0
 */
public class SingleNum {
    public static void main(String[] args) {
        SingleNum self = new SingleNum();
        int[] nums = {1, 2, 1, 3, 2, 5};
        System.out.println(self.singleNumber(nums));
    }

    /**
     * 用哈希表来实现线性复杂度
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.getOrDefault(nums[i], 0);
            count++;
            if (count >= 2) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], count);
            }
        }
        Set<Integer> keys = map.keySet();
        int index = 0;
        for (Integer key : keys) {
            result[index] = key;
            index++;
        }
        return result;
    }

    /**
     * 位运算解决
     * @param nums
     * @return
     */
    public int[] singleNumberPro(int[] nums) {
        int len = nums.length;
        int xory = 0;
        for (int i = 0; i < len; i++) {
            xory ^= nums[i];
        }
        xory = xory == Integer.MIN_VALUE ? xory : xory & (-xory);
        int type1 = 0;
        int type2 = 0;
        for (int num : nums) {
            if ((num & xory) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        return new int[]{type1, type2};
    }
}
