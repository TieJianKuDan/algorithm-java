package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/29 10:49
 * @Description 1588. 所有奇数长度子数组的和
 * @Since version-1.0
 */
public class OddLengthSubarrays {
    public static void main(String[] args) {

    }

    public int sumOddLengthSubarrays(int[] arr) {
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        int res = 0;
        for (int i = 1; i <= arr.length; i = i + 2) {
            for (int j = 0; j <= arr.length - i; j++) {
                int temp = sum[j + i - 1] - sum[j] + arr[j];
                res += temp;
            }
        }
        return res;
    }
}
