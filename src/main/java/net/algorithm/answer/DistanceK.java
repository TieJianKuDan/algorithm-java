package net.algorithm.answer;

import net.algorithm.pojo.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author TieJianKuDan
 * @Date 2021/7/28 9:10
 * @Description 863. 二叉树中所有距离为 K 的结点
 * @Since version-1.0
 */
public class DistanceK {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(4);

        System.out.println(distanceK(root, root.left, 2));
    }

    private static Set<TreeNode> set = new HashSet<TreeNode>();

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (target == null) {
            return res;
        }
        set.add(target);
        if (0 == k) {
            res.add(target.val);
            return res;
        }

        // 找到目标父亲节点
        TreeNode father = getFather(root, target);
        if (!set.contains(father)) {
            res.addAll(distanceK(root, father, k - 1));
        }
        if (!set.contains(target.left)) {
            res.addAll(distanceK(root, target.left, k - 1));
        }
        if (!set.contains(target.right)) {
            res.addAll(distanceK(root, target.right, k - 1));
        }

        return res;
    }

    public static TreeNode getFather(TreeNode root, TreeNode target) {
        if (root == target || root == null) {
            return null;
        }
        if (root.left == target || root.right == target) {
            return root;
        }
        TreeNode father = getFather(root.left, target);
        return father != null ? father : getFather(root.right, target);
    }
}
