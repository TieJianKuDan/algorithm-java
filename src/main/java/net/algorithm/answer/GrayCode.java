package net.algorithm.answer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author TieJianKuDan
 * @Date 2022/1/8 10:16
 * @Description 89. 格雷编码
 * @Since version-1.0
 */
public class GrayCode {
    public static void main(String[] args) {
        GrayCode self = new GrayCode();
        System.out.println(self.grayCode(3));
    }

    public List<Integer> grayCode(int n) {
        int target = 1 << n;
        Set<Integer> records = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        res.add(0);
        records.add(0);
        dfs(res, records, n, target);
        return res;
    }

    private boolean dfs(List<Integer> res, Set<Integer> records, int n, int target) {
        if (res.size() == target) {
            return true;
        }
        int next = res.size() == target - 1 ? res.get(0) : res.get(res.size() - 1);
        int mask = 1;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            if ((next & mask) == 0) {
                next |= mask;
            } else {
                next = next & (~mask);
                flag = false;
            }

            if (!records.contains(next)) {
                res.add(next);
                records.add(next);
                if (dfs(res, records, n, target)) {
                    return true;
                } else {
                    res.remove(res.size() - 1);
                    records.remove(next);
                }
            }

            if (flag) {
                next = next & (~mask);
            } else {
                next |= mask;
            }
            mask <<= 1;
        }
        return false;
    }
}
