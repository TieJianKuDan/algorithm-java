package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/12/7 11:01
 * @Description 1034. 边界着色
 * @Since version-1.0
 */
public class ColorBorder {
    public static void main(String[] args) {
        int[][] grid = {{1,2,2},{2,3,2}};
        ColorBorder self = new ColorBorder();
        System.out.println(self.colorBorder(grid, 0, 1, 3));
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int ROW = grid.length;
        int COL = grid[0].length;
        int[][] visited1 = new int[ROW][COL];
        int[][] visited2 = new int[ROW][COL];
        dfs1(grid, row, col, grid[row][col], visited1);
        dfs2(visited1, row, col, color, visited2, grid);
        return grid;
    }

    private void dfs1(int[][] grid, int row, int col, int color, int[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] != 0) {
            return;
        }
        if (grid[row][col] == color) {
            // 是连通分量
            visited[row][col] = 3;
            dfs1(grid, row - 1, col, color, visited);
            dfs1(grid, row + 1, col, color, visited);
            dfs1(grid, row, col - 1, color, visited);
            dfs1(grid, row, col + 1, color, visited);
        } else {
            // 不是连通分量
            visited[row][col] = 2;
        }
    }

    private void dfs2(int[][] map, int row, int col, int color , int[][] visited, int[][] grid) {
        if (row < 0 || row >= map.length || col < 0 || col >= map[0].length || visited[row][col] != 0) {
            return;
        }
        if (map[row][col] == 3) {
            // 是连通分量
            visited[row][col] = 1;
            if (isEdge(map, row, col)) {
                grid[row][col] = color;
            }
            dfs2(map, row - 1, col, color, visited, grid);
            dfs2(map, row + 1, col, color, visited, grid);
            dfs2(map, row, col - 1, color, visited, grid);
            dfs2(map, row, col + 1, color, visited, grid);
        } else {
            // 不是连通分量
            visited[row][col] = 1;
        }
    }

    private boolean isEdge(int[][] visited, int row, int col) {
        if (row <= 0 || row >= visited.length-1 ||
                col <= 0 ||
                col >= visited[0].length-1 ||
                visited[row - 1][col] != 3 ||
                visited[row + 1][col] != 3 ||
                visited[row][col - 1] != 3 ||
                visited[row][col + 1] != 3) {
            return true;
        } else {
            return false;
        }
    }
}
