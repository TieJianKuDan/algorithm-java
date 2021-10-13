package net.algorithm.answer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/16 10:54
 * @Description 526. 优美的排列
 * @Since version-1.0
 */
public class Arrangement {
    public static void main(String[] args) {
        int count = new Arrangement().countArrangement(5);
        System.out.println(count);
    }

    private int count = 0;

    public int countArrangement(int n) {
        dfs(n, new HashSet<Integer>(), 1);
        return count;
    }

    /**
     * @param n 待选
     * @param choosed 已选
     * @param depth 深度
     * @description 回溯算法
     */
    public void dfs(int n, Set<Integer> choosed, int depth) {
        if (depth > n) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (choosed.contains(i) || (i % depth != 0 && depth % i != 0)) {
                continue;
            }
            choosed.add(i);
            dfs(n, choosed, depth + 1);
            choosed.remove(i);
        }
    }
}
