package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/10 9:52
 * @Description 495. 提莫攻击
 * @Since version-1.0
 */
public class TeemoAttacking {
    public static void main(String[] args) {
        int[] timeSeries = {1,2,3,4,5};
        TeemoAttacking self = new TeemoAttacking();
        System.out.println(self.findPoisonedDuration(timeSeries, 5));
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int temp = timeSeries[i] + duration - 1;
            if (temp < timeSeries[i + 1]) {
                res += duration;
            } else {
                res += duration - (temp - timeSeries[i + 1] + 1);
            }
        }
        res += duration;
        return res;
    }
}
