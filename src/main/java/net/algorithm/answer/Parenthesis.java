package net.algorithm.answer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/14 10:00
 * @Description 22. 括号生成
 * @Since version-1.0
 */
public class Parenthesis {
    public static void main(String[] args) {
        System.out.println(new Parenthesis().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String>[] dp = new List[n + 1];
        dp[0] = new ArrayList<>();
        dp[0].add("");
        dp[1] = new ArrayList<>();
        // n = 1 时的结果
        dp[1].add("()");
        if (n == 1) {
            return dp[n];
        }
        for (int i = 2; i <= n; i++) {
            dp[i] = new ArrayList<>();
            int low = 0, high = i - 1;
            while (low < i) {
                for (String sn : dp[low]) {
                    for (String sw : dp[high]) {
                        dp[i].add("(" + sn + ")" + sw);
                    }
                }
                low++;
                high--;
            }
        }
        return dp[n];
    }
}
