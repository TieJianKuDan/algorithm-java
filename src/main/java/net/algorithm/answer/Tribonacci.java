package net.algorithm.answer;

import java.util.LinkedList;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/8 10:09
 * @Description 1137. 第 N 个泰波那契数
 * @Since version-1.0
 */
public class Tribonacci {
    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }

    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        LinkedList<Integer> list = new LinkedList<>();
        int res = 0;
        list.offer(0);
        list.offer(1);
        list.offer(1);
        for (int i = 3; i <= n; i++) {
            res = list.get(0) + list.get(1) + list.get(2);
            list.poll();
            list.offer(res);
        }
        return res;
    }
}
