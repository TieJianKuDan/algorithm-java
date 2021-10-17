package net.algorithm.answer;

import net.algorithm.pojo.TreeNode;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/17 19:06
 * @Description 230. 二叉搜索树中第K小的元素
 * @Since version-1.0
 */
public class KthSmallest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        System.out.println(new KthSmallest().kthSmallest(root, 2));
    }

    private int index = 1;
    private int res = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return res;
        }
        kthSmallest(root.left, k);
        if (k == index) {
            res = root.val;
            index++;
        } else {
            index++;
            kthSmallest(root.right, k);
        }
        return res;
    }
}
