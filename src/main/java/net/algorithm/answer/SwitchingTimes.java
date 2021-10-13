package net.algorithm.answer;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class SwitchingTimes {
    public static void main(String[] args) {

    }

    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] ints : source) {
            for (int color : ints) {
                map.put(color, map.getOrDefault(color, 0) + 1);
            }
        }
        for (int[] ints : target) {
            for (int color : ints) {
                if (!map.containsKey(color) || map.get(color) == 0) {
                    res++;
                } else {
                    map.put(color, map.get(color) - 1);
                }
            }
        }
        return res;
    }
}
