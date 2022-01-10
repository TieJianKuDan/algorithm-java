package net.algorithm.answer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author TieJianKuDan
 * @Date 2022/1/10 10:07
 * @Description 306. 累加数
 * @Since version-1.0
 */
public class IsAdditiveNumber {
    public static void main(String[] args) {
        IsAdditiveNumber self = new IsAdditiveNumber();
        System.out.println(self.isAdditiveNumber("199111992"));
    }

    public boolean isAdditiveNumber(String num) {
        int len = (int) Math.floor(num.length() / 2.0);
        ArrayList<Long> list = new ArrayList<>();
        return dfs(num, 0, len, list);
    }

    private boolean dfs(String num, int start, int len, List<Long> list) {
        if (start >= num.length()) {
            if (list.size() < 3) {
                return false;
            } else {
                return true;
            }
        }
        for (int i = start; i < Math.min(start + len, num.length()); i++) {
            if (num.charAt(start) == '0' && i != start) {
                return false;
            }
            long candidate = Long.parseLong(num.substring(start, i + 1));
            if (list.size() >= 2 &&
                    candidate != list.get(list.size() - 1) + list.get(list.size() -2)) {
                continue;
            }
            list.add(candidate);
            if (dfs(num, i + 1, len, list)) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
}
