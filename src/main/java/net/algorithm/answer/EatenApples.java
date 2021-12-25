package net.algorithm.answer;

import java.util.PriorityQueue;

/**
 * @Author TieJianKuDan
 * @Date 2021/12/24 20:13
 * @Description 1705. 吃苹果的最大数目
 * @Since version-1.0
 */
public class EatenApples {
    public static void main(String[] args) {
        int[] apples = {3,0,0,0,0,2};
        int[] days = {3,0,0,0,0,2};
        EatenApples self = new EatenApples();
        System.out.println(self.eatenApples(apples, days));
    }

    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int count = 0;
        int day = 0;
        while (!queue.isEmpty() || day < apples.length) {
            while (!queue.isEmpty()) {
                if (queue.peek()[0] <= day) {
                    queue.poll();
                } else {
                    break;
                }
            }
            if (day < apples.length) {
                int endDay = day + days[day];
                if (apples[day] != 0) {
                    queue.offer(new int[]{endDay, apples[day]});
                }
            }
            int[] peek = queue.peek();
            if (peek != null) {
                peek[1]--;
                count++;
                if (peek[1] <= 0) {
                    queue.poll();
                }
            }
            day++;
        }
        return count;
    }
}
