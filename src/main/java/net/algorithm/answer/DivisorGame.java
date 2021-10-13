package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/13 10:00
 * @Description 除数博弈
 * @Since version-1.0
 */
public class DivisorGame {
    public static void main(String[] args) {
        System.out.println(new DivisorGame().divisorGame(3));
    }

    public boolean divisorGame(int n) {
        if (n == 0) {
            return false;
        }
        // dp[i] 表示数字为 i 时，爱丽丝先手的游戏结果
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        for (int i = 0; i < dp.length; i++) {
            boolean flag = false;
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    flag = true;
                    break;
                }
            }
            dp[i] = flag;
        }
        return dp[n];
    }
}
