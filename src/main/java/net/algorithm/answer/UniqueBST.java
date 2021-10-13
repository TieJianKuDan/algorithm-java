package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/22 10:06
 * @Description 96. 不同的二叉搜索树
 * @Since version-1.0
 */
public class UniqueBST {
    public static void main(String[] args) {
        System.out.println(new UniqueBST().numTrees(3));
    }

    public int numTrees(int n) {
        int[][] rem = new int[n + 1][n + 1];
        return numTrees(rem, 1, n);
    }

    public int numTrees(int[][] rem, int start, int end) {
        int res = 0;
        if (start >= end) {
            return 1;
        }
        if (rem[start][end] != 0) {
            return rem[start][end];
        }
        for (int i = start; i <= end; i++) {
            res += numTrees(rem, start, i - 1) * numTrees(rem, i + 1, end);
        }
        rem[start][end] = res;
        return res;
    }
}
