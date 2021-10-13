package net.algorithm.answer;

import java.util.Stack;

/**
 * @Author TieJianKuDan
 * @Date 2021/8/21 10:56
 * @Description 443. 压缩字符串
 * @Since version-1.0
 */
public class StrCompress {
    public static void main(String[] args) {
        System.out.println(new StrCompress().compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
    }

    public int compress(char[] chars) {
        int res = 0;
        int count = 1;
        int i = 1;
        while (i <= chars.length) {
            char temp = i == chars.length ? (char) (chars[i - 1] + 1) : chars[i];
            if (temp == chars[i - 1]) {
                count++;
            } else {
                if (count == 1) {
                    chars[res] = chars[i - 1];
                    res++;
                } else {
                    chars[res] = chars[i - 1];
                    res++;
                    Stack<Integer> stack = new Stack<>();
                    while (count > 0) {
                        stack.push(count % 10);
                        count /= 10;
                    }
                    while (!stack.isEmpty()) {
                        chars[res] = (char) (stack.pop() + 48);
                        res++;
                    }
                }
                count = 1;
            }
            ++i;
        }
        return res;
    }
}
