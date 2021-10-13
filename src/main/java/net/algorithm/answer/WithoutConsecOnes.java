package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/11 10:04
 * @Description 600. 不含连续1的非负整数
 * @Since version-1.0
 */
public class WithoutConsecOnes {
    public static void main(String[] args) {
        System.out.println(new WithoutConsecOnes().findIntegers(1_000_000_000));
    }

    public int findIntegers(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            int help = 3;
            boolean flag = false;
            if ((i & help) == help) {
                flag = true;
                continue;
            }
            for (int j = 1; j < 29; j++) {
                help = help << 1;
                if ((i & help) == help) {
                    flag = true;
                    continue;
                }
            }
            if (!flag) {
                count++;
            }
        }
        return count;
    }
}
