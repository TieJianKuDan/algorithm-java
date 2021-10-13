package net.algorithm.answer;

import java.util.Arrays;

public class DelOp2Str {
    public static void main(String[] args) {
        System.out.println(new DelOp2Str().minDistance("intention", "execution"));
    }

    public int minDistance(String word1, String word2) {
        int[][] rem = new int[word1.length()][word2.length()];
        for (int[] ele : rem) {
            Arrays.fill(ele, -1);
        }
        int len = help(word1, 0, word2, 0, rem);
        return word1.length() - len + word2.length() - len;
    }

    private int help(String word1, int start1, String word2, int start2, int[][] rem) {
        if (start1 == word1.length() || start2 == word2.length()) {
            return 0;
        }
        if (rem[start1][start2] != -1) {
            return rem[start1][start2];
        }
        // index1 word1.charAt(start1) 在 word2 中第一次出现的位置
        int index1 = -1, index2 = -1;
        int res = 0;
        for (int i = start2; i < word2.length(); i++) {
            if (word2.charAt(i) == word1.charAt(start1)) {
                index1 = i;
                break;
            }
        }
        for (int i = start1; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(start2)) {
                index2 = i;
                break;
            }
        }
        if (index1 == -1 && index2 == -1) {
            res = help(word1, start1 + 1, word2, start2 + 1, rem);
        } else if (index1 == -1) {
            res = 1 + help(word1, index2 + 1, word2, start2 + 1, rem);
        } else if (index2 == -1) {
            res = 1 + help(word1, start1 + 1, word2, index1 + 1, rem);
        } else if (index1 != -1 && index2 != -1) {
            res = 1 + Math.max(help(word1, index2 + 1, word2, start2 + 1, rem),
                    help(word1, start1 + 1, word2, index1 + 1, rem));
        }
        res = Math.max(res, help(word1, start1 + 1, word2, start2 + 1, rem));
        rem[start1][start2] = res;
        return res;
    }
}
