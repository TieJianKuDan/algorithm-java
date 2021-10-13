package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/7 9:48
 * @Description 1221. 分割平衡字符串
 * @Since version-1.0
 */
public class BalancedStr {
    public static void main(String[] args) {

    }

    public int balancedStringSplit(String s) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                count++;
            }
            if (s.charAt(i) == 'L') {
                count--;
            }
            if (count == 0) {
                res++;
            }
        }
        return res;
    }
}
