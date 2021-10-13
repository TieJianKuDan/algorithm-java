package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/10 14:50
 * @Description 1894. 找到需要补充粉笔的学生编号
 * @Since version-1.0
 */
public class ChalkReplacer {
    public static void main(String[] args) {
        int[] chalk = {3,4,1,2};
        System.out.println(new ChalkReplacer().chalkReplacer(chalk, 500));
    }

    public int chalkReplacer(int[] chalk, int k) {
        for (int i = 1; i < chalk.length; i++) {
            chalk[i] = chalk[i - 1] + chalk[i];
        }
        k = k % chalk[chalk.length - 1];
        int low = 0, high = chalk.length;
        while (low < high) {
            int cen = (high - low) / 2 + low;
            if (chalk[cen] <= k) {
                low = cen + 1;
            }
            if (chalk[cen] > k) {
                high = cen;
            }
        }
        return low;
    }
}
