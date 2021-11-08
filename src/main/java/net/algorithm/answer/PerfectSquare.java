package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/4 10:09
 * @Description 367. 有效的完全平方数
 * @Since version-1.0
 */
public class PerfectSquare {
    public static void main(String[] args) {
        PerfectSquare self = new PerfectSquare();
        System.out.println(self.isPerfectSquare(2147395600));
    }

    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = 1;
        int mult = high * high;
        while (mult < num && mult > 0) {
            high <<= 1;
            mult = high * high;
        }
        while (low <= high) {
            int cen = (high - low) / 2 + low;
            int temp = cen * cen;
            if (temp == num) {
                return true;
            } else if (temp > num || temp <= 0) {
                high = cen - 1;
            } else {
                low = cen + 1;
            }
        }
        return false;
    }
}
