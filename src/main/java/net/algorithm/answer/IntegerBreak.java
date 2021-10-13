package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/10 10:54
 * @Description 343. 整数拆分
 * @Since version-1.0
 */
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(10));
    }

    public int integerBreak(int n) {
        int max = 0;
        int[] rem = new int[n + 1];
        for (int i = 1; i < n; i++) {
            max = Math.max(help(i, rem) * help(n - i, rem), max);
        }
        return max;
    }

    private int help(int n, int[] rem) {
        int max = n;
        if (n == 1) {
            return 1;
        }
        if (rem[n] != 0) {
            return rem[n];
        }
        for (int i = 1; i < n; i++) {
            max = Math.max(help(i, rem) * help(n - i, rem), max);
        }
        rem[n] = max;
        return max;
    }
}
