package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/31 10:53
 * @Description 1109. 航班预订统计
 * @Since version-1.0
 */
public class FlightBookings {
    public static void main(String[] args) {

    }

    /**
     * @param bookings
     * @param n
     * @return
     * @discription 用差分数组的方式做
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }
}
