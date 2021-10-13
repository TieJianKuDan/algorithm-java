package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/18 10:52
 * @Description
 * @Since version-1.0
 */
public class PlalindromeSubstrings {
    public static void main(String[] args) {

    }

    // 中心扩展法
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            // 中心为一个字符的情形
            int left = i, right = i;
            while (left >= 0
                    && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                res++;
                left--;
                right++;
            }
            // 中心有两个字符的情形
            if (s.length() - 1 != i && s.charAt(i) == s.charAt(i + 1)) {
                left = i;
                right = i + 1;
                while (left >= 0 &&
                        right < s.length() &&
                        s.charAt(left) == s.charAt(right)) {
                    res++;
                    left--;
                    right++;
                }
            }
        }
        return res;
    }
}
