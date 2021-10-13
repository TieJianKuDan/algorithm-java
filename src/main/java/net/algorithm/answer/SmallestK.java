package net.algorithm.answer;

import java.util.PriorityQueue;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/3 10:50
 * @Description 面试题 17.14. 最小K个数
 * @Since version-1.0
 */
public class SmallestK {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        System.out.println(new SmallestK().smallestK(arr, k));
    }

    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll();
        }
        return res;
    }
}
