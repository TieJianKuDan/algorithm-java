package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2022/2/24 9:18
 * @Description 1706. 球会落何处
 * @Since version-1.0
 */
public class FindBall {
    public static void main(String[] args) {

    }

    public int[] findBall(int[][] grid) {
        int[] locations = new int[grid[0].length];
        for (int i = 0; i < locations.length; i++) {
            locations[i] = i;
        }
        return help(grid, 0, locations);
    }

    private int[] help(int[][] grid, int start, int[] locations) {
        int col = grid[0].length;

        if (grid.length - start == 0) {
            return locations;
        } else {
            for (int i = 0; i < locations.length; i++) {
                int location = locations[i];
                if (location == -1) {
                    continue;
                }
                if (grid[start][location] == -1) {
                    if (location == 0 || grid[start][location - 1] == 1) {
                        locations[i] = -1;
                    } else {
                        locations[i] = location - 1;
                    }
                } else {
                    if (location == (col - 1) || grid[start][location + 1] == -1) {
                        locations[i] = -1;
                    } else {
                        locations[i] = location + 1;
                    }
                }
            }
            return help(grid, start + 1, locations);
        }
    }
}
