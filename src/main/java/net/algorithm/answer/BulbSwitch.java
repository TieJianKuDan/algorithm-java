package net.algorithm.answer;

import java.util.Arrays;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/15 9:08
 * @Description 319. 灯泡开关
 * @Since version-1.0
 */
public class BulbSwitch {
    public static void main(String[] args) {
        BulbSwitch self = new BulbSwitch();
        System.out.println(self.bulbSwitch(9999));
        System.out.println(self.bulbSwitchPro(9999));
    }

    public int bulbSwitch(int n) {
        boolean[] bulbs = new boolean[n];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int index = i - 1;
            while (index < n) {
                bulbs[index] = bulbs[index] ? false : true;
                index += i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (bulbs[i]) {
                res++;
            }
        }
        return res;
    }

    public int bulbSwitchPro(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int temp = (int) Math.sqrt(i);
            if (temp * temp == i) {
                res++;
            }
        }
        return res;
    }
}
