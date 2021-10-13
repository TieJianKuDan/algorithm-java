package net.algorithm.answer;

import net.algorithm.pojo.TreeNode;

/**
 * @Author TieJianKuDan
 * @Date 2021/7/27 9:46
 * @Description 671. 二叉树中第二小的节点
 * @Since version-1.0
 */
public class SecondMinimumValue {
    public static void main(String[] args) {

    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        if (root.left == null && root.right == null) {
            return -1;
        }

        if (root.left.val == root.right.val) {
            int candidate1 = findSecondMinimumValue(root.left);
            int candidate2 = findSecondMinimumValue(root.right);
            if (candidate1 == -1 && candidate2 == -1) {
                return -1;
            }
            if (candidate1 == -1) {
                return candidate2;
            }
            if (candidate2 == -1) {
                return candidate1;
            }
            if (candidate1 < candidate2) {
                return candidate1;
            } else {
                return candidate2;
            }
        }

        if (root.val == root.left.val) {
            int temp = findSecondMinimumValue(root.left);
            if (temp < root.right.val && temp != -1) {
                return temp;
            }
            return root.right.val;
        }
        if (root.val == root.right.val) {
            int temp = findSecondMinimumValue(root.right);
            if (temp < root.left.val && temp != -1) {
                return temp;
            }
            return root.left.val;
        }
        return -1;
    }
}
