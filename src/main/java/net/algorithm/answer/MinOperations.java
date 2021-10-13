package net.algorithm.answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author TieJianKuDan
 * @Date 2021/7/26 14:19
 * @Description 1713. 得到子序列的最少操作次数
 * @Since version-1.0
 */
public class MinOperations {
    public static void main(String[] args) {
        int[] target = {6, 4, 8, 1, 3, 2};
        int[] arr = {4, 7, 6, 2, 3, 8, 6, 1};
        System.out.println(minOperations(target, arr));
    }

    public static int minOperations(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                list.add(map.get(arr[i]));
            }
        }
        return target.length - lengthOfLIS(list);
    }

    // 超时超内存
    public static int getLongestSubLen(int[] arr, int start, int pre, int[][] mem) {
        int preValue = pre == -1 ? -1 : arr[pre];
        int res;
        if (start >= arr.length) {
            return 0;
        }

        if (pre != -1 && mem[start][pre] != 0) {
            return mem[start][pre];
        }

        if (arr[start] > preValue) {
            res = Math.max(getLongestSubLen(arr, start + 1, pre, mem), getLongestSubLen(arr, start + 1, start, mem) + 1);
        } else {
            res = getLongestSubLen(arr, start + 1, pre, mem);
        }

        if (pre != -1) {
            mem[start][pre] = res;
        }
        return res;
    }

    public static int lengthOfLIS(List<Integer> list) {
        // 长度为 i + 1 的各个递增子序列中，最小尾数为 temp[i]
        // 只有设置成最小尾数的情形才最有可能得到最长子序列
        List<Integer> temp = new ArrayList<>();
        temp.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > temp.get(temp.size() - 1)) {
                temp.add(list.get(i));
            } else {
                int index = getFirstBiggerNum(temp, list.get(i));
                temp.set(index, list.get(i));
            }
        }
        return temp.size();
    }

    public static int getFirstBiggerNum(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        while (low < high) {
            int cen = (high - low) / 2 + low;
            if (list.get(cen) <= target) {
                low = cen + 1;
            } else {
                high = cen;
            }
        }
        return low;
    }
}
