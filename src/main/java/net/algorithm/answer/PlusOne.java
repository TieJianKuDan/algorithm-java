package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/21 10:30
 * @Description 66. 加一
 * @Since version-1.0
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            if (digits[i] < 10) {
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[len + 1];
            for (int i = 0; i < len; i++) {
                res[i + 1] = digits[i];
            }
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
