package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/15 20:49
 * @Description 38. 外观数列
 * @Since version-1.0
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String last = countAndSay(n - 1);
        int count = 1;
        char preChar = last.charAt(0);
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < last.length(); i++) {
            if (preChar == last.charAt(i)) {
                count++;
            } else {
                builder.append(count);
                builder.append(preChar);
                count = 1;
                preChar = last.charAt(i);
            }
            if (i == last.length() - 1) {
                builder.append(count);
                builder.append(preChar);
            }
        }
        return builder.toString();
    }
}
