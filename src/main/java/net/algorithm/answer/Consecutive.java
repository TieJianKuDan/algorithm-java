package net.algorithm.answer;

import java.util.HashMap;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/13 11:01
 * @Description 128. 最长连续序列(有问题)
 * @Since version-1.0
 */
public class Consecutive {
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(new Consecutive().longestConsecutive(nums));
    }

    private HashMap<Integer, int[]> parent;

    public int longestConsecutive(int[] nums) {
        int res = 0;
        // 并查集的根节点选择为元素最小的那个
        // 初始化各个元素的父节点
        init(nums);
        // 将 num 中所有差值为 1 的元素合并
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, union(nums[i], nums[i] + 1));
        }
        return res;
    }

    private int union(int a, int b) {
        if (!parent.containsKey(b)) {
            return parent.get(a)[1];
        }
        int roota = find(a);
        int rootb = find(b);
        if (roota >= rootb) {
            parent.get(roota)[0] = rootb;
            parent.get(rootb)[1] += parent.get(roota)[1];
        } else {
            parent.get(rootb)[0] = roota;
            parent.get(roota)[1] += parent.get(rootb)[1];
        }
        return Math.max(parent.get(roota)[1], parent.get(rootb)[1]);
    }

    private int find(int ele) {

        int father = parent.get(ele)[0];
        if (father == ele) {
            return ele;
        } else {
            int root = find(parent.get(ele)[0]);
            parent.get(ele)[0] = root;
            if (father != root) {
                parent.get(father)[1]--;
            }
            return root;
        }
    }

    private void init(int[] nums) {
        int len = nums.length;
        parent = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            // key, {父亲，个数}
            parent.put(nums[i], new int[]{nums[i], 1});
        }
    }
}
