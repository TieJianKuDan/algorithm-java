package net.algorithm.answer;

import java.util.HashMap;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/8 9:54
 * @Description 1218. 最长定差子序列
 * @Since version-1.0
 */
public class LongestSubsequence {
    public static void main(String[] args) {
        int[] arr = {7,7,7,7,7,7,7};
        LongestSubsequence self = new LongestSubsequence();
        System.out.println(self.longestSubsequence(arr, 0));
    }

    public int longestSubsequence(int[] arr, int difference) {
        int length = arr.length;
        int res = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        // dp[i] 表示以 arr[i] 为尾项的最长等差子序列的长度
        int[] dp = new int[length];
        dp[0] = 1;
        map.put(arr[0], 1);
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            int pre = arr[i] - difference;
            Integer preLen = map.getOrDefault(pre, 0);
            dp[i] = preLen + 1;
            Integer saved = map.getOrDefault(arr[i], 1);
            map.put(arr[i], Math.max(saved, dp[i]));
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
