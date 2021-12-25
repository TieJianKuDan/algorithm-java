package net.algorithm.answer;

/**
 * @Author TieJianKuDan
 * @Date 2021/12/22 10:39
 * @Description 686. 重复叠加字符串匹配(错误)
 * @Since version-1.0
 */
public class RepeatedStringMatch {
    public static void main(String[] args) {
        RepeatedStringMatch self = new RepeatedStringMatch();
        String a = "aba";
        String b = "abaabaaba";
        System.out.println(self.repeatedStringMatch(a, b));
    }

    public int repeatedStringMatch(String a, String b) {
        if (b.length() <= a.length()) {
            return isSubStr(a, b, 0, b.length() - 1) ? 1 : 0;
        }
        int index = -1;
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            if (!isSubStr(a, b, 0, i)) {
                break;
            } else if (b.charAt(i) == a.charAt(a.length() - 1)) {
                index = i;
            }
        }
        if (index < 0) {
            return -1;
        }
        int count = 0;
        while (true) {
            int start = index + a.length() * count + 1;
            int end = start + a.length() - 1;
            if (end >= b.length()) {
                break;
            }
            if (!isSubStr(a, b, start, end)) {
                break;
            }
            count++;
        }
        int j = index + count * a.length() + 1;
        if (!isSubStr(a, b, j, b.length() - 1)) {
            return -1;
        }
        return j == b.length() ? count + 1 : count + 2;
    }

    public boolean isSubStr(String a, String b, int start, int end) {
        for (int i = 0; i < a.length(); i++) {
            boolean flag = true;
            for (int j = start; j <= end; j++) {
                if (end - start + 1 > a.length() - i) {
                    return false;
                }
                if (a.charAt(i + j - start) != b.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
