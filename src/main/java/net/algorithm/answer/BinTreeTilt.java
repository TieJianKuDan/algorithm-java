package net.algorithm.answer;

import net.algorithm.pojo.TreeNode;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/18 9:40
 * @Description 563. 二叉树的坡度
 * @Since version-1.0
 */
public class BinTreeTilt {
    public static void main(String[] args) {
        
    }

    private int res = 0;

    public int findTilt(TreeNode root) {
        getSum(root);
        return res;
    }

    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        res += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }
}
