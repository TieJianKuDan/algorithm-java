package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/13 10:10
 * @Description LCS 01. 下载插件
 * @Since version-1.0
 */
public class Plugging {
    public static void main(String[] args) {
        System.out.println(new Plugging().leastMinutes(1000));
    }

    public int leastMinutes(int n) {
        int res = n;
        int speed = 1;
        for (int i = 1; i < res; i++) {
            speed = speed * 2;
            if (n % speed == 0) {
                res = Math.min(res, n / speed + i);
            } else {
                res = Math.min(res, n / speed + i + 1);
            }
        }
        return res;
    }
}
