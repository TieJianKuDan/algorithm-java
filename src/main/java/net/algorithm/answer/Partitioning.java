package net.algorithm.answer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/22 10:57
 * @Description 131. 分割回文串
 * @Since version-1.0
 */
public class Partitioning {
    public static void main(String[] args) {
        System.out.println(new Partitioning().partition("abaa"));
    }

    public List<List<String>> partition(String s) {
        return partition(s, s.length());
    }

    public List<List<String>> partition(String s, int len) {
        List<List<String>> res = new ArrayList<>();
        if (len <= 0) {
            res.add(new ArrayList<String>());
            return res;
        }
        for (int i = 0; i < len; i++) {
            if (isplalindrome(s, i, len - 1)) {
                List<List<String>> temp = partition(s, i);
                for (List<String> list : temp) {
                    list.add(s.substring(i, len));
                }
                res.addAll(temp);
            }
        }
        return res;
    }

    public boolean isplalindrome(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
