package net.algorithm.answer;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author TieJianKuDan
 * @Date 2021/7/29 10:21
 * @Description 1104. 二叉树寻路
 * @Since version-1.0
 */
public class PathInZigZagTree {
    public static void main(String[] args) {
        System.out.println(pathInZigZagTree(1));
    }

    public static List<Integer> pathInZigZagTree(int label) {
        int row = getRow(label);
        LinkedList<Integer> res = new LinkedList<>();
        res.push(label);
        row--;
        while (row > 0) {
            label = getParent(label, row);
            res.push(label);
            row--;
        }
        return res;
    }

    public static int getParent(int lable, int row) {
        int father = lable / 2;
        father = (1 << (row)) + (1 << (row - 1)) - 1 - father;
        return father;
    }

    public static int getRow(int label) {
        int row = 1;
        int temp = label;
        while (1 != temp) {
            temp >>= 1;
            row++;
        }
        return row;
    }
}
