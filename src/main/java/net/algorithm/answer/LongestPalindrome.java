package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/13 11:12
 * @Description 5. 最长回文子串
 * @Since version-1.0
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        // 回文串去掉首位依旧是一个回文串（长度小于 3 时比较特殊）
        int start = 0, end = 0;
        // dp[i][j] 表示 s 从索引 i 到 j 是否是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i; j < dp[i].length; j++) {
                if (s.charAt(i) == s.charAt(j) && j - i <= 1) {
                    dp[i][j] = true;
                }
                if (s.charAt(i) == s.charAt(j) && j - i > 1) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
