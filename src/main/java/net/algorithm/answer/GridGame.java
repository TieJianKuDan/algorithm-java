package net.algorithm.answer;

public class GridGame {
    public static void main(String[] args) {
        int[][] grid = {{20,3,20,17,2,12,15,17,4,15},
                        {20,10,13,14,15,5,2,3,14,3}};
        System.out.println(new GridGame().gridGame(grid));
    }

    public long gridGame(int[][] grid) {
        return help(grid);
    }

    private long help(int[][] grid) {
        long min = Long.MAX_VALUE;
        long[][] preSum = new long[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            preSum[i][0] = grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                preSum[i][j] = preSum[i][j - 1] + grid[i][j];
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            long temp1 = preSum[1][i] - grid[1][i];
            long temp2 = preSum[0][grid[0].length - 1] - preSum[0][i];
            long temp = Math.max(temp1, temp2);
            min = temp < min ? temp : min;
        }
        return min;
    }
}