package net.algorithm.answer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author TieJianKuDan
 * @Date 2021/7/23 12:51
 * @Description 检查是否区域内所有整数都被覆盖
 * @Since version-1.0
 */
public class IsCovered {
    public static void main(String[] args) {
        int[][] ranges = {{1,2},{3,4},{5,6}};
        System.out.println(isCovered(ranges, 2, 5));
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int low = left;
        int high = right;
        for (int[] range : ranges) {
            if (left <= range[0] && right >= range[0] && right <= range[1]) {
                right = range[0] - 1;
            } else if (left >= range[0] && right <= range[1]) {
                return true;
            } else if (left >= range[0] && left <= range[1] && right >= range[1]) {
                left = range[1] + 1;
            }
            if (left > right) {
                return true;
            }
        }
        return false;
    }
}
