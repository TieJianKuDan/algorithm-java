package net.algorithm.answer;

import net.algorithm.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/15 11:26
 * @Description 96.不同二叉搜索树
 * @Since version-1.0
 */
public class GenerateTrees {
    public static void main(String[] args) {

    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        return list;
    }
}
