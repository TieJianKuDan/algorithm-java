package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2022/2/23 9:43
 * @Description 917. 仅仅反转字母
 * @Since version-1.0
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        ReverseOnlyLetters self = new ReverseOnlyLetters();
        System.out.println(self.reverseOnlyLetters("7_28]"));
    }

    public String reverseOnlyLetters(String s) {
        int pre = 0, last = s.length() - 1;
        char[] arr = s.toCharArray();
        while (pre < last) {
            while ((pre < last) &&
                    (arr[pre] < 'A' ||
                    (arr[pre] > 'Z' && arr[pre] < 'a') ||
                    arr[pre] > 'z')) {
                pre++;
            }
            while ((pre < last) &&
                    (arr[last] < 'A' ||
                    (arr[last] > 'Z' && arr[last] < 'a') ||
                    arr[last] > 'z')) {
                last--;
            }
            if (pre < last) {
                char temp = arr[pre];
                arr[pre] = arr[last];
                arr[last] = temp;
            }
            pre++;
            last--;
        }
        return new String(arr);
    }
}
