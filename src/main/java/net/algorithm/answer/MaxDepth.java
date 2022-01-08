package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2022/1/7 15:53
 * @Description 1614. 括号的最大嵌套深度
 * @Since version-1.0
 */
public class MaxDepth {
    public static void main(String[] args) {

    }

    public int maxDepth(String s) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            if (s.charAt(i) == ')') {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
