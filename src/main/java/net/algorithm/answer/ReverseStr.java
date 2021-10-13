package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/20 12:14
 * @Description 541. 反转字符串 II
 * @Since version-1.0
 */
public class ReverseStr {
    public static void main(String[] args) {
        System.out.println(new ReverseStr().reverseStr("abcdefg", 2));
    }

    public String reverseStr(String s, int k) {
        char[] target = s.toCharArray();
        int start = 0;
        while (start < target.length) {
            reverseCharArray(target, start, k);
            start = start + 2 * k;
        }
        return new String(target);
    }

    public void reverseCharArray(char[] target, int start, int k) {
        int end = (target.length - start) > k ? start + k - 1 : target.length - 1;
        while (start <= end) {
            char temp = target[start];
            target[start] = target[end];
            target[end] = temp;
            start++;
            end--;
        }
    }
}
