package net.algorithm.answer;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/9 10:34
 * @Description 313. 超级丑数
 * @Since version-1.0
 */
public class SuperUglyNumber {
    public static void main(String[] args) {
        int[] primes = {7, 19, 29, 37, 41, 47, 53, 59, 61, 79, 83, 89, 101, 103, 109, 127, 131, 137, 139, 157, 167, 179, 181, 199, 211, 229, 233, 239, 241, 251};
        System.out.println(nthSuperUglyNumberPro(
                100000, primes));
    }

    /**
     * @param n
     * @param primes
     * @return 丑数
     * @Desciption 复杂度高
     */
    public static int nthSuperUglyNumber(int n, int[] primes) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = set.pollFirst();
            for (int j = 0; j < primes.length; j++) {
                set.add(res * primes[j]);
            }
        }
        return (int) res;
    }

    /**
     * @param n
     * @param primes
     * @return 丑数
     * @Description 动态规划改进
     */
    public static int nthSuperUglyNumberPro(int n, int[] primes) {
        // dp[i] 第 i 个丑数
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int[] points = new int[primes.length];
        Arrays.fill(points, 1);
        for (int i = 2; i < dp.length; i++) {
            int[] nums = new int[points.length];
            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < nums.length; j++) {
                nums[j] = dp[points[j]] * primes[j];
                minNum = Math.min(nums[j], minNum);
            }
            dp[i] = minNum;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == minNum) {
                    points[j]++;
                }
            }
        }
        return dp[n];
    }
}