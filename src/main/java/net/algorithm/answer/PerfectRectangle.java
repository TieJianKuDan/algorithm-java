package net.algorithm.answer;

import java.util.*;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/16 9:59
 * @Description 391. 完美矩形
 * @Since version-1.0
 */
public class PerfectRectangle {
    public static void main(String[] args) {
        int[][] rectangles = {{1,1,2,3},{1,3,2,4},{3,1,4,2},{3,2,4,4}};
        PerfectRectangle self = new PerfectRectangle();
        System.out.println(self.isRectangleCover(rectangles));
    }

    public boolean isRectangleCover(int[][] rectangles) {
        HashMap<Integer, List<int[]>> left = new HashMap<>();
        HashMap<Integer, List<int[]>> right = new HashMap<>();
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        // 保存各个矩形的左右两边
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0];
            int x2 = rectangle[2];
            minX = Math.min(x1, minX);
            maxX = Math.max(x2, maxX);
            int y1 = rectangle[1];
            int y2 = rectangle[3];
            List edges1 = left.getOrDefault(x1, new ArrayList<>());
            edges1.add(new int[]{y1, y2});
            left.put(x1, edges1);
            List edges2 = right.getOrDefault(x2, new ArrayList<>());
            edges2.add(new int[]{y1, y2});
            right.put(x2, edges2);
        }
        if (left.size() != right.size()) {
            return false;
        }
        // 合并各个矩形的边
        Set<Map.Entry<Integer, List<int[]>>> entries = left.entrySet();
        for (Map.Entry<Integer, List<int[]>> entry : entries) {
            List<int[]> edges = entry.getValue();
            edges.sort((o1, o2) -> o1[0] - o2[0]);
            ArrayList<int[]> merge = new ArrayList<>();
            int[] temp = edges.get(0);
            int p = 1;
            while (p < edges.size()) {
                if (edges.get(p)[0] > edges.get(p - 1)[1]) {
                    merge.add(temp);
                    temp = edges.get(p);
                } else if (edges.get(p)[0] == edges.get(p - 1)[1]) {
                    temp[1] = edges.get(p)[1];
                } else {
                    return false;
                }
                p++;
            }
            merge.add(temp);
            left.put(entry.getKey(), merge);
        }
        entries = right.entrySet();
        for (Map.Entry<Integer, List<int[]>> entry : entries) {
            List<int[]> edges = entry.getValue();
            edges.sort((o1, o2) -> o1[0] - o2[0]);
            ArrayList<int[]> merge = new ArrayList<>();
            int[] temp = edges.get(0);
            int p = 1;
            while (p < edges.size()) {
                if (edges.get(p)[0] > edges.get(p - 1)[1]) {
                    merge.add(temp);
                    temp = edges.get(p);
                } else if (edges.get(p)[0] == edges.get(p - 1)[1]) {
                    temp[1] = edges.get(p)[1];
                } else {
                    return false;
                }
                p++;
            }
            merge.add(temp);
            right.put(entry.getKey(), merge);
        }
        for (Map.Entry<Integer, List<int[]>> entry : entries) {
            Integer x = entry.getKey();
            if (x != maxX && x != minX) {
                List<int[]> el = left.get(x);
                if (el == null) {
                    return false;
                }
                List<int[]> er = right.get(x);
                for (int i = 0; i < el.size(); i++) {
                    if (el.get(i)[0] != er.get(i)[0] || el.get(i)[1] != er.get(i)[1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
