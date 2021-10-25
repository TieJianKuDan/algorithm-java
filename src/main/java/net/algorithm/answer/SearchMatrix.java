package net.algorithm.answer;

import java.util.Arrays;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/25 9:23
 * @Description 240. 搜索二维矩阵 II
 * @Since version-1.0
 */
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1}};
        int target = 2;
        System.out.println(new SearchMatrix().searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int end = matrix.length - 1;
        return help(matrix, target, 0, end);
    }

    private boolean help(int[][] matrix, int target, int start, int end) {
        int len = matrix[0].length;
        if (start > end) {
            return false;
        }
        int low = start;
        int high = end;
        while (low <= high) {
            int cen = (high - low) / 2 + low;
            if (matrix[cen][0] > target) {
                high = cen - 1;
            } else if (matrix[cen][len - 1] < target) {
                low = cen + 1;
            } else {
                // 在这行寻找，看能否找到
                int site = Arrays.binarySearch(matrix[cen], target);
                if (site >= 0) {
                    return true;
                } else {
                    return help(matrix, target, start, cen - 1)
                            || help(matrix, target, cen + 1, end);
                }
            }
        }
        return false;
    }
}
