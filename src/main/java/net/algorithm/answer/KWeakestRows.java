package net.algorithm.answer;

import java.util.*;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/1 11:10
 * @Description 1337. 矩阵中战斗力最弱的 K 行
 * @Since version-1.0
 */
public class KWeakestRows {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};
        int[] res = kWeakestRows(mat, 3);
        System.out.println("pause");
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        int index = 0;
        for (int[] row : mat) {
            int sum = 0;
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 0) {
                    break;
                }
                sum += row[i];
            }
            TreeSet<Integer> value = map.getOrDefault(sum, new TreeSet<Integer>());
            value.add(index);
            map.put(sum, value);
            index++;
        }

        int[] res = new int[k];
        Set<Map.Entry<Integer, TreeSet<Integer>>> entries = map.entrySet();
        index = 0;
        for (Map.Entry<Integer, TreeSet<Integer>> entry : entries) {
            TreeSet<Integer> value = entry.getValue();
            for (Integer i : value) {
                if (index >= k) {
                    return res;
                }
                res[index] = i;
                index++;
            }
        }
        return res;
    }
}
