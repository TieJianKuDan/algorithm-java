package net.algorithm.answer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/14 11:09
 * @Description 1583. 统计不开心的朋友
 * @Since version-1.0
 */
public class UnhappyFriends {
    public static void main(String[] args) {
        int[][] preferrences = {{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}};
        int[][] pairs = {{1, 3}, {0, 2}};
        int res = new UnhappyFriends().unhappyFriends(4, preferrences, pairs);
        System.out.println(res);
    }

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        HashSet<Integer> unhappy = new HashSet<Integer>();
        // relation[i][j] 表示 i 和 j 的关系
        int[][] relation = new int[n][n];
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                relation[i][preferences[i][j]] = j;
            }
        }
        for (int i = 0; i < pairs.length - 1; i++) {
            for (int j = i + 1; j < pairs.length; j++) {
                isHappy(pairs[i], pairs[j], unhappy, relation);
            }
        }
        return unhappy.size();
    }

    public void isHappy(int[] pair1, int[] pair2, Set<Integer> unhappy, int[][] relation) {
        if (!unhappy.contains(pair1[0])) {
            if ((relation[pair1[0]][pair2[0]] < relation[pair1[0]][pair1[1]] &&
                    relation[pair2[0]][pair1[0]] < relation[pair2[0]][pair2[1]]) ||
                    (relation[pair1[0]][pair2[1]] < relation[pair1[0]][pair1[1]] &&
                            relation[pair2[1]][pair1[0]] < relation[pair2[1]][pair2[0]])) {
                unhappy.add(pair1[0]);
            }
        }
        if (!unhappy.contains(pair1[1])) {
            if ((relation[pair1[1]][pair2[1]] < relation[pair1[1]][pair1[0]] &&
                    relation[pair2[1]][pair1[1]] < relation[pair2[1]][pair2[0]]) ||
                    (relation[pair1[1]][pair2[0]] < relation[pair1[1]][pair1[0]] &&
                            relation[pair2[0]][pair1[1]] < relation[pair2[0]][pair2[1]])) {
                unhappy.add(pair1[1]);
            }
        }
        if (!unhappy.contains(pair2[0])) {
            if ((relation[pair2[0]][pair1[0]] < relation[pair2[0]][pair2[1]] &&
                    relation[pair1[0]][pair2[0]] < relation[pair1[0]][pair1[1]]) ||
                    (relation[pair2[0]][pair1[1]] < relation[pair2[0]][pair2[1]] &&
                            relation[pair1[1]][pair2[0]] < relation[pair1[1]][pair1[0]])) {
                unhappy.add(pair2[0]);
            }
        }
        if (!unhappy.contains(pair2[1])) {
            if ((relation[pair2[1]][pair1[1]] < relation[pair2[1]][pair2[0]] &&
                    relation[pair1[1]][pair2[1]] < relation[pair1[1]][pair1[0]]) ||
                    (relation[pair2[1]][pair1[0]] < relation[pair2[1]][pair2[0]] &&
                            relation[pair1[0]][pair2[1]] < relation[pair1[0]][pair1[1]])) {
                unhappy.add(pair2[1]);
            }
        }
    }
}
