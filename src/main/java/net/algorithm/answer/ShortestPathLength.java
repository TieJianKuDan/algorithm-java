package net.algorithm.answer;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/6 20:29
 * @Description 847. 访问所有节点的最短路径
 * @Since version-1.0
 */
public class ShortestPathLength {
    public static void main(String[] args) {
//        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
//        int[][] graph = {{1},{0,2,4},{1,3,4},{2},{1,2}};
        int[][] graph = {{2, 3, 5, 7}, {2, 3, 7}, {0, 1}, {0, 1}, {7}, {0}, {10}, {9, 10, 0, 1, 4}, {9}, {7, 8}, {7, 6}};

        System.out.println(shortestPathLength(graph));
    }

    public static int shortestPathLength(int[][] graph) {
        // 0 -> node 编号 1 -> 每位代表一个点有无到达过 2 -> 路径长度
        LinkedList<int[]> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            queue.offer(new int[]{i, 1 << i, 0});
        }
        int condition = (1 << graph.length) - 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                if (node[1] >= condition) {
                    return node[2];
                }
                if (set.contains(node[0] + "," + node[1])) {
                    continue;
                } else {
                    set.add(node[0] + "," + node[1]);
                }
                for (int number : graph[node[0]]) {
                    if ((node[1] & (1 << number)) == 0) {
                        queue.offer(new int[]{number, node[1] + (1 << number), node[2] + 1});
                    } else {
                        queue.offer(new int[]{number, node[1], node[2] + 1});
                    }
                }
            }
        }
        return -1;
    }
}
