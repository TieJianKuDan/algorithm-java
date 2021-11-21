package net.algorithm.answer;

import net.algorithm.pojo.n_ary.Node;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/21 9:40
 * @Description 559. N 叉树的最大深度
 * @Since version-1.0
 */
public class N_aryTree {
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        for (Node child : root.children) {
            res = Math.max(res, maxDepth(child));
        }
        return res + 1;
    }
}
