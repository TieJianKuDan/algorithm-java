package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/18 10:09
 * @Description Nim 游戏
 * @Since version-1.0
 */
public class Nim {
    public static void main(String[] args) {
        System.out.println(new Nim().canWinNim(39));
    }

    public boolean canWinNim(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return true;
        }
        boolean[] dp = new boolean[3];
        dp[0] = true;
        dp[1] = true;
        dp[2] = true;
        for (int i = 4; i < n + 1; i++) {
            boolean temp = true;
            if (!dp[0] || !dp[1] || !dp[2]) {
                temp = true;
            } else {
                temp = false;
            }
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = temp;
        }
        return dp[2];
    }
}
