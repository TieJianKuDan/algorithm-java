package net.algorithm.answer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/25 11:02
 * @Description 797. 所有可能的路径
 * @Since version-1.0
 */
public class PathsSourceTarget {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        System.out.println(new PathsSourceTarget().allPathsSourceTarget(graph));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> routes = new ArrayList<>();
        ArrayList<Integer> route = new ArrayList<>();
        route.add(0);
        dfs(graph, 0, route, routes);
        return routes;
    }

    public void dfs(int[][] graph, int start, List<Integer> route, List<List<Integer>> routes) {
        if (start == graph.length - 1) {
            routes.add(new ArrayList<>(route));
            return;
        }
        for (int point : graph[start]) {
            route.add(point);
            dfs(graph, point, route, routes);
            route.remove(route.size() - 1);
        }
    }
}
