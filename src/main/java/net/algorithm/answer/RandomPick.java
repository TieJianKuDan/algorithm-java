package net.algorithm.answer;

import java.util.Date;
import java.util.Random;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/30 11:08
 * @Description 528. 按权重随机选择
 * @Since version-1.0
 */
public class RandomPick {
    private int[] distribution;

    public RandomPick(int[] w) {
        distribution = new int[w.length];
        distribution[0] = w[0];
        for (int i = 1; i < distribution.length; i++) {
            distribution[i] = distribution[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        Random random = new Random(new Date().getTime());
        int value = random.nextInt(distribution[distribution.length - 1]) + 1;
        if (value <= distribution[0]) {
            return 0;
        }
        int low = 0;
        int high = distribution.length - 1;
        while (low <= high) {
            if (value <= distribution[high] && value > distribution[high - 1]) {
                return high;
            }
            int cen = (high - low) / 2 + low;
            if (value <= distribution[cen]) {
                high = cen;
            }
            if (value > distribution[cen]) {
                low = cen + 1;
            }
        }
        return -1;
    }
}
