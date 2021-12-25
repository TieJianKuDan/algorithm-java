package net.algorithm.answer;

import net.algorithm.pojo.TreeNode;

import java.util.LinkedList;

/**
 * @Author TieJianKuDan
 * @Date 2021/12/25 13:08
 * @Description 1609. 奇偶树
 * @Since version-1.0
 */
public class IsEvenOddTree {
    public static void main(String[] args) {

    }

    public boolean isEvenOddTree(TreeNode root) {
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return false;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode pre = null;
            TreeNode now = null;
            for (int i = 0; i < size; i++) {
                now = queue.poll();
                if (isOdd(level)) {
                    if (isOdd(now.val)) {
                        return false;
                    }
                    if (pre != null && now.val >= pre.val) {
                        return false;
                    }
                } else {
                    if (!isOdd(now.val)) {
                        return false;
                    }
                    if (pre != null && now.val <= pre.val) {
                        return false;
                    }
                }
                if (now.left != null) {
                    queue.offer(now.left);
                }
                if (now.right != null) {
                    queue.offer(now.right);
                }
                pre = now;
            }
            level++;
        }
        return true;
    }

    private boolean isOdd(int num) {
        return num % 2 != 0;
    }
}
