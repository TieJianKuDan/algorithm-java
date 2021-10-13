package net.algorithm.answer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author TieJianKuDan
 * @Date 2021/9/8 10:31
 * @Description 502. IPO
 * @Since version-1.0
 */
public class MaximizedCapital {
    public static void main(String[] args) {
        System.out.println(new MaximizedCapital().findMaximizedCapital(3, 0, new int[]{1,2,3,2,1}, new int[]{0,1,1,2,2}));
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        ArrayList<int[]> invest = new ArrayList<>();
        // {{本金，利润}, ...}
        for (int i = 0; i < profits.length; i++) {
            invest.add(new int[]{capital[i], profits[i]});
        }
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>((a , b) -> b - a);
        invest.sort(Comparator.comparingInt(o -> o[0]));
        int index = 0;
        int count = 0;
        while (count < k) {
            if (index < invest.size() && invest.get(index)[0] <= w) {
                bigHeap.offer(invest.get(index)[1]);
                index++;
            } else {
                if (bigHeap.isEmpty()) {
                    break;
                }
                w += bigHeap.poll();
                count++;
            }
        }
        return w;
    }
}
