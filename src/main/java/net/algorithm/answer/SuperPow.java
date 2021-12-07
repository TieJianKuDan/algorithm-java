package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/12/5 9:52
 * @Description 372. 超级次方
 * @Since version-1.0
 */
public class SuperPow {
    public static void main(String[] args) {
        SuperPow self = new SuperPow();
        System.out.println(self.superPow(2147483647, new int[]{2, 0, 0}));
//        System.out.println(self.pow(2, 3));
    }

        private final int MOD = 1337;

        public int superPow(int a, int[] b) {
            return help(a, b, b.length - 1);
        }

        private int help(int a, int[] b, int end) {
            if (end < 0) {
                return 1;
            }
            if (end == 0) {
                return pow(a, b[end]);
            }
            return pow(help(a, b, end - 1), 10) * pow(a, b[end]) % MOD;
        }

        private int pow(int a, int b) {
            a %= MOD;
            if (b <= 0) {
                return 1;
            }
            if (b == 1) {
                return a;
            }
            int temp = b / 2;
            return (pow(a, temp) * pow(a, b - temp)) % MOD;
        }
}
