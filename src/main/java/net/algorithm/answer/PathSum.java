package net.algorithm.answer;

import net.algorithm.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/28 9:29
 * @Description 437. 路径总和 III
 * @Since version-1.0
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left1 = new TreeNode(5);
        TreeNode right1 = new TreeNode(-3);
        root.left = left1;
        root.right = right1;
        TreeNode left2 = new TreeNode(3);
        TreeNode right2 = new TreeNode(2);
        left1.left = left2;
        left1.right = right2;
        TreeNode right3 = new TreeNode(11);
        right1.right = right3;
        TreeNode right4 = new TreeNode(1);
        right2.right = right4;
        TreeNode left3 = new TreeNode(3);
        TreeNode right5 = new TreeNode(-2);
        left2.left = left3;
        left2.right = right5;
        System.out.println(new PathSum().pathSumPro(root, 8));
    }

    private int sum = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        sum += help(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return sum;
    }

    private int help(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == targetSum) {
            res++;
        }
        return res
                + help(root.left, targetSum - root.val)
                + help(root.right, targetSum - root.val);
    }

    // 前缀和 + 回溯
    public int pathSumPro(TreeNode root, int targetSum) {
        // 记录前缀和，key = 前缀和 value = 个数
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    private int dfs(TreeNode root, Map<Integer, Integer> prefix, int curr, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        curr += root.val;
        res = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        res += dfs(root.left, prefix, curr, targetSum);
        res += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);
        return res;
    }
}
