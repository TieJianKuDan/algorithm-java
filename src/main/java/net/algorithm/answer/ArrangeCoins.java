package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/10 9:53
 * @Description 441. 排列硬币
 * @Since version-1.0
 */
public class ArrangeCoins {
    public static void main(String[] args) {
        System.out.println(new ArrangeCoins().arrangeCoins(1804289383));
    }

    public int arrangeCoins(int n) {
        int low = 1, high = n;
        while(low <= high) {
            int cen = (high - low) / 2 + low;
            if (help(cen) > n) {
                high = cen - 1;
            } else if (help(cen) < n) {
                low = cen + 1;
            } else {
                return cen;
            }
        }
        return high;
    }
    private long help(long k) {
        return ((k + 1) * k) / 2;
    }
}
