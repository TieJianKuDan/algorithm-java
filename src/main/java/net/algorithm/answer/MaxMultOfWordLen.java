package net.algorithm.answer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/17 9:49
 * @Description 318. 最大单词长度乘积
 * @Since version-1.0
 */
public class MaxMultOfWordLen {
    public static void main(String[] args) {

    }

    public int maxProduct(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!isHasSameChar(words[i], words[j])) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    private boolean isHasSameChar(String word1, String word2) {
        int record = 0;
        for (int i = 0; i < word1.length(); i++) {
            int temp = 1 << (word1.charAt(i) - 97);
            record |= temp;
        }
        for (int i = 0; i < word2.length(); i++) {
            int temp = 1 << (word2.charAt(i) - 97);
            if ((record & temp) != 0) {
                return true;
            }
        }
        return false;
    }
}
