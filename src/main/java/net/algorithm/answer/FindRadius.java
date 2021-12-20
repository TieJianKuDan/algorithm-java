package net.algorithm.answer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author TieJianKuDan
 * @Date 2021/12/20 10:13
 * @Description 475. 供暖器
 * @Since version-1.0
 */
public class FindRadius {
    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 5, 15};
        int[] heaters = {2, 30};
        FindRadius self = new FindRadius();
        System.out.println(self.findRadiusPro(houses, heaters));
    }

    public int findRadius(int[] houses, int[] heaters) {
        int count = -1;
        HashSet<Integer> set = new HashSet<>();
        int[][] spread = new int[heaters.length][2];
        for (int house : houses) {
            set.add(house);
        }
        for (int i = 0; i < heaters.length; i++) {
            spread[i][0] = heaters[i];
            spread[i][1] = heaters[i];
        }
        while (!set.isEmpty()) {
            for (int[] ele : spread) {
                set.remove(ele[0]);
                set.remove(ele[1]);
                ele[0]--;
                ele[1]++;
            }
            count++;
        }
        return count;
    }

    public int findRadiusPro(int[] houses, int[] heaters) {
        int maxR = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int temp = binarySearch(heaters, house);
            maxR = Math.max(Math.abs(heaters[temp] - house), maxR);
        }
        return maxR;
    }

    public int binarySearch(int[] houses, int target) {
        int low = 0;
        int high = houses.length - 1;
        while (low <= high) {
            int cen = (high - low) / 2 + low;
            if (houses[cen] == target) {
                return cen;
            }
            if (houses[cen] < target) {
                low = cen + 1;
            }
            if (houses[cen] > target) {
                high = cen - 1;
            }
        }
        if (high < 0) {
            return low;
        }
        if (low >= houses.length) {
            return high;
        }
        if (Math.abs(houses[low] - target)
                >= Math.abs(houses[high] - target)) {
            return high;
        } else {
            return low;
        }
    }
}
