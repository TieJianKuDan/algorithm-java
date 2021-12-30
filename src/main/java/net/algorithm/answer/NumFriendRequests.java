package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/12/27 10:44
 * @Description 825. 适龄的朋友
 * @Since version-1.0
 */
public class NumFriendRequests {
    public static void main(String[] args) {
        int[] ages = {20, 30, 100, 110, 120};
        NumFriendRequests self = new NumFriendRequests();
        System.out.println(self.numFriendRequests(ages));
    }

    public int numFriendRequests(int[] ages) {
        int res = 0;
        int[] counts = new int[121];
        int[] preSum = new int[121];
        for (int age : ages) {
            counts[age]++;
        }
        preSum[0] = counts[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = counts[i] + preSum[i - 1];
        }
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] >= 15) {
                res += preSum[ages[i]] - preSum[(int) Math.floor(0.5 * ages[i] + 7)] - 1;
            }
        }
        return res;
    }
}
