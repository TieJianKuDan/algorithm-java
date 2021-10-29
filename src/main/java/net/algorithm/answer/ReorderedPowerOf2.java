package net.algorithm.answer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author TieJianKuDan
 * @Date 2021/10/28 9:01
 * @Description 869. 重新排序得到 2 的幂
 * @Since version-1.0
 */
public class ReorderedPowerOf2 {
    public static void main(String[] args) {
        ReorderedPowerOf2 self = new ReorderedPowerOf2();
        System.out.println(self.reorderedPowerOf2(10));
    }

    public boolean reorderedPowerOf2(int n) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int digit = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (n > 0) {
            int temp = n % 10;
            n /= 10;
            max = Math.max(max, temp);
            min = temp == 0 ? min : Math.min(min, temp);
            digit++;
            Integer preCount = map.getOrDefault(temp, 0);
            map.put(temp, preCount + 1);
        }
        int mult = 1;
        for (int i = 0; i < digit - 1; i++) {
            mult *= 10;
        }
        int bigest = max < 9 ? (max + 1) * mult : mult * 10;
        int minest = (min - 1) * mult;
        int candidate = 1;
        while (candidate < bigest) {
            if (candidate > minest && isMatch(map, candidate)) {
                return true;
            }
            candidate <<= 1;
        }
        return false;
    }

    private boolean isMatch(Map<Integer, Integer> map, int candidate) {
        Map<Integer, Integer> candNums = new HashMap<>();
        while (candidate > 0) {
            int temp = candidate % 10;
            candidate /= 10;
            Integer preCount = candNums.getOrDefault(temp, 0);
            candNums.put(temp, preCount + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = candNums.entrySet();
        if (map.size() != candNums.size()) {
            return false;
        }
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (!map.containsKey(entry.getKey()) ||
                    !map.get(entry.getKey()).equals(entry.getValue())
                    ) {
                return false;
            }
        }
        return true;
    }
}
