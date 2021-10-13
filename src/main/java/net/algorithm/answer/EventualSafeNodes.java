package net.algorithm.answer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/5 19:53
 * @Description 802. 找到最终的安全状态
 * @Since version-1.0
 */
public class EventualSafeNodes {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(graph));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (isSafe(graph, color, i)) {
                res.add(i);
            }
        }
        return res;
    }

    public static boolean isSafe(int[][] graph, int[] color, int start) {
        if (color[start] > 0) {
            return color[start] == 2;
        }
        color[start] = 1;
        boolean res = true;
        for (int next : graph[start]) {
            if (!isSafe(graph, color, next)) {
                return false;
            }
        }
        color[start] = 2;
        return true;
    }
}
