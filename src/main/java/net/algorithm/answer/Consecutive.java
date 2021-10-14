package net.algorithm.answer;

import java.util.HashMap;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/13 11:01
 * @Description 128. 最长连续序列
 * @Since version-1.0
 */
public class Consecutive {
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(new Consecutive().longestConsecutive(nums));
    }

    private HashMap<Integer, int[]> roots;

    /**
     * 使用并查集做，主要是练习并查集的使用
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int res = 0;
        // 并查集的根节点选择为元素最小的那个
        init(nums);
        // 将 num 中所有差值为 1 的元素合并
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, union(nums[i], nums[i] + 1));
        }
        return res;
    }

    /**
     * 合并两个集合，并返回合并后的集合元素个数
     * @param a roots 中一定存在
     * @param b roots 不一定存在
     * @return
     */
    private int union(int a, int b) {
        int res = 0;
        int rootA = find(a);
        if (!roots.containsKey(b)) {
            return roots.get(rootA)[1];
        }
        int rootB = find(b);
        if (rootA < rootB) {
            int[] temp = roots.get(rootB);
            temp[0] = rootA;
            roots.get(rootA)[1] += temp[1];
            res = roots.get(rootA)[1];
        } else if (rootA > rootB) {
            int[] temp = roots.get(rootA);
            temp[0] = rootB;
            roots.get(rootB)[1] += temp[1];
            res = roots.get(rootB)[1];
        } else {
            res = roots.get(rootA)[1];
        }
        return res;
    }

    /**
     * 找到 ele 元素所处树的根节点
     * @param ele
     * @return
     */
    private int find(int ele) {
        int father = roots.get(ele)[0];
        if (father == ele) {
            return father;
        } else {
            int root = find(father);
            if (root != father) {
                roots.get(father)[1] -= roots.get(ele)[1];
                roots.get(ele)[0] = root;
            }
            return root;
        }
    }

    /**
     * 初始化集合
     * @param nums
     */
    private void init(int[] nums) {
        int len = nums.length;
        roots = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            // {根节点，以 num[i] 为根的子树元素个数}
            roots.put(nums[i], new int[]{nums[i], 1});
        }
    }
}
