package net.algorithm.answer;

import java.util.PriorityQueue;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/3 9:52
 * @Description 407. 接雨水 II
 * @Since version-1.0
 */
public class TrapRainWater {
    public static void main(String[] args) {

    }

    /**
     * 1. 首先将最外层当作边界
     * 2. 从最低的边界入手，看它与之相邻的方格是否能盛水
     * 3. 如果能盛水，哪这个方格最终盛水的高度必然已经确定了
     * 4. 将方格盛水后的高度当成新的边界
     * 5. 重复 2 - 5 直至全部的方格都成为边界
     *
     * @param heightMap
     * @return
     */
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;
        int res = 0;
        boolean[][] visit = new boolean[n][m];
        PriorityQueue<int[]> boundary = new PriorityQueue<>(((o1, o2) -> o1[2] - o2[2]));
        // 最外层直接加入到边界
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == (n - 1)) {
                for (int j = 0; j < m; j++) {
                    boundary.offer(new int[]{i, j, heightMap[i][j]});
                    visit[i][j] = true;
                }
            } else {
                boundary.offer(new int[]{i, 0, heightMap[i][0]});
                visit[i][0] = true;
                boundary.offer(new int[]{i, m - 1, heightMap[i][m - 1]});
                visit[i][m - 1] = true;
            }
        }
        // 2 - 5 步
        int[] dir = {-1, 0, 1, 0, -1};
        while (!boundary.isEmpty()) {
            int[] minBound = boundary.poll();
            for (int i = 0; i < dir.length - 1; i++) {
                int row = minBound[0] + dir[i];
                int col = minBound[1] + dir[i + 1];
                if (row >= 0 && row < n && col >= 0 && col < m && !visit[row][col]) {
                    if (heightMap[row][col] < minBound[2]) {
                        res += (minBound[2] - heightMap[row][col]);
                    }
                    boundary.offer(new int[]{row, col, Math.max(minBound[2], heightMap[row][col])});
                    visit[row][col] = true;
                }
            }
        }
        return res;
    }
}
