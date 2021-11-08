package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/8 9:57
 * @Description
 * @Since version-1.0
 */
public class RangeAddition {
    public static void main(String[] args) {

    }

    public int maxCount(int m, int n, int[][] ops) {
        int x = m;
        int y = n;
        for (int[] op : ops) {
            x = Math.min(op[0], x);
            y = Math.min(op[1], y);
        }
        return x * y;
    }
}
