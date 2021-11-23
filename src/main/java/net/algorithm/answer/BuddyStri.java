package net.algorithm.answer;

import java.util.HashSet;

/**
 * @Author TieJianKuDan
 * @Date 2021/11/23 9:36
 * @Description 859. 亲密字符串
 * @Since version-1.0
 */
public class BuddyStri {
    public static void main(String[] args) {
        BuddyStri self = new BuddyStri();
        System.out.println(self.buddyStrings("abcaa", "abcbb"));
    }

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int pre = 0, las = 0;
        boolean flag = false;
        while (pre < s.length() && las < s.length()) {
            if (s.charAt(pre) != goal.charAt(pre)) {
                flag = true;
            } else {
                pre++;
                las++;
            }
            if (flag) {
                las++;
            }
            if (flag && las < s.length() && s.charAt(las) != goal.charAt(las)) {
                break;
            }
        }
        if (flag && las < s.length() && s.charAt(las) == goal.charAt(pre) && s.charAt(pre) == goal.charAt(las)) {
            for (int i = las + 1; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
        if (!flag) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) {
                    return true;
                }
                set.add(s.charAt(i));
            }
        }
        return false;
    }
}
