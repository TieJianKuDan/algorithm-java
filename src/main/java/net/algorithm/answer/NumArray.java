package net.algorithm.answer;

import java.util.Arrays;
/**
 * @Author TieJianKuDan
 * @Date 2022/4/4 10:22
 * @Description 307. 区域和检索 - 数组可修改
 * @Since version-1.0
 */
class NumArray {
    int[] tree;
    int[] nums;

    public NumArray(int[] nums) {
        int len = nums.length;
        this.tree = new int[len];
        this.nums = new int[len];
        Arrays.fill(this.tree, 0);
        for (int i = 0; i < len; i++) {
            this.nums[i] = nums[i];
        }
        tree[0] = nums[0];
        for (int i = 1; i < len; i++) {
            int lowb = lowBit(i);
            for (int j = i - lowb + 1; j <= i; j++) {
                tree[i] += nums[j];
            }
        }
    }

    private int lowBit(int num) {
        return num & (-num);
    }

    private int rangeQuery(int right) {
        int sum = 0;
        while (right > 0) {
            sum += tree[right];
            right -= lowBit(right);
        }
        return sum + nums[0];
    }

    public void update(int index, int val) {
        if (index == 0) {
            tree[index] = val;
            nums[index] = val;
            return;
        }
        int right = index;
        int delta = val - nums[index];
        while (right < tree.length) {
            tree[right] += delta;
            right += lowBit(right);
        }
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return rangeQuery(right) - rangeQuery(left) + nums[left];
    }
}