package net.algorithm.answer;

import java.util.List;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/23 9:56
 * @Description 139. 单词拆分
 * @Since version-1.0
 */
public class WordBreak {
    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int[] rem = new int[s.length()];
        return wordBreak(s, wordDict, 0, rem);
    }

    public boolean wordBreak(String s, List<String> wordDict, int start, int[] rem) {
        if (start >= s.length()) {
            return true;
        }
        if (rem[start] != 0) {
            return rem[start] == 1;
        }
        boolean res = false;
        for (String candidate : wordDict) {
            if (s.charAt(start) == candidate.charAt(0) && candidate.length() + start <= s.length()) {
                String substring = s.substring(start, candidate.length() + start);
                if (substring.equals(candidate)) {
                    res = res || wordBreak(s, wordDict, start + candidate.length(), rem);
                }
                if (res) {
                    break;
                }
            }
        }
        rem[start] = res ? 1 : 2;
        return res;
    }
}
